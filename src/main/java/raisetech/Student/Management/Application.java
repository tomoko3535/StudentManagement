package raisetech.Student.Management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import raisetech.Student.Management.repository.StudentRepository;

@SpringBootApplication
@RestController
public class Application {


	@Autowired
	private StudentRepository repository;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}