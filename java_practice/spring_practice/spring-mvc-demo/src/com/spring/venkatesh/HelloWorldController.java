package com.spring.venkatesh;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "hello-world-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "show-studentname-form";
	}
	
	@RequestMapping("/processFormVersion2")
	public String  convertToUpperCase(HttpServletRequest request, Model model) {
		String name = request.getParameter("student_name");
		name = name.toUpperCase();
		model.addAttribute("message",name);
		
		return "show-studentname-form";
	}
	
	@RequestMapping("/processFormVersion3")
	public String  convertToUpperCase(
			@RequestParam("student_name") String name,
			Model model) {
		
		name = "Hello from version 3: "+name.toUpperCase();
		model.addAttribute("message",name);
		
		return "show-studentname-form";
	}
}
