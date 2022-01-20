package com.example.demo;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;



@Configuration
//@EnableWebMvc

public class SeetingClass implements WebMvcConfigurer {

/*	@Bean
	public ViewResolver internalResourceViewResolver()
	{
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/jsp/");
		bean.setSuffix(".jsp");
		bean.setOrder(0);
		
		System.out.println("in my setting class");
		return bean;
	}
	@Bean
	public BeanNameViewResolver beanNameViewResolver(){
	    return new BeanNameViewResolver();
	}
	
	
	*/
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
	
	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(localeChangeInterceptor());
	}
	
	
	
}
