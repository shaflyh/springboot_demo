package com.hand.train.mapper;

import com.hand.train.po.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Insert("INSERT INTO student (stu_id, stu_name, sex, birthdate) VALUES (#{stuId}, #{stuName}, #{sex}, #{birthdate})")
    void insertStudent(Student student);

    @Update("UPDATE student SET stu_name = #{stuName}, sex = #{sex}, birthdate = #{birthdate} WHERE stu_id = #{stuId}")
    void updateStudent(Student student);

    @Delete("DELETE FROM student WHERE stu_id = #{stuId}")
    void deleteStudent(Long stuId);

    @Select("SELECT * FROM student WHERE stu_id = #{stuId}")
    @Results({
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "stuName", column = "stu_name")
    })
    Student getStudentById(Long stuId);

    @Select("SELECT * FROM student")
    @Results({
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "stuName", column = "stu_name")
    })
    List<Student> getAllStudents();
}
