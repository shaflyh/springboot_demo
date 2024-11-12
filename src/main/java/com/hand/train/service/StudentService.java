package com.hand.train.service;

import com.hand.train.mapper.StudentMapper;
import com.hand.train.po.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentMapper mapper;

    public StudentService(StudentMapper studentMapper) {
        this.mapper = studentMapper;
    }

    public String addStudent(Student student) {
        mapper.insertStudent(student);
        return "Student added successfully!";
    }

    public String updateStudent(Student student) {
        mapper.updateStudent(student);
        return "Student id " + student.getStuId() + " updated successfully!";
    }

    public String deleteStudent(Long stuId) {
        mapper.deleteStudent(stuId);
        return "Student id " + stuId + " deleted successfully!";
    }

    public Student getStudentById(Long stuId) {
        return mapper.getStudentById(stuId);
    }

    public List<Student> getAllStudent() {
        return mapper.getAllStudents();
    }
}
