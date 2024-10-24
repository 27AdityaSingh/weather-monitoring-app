package com.weather.monitor.dto;

public class WeeklyTemperatureSummaryDTO {
    private int year;
    private int week;
    private double averageTemperature;
    private double minTemperature;
    private double maxTemperature;

    // Constructor
    public WeeklyTemperatureSummaryDTO(int year, int week, double averageTemperature, double minTemperature, double maxTemperature) {
        if (year < 0) {
            throw new IllegalArgumentException("Year cannot be negative");
        }
        if (week < 1 || week > 52) {
            throw new IllegalArgumentException("Week must be between 1 and 52");
        }

        this.year = year;
        this.week = week;
        this.averageTemperature = averageTemperature;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    // Getters and Setters
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("Year cannot be negative");
        }
        this.year = year;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        if (week < 1 || week > 52) {
            throw new IllegalArgumentException("Week must be between 1 and 52");
        }
        this.week = week;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }
}

