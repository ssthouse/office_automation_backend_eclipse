package com.ssthouse.officeautomation.base;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.portlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ssthouse.officeautomation.util.Log;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.ssthouse.officeautomation" })
public class SpringConfig extends WebMvcConfigurerAdapter {
	
	
	   @Bean
	   public GlobalHandlerExceptionResolver globalHandlerExceptionResolver() {
		   Log.error("**************************************");
	      return new GlobalHandlerExceptionResolver();
	   }
}
