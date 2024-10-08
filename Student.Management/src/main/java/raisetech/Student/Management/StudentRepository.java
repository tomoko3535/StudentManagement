package raisetech.Student.Management;

import org.apache.ibatis.annotations.*;

@Mapper

public interface StudentRepository {

    @Select("SELECT * FROM students_courses")
    List<studentsCourses> search();
}
