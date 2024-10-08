package raisetech.Student.Management;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface StudentRepository {

    @Select("SELECT * FROM students_courses")
    List<studentsCourses> search();

}
