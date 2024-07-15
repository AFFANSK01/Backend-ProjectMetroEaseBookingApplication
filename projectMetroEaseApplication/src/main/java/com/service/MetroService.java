package com.service;

import java.util.List;
import java.util.Map;

import com.exception.MetroNotFoundException;
import com.model.Metro;

public interface MetroService {

	public Metro saveMetro(Metro metro);
	
	public Metro getOneMetro(long id);
	
	public List<Metro> getAllMetro();
	
	public Metro updateMetro(Metro metro);
	
	public Map<String, Object> deleteMetro(long id) throws MetroNotFoundException;
}
