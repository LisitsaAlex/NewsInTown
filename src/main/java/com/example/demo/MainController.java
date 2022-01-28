package com.example.demo;



import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.demo.DBClass.*;


@Controller
public class MainController {

	
	@Autowired
	private UserRepository userRepository;
	
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
		Message message = new Message();
		message.setName(personMessage.getName());
		message.setEmail(personMessage.getEmail());
		message.setPhone(personMessage.getPhone());
		message.setMessage(personMessage.getMessage());
		
		userRepository.save(message);
		
		return "redirect:messageSend";
	}

	@GetMapping("/messageSend")
	public String messageSent(Model model)
	{
		return "messageSend";
	}
	
	
	@ExceptionHandler(SQLException.class)
	public String databaseError(Model model, SQLException ex)
	{
		if (ex.getErrorCode()==1062)
			model.addAttribute("myMessage", new String("You may have already left a message, thanks."));
			model.addAttribute("exception", ex.getMessage());
	
		
		return "errorPage";
		
	}

	
	
}