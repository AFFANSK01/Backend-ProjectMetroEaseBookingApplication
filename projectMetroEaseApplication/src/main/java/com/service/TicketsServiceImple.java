package com.service;

//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TicketsRepository;
//import com.exception.TicketsNotFoundException;
import com.model.Tickets;

@Service
public class TicketsServiceImple implements TicketsService{

	@Autowired 
	TicketsRepository ticketRepo;
	
	@Override
	public Tickets saveTickets(Tickets t) {
		
		return ticketRepo.save(t);
	}

	@Override
	public Tickets getTicketById(long ticketId) {
		
		return ticketRepo.findById(ticketId).orElse(null);
	}

	@Override
	public List<Tickets> getAllTickets() {
		
		return ticketRepo.findAll();
	}

	/*
	@Override
	public Tickets updateTickets(Tickets tickets) {
		
		Tickets t = ticketRepo.findById(tickets.getTicketId()).orElse(null);
		t.setTravelDate(tickets.getTravelDate());
		
		Tickets updatedTicket = ticketRepo.save(t);
		return updatedTicket;
	}

	@Override
	public Map<String, Object> deleteTickets(long id) throws TicketsNotFoundException {
		
		Map<String, Object> response = new HashMap<>();
		   
		   try {
			   Tickets ticket = ticketRepo.findById(id).orElseThrow(()-> new TicketsNotFoundException("Ticket not found with id "+id));
			   ticketRepo.delete(ticket);
			   response.put("deleted", Boolean.TRUE);
		   }
		   
		   catch(TicketsNotFoundException m) {
			   response.put("not found", m.getMessage());
		   }
		   
		   return response;
    }
    
    */


}
