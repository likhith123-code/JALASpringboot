package com.example.Demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Demo.Model.Student;
import com.example.Demo.Service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@GetMapping("/home/student/{mobile}/{name}")
	public ResponseEntity<?> getStudent(@PathVariable("mobile") String mobileNumber,@PathVariable("name") String firstName) {
		return service.findStudent(mobileNumber, firstName);
	}
	
	@PostMapping("/home/add")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		return service.createStudent(student);
	}
	
	@PutMapping("/home/edit/{id}")
	public ResponseEntity<?> addStudent(@PathVariable("id") int id,@RequestBody Student student) {
		return service.editStudent(id, student);
	}

	@DeleteMapping("/home/delete/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {
		return service.deleteStudent(id);
	}
	
}
