package com.service;

import java.util.List;

import com.model.Payment;

public interface PaymentService  {

	public Payment savePayment(Payment payment);
	
	public Payment getOnePayment(long id);
	
	public List<Payment> getAllPayment();

}
