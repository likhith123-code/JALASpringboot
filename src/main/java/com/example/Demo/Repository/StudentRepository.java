package com.example.Demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Demo.Model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query(value = "select * from students where mobileNumber = ?1 and firstName = ?2",nativeQuery = true)
	Student findByMobileNumberAndFirstName(String mobileNumber,String firstName);
}
