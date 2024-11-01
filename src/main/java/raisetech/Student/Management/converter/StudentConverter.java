package raisetech.Student.Management.converter;

import org.springframework.stereotype.Component;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.StudentsCourses;
import raisetech.Student.Management.domain.StudentDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverter {
    public List<StudentDetail> covertStudentDetails(List<Student> students, List<StudentsCourses> studentsCourses) {
        List<StudentDetail> studentDetails = new ArrayList<>();
        students.forEach(Student -> {
            StudentDetail studentDetail = new StudentDetail();
            studentDetail.setStudent(Student);

            List<StudentsCourses> convertStudentCourses = studentsCourses.stream()
                    .filter(studentCourse -> Student.getId().equals(studentCourse.getStudentId()))
                    .collect(Collectors.toList());

            studentDetail.setStudentsCourses(convertStudentCourses);
            studentDetails.add(studentDetail);
        });
        return studentDetails;
    }
}