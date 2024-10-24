package com.weather.monitor.controller;

import com.weather.monitor.dto.DailyTemperatureSummaryDTO;
import com.weather.monitor.dto.WeeklyTemperatureSummaryDTO;
import com.weather.monitor.exception.NoDataFoundException;
import com.weather.monitor.service.WeatherDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherDataController {

    private final WeatherDataService weatherDataService;
    private final Logger logger = LoggerFactory.getLogger(WeatherDataController.class);

    @Autowired
    public WeatherDataController(WeatherDataService weatherDataService) {
        this.weatherDataService = weatherDataService;
    }

    @GetMapping("/daily-summary/{city}")
    public ResponseEntity<List<DailyTemperatureSummaryDTO>> getDailySummary(@PathVariable String city) {
        logger.info("Received request for daily summary for city: {}", city);

        try {
            // Fetch daily summaries for the given city
            List<DailyTemperatureSummaryDTO> summaries = weatherDataService.getDailyTemperatureSummary(city);

            logger.info("Returning daily summary for city: {}", city);
            // Return the summaries with a 200 OK status
            return ResponseEntity.ok(summaries);
        } catch (NoDataFoundException ex) {
            logger.warn("No weather data found for city: {}", city);
            // Return a 404 status with an empty body if no data is found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(List.of());
        } catch (Exception ex) {
            logger.error("An error occurred while retrieving daily summary for city: {}: {}", city, ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(List.of());
        }
    }

    @GetMapping("/weekly-summary/{city}")
    public ResponseEntity<List<WeeklyTemperatureSummaryDTO>> getWeeklySummary(@PathVariable String city) {
        logger.info("Received request for weekly summary for city: {}", city);

        try {
            // Fetch weekly summaries for the given city
            List<WeeklyTemperatureSummaryDTO> summaries = weatherDataService.getWeeklyTemperatureSummary(city);

            logger.info("Returning weekly summary for city: {}", city);
            // Return the summaries with a 200 OK status
            return ResponseEntity.ok(summaries);
        } catch (NoDataFoundException ex) {
            logger.warn("No weather data found for city: {}", city);
            // Return a 404 status with an empty body if no data is found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(List.of());
        } catch (Exception ex) {
            logger.error("An error occurred while retrieving weekly summary for city: {}: {}", city, ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(List.of());
        }
    }

    // Additional endpoints can be added here
}


