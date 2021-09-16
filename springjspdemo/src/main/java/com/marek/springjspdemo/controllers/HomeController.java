package com.marek.springjspdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(Model model) {
		
		String name = "Logan";
		int numBelts = 40;
		
		model.addAttribute("n", name);
		model.addAttribute("numberOfBelts", numBelts);
		//ArrayList<String> favArtists = new ArrayList()
		String [] favArtists = {"Dojo Cat", "Colony House", "Mac Miller"};
		//int[] coolNumbers = {23,8,32,77};
		
		model.addAttribute("favArtists", favArtists);
		
		
		return "index.jsp";
	}
}
