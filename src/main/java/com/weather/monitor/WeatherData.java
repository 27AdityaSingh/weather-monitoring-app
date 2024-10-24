package com.weather.monitor;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity(name = "WeatherDataEntity")  // Give this entity a unique name
@Table(name = "weather_data")
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "City name cannot be null")
    @Size(min = 1, message = "City name must not be empty")
    @Column(name = "city", nullable = false)  // Explicit column mapping
    private String city;

    @NotNull(message = "Temperature cannot be null")
    @Column(name = "temperature", nullable = false)  // Explicit column mapping
    private double temperature;

    @Column(name = "recorded_at")  // Renamed the timestamp column to be more descriptive
    private LocalDateTime timestamp;

    // No-argument constructor
    public WeatherData() {
    }

    // Constructor with parameters, defaulting the timestamp if not provided
    public WeatherData(String city, double temperature, LocalDateTime timestamp) {
        this.city = city;
        this.temperature = temperature;
        this.timestamp = (timestamp != null) ? timestamp : LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", temperature=" + temperature +
                ", timestamp=" + timestamp +
                '}';
    }
}

