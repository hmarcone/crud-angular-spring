package com.hmarcone;

import com.hmarcone.enums.Category;
import com.hmarcone.model.Course;
import com.hmarcone.model.Lesson;
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

			for (int i = 0; i < 20; i++) {
				Course c = new Course();
				c.setName("Angular com Spring" + i);
				c.setCategory(Category.FRONT_END);

				Course c1 = new Course();
				c1.setName("Flutter com Dart");
				c1.setCategory(Category.FRONT_END);

				Lesson l = new Lesson();
				l.setName("Introdução");
				l.setYoutubeUrl("01234567890");
				l.setCourse(c);
				c.getLessons().add(l);

				Lesson l1 = new Lesson();
				l1.setName("Introdução");
				l1.setYoutubeUrl("01234567891");
				l1.setCourse(c1);
				c1.getLessons().add(l1);

				Lesson l2 = new Lesson();
				l2.setName("Angular");
				l2.setYoutubeUrl("01234567891");
				l2.setCourse(c);
				c.getLessons().add(l2);

				courseRepository.save(c);
				courseRepository.save(c1);
			}
		};
	}
}