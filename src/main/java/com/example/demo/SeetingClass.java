package com.example.demo;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.example.demo.DBClass.Message;
import com.example.demo.DBClass.PersonMessage;



@Configuration

public class SeetingClass implements WebMvcConfigurer {


	@Bean
	public LocaleResolver localeResolver()
	{
		SessionLocaleResolver sessionLoaleResolver = new SessionLocaleResolver();
		sessionLoaleResolver.setDefaultLocale(Locale.US);
		return sessionLoaleResolver;
		
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor()
	{
		LocaleChangeInterceptor localeChangeInteceptor = new LocaleChangeInterceptor();
		localeChangeInteceptor.setParamName("lang");
		return localeChangeInteceptor;
	}
	
	
	@Bean
	public Message message()
	{
		return new Message();
	}
	
	@Bean 
	public PersonMessage personMessage()
	{
		return new PersonMessage();
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(localeChangeInterceptor());
	}
	
	
	
}
