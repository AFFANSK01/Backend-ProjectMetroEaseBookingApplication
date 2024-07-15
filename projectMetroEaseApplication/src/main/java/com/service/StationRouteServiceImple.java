package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StationRouteRepository;
import com.exception.StationRouteNotFoundException;
import com.model.StationRoute;

@Service
public class StationRouteServiceImple implements StationRouteService{

	@Autowired
	StationRouteRepository stationRouteRepo; 
	
	@Override
	public StationRoute saveStationRoute(StationRoute station) {
		
		return stationRouteRepo.save(station);
	}

	@Override
	public StationRoute getStationRoute(long stationRouteId) {
		
		return stationRouteRepo.findById(stationRouteId).orElse(null);
	}
	

	@Override
	public List<StationRoute> getAllStationRoute() {
		
		return stationRouteRepo.findAll();
	}

	@Override
	public StationRoute updateStationRoute(StationRoute stationRoute) {
		
		StationRoute station = stationRouteRepo.findById(stationRoute.getStationId()).orElse(null);
		station.setFromStation(stationRoute.getFromStation());
		station.setToStation(stationRoute.getToStation());
		station.setFare(stationRoute.getFare());
		return stationRouteRepo.save(station);
	}

	@Override
	public Map<String, Object> deleteStationRoute(long id) throws StationRouteNotFoundException {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			StationRoute station = stationRouteRepo.findById(id).orElseThrow(()-> new StationRouteNotFoundException("StationRoute not found"+id));
			stationRouteRepo.delete(station);
			response.put("deleted", Boolean.TRUE);
		}
		catch(StationRouteNotFoundException s)
		{
			response.put("not found", s.getMessage());
		}
		return response;
	}

	@Override
	public int calculateFare(String fromStation, String toStation) {
		List<StationRoute> routes = stationRouteRepo.findByFromStationAndToStation(fromStation, toStation);

        // Calculate total fare
        int totalFare = routes.stream().mapToInt(StationRoute::getFare).sum();

        return totalFare;
	}

	

}
