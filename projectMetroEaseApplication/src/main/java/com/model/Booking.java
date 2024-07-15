package com.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookingId;
	private String passengerName;
	private String fromStation;
	private String toStation;
	private int fare;
	
	//distance optional 
	
	@Column(columnDefinition="TIMESTAMP")
	private LocalDate travelDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="metro_id")
	private Metro metro;

	public Booking() {
		super();
	}

	public Booking(long bookingId, String passengerName, String fromStation, String toStation, int fare, LocalDate travelDate,
		 Metro metro) {
		super();
		this.bookingId = bookingId;
		this.passengerName = passengerName;
		this.fromStation = fromStation;
		this.toStation = toStation;
		this.fare = fare;
		this.travelDate = travelDate;
		this.metro = metro;
	}

	public long getBookId() {
		return bookingId;
	}

	public void setBookId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
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

	public int getFare() {
		return fare;
	}
	
	public void setFare(int fare) {
	   this.fare = fare;	
	}
	
	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public Metro getMetro() {
		return metro;
	}

	public void setMetro(Metro metro) {
		this.metro = metro;
	}
	
		
}
