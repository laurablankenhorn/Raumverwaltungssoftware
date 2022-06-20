package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import GUI.View;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo", "GUI"})
public class DemoApplication {

	public static void main(String[] args) {
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(DemoApplication.class);

		builder.headless(false);

		ConfigurableApplicationContext context = builder.run(args);
		
		try {
			View frame = context.getBean(View.class);
			frame.setSize(850, 650);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
