package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PaymentRepository;
import com.model.Payment;

@Service
public class PaymentServiceImple implements PaymentService{
	
	@Autowired
	PaymentRepository paymentRepo;
	

	@Override
	public Payment savePayment(Payment payment) {
		
		return paymentRepo.save(payment);
	}

	@Override
	public Payment getOnePayment(long id) {
		
		return paymentRepo.findById(id).orElse(null);
	}

	@Override
	public List<Payment> getAllPayment() {
		
		return paymentRepo.findAll();
	}

}
