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
	//@Autowired
	//private Message message;
	@Autowired
	private PersonMessage personMessage;
	
	
	@GetMapping("/")
	public String my(Model model)
	{
		model.addAttribute("personMessage", personMessage);
		return "index";
	}
	
	
	@PostMapping("/")
	
	public String handlePostRequest(@ModelAttribute PersonMessage personMessage, Model model)
	{
		Message message = new Message();
		message.setParams(personMessage.getName(), personMessage.getEmail(), personMessage.getPhone(), personMessage.getMessage());
		
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