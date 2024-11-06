package raisetech.student.management.repository;

import org.apache.ibatis.annotations.*;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentsCourses;

import java.util.List;

@Mapper

public interface StudentRepository {


    @Select("SELECT * FROM students")
    List<Student> search();

    @Select("SELECT * FROM students_courses")
    List<StudentsCourses> searchStudentCourses();

    @Insert("INSERT INTO students(name,kana_name,nickname,email,area,age,gender,remark,is_deleted) "
        + "VALUES(#{name},#{kanaName},#{email},#{area},#{age},#{sex},#{remark},false)")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void registerStudent(Student student);
}