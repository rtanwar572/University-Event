package com.Rohit.UniversityStudent.service;


import com.Rohit.UniversityStudent.repository.StudentRepo;
import com.Rohit.UniversityStudent.entities.Department;
import com.Rohit.UniversityStudent.entities.Student;
import com.Rohit.UniversityStudent.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public  Student getStudentById(int studentId) {
        return studentRepo.findById(studentId).orElseThrow(()->new IllegalArgumentException("Student Not found"));
    }

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        return (List<Student>) studentRepo.findAll();
    }

    public String updateStudentDepartment(int studentId, Department department) {
        Student student =studentRepo.findById(studentId)
                .orElseThrow(()->new IllegalArgumentException("Student not found"));
        student.setDepartment(department);
        studentRepo.save(student);
        return "Updated Successfully !!";
    }

    public void deleteStudent(int studentId) {
        studentRepo.deleteById(studentId);
    }
}
