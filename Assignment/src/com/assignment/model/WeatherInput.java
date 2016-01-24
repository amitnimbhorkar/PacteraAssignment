package com.assignment.model;

import java.io.Serializable;

public class WeatherInput implements Serializable {

	private static final long serialVersionUID = 1L;

	String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
