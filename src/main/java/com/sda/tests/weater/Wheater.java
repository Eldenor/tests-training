package com.sda.tests.weater;

public class Wheater {
    private long timestamp;
    private double temperature;
    private double windSpeed;
    private int clouds;
    private double rainVolume;

    public Wheater(long timestamp, double temperature, double windSpeed, int clouds, double rainVolume) {
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.clouds = clouds;
        this.rainVolume = rainVolume;
    }

    public Wheater(long timestamp, double temperature, double windSpeed, int clouds) {
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.clouds = clouds;
    }

    public Wheater() {

    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public double getRainVolume() {
        return rainVolume;
    }

    public void setRainVolume(double rainVolume) {
        this.rainVolume = rainVolume;
    }
}
