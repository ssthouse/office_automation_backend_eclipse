package com.ssthouse.officeautomation.base;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ssthouse.officeautomation.util.Log;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.ssthouse.officeautomation" })
public class SpringConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//TODO 并没有起作用, 先放在这吧
		registry.addMapping("/**")
		.allowedOrigins("http://localhost:8081/");
	}
}
