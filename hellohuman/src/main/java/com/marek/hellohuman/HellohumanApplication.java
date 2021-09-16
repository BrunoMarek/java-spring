package com.marek.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HellohumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellohumanApplication.class, args);
	}
	
	@RequestMapping("/")
	public String Human(@RequestParam(value="name", required=false) String yourName) {
		if(yourName==null) {
			return "Hi human /n Welcome to Springbot";
		}else {
			return " Hi " + yourName + "/n Welcome to Springbot";
		
		}
	}

}
