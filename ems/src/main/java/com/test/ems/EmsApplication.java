package com.test.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.test.*")
@EnableJpaRepositories("com.test.*")
@EntityScan("com.test.*") 
public class EmsApplication extends SpringBootServletInitializer{

	 @Override
	   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	      return application.sources(EmsApplication.class);
	   }
	   public static void main(String[] args) {
	      SpringApplication.run(EmsApplication.class, args);
	   }

}