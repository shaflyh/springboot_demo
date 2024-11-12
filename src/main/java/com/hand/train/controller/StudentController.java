package com.hand.train.controller;

import com.hand.train.po.Student;
import com.hand.train.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Student API")
@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @ApiOperation(value = "Add a new student")
    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(service.addStudent(student));
    }

    @ApiOperation(value = "Update an existing student")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setStuId(id);
        return ResponseEntity.ok(service.updateStudent(student));
    }

    @ApiOperation(value = "Delete a student by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteStudent(id));
    }

    @ApiOperation(value = "Get a student by ID")
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @ApiOperation(value = "Get all students")
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudent();
    }
}
