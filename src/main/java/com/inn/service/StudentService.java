package com.inn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inn.dao.IStudentRepo;
import com.inn.exception.ProvisioningException;
import com.inn.model.Student;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentService {

	@Autowired
	private IStudentRepo repo;

	public ResponseEntity<String> createRecord(Student student) {
		try {

			if (student.getRollno() == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("rollno should not be empty or null value :");
			}
			Student newStudent = repo.save(student);
			return ResponseEntity.status(HttpStatus.OK).body(newStudent.toString());

		} catch (ProvisioningException e) {
			throw new ProvisioningException(e.getMessage());
		}
	}
	
	
	
}
