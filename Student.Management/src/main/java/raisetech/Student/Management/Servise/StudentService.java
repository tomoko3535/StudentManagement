package raisetech.Student.Management.Servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.StudentsCourses;
import raisetech.Student.Management.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository){
        this.repository = repository;
    }
    public List<Student> searchStudentList(){
        return repository.search();
    }
    public List<StudentsCourses> searchStudentCourseList(){
        return repository.searchStudentCourses();
    }
    public List<Student> students30s(){
        return repository.students30s();
    }
    public List<StudentsCourses> searchStudentsCoursesJava() {
        return repository.searchStudentsCoursesJava();
    }
}
