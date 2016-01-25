package com.assignment.factory;

import com.assignment.dto.WeatherValueObject;

public interface IWeatherDataSource {

	public WeatherValueObject getWeatherData(String city) throws Exception;
}
