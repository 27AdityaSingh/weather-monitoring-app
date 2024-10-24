package com.weather.monitor;

import com.weather.monitor.service.WeatherSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherMonitorApplication implements CommandLineRunner {

    @Autowired
    private WeatherSummaryService weatherSummaryService;

    public static void main(String[] args) {
        SpringApplication.run(WeatherMonitorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Check if a city argument is passed; if not, default to "Delhi"
        String city = (args != null && args.length > 0) ? args[0] : "Delhi";

        // Save daily and weekly temperature summaries for the specified city
        weatherSummaryService.saveDailyTemperatureSummary(city);
        weatherSummaryService.saveWeeklyTemperatureSummary(city);
    }
}
