package com.cache.cache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cache.cache.model.Student;
import com.cache.cache.repo.StudentRepo;

@RestController
public class StudentController {
	@Autowired
	private StudentRepo repo;
	@GetMapping("/save")
	public Student save()
	{
		Student s=new Student();
		s.setName("pujitha");
		Student s1=new Student();
		s1.setName("hema");
		repo.save(s1);
		Student s2=new Student();
		s2.setName("satyam");
		repo.save(s2);
		return repo.save(s);
		
	}
	@Cacheable(value="stud-cache")
	@GetMapping("/getall")
	public List<Student> getall()
	{
		return repo.findAll();
	}
	@Cacheable(value="stud-cache",key="#id")
	@GetMapping("/getbyid/{id}")
	public Student getById(@PathVariable int id)
	{
		return repo.findById(id).get();
	}

}
