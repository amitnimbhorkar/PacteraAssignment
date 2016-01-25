package com.assignment.service;

import com.assignment.dto.WeatherValueObject;
import com.assignment.factory.IWeatherDataSource;
import com.assignment.factory.WeatherDataSourceFactory;
import com.assignment.util.IApplicationConstants;

public class WeatherServiceImpl implements IWeatherService {

	private WeatherDataSourceFactory weatherDataSourceFactory;

	public void setWeatherDataSourceFactory(WeatherDataSourceFactory weatherDataSourceFactory) {
		this.weatherDataSourceFactory = weatherDataSourceFactory;
	}

	public WeatherValueObject retrieveWeatherData(String city) throws Exception {
		IWeatherDataSource weatherDataSource = weatherDataSourceFactory
				.getWeatherDataSource(IApplicationConstants.OPEN_WEATHER_MAP_DATA_SOURCE);
		return weatherDataSource.getWeatherData(city);
	}
}
