package raisetech.Student.Management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {


	@Autowired
	private StudentRepository repository;

	private String name = "Yamada Taro";
	private String age = "30";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@GetMapping("/student")
	public String getStudent(){
		Student student = repository.searchByName("YoshidaHanako");
		return student.getName() + " " + student.getAge() + "歳";
	}

	@PostMapping("/student")
	public void registerStudent(String name, int age){
		repository.registerStudent(name, age);

	}

	@PostMapping("/studentName")
	public void updateStudentName(String name){
		this.name = name;
	}
}

