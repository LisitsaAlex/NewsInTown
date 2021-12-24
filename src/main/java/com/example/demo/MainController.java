package com.example.demo;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		System.out.println("is controller greeting");
		return "greeting";
	}
	
	@GetMapping("/")
	public String my(Model model)
	{
		model.addAttribute("name", "1234");
		System.out.println("is controller /");

		return "greeting";
	}
	
	@GetMapping("/welcome")
	public String myc(Model model)
	{
		model.addAttribute("name", "1234");
		System.out.println("is controller /welcome");

		return "welcome";
	}
}