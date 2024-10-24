package com.weather.monitor.service;

import com.weather.monitor.dto.DailyTemperatureSummaryDTO;
import com.weather.monitor.exception.NoDataFoundException;
import com.weather.monitor.repository.WeatherDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherDataService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherDataService.class);
    private final WeatherDataRepository weatherDataRepository;

    @Autowired
    public WeatherDataService(WeatherDataRepository weatherDataRepository) {
        this.weatherDataRepository = weatherDataRepository;
    }

    /**
     * Retrieves the daily temperature summary for a given city.
     *
     * @param city the name of the city to fetch the weather data for
     * @return a list of daily temperature summaries
     * @throws NoDataFoundException if no weather data is found for the specified city
     */
    public List<DailyTemperatureSummaryDTO> getDailyTemperatureSummary(String city) {
        // Fetching data from the repository directly as List<DailyTemperatureSummaryDTO>
        List<DailyTemperatureSummaryDTO> results = weatherDataRepository.getDailyTemperatureSummary(city);
        
        if (results.isEmpty()) {
            logger.warn("No weather data found for city: {}", city);
            throw new NoDataFoundException("No weather data found for city: " + city);
        }

        logger.info("Retrieved {} daily temperature summaries for city: {}", results.size(), city);
        return results;
    }
}




