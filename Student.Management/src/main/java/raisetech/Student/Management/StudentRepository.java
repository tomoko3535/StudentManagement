package raisetech.Student.Management;

import org.apache.ibatis.annotations.*;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.StudentsCourses;

import java.util.List;

@Mapper

public interface StudentRepository {


        @Select("SELECT * FROM students WHERE age BETWEEN 30 AND 39")
        List<Student> search();

        @Select("SELECT * FROM students_courses WHERE course_name ='Java'")
        List<StudentsCourses> searchStudentCourses();

}

