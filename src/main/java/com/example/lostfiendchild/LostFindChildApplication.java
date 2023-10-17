package com.example.lostfiendchild;

import com.example.lostfiendchild.service.LostChildService;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LostFindChildApplication implements CommandLineRunner {

	@Resource
	LostChildService lostChildService;

	public static void main(String[] args) {
		SpringApplication.run(LostFindChildApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		lostChildService.init();
	}
}
