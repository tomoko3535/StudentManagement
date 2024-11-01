package raisetech.Student.Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.Student.Management.repository.StudentRepository;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.StudentsCourses;
import raisetech.Student.Management.domain.StudentDetail;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {
    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> searchStudentList() {
        return repository.search();
    }

    public StudentDetail searchStudent(String id){
       Student student = repository.searchStudent(id);
       List<StudentsCourses>studentsCourses = repository.searchStudentsCourses(student.getId());
       StudentDetail studentDetail = new StudentDetail();
       studentDetail.setStudent(student);
       studentDetail.setStudentsCourses(studentsCourses);
       return studentDetail;
    }

    public List<StudentsCourses> searchStudentCourseList() {
        return repository.searchStudentsCoursesList();
    }

    @Transactional
    public void registerStudent(StudentDetail studentDetail) {
        repository.registerStudent(studentDetail.getStudent());
        for (StudentsCourses studentsCourse : studentDetail.getStudentsCourses()) {
            studentsCourse.setStudentId(studentDetail.getStudent().getId());
            studentsCourse.setCourseStartAt(LocalDateTime.now());
            studentsCourse.setCourseEndAt(LocalDateTime.now().plusYears(1));
            repository.registerStudentsCourses(studentsCourse);
        }
    }

    @Transactional
    public void updateStudent(StudentDetail studentDetail) {
        repository.registerStudent(studentDetail.getStudent());
        for (StudentsCourses studentsCourse : studentDetail.getStudentsCourses()) {
            repository.updateStudentsCourses(studentsCourse);
        }
    }
}



