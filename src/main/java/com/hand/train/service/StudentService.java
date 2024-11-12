package com.hand.train.service;

import com.hand.train.mapper.StudentMapper;
import com.hand.train.po.Student;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class StudentService {

    private final StudentMapper mapper;
    private final RedisTemplate<String, Object> redisTemplate;

    public StudentService(StudentMapper studentMapper, RedisTemplate<String, Object> redisTemplate) {
        this.mapper = studentMapper;
        this.redisTemplate = redisTemplate;
    }

    public String addStudent(Student student) {
        mapper.insertStudent(student);
        redisTemplate.opsForValue().set("student:" + student.getStuId(), student, 10, TimeUnit.MINUTES);
        return "Student added successfully!";
    }

    public String updateStudent(Student student) {
        mapper.updateStudent(student);
        redisTemplate.opsForValue().set("student:" + student.getStuId(), student, 10, TimeUnit.MINUTES);
        return "Student id " + student.getStuId() + " updated successfully!";
    }

    public String deleteStudent(Long stuId) {
        mapper.deleteStudent(stuId);
        redisTemplate.delete("student:" + stuId);
        return "Student id " + stuId + " deleted successfully!";
    }

    public Student getStudentById(Long stuId) {
        String key = "student:" + stuId;

        // Try to fetch from Redis
        Student student = (Student) redisTemplate.opsForValue().get(key);
        if (student != null) {
            return student;
        }

        // If not found, fetch from database and cache it
        student = mapper.getStudentById(stuId);
        if (student != null) {
            redisTemplate.opsForValue().set(key, student, 10, TimeUnit.MINUTES);
        }
        return student;
    }

    public List<Student> getAllStudent() {
        return mapper.getAllStudents();
    }
}
