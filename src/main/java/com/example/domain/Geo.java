package com.example.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Geo {

	private String lat;
	private String lng;

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public Geo(String lat, String lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}

	public Geo() {
		super();
	}

}
