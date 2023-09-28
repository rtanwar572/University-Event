package com.Rohit.UniversityStudent.Controller;

import com.Rohit.UniversityStudent.entities.Department;
import com.Rohit.UniversityStudent.entities.Student;
import com.Rohit.UniversityStudent.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student)
    {
        Student addedStudent=studentService.addStudent(student);
        return ResponseEntity.ok(addedStudent);
    }
    @GetMapping
    public ResponseEntity<List<Student>>getAllStudents(){
        List<Student>students=studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
    @GetMapping("/{studentId}")
    public ResponseEntity<Student>getStudentById(@PathVariable int studentId)
    {
        Student student=studentService.getStudentById(studentId);
        return ResponseEntity.ok(student);
    }
    @PatchMapping("/{studentId}/department")
    public String updateStudentDepartment(
            @PathVariable int studentId, @RequestBody Department department)
    {
        return studentService.updateStudentDepartment(studentId,department);
    }
    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void>deleteStudent(@PathVariable int studentId)
    {
        studentService.deleteStudent(studentId);
        return  ResponseEntity.ok().build();
    }

}
