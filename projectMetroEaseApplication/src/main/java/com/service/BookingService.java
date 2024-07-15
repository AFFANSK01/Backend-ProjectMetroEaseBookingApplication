package com.service;

import java.util.List;
import java.util.Map;

import com.exception.BookingNotFoundException;
import com.model.Booking;

public interface BookingService {

	public Booking saveBooking(Booking booking);
	
	public Map<String, Object> getBookingById(long id) throws BookingNotFoundException;
	
	public List<Booking> getAllBooking();
	
	public Booking updateBooking(Booking booking);
	
	public Map<String, Object> deleteBooking(long id);
	
}
