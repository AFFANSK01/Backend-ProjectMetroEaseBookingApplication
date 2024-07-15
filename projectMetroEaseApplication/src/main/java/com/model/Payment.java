package com.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long payId;
	private String paymentMethod;
	private double amount;
	private String status;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private Booking booking;
	
	public Payment() {
		super();
	}

	public Payment(long payId, String paymentMethod, double amount, String status, Booking booking) {
		super();
		this.payId = payId;
		this.paymentMethod = paymentMethod;
		this.amount = amount;
		this.status = status;
		this.booking = booking;
	}

	public long getPayId() {
		return payId;
	}

	public void setPayId(long payId) {
		this.payId = payId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	
	
}
