package com.weather.monitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.weather.monitor.model.WeatherData; // Ensure this import points to your WeatherData model
import com.weather.monitor.dto.DailyTemperatureSummaryDTO;
import com.weather.monitor.dto.WeeklyTemperatureSummaryDTO;

import java.util.List;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {

    // Daily temperature summary
    @Query("SELECT new com.weather.monitor.dto.DailyTemperatureSummaryDTO(" +
           "FUNCTION('DATE', wd.timestamp), AVG(wd.temperature), MIN(wd.temperature), MAX(wd.temperature)) " +
           "FROM WeatherData wd WHERE wd.city = :city " +
           "GROUP BY FUNCTION('DATE', wd.timestamp) " +
           "ORDER BY FUNCTION('DATE', wd.timestamp)")
    List<DailyTemperatureSummaryDTO> getDailyTemperatureSummary(@Param("city") String city);

    // Weekly temperature summary
    @Query("SELECT new com.weather.monitor.dto.WeeklyTemperatureSummaryDTO(" +
           "FUNCTION('YEAR', wd.timestamp), FUNCTION('WEEK', wd.timestamp), AVG(wd.temperature), MIN(wd.temperature), MAX(wd.temperature)) " +
           "FROM WeatherData wd WHERE wd.city = :city " +
           "GROUP BY FUNCTION('YEAR', wd.timestamp), FUNCTION('WEEK', wd.timestamp) " +
           "ORDER BY FUNCTION('YEAR', wd.timestamp), FUNCTION('WEEK', wd.timestamp)")
    List<WeeklyTemperatureSummaryDTO> getWeeklyTemperatureSummary(@Param("city") String city);
}
