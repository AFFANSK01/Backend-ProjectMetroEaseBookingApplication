package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Tickets;

public interface TicketsRepository extends JpaRepository<Tickets, Long>{

}
