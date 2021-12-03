package com.projet_API.tp5.data.data.meteo;

public class MeteoData {
	
	private int day;
	private int tmin;
	private int tmax;
	private int probarain;
	
	public MeteoData() {
	}

	public int getProbarain() {
		return probarain;
	}

	public void setProbarain(int probarain) {
		this.probarain = probarain;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getTmin() {
		return tmin;
	}

	public void setTmin(int tmin) {
		this.tmin = tmin;
	}

	public int getTmax() {
		return tmax;
	}

	public void setTmax(int tmax) {
		this.tmax = tmax;
	}
	
	
}
