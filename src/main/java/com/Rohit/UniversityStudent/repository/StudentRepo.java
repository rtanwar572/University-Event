package com.Rohit.UniversityStudent.repository;


import com.Rohit.UniversityStudent.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends CrudRepository<Student,Integer> {
}
