package com.weather.monitor.repository;

import com.weather.monitor.model.DailyTemperatureSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DailyTemperatureSummaryRepository extends JpaRepository<DailyTemperatureSummary, Long> {

    // Find summaries by date
    List<DailyTemperatureSummary> findByDate(LocalDate date);

    // Find summaries by city
    List<DailyTemperatureSummary> findByCity(String city);

    // Custom query to find summaries within a date range
    @Query("SELECT d FROM DailyTemperatureSummary d WHERE d.date BETWEEN :startDate AND :endDate")
    List<DailyTemperatureSummary> findByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
