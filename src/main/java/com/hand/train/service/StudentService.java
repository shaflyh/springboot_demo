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

    public void addStudent(Student student) {
        mapper.insertStudent(student);
    }

    public void updateStudent(Student student) {
        mapper.updateStudent(student);
    }

    public void deleteStudent(Long stuId) {
        mapper.deleteStudent(stuId);
    }

    public Student getStudentById(Long stuId) {
        return mapper.getStudentById(stuId);
    }

    public List<Student> getAllStudent() {
        return mapper.getAllStudents();
    }
}
