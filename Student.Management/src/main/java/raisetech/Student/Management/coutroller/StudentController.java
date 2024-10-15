package raisetech.Student.Management.coutroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.Student.Management.Servise.StudentService;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.StudentsCourses;

import java.util.List;

@RestController
public class StudentController {

    private StudentService service;
    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/studentList")
    public List<Student> getStudentList(){
        return service.searchStudentList();
    }
    @GetMapping("/students_coursesList")
    public List<StudentsCourses> getStudentcoursesList() {
        return service.searchStudentCourseList();
    }
    @GetMapping("/students30s")
    public List<Student> students30s(){
        return service.students30s();
    }
    @GetMapping("/students_coursesJava")
    public List<StudentsCourses> getStudentsCoursesJava(){
        return service.searchStudentsCoursesJava();
    }


    }

