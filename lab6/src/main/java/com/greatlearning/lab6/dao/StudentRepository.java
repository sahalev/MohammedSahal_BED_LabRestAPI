package com.greatlearning.lab6.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.lab6.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
	
	
}
