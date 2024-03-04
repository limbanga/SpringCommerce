package com.example.SpringCommerce.limbanga;

import ch.qos.logback.classic.Logger;
import com.example.SpringCommerce.limbanga.repositories.CategoryRepository;
import com.example.SpringCommerce.limbanga.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LimbangaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimbangaApplication.class, args);
	}
}
