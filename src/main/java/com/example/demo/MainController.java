package com.example.demo;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

	
	@GetMapping("/")
	public String my(Model model)
	{
		model.addAttribute("personMessage", new PersonMessage());
		return "index";
	}
	
	
	@PostMapping("/")
	public String handlePostRequest(@ModelAttribute PersonMessage personMessage, Model model)
	{
		System.out.println("person name: "+personMessage.getName());
		System.out.println("person email: "+personMessage.getEmail());
		System.out.println("person phone: "+personMessage.getPhone());
		System.out.println("person massege: "+personMessage.getMessage());
		
		
		
		return "index";
	}
	
	
	
	
}