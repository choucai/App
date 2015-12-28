package com.dream.java.pattern.dp02_observer.system;

public class WeatherStationHeatIndex {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay(weatherData);
		com.dream.java.pattern.dp02_observer.system.StatisticsDisplay statisticsDisplay = new com.dream.java.pattern.dp02_observer.system.StatisticsDisplay(weatherData);
		com.dream.java.pattern.dp02_observer.system.ForecastDisplay forecastDisplay = new com.dream.java.pattern.dp02_observer.system.ForecastDisplay(weatherData);
		HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}
