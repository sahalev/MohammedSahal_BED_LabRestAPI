package com.greatlearning.lab6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.lab6.dao.StudentRepository;
import com.greatlearning.lab6.entity.Student;



@Service
public class StudentService {
	
	@Autowired
	private  StudentRepository studentRepository;
	
	public Student saveStudent(Student st)
	{
		return this.studentRepository.save(st);
	}
	
	
	public List<Student> fetchAllStudents()
	{
		return this.studentRepository.findAll();
	}
	
	public Student fetchStudentById(long id)
	{
		return this.studentRepository.findById(id).orElseThrow();
	}
	public void deleteStudent(long id)
	{
		this.studentRepository.deleteById(id);
	}
	
	
	

}
