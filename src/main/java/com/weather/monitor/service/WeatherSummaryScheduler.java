package com.weather.monitor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class WeatherSummaryScheduler {
    private static final Logger logger = LoggerFactory.getLogger(WeatherSummaryScheduler.class);

    @Autowired
    private WeatherSummaryService weatherSummaryService;

    @Value("${weather.city}")
    private String city;

    @Scheduled(cron = "0 0 0 * * ?")
    public void calculateDailySummary() {
        try {
            weatherSummaryService.saveDailyTemperatureSummary(city);
            logger.info("Daily summary calculated for city: {}", city);
        } catch (Exception e) {
            logger.error("Error while calculating daily summary for {}: {}", city, e.getMessage());
        }
    }

    @Scheduled(cron = "0 0 0 * * SUN")
    public void calculateWeeklySummary() {
        try {
            weatherSummaryService.saveWeeklyTemperatureSummary(city);
            logger.info("Weekly summary calculated for city: {}", city);
        } catch (Exception e) {
            logger.error("Error while calculating weekly summary for {}: {}", city, e.getMessage());
        }
    }
}

