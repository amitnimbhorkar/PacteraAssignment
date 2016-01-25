package com.assignment.service;

import com.assignment.dto.WeatherValueObject;

public interface IWeatherService {

	/** This method retrieves weather data from corresponding data source.
	 * @param city
	 * @return
	 * @throws Exception
	 */
	WeatherValueObject retrieveWeatherData(String city) throws Exception;
}
