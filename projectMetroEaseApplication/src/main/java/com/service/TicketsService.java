package com.service;

import java.util.List;
//import java.util.Map;

//import com.exception.TicketsNotFoundException;
import com.model.Tickets;

public interface TicketsService {

	public Tickets saveTickets(Tickets ticket);
	
	public Tickets getTicketById(long ticketId);
	
	public List<Tickets> getAllTickets();
	
	/*
    public Tickets updateTickets(Tickets tickets);
	
	public Map<String, Object> deleteTickets(long id) throws TicketsNotFoundException;
	 */
	
}
