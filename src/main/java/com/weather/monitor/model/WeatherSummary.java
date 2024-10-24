package com.weather.monitor.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

public class WeatherSummary {
    // Define the properties of WeatherSummary
    @NotNull(message = "City name cannot be null")
    @Size(min = 1, message = "City name must not be empty")
    private String city;

    private double temperature;

    @NotNull(message = "Description cannot be null")
    @Size(min = 1, message = "Description must not be empty")
    private String description;

    // Constructor
    public WeatherSummary(String city, double temperature, String description) {
        this.city = city;
        this.temperature = temperature;
        this.description = description;
    }

    // Getters and Setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "WeatherSummary{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeatherSummary)) return false;
        WeatherSummary that = (WeatherSummary) o;
        return Double.compare(that.temperature, temperature) == 0 &&
               Objects.equals(city, that.city) &&
               Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, temperature, description);
    }
}

