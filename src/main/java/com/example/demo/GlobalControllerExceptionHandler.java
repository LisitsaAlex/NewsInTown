package com.example.demo;



import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String defaultErrorHadler(Model model, Exception ex)
	{
		
		model.addAttribute("exception", ex.getMessage());
		return "errorPage";
		
	}



}
