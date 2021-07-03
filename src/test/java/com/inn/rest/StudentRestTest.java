package com.inn.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inn.model.Student;
import com.inn.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebMvcTest(controllers = StudentRest.class)
public class StudentRestTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;

	@Autowired
	private ObjectMapper ObjectMapper;

	public StudentRestTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void addStudentTest() throws Exception {
		log.info("test case started:");
		Student student = new Student(1, "sagar", "adarsh");
		String reqJson = ObjectMapper.writeValueAsString(student);

		Mockito.when(studentService.createRecord(student))
				.thenReturn(ResponseEntity.status(HttpStatus.OK).body(student.toString()));
		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.post("/student/add").content(reqJson).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		log.info("result :{}", result.getResponse());
		String resultContext = result.getResponse().getContentAsString();

		log.info("result Context :{}", resultContext);
	}
}
