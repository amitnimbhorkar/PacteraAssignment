package com.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment.model.WeatherInput;
import com.assignment.service.WeatherService;

@Controller
@RequestMapping("/weather")
public class AssignmentController {

	@Autowired(required=true)
	private WeatherService weatherService;

	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getCurrentWeather(ModelMap model) throws Exception {
		WeatherInput input = new WeatherInput();

		model.addAttribute("weather", input);

		return "Weather";
	}

	@ModelAttribute("cities")
	public List<String> initializeCountries() {

		List<String> cities = new ArrayList<String>();
		cities.add("Melbourne");
		cities.add("Sydney");
		cities.add("Wollongong");
		return cities;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String getWeatherAction(@RequestParam("city") String city, ModelMap model) throws Exception {

		model.addAttribute("weatherVO", weatherService.retrieveWeatherData(city));

		WeatherInput input = new WeatherInput();
		input.setCity(city);
		model.addAttribute("weather", input);

		return "Weather";
	}

}
