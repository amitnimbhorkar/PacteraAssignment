package com.assignment.service;

import java.util.Date;

import org.bitpipeline.lib.owm.OwmClient;
import org.bitpipeline.lib.owm.WeatherData;
import org.bitpipeline.lib.owm.WeatherStatusResponse;

import com.assignment.dto.WeatherValueObject;

public class WeatherServiceImpl implements WeatherService{

	public WeatherValueObject retrieveWeatherData(String city) throws Exception {
		WeatherValueObject weatherVO = new WeatherValueObject();

		OwmClient owm = new OwmClient();

		WeatherStatusResponse currentWeather = owm.currentWeatherAtCity(city);
		if (currentWeather.hasWeatherStatus()) {

			WeatherData weather = currentWeather.getWeatherStatus().get(0);

			double celsius = ((weather.getTemp() - 32) * (5 / 9.0));

			weatherVO.setTemperature(String.valueOf(celsius) + "\'C");

			weatherVO.setUpdatedTime(new Date(weather.getDateTime()));

			weatherVO.setWind(((weather.getWindSpeed() * 18) / 5) + " km/h");

			weatherVO.setWeather(weather.getWeatherConditions().get(0).getDescription());

			weatherVO.setCity(city);

			System.out.println("Temp=" + weather.getTemp() + ", Time=" + weather.getDateTime() + ", Wind="
					+ weather.getWindSpeed() + ", Desc=" + weather.getWeatherConditions().get(0).getDescription());
		}

		return weatherVO;
	}
}
