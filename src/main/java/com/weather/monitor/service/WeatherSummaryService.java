package com.weather.monitor.service;

import com.weather.monitor.dto.DailyTemperatureSummaryDTO;
import com.weather.monitor.dto.WeeklyTemperatureSummaryDTO;
import com.weather.monitor.model.DailyTemperatureSummary;
import com.weather.monitor.model.WeeklyTemperatureSummary;
import com.weather.monitor.repository.DailyTemperatureSummaryRepository;
import com.weather.monitor.repository.WeeklyTemperatureSummaryRepository;
import com.weather.monitor.repository.WeatherDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("weatherSummaryService")
public class WeatherSummaryService {
    private static final Logger logger = LoggerFactory.getLogger(WeatherSummaryService.class);

    private final WeatherDataRepository weatherDataRepository;
    private final DailyTemperatureSummaryRepository dailySummaryRepository;
    private final WeeklyTemperatureSummaryRepository weeklySummaryRepository;

    @Autowired
    public WeatherSummaryService(WeatherDataRepository weatherDataRepository,
                                 DailyTemperatureSummaryRepository dailySummaryRepository,
                                 WeeklyTemperatureSummaryRepository weeklySummaryRepository) {
        this.weatherDataRepository = weatherDataRepository;
        this.dailySummaryRepository = dailySummaryRepository;
        this.weeklySummaryRepository = weeklySummaryRepository;
    }

    public void saveDailyTemperatureSummary(String city) {
        List<DailyTemperatureSummaryDTO> dailySummaries = weatherDataRepository.getDailyTemperatureSummary(city);
        if (dailySummaries.isEmpty()) {
            logger.warn("No daily summaries available for city: {}", city);
            return;
        }

        List<DailyTemperatureSummary> dailySummaryEntities = new ArrayList<>();
        
        for (DailyTemperatureSummaryDTO summary : dailySummaries) {
            LocalDate date = convertToLocalDate(summary.getDate());
            Double avgTemperature = summary.getAvgTemp();
            Double minTemperature = summary.getMinTemp();
            Double maxTemperature = summary.getMaxTemp();

            if (date != null) {
                DailyTemperatureSummary dailySummary = new DailyTemperatureSummary();
                dailySummary.setCity(city);
                dailySummary.setDate(date);
                dailySummary.setAverageTemperature(avgTemperature);
                dailySummary.setMinimumTemperature(minTemperature);
                dailySummary.setMaximumTemperature(maxTemperature);

                dailySummaryEntities.add(dailySummary);
            } else {
                logger.warn("Received null date for city: {}", city);
            }
        }

        if (!dailySummaryEntities.isEmpty()) {
            try {
                dailySummaryRepository.saveAll(dailySummaryEntities);
                logger.info("Saved {} daily summaries for city: {}", dailySummaryEntities.size(), city);
            } catch (Exception e) {
                logger.error("Error saving daily summaries for city: {}: {}", city, e.getMessage());
            }
        }
    }

    public void saveWeeklyTemperatureSummary(String city) {
        // Similar logic as saveDailyTemperatureSummary
        // Implement your method here
    }

    private LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}


