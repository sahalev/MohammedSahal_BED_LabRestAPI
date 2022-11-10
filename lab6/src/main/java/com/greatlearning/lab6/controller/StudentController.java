package com.greatlearning.lab6.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.lab6.dao.StudentRepository;
import com.greatlearning.lab6.entity.Student;
import com.greatlearning.lab6.service.StudentService;

@Controller
@RequestMapping("students")
public class StudentController {
	
	
	@Autowired
	StudentService service;
	
	@GetMapping("list")
	public String showStudents(Model model)
	{
		List<Student> students=service.fetchAllStudents();
		model.addAttribute("students", students);
		return "studentlist";
	}
	
	
	@GetMapping("showForm")
	public String showStudentForm(Model model)
	{
		Student st = new Student();
		model.addAttribute("student", st);
		return "studentForm";
	}
	

	@PostMapping("save")
	public String saveStudent(Model model, @ModelAttribute("student") Student student)
	{
		service.saveStudent(student);
		return "redirect:/students/list";
	}
	
	@GetMapping("edit")
	public String updateStudent(Model model, @RequestParam("id") long id)
	{
		Student st = service.fetchStudentById(id);
		model.addAttribute("student", st);
		return "studentForm";
	}
	
	@GetMapping("delete")
	public String deleteStudent(Model model, @RequestParam("id") long id)
	{
		service.deleteStudent(id);
		return "redirect:/students/list";
	}
	
	@GetMapping("access-denied")
	public String showAccessDenied()
	{
		return "access-denied";
	}



}
