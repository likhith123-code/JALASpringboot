package com.example.Demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Demo.Model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{

	@Query(value = "Select * from admin where username = ?1",nativeQuery = true)
	Admin findByUsername(String userrname);
	

}
