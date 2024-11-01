package raisetech.Student.Management.data;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class StudentsCourses {

    private String StudentId;
    private String CourseId;
    private String CourseName;
    private String CourseDate;
    private LocalDateTime courseStartAt;
    private LocalDateTime courseEndAt;
}
