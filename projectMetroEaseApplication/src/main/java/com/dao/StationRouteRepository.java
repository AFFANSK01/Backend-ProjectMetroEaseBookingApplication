package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.StationRoute;

public interface StationRouteRepository extends JpaRepository<StationRoute, Long>{

	 List<StationRoute> findByFromStationAndToStation(String fromStation, String toStation);	
}
