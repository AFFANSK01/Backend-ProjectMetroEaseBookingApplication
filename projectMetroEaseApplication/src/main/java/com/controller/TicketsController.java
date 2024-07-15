package com.controller;

import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
/*
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
*/
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.exception.TicketsNotFoundException;
import com.model.Tickets;
import com.service.TicketsService;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
public class TicketsController {

	@Autowired
	TicketsService ticketService;
	
	@PostMapping("/addTicket")
	public Tickets saveTickets(@RequestBody Tickets ticket) {
		return ticketService.saveTickets(ticket);
	}
	
	@GetMapping("/getTickets")
	public Tickets getTicketById(@PathVariable int id) {
		return ticketService.getTicketById(id);
	}
	
	@GetMapping("/getAllTickets")
	public List<Tickets> getAllTickets(){
		return ticketService.getAllTickets();
	}
	
	//update and delete ticket is not needed
	
	/*
	@PutMapping("/updateTickets/{id}")
	public ResponseEntity<Tickets> updateTickets(@RequestBody Tickets ticket)
	{
		Tickets t = ticketService.updateTickets(ticket);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("User", "User updated").body(t);
	}
	
	@DeleteMapping("/deleteTickets/{id}")
	public ResponseEntity<Map<String, Object>> deleteTicket(@PathVariable ("id") long id) throws TicketsNotFoundException
	{
		Map<String, Object> response = ticketService.deleteTickets(id);
		
		return ResponseEntity.ok(response);
	}
	
	*/
	
}
