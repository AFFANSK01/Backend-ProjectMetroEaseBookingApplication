package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MetroRepository;
import com.exception.MetroNotFoundException;
import com.model.Metro;

@Service
public class MetroServiceImple implements MetroService{

	@Autowired
	MetroRepository metroRepo;

	@Override
	public Metro saveMetro(Metro metro) {
		
		return metroRepo.save(metro);
	}

	@Override
	public Metro getOneMetro(long id) {
		
		return metroRepo.findById(id).orElse(null);
	}

	@Override
	public List<Metro> getAllMetro() {
		
		return metroRepo.findAll();
	}

	@Override
	public Metro updateMetro(Metro metro) {
		
		Metro m = metroRepo.findById(metro.getMetroId()).orElse(null);
		m.setMetroName(metro.getMetroName());
		m.setCapacity(metro.getCapacity());
		
		Metro updatedMetro = metroRepo.save(m);
		return updatedMetro;
	}

	
	@Override
	public Map<String, Object> deleteMetro(long id) {
		
	   Map<String, Object> response = new HashMap<>();
	   
	   try {
		   Metro metro = metroRepo.findById(id).orElseThrow(()-> new MetroNotFoundException("Metro not found with id "+id));
		   metroRepo.delete(metro);
		   response.put("deleted", Boolean.TRUE);
	   }
	   
	   catch(MetroNotFoundException m) {
		   response.put("not found", m.getMessage());
	   }
	   
	   return response;
	}

}
