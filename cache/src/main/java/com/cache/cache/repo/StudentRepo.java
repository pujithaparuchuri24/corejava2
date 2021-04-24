package com.cache.cache.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cache.cache.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{

}
