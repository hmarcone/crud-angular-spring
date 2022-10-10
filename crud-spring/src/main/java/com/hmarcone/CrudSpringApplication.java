package com.hmarcone;

import com.hmarcone.model.Course;
import com.hmarcone.repository.CourseRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			Course c = new Course();
			c.setName("Angular com Spring");
			c.setCategory("front-end");

			Course c1 = new Course();
			c1.setName("Flutter com Dart");
			c1.setCategory("front-end");
			
			courseRepository.save(c);
			courseRepository.save(c1);
		};
	}
}