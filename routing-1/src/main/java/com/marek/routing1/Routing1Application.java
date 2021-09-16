package com.marek.routing1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class Routing1Application {

	public static void main(String[] args) {
		SpringApplication.run(Routing1Application.class, args);
	}
	
	@RequestMapping("/color/{colorName}")
	public String showColorInfo(@PathVariable("colorName") String colorName) {
		return "The color you selected is:" + colorName;
	}
	
	@RequestMapping("/coding")
	public String coding() {
		return "Hello Coding Dojo!";
	}
	
	@RequestMapping("/coding/python")
	public String codingpy() {
		return "Python/Djangp was awesome!";
	}
	
	@RequestMapping("/coding/java")
	public String codingjava() {
		return "Java/Spring is better!";
	}
	
	@RequestMapping("/{dojo}")
	public String DojoController(@PathVariable("dojo") String dojo) {
		if(dojo.equals("dojo")) {
			return " The dojo is awesome!";
		}else if(dojo.equals("burbank-dojo")) {
			return " Burbank Dojo is located in southern California";
		}else if (dojo.equals("san-jose")) {
			return "SJ Dojo is the HQ";
		} else {
			return "I dont know this dojo";
		}
	}
	
}

	
	
	

