package raisetech.Student.Management;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	private String name = "Enami Kouji";
    public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/name")
	public String getName(){
		return name;
	}
	@PostMapping("/name")
	public void setName(String name){
		this.name = name;
	}
}
