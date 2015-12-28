package com.dream.java.pattern.dp02_observer.weather.observer;

public interface Observer {
	public void update(float temp, float humidity, float pressure);
}
