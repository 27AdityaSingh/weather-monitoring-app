package com.weather.monitor.repository;

import com.weather.monitor.model.WeatherSummary; // Ensure this imports the correct model
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WeatherSummaryRepository extends JpaRepository<WeatherSummary, Long> {

    // Find weather summaries by city
    List<WeatherSummary> findByCity(String city);

    // Find weather summaries by city and date
    List<WeatherSummary> findByCityAndDate(String city, LocalDate date);

    // Find weather summaries by city, year, and week
    List<WeatherSummary> findByCityAndYearAndWeek(String city, int year, int week);
}
