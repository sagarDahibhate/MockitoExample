package com.inn.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.inn.dao.IStudentRepo;
import com.inn.model.Student;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class StudentServiceTest {

	@Autowired
	private StudentService studentService;

	public StudentServiceTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void createRecordTest() {
		log.info("first test case");
		ResponseEntity<String> resp = studentService.createRecord(new Student(6, "shubham", "mahanajn"));
		System.out.println("resp: {}" + resp);
	}
}
