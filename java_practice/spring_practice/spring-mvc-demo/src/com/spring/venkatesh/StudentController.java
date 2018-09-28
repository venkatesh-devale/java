package com.spring.venkatesh;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/show-student-registration")
	public String showRegistrationPage(Model model) {
		Student student = new Student();
		
		model.addAttribute("student", student);
		return "student-registration-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		System.out.println("Student information: "+theStudent.getFirstName()+" "+theStudent.getLastName());
		return "student-confirmation";
	}
}
