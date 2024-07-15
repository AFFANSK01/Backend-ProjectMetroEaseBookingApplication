package com.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Tickets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ticketId;
	private LocalDateTime travelDate;
	private String arrivalTime;
	private String departureTime;
	//private double fare;
	
	@Lob
	@Column(length=100000)
	private byte[] ticketData;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private Booking booking;
	
	//@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	//private User user;
	
	public Tickets() {
		super();
	}

	public Tickets(long ticketId, LocalDateTime travelDate, String arrivalTime, String departureTime, 
			byte[] ticketData, Booking booking) {
		super();
		this.ticketId = ticketId;
		this.travelDate = travelDate;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		//this.fare = fare;
		this.ticketData = ticketData;
		this.booking = booking;
		//this.user = user;
	}

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public LocalDateTime getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDateTime travelDate) {
		this.travelDate = travelDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	/*
	 
	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

    */
	
	public byte[] getTicketData() {
		return ticketData;
	}

	public void setTicketData(byte[] ticketData) {
		this.ticketData = ticketData;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	/*
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	*/
	

}
