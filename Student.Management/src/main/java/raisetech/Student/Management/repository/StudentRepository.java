package raisetech.Student.Management.repository;

import org.apache.ibatis.annotations.*;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.StudentsCourses;

import java.util.List;

@Mapper

public interface StudentRepository {


        @Select("SELECT * FROM students")
        List<Student> search();

        @Select("SELECT * FROM students_courses")
        List<StudentsCourses> searchStudentCourses();

}

