package com.service;

import java.util.List;
import java.util.Map;

import com.exception.StationRouteNotFoundException;
import com.model.StationRoute;

public interface StationRouteService {

	public StationRoute saveStationRoute(StationRoute station);
	
	public StationRoute getStationRoute(long stationRouteId);
	
	public List<StationRoute> getAllStationRoute();
	
	public StationRoute updateStationRoute(StationRoute stationRoute);
	
	public Map<String, Object> deleteStationRoute(long id) throws StationRouteNotFoundException;

	public int calculateFare(String fromStation, String toStation);
}
