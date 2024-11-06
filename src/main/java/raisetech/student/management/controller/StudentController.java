package raisetech.student.management.controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import raisetech.student.management.Service.StudentService;
import raisetech.student.management.controller.converter.StudentConverter;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentsCourses;

import java.util.List;

@Controller
public class StudentController {

    private StudentService service;
    private StudentConverter converter;

    @Autowired
    public StudentController(StudentService service, StudentConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping("/studentList")
    public String getStudentList(Model model){
        List<Student> students = service.searchStudentList();
        List<StudentsCourses> studentsCourses = service.searchStudentCourseList();

        model.addAttribute("studentList", converter.covertStudentDetails(students,studentsCourses));
        return "studentList";
    }


    @GetMapping("/students_coursesList")
    public List<StudentsCourses> getStudentcoursesList() {
        return service.searchStudentCourseList();
    }
}