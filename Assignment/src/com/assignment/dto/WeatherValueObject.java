package com.assignment.dto;

import java.io.Serializable;
import java.util.Date;

public class WeatherValueObject implements Serializable {

	private static final long serialVersionUID = 1L;

	private String city;
	private Date updatedTime;
	private String weather;
	private String temperature;
	private String wind;
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWind() {
		return wind;
	}

	public void setWind(String wind) {
		this.wind = wind;
	}
}
