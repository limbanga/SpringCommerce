package com.example.SpringCommerce.limbanga;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LimbangaApplication {
	public static void main(String[] args) {
		SpringApplication.run(LimbangaApplication.class, args);
	}

	//
	 @Bean
	public Cloudinary cloudinary() {
		return  new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dxlbygekk",
				"api_key", "695755995927514",
				"api_secret", "bFXd4hT5IC7T0ZqoTozwFo8E9NA"));
	}

}

