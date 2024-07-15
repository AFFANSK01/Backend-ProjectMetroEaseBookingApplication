package com.service;

import com.model.Admin;

public interface AdminService {

	public Admin saveAdmin(Admin admin);
	
	public Admin getAdmin(long adminId);
	
	public Admin updateAdmin(Admin admin);
	
	
	
}
