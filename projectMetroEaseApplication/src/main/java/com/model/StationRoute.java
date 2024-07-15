package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StationRoute {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long stationId;
	private String fromStation;
	private String toStation;
	private double distance;
	private int fare;
	
	public StationRoute() {
		super();
	}

	public StationRoute(long stationId, String fromStation, String toStation, double distance, int fare) {
		super();
		this.stationId = stationId;
		this.fromStation = fromStation;
		this.toStation = toStation;
		this.distance = distance;
		this.fare = fare;
	}

	public long getStationId() {
		return stationId;
	}

	public void setStationId(long stationId) {
		this.stationId = stationId;
	}

	public String getFromStation() {
		return fromStation;
	}

	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}

	public String getToStation() {
		return toStation;
	}

	public void setToStation(String toStation) {
		this.toStation = toStation;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public int getFare() {
		return fare;
	}
	
	public void setFare(int fare) {
		this.fare = fare;
	}
	
}
