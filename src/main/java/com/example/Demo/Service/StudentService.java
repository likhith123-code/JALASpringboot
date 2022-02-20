package com.example.Demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Demo.Model.Student;
import com.example.Demo.Repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	public ResponseEntity<?> createStudent(Student student){
		studentRepository.save(student);
		return new ResponseEntity<String>("Student created successfully",HttpStatus.OK);
				
	}
	
	public ResponseEntity<?> findStudent(String mobileNumber,String name){
		Student existingStudent = studentRepository.findByMobileNumberAndFirstName(mobileNumber,name);
		
		if(existingStudent==null)
			return new ResponseEntity<String>("Student Not Found ",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Student>(existingStudent,HttpStatus.OK);
	}
	
	public ResponseEntity<?> editStudent(int id,Student student){
		Optional<Student> existingStudent = studentRepository.findById(id);
		Student presentStudent = existingStudent.get();
		
		if(presentStudent==null)
			return new ResponseEntity<String>("Student Not Found ",HttpStatus.NOT_FOUND);
		
		presentStudent.setDescription(student.getDescription());
		presentStudent.setDOB(student.getDOB());
		presentStudent.setEmailId(student.getEmailId());
		presentStudent.setFirstName(student.getFirstName());
		presentStudent.setGender(student.getGender());
		presentStudent.setLastName(student.getLastName());
		presentStudent.setMobileNumber(student.getMobileNumber());
		presentStudent.setQualification(student.getQualification());
		studentRepository.save(presentStudent);
		
		return new ResponseEntity<String>("Student Updated ",HttpStatus.OK);
		
	}
	
	public ResponseEntity<?> deleteStudent(int id){
		Optional<Student> stOptional = studentRepository.findById(id);
		if(stOptional.get()==null)
			return new ResponseEntity<String>("Student Not Found ",HttpStatus.NOT_FOUND);
		studentRepository.deleteById(id);
		return new ResponseEntity<String>("Student deleted ",HttpStatus.OK);
	}
	
	
}
