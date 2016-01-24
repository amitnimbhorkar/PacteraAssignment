package com.assignment.service;

import com.assignment.dto.WeatherValueObject;

public interface WeatherService {
	WeatherValueObject retrieveWeatherData(String city) throws Exception;
}
