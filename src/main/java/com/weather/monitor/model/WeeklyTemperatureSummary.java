package com.weather.monitor.model;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

public class WeeklyTemperatureSummary {
    @NotNull(message = "City cannot be null")
    private String city;

    @NotNull(message = "Start date cannot be null")
    private LocalDate startDate;

    private double averageTemperature;
    private double minimumTemperature;
    private double maximumTemperature;

    private int year;  // Year of the summary
    private int week;  // Week number of the year

    // Constructor
    public WeeklyTemperatureSummary(String city, LocalDate startDate, double averageTemperature,
                                    double minimumTemperature, double maximumTemperature, int year, int week) {
        this.city = city;
        this.startDate = startDate;
        this.averageTemperature = averageTemperature;
        this.minimumTemperature = minimumTemperature;
        this.maximumTemperature = maximumTemperature;
        this.year = year;
        this.week = week;
    }

    // Default constructor
    public WeeklyTemperatureSummary() {}

    // Getters and Setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public double getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(double minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

    public double getMaximumTemperature() {
        return maximumTemperature;
    }

    public void setMaximumTemperature(double maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    @Override
    public String toString() {
        return "WeeklyTemperatureSummary{" +
                "city='" + city + '\'' +
                ", startDate=" + startDate +
                ", averageTemperature=" + averageTemperature +
                ", minimumTemperature=" + minimumTemperature +
                ", maximumTemperature=" + maximumTemperature +
                ", year=" + year +
                ", week=" + week +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeeklyTemperatureSummary)) return false;
        WeeklyTemperatureSummary that = (WeeklyTemperatureSummary) o;
        return Double.compare(that.averageTemperature, averageTemperature) == 0 &&
                Double.compare(that.minimumTemperature, minimumTemperature) == 0 &&
                Double.compare(that.maximumTemperature, maximumTemperature) == 0 &&
                year == that.year &&
                week == that.week &&
                Objects.equals(city, that.city) &&
                Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, startDate, averageTemperature, minimumTemperature, maximumTemperature, year, week);
    }
}

