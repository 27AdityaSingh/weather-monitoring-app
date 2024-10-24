package com.weather.monitor.repository;

import com.weather.monitor.model.WeeklyTemperatureSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WeeklyTemperatureSummaryRepository extends JpaRepository<WeeklyTemperatureSummary, Long> {

    // Custom method to find summaries by city
    List<WeeklyTemperatureSummary> findByCity(String city);

    // Custom method to find summaries by city and date
    @Query("SELECT w FROM WeeklyTemperatureSummary w WHERE w.city = :city AND w.startDate = :date")
    List<WeeklyTemperatureSummary> findByCityAndDate(@Param("city") String city, @Param("date") LocalDate date);

    // Optional: Custom method to find summaries by city, year, and week
    @Query("SELECT w FROM WeeklyTemperatureSummary w WHERE w.city = :city AND w.year = :year AND w.week = :week")
    List<WeeklyTemperatureSummary> findByCityYearAndWeek(@Param("city") String city, @Param("year") int year, @Param("week") int week);
}
