package com.assignment.controller;

import java.util.Date;

import org.bitpipeline.lib.owm.OwmClient;
import org.bitpipeline.lib.owm.WeatherData;
import org.bitpipeline.lib.owm.WeatherStatusResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.assignment.dto.WeatherValueObject;

@Controller
@RequestMapping("/weather")
public class AssignmentController {

	@RequestMapping(method = RequestMethod.GET)
	public String getCurrentWeather(ModelMap model) throws Exception {

		WeatherValueObject weatherVO = new WeatherValueObject();

		OwmClient owm = new OwmClient();

		WeatherStatusResponse currentWeather = owm.currentWeatherAtCity("Melbourne", "AU");
		if (currentWeather.hasWeatherStatus()) {
			WeatherData weather = currentWeather.getWeatherStatus().get(0);

			weatherVO.setTemperature(String.valueOf(weather.getTemp()));

			weatherVO.setUpdatedTime(new Date(weather.getDateTime()));

			weatherVO.setWind(((weather.getWindSpeed() * 18) / 5) + " km/h");

			weatherVO.setWeather(weather.getWeatherConditions().get(0).getDescription());

		}

		model.addAttribute("message", "PFA data");
		model.addAttribute("weatherVO", weatherVO);
		return "Weather";
	}
}
