package com.assignment.factory;

import com.assignment.util.IApplicationConstants;

public class WeatherDataSourceFactory {

	private OpenWeatherMapSource openWeatherMapSource;

	private SomeOtherSource someOtherSource;

	public void setOpenWeatherMapSource(OpenWeatherMapSource openWeatherMapSource) {
		this.openWeatherMapSource = openWeatherMapSource;
	}

	public void setSomeOtherSource(SomeOtherSource someOtherSource) {
		this.someOtherSource = someOtherSource;
	}

	public IWeatherDataSource getWeatherDataSource(String clientName) {
		if (clientName.equals(IApplicationConstants.OPEN_WEATHER_MAP_DATA_SOURCE)) {
			return openWeatherMapSource;
		} else if (clientName.equals(IApplicationConstants.SOME_OTHER_DATA_SOURCE)) {
			return someOtherSource;
		}
		return null;
	}
}
