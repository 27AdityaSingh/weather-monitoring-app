package com.weather.monitor.model;

import java.time.LocalDate;
import java.util.Objects;

public class DailyTemperatureSummary {
    private LocalDate date;           // The date of the summary
    private double averageTemperature; // The average temperature for the day
    private double minimumTemperature; // The minimum temperature for the day
    private double maximumTemperature; // The maximum temperature for the day
    private String city;               // The city for the summary

    // Constructor
    public DailyTemperatureSummary(LocalDate date, double averageTemperature, double minimumTemperature, double maximumTemperature, String city) {
        if (minimumTemperature > maximumTemperature) {
            throw new IllegalArgumentException("Minimum temperature cannot be greater than maximum temperature.");
        }
        this.date = date;
        this.averageTemperature = averageTemperature;
        this.minimumTemperature = minimumTemperature;
        this.maximumTemperature = maximumTemperature;
        this.city = city;
    }

    // Default constructor
    public DailyTemperatureSummary() {}

    // Getters and Setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
        if (minimumTemperature > this.maximumTemperature) {
            throw new IllegalArgumentException("Minimum temperature cannot be greater than maximum temperature.");
        }
        this.minimumTemperature = minimumTemperature;
    }

    public double getMaximumTemperature() {
        return maximumTemperature;
    }

    public void setMaximumTemperature(double maximumTemperature) {
        if (maximumTemperature < this.minimumTemperature) {
            throw new IllegalArgumentException("Maximum temperature cannot be less than minimum temperature.");
        }
        this.maximumTemperature = maximumTemperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "DailyTemperatureSummary{" +
                "date=" + date +
                ", averageTemperature=" + averageTemperature +
                ", minimumTemperature=" + minimumTemperature +
                ", maximumTemperature=" + maximumTemperature +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DailyTemperatureSummary)) return false;
        DailyTemperatureSummary that = (DailyTemperatureSummary) o;
        return Double.compare(that.averageTemperature, averageTemperature) == 0 &&
               Double.compare(that.minimumTemperature, minimumTemperature) == 0 &&
               Double.compare(that.maximumTemperature, maximumTemperature) == 0 &&
               Objects.equals(date, that.date) &&
               Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, averageTemperature, minimumTemperature, maximumTemperature, city);
    }
}

