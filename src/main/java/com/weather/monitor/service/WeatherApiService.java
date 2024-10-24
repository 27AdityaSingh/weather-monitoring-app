package com.weather.monitor.service;

import com.weather.monitor.model.WeatherData;
import com.weather.monitor.WeatherResponse;
import com.weather.monitor.repository.WeatherDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class WeatherApiService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherApiService.class);
    private final RestTemplate restTemplate;
    private final WeatherDataRepository weatherDataRepository;

    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Value("${openweathermap.api.url}")
    private String apiUrl;

    @Value("${weather.city}")
    private String city; // Make city dynamic

    @Autowired
    public WeatherApiService(RestTemplate restTemplate, WeatherDataRepository weatherDataRepository) {
        this.restTemplate = restTemplate;
        this.weatherDataRepository = weatherDataRepository;
    }

    @Scheduled(fixedRateString = "${weather.fetch.rate}") // Dynamic fetch rate from properties
    public void fetchWeatherData() {
        String url = apiUrl.replace("{city}", city).replace("{apikey}", apiKey);

        try {
            WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);
            if (response != null && response.getMain() != null) {
                double temperatureInKelvin = response.getMain().getTemp();
                double temperatureInCelsius = temperatureInKelvin - 273.15; // Convert to Celsius

                // Log the fetched weather data
                logger.info("Weather data fetched: City = {}, Temp = {:.2f} °C", response.getName(), temperatureInCelsius);

                // Save the data to the database
                WeatherData weatherData = new WeatherData();
                weatherData.setCity(response.getName());
                weatherData.setTemperature(temperatureInCelsius);
                weatherData.setTimestamp(LocalDateTime.now());

                weatherDataRepository.save(weatherData); // Save to database

                // Log the saved weather data
                logger.info("Weather data saved to database: City = {}, Temp = {:.2f} °C", 
                    weatherData.getCity(), weatherData.getTemperature());
            } else {
                logger.warn("No valid response received from the API.");
            }
        } catch (Exception e) {
            logger.error("Error fetching weather data: {}", e.getMessage(), e);
        }
    }
}


