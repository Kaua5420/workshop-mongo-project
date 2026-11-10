package com.a1.workshopmongo.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.a1.workshopmongo.domain.User;
import com.a1.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	private final UserRepository userRepository;

	Instantiation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User u1 = new User(null, "Henry Brown", "henryyy333@gmail.com");
		User u2 = new User(null, "Noah White", "noahnoah45@gmail.com");
		User u3 = new User(null, "Sophie Kenz", "sophie494522@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		
	}

}
