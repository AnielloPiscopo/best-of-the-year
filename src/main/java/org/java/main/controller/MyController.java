package org.java.main.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/resources")
public class MyController {
	@GetMapping("/best")
	public String printMessage(Model model,
			@RequestParam(name = "name") String name) {
		model.addAttribute("name", name);
		
		return "index";
	}
}
