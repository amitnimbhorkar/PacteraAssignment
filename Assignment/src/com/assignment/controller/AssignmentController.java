package com.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/weather")
public class AssignmentController {

	@RequestMapping(method = RequestMethod.GET)
	   public String getCurrentWeather(ModelMap model) {
	      model.addAttribute("message", "Hello Spring MVC Framework!");
	      return "Weather";
	   }
}
