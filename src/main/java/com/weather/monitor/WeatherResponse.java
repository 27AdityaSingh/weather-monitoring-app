package com.weather.monitor;

public class WeatherResponse {
    private String name; // City name
    private Main main;

    // Getter and Setter for city name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for main (temperature, pressure, humidity)
    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    // Inner class Main to handle temperature, pressure, and humidity
    public static class Main {
        private double temp; // Temperature in Kelvin
        private double pressure;
        private double humidity;

        // Getter and Setter for temperature
        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        // Getter and Setter for pressure
        public double getPressure() {
            return pressure;
        }

        public void setPressure(double pressure) {
            this.pressure = pressure;
        }

        // Getter and Setter for humidity
        public double getHumidity() {
            return humidity;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        // Convert temperature from Kelvin to Celsius
        public double getTempInCelsius() {
            return temp - 273.15;
        }

        // Convert temperature from Kelvin to Fahrenheit
        public double getTempInFahrenheit() {
            return (temp - 273.15) * 9/5 + 32;
        }

        @Override
        public String toString() {
            return "Main{" +
                    "temp=" + temp +
                    ", pressure=" + pressure +
                    ", humidity=" + humidity +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "name='" + name + '\'' +
                ", main=" + main +
                '}';
    }
}

