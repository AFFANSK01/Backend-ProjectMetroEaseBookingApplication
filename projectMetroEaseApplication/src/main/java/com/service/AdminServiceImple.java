package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AdminRepository;
import com.model.Admin;

@Service
public class AdminServiceImple implements AdminService{

	@Autowired
	AdminRepository adminRepo;
	
	@Override
	public Admin saveAdmin(Admin a) {
	
		return adminRepo.save(a);
	}

	@Override
	public Admin getAdmin(long adminId) {
		
		return adminRepo.findById(adminId).orElse(null);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		
		Admin a = adminRepo.findById(admin.getAdminId()).orElse(null);
		a.setAdminName(admin.getAdminName());
		a.setAdminPhoneNo(admin.getAdminPhoneNo());
		return adminRepo.save(a);
	}
	

}
