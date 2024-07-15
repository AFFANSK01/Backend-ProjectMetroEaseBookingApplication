	package com.model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Metro {
    
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "metro_seq")
	@SequenceGenerator(name = "metro_seq", sequenceName = "metro_sequence", allocationSize=501)
	private long metroId;
	private String metroName;
	private long capacity;
	                                                                 //Cascadetype.PERSIST - will only to persist or save the data
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)   //Cascasdetype.All - will allow us to perform all operation (persist, remove, merge, refresh, detach) are cascaded. 
	private List<StationRoute> stationRoute;                        //save metro along with station route list

	public Metro() {
		super();
	}

	public Metro(long metroId, String metroName, long capacity, List<StationRoute> stationRoute) {
		super();
		this.metroId = metroId;
		this.metroName = metroName;
		this.capacity = capacity;
		this.stationRoute = stationRoute;
	}	

	public long getMetroId() {
		return metroId;
	}

	public void setMetroId(long metroId) {
		this.metroId = metroId;
	}

	public String getMetroName() {
		return metroName;
	}

	public void setMetroName(String metroName) {
		this.metroName = metroName;
	}

	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	public List<StationRoute> getStationRoute() {
		return stationRoute;
	}

	public void setStationRoute(List<StationRoute> stationRoute) {
		this.stationRoute = stationRoute;
	}
	
	
}
