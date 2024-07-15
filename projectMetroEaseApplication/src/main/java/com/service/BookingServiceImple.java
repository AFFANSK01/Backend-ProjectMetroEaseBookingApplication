package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookingRepository;
import com.dao.MetroRepository;
import com.exception.BookingNotFoundException;
import com.model.Booking;
import com.model.Metro;

@Service
public class BookingServiceImple implements BookingService{
	
	@Autowired
	BookingRepository bookingRepo;
	
	@Autowired
	MetroRepository metroRepo;

	@Override
	public Booking saveBooking(Booking booking) {
		
		Metro metro = metroRepo.findById(booking.getMetro().getMetroId()).orElseThrow(()-> new RuntimeException("Metro Not Found"));
		
		booking.setMetro(metro);
		return bookingRepo.save(booking);
	}

	@Override
	public Map<String, Object> getBookingById(long id) throws BookingNotFoundException {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			Booking booking = bookingRepo.findById(id).orElseThrow(()-> new BookingNotFoundException("Booking Not Found with id"+id));
			
			response.put("found", Boolean.TRUE);
		}
		
		catch(BookingNotFoundException b) {
			response.put("not found", b.getMessage());
		}
		return response;
	}

	@Override
	public List<Booking> getAllBooking() {
		
		return bookingRepo.findAll();
	}

	@Override
	public Booking updateBooking(Booking booking) {
		
		Booking b = bookingRepo.findById(booking.getBookId()).orElse(booking);
		b.setFromStation(booking.getFromStation());
		b.setToStation(booking.getToStation());
		b.setTravelDate(booking.getTravelDate());
		Booking updatedBooking = bookingRepo.save(b);
		return updatedBooking;
	}

	@Override
	public Map<String, Object> deleteBooking(long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			Booking booking = bookingRepo.findById(id).orElse(null);
			bookingRepo.delete(booking);
			response.put("deleted", Boolean.TRUE);
					
		}
		catch(Exception e) {
			response.put("not deleted", e.getMessage());
		}
		return response;
	}
	

}
