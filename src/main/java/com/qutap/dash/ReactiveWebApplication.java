package com.qutap.dash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.qutap.dash")
public class ReactiveWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveWebApplication.class, args);
	}
	
}
