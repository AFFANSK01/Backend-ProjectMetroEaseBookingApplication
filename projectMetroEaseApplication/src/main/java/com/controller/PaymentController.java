package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Payment;
import com.service.PaymentService;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/addPayment")
	public Payment addPayment(@RequestBody Payment payment)
	{
		return paymentService.savePayment(payment);
	}
	
	@GetMapping("/getPayment")
	public Payment getOnePayment(@PathVariable long id)
	{
		return paymentService.getOnePayment(id);
	}
	
	@GetMapping("/getAllPayment")
	public List<Payment> getAllPayment(){
		return paymentService.getAllPayment();
	}
}

