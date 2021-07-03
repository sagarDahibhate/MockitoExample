package com.inn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.model.Student;

@Repository
public interface IStudentRepo extends JpaRepository<Student, Integer>{

}
