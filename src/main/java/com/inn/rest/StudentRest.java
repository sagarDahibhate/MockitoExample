package com.inn.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inn.model.Student;
import com.inn.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentRest {

	@Autowired
	private StudentService studentService;

	@PostMapping("/add")
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		try {
			return studentService.createRecord(student);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
		}
	}
}
