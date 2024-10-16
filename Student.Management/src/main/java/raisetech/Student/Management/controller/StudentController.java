package raisetech.Student.Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.Student.Management.Servise.StudentService;
import raisetech.Student.Management.controller.converter.StudentConverter;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.StudentsCourses;
import raisetech.Student.Management.domain.StudentDetail;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController

public class StudentController {
    private StudentService service;
    private StudentConverter converter;

    @Autowired
    public StudentController(StudentService service, StudentConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping("/studentList")
    public List<StudentDetail> getStudentList() {
       List<Student> students = service.searchStudentList();
       List<StudentsCourses> studentsCourses = service.searchStudentCourseList();

        return converter.covertStudentDetails(students, studentsCourses);
    }


    @GetMapping("/students_coursesList")
    public List<StudentsCourses> getStudentcoursesList() {
        return service.searchStudentCourseList();
    }


}



