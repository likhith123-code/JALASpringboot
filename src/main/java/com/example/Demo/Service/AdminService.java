package com.example.Demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Demo.Model.Admin;
import com.example.Demo.Repository.AdminRepository;

@Service
public class AdminService {

	@Autowired 
	AdminRepository adminRepository;
	public ResponseEntity<?> login(Admin admin){
		Admin admin2 = adminRepository.findByUsername(admin.getUserrname());
		if(admin2==null)
			return new ResponseEntity<String>("No User Found",HttpStatus.NOT_FOUND);
		return new ResponseEntity<String>("User logged In",HttpStatus.OK);
	}
}
