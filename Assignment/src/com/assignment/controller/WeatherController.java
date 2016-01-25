package com.assignment.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment.model.WeatherInput;
import com.assignment.service.IWeatherService;

@Controller
@RequestMapping("/weather")
public class WeatherController {

	@Autowired(required = true)
	private IWeatherService weatherService;
	@Autowired(required = true)
	private MessageSource messageSource;

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void setWeatherService(IWeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initialiseFormBackingBean(ModelMap model) throws Exception {
		WeatherInput input = new WeatherInput();

		model.addAttribute("weather", input);

		return "Weather";
	}

	@ModelAttribute("cities")
	public List<String> initializeCountries() {

		return Arrays.asList(messageSource.getMessage("au.cities.list", null, null).split(","));

	}

	@RequestMapping(method = RequestMethod.POST)
	public String getCurentWeatherAction(@RequestParam("city") String city, ModelMap model) throws Exception {

		model.addAttribute("weatherVO", weatherService.retrieveWeatherData(city));

		WeatherInput input = new WeatherInput();
		input.setCity(city);
		model.addAttribute("weather", input);

		return "Weather";
	}

}
