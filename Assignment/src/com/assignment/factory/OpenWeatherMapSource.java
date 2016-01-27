package com.assignment.factory;

import org.bitpipeline.lib.owm.OwmClient;
import org.bitpipeline.lib.owm.WeatherData;
import org.bitpipeline.lib.owm.WeatherStatusResponse;

import com.assignment.dto.WeatherValueObject;
import com.assignment.util.ApplicationUtils;
import com.assignment.util.IApplicationConstants;

public class OpenWeatherMapSource implements IWeatherDataSource {

	private OwmClient owmClient;

	public void setOwmClient(OwmClient owmClient) {
		this.owmClient = owmClient;
	}

	@Override
	public WeatherValueObject getWeatherData(String city) throws Exception {
		WeatherValueObject weatherVO = new WeatherValueObject();

		WeatherStatusResponse currentWeather = owmClient.currentWeatherAtCity(city,
				IApplicationConstants.DEFAULT_COUNTRY);
		if (currentWeather!= null && currentWeather.hasWeatherStatus()) {

			WeatherData weather = currentWeather.getWeatherStatus().get(0);

			weatherVO.setTemperature(ApplicationUtils.convertKelvinToCelcius(weather.getTemp()) + "\'C");

			weatherVO.setUpdatedTime(ApplicationUtils.convertDateToStringInReqFormat(weather.getDateTime(),
					IApplicationConstants.DATE_FORMAT));

			weatherVO.setWind(((weather.getWindSpeed() * 18) / 5) + " km/h");

			weatherVO.setWeather(weather.getWeatherConditions().get(0).getDescription());

			weatherVO.setCity(city);
		}

		return weatherVO;

	}

}
