package com.a1.workshopmongo.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.a1.workshopmongo.domain.Post;
import com.a1.workshopmongo.domain.User;
import com.a1.workshopmongo.dto.AuthorDTO;
import com.a1.workshopmongo.repository.PostRepository;
import com.a1.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	private final UserRepository userRepository;
	private final PostRepository postRepository;

	Instantiation(UserRepository userRepository, PostRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User u1 = new User(null, "Henry Brown", "henryyy333@gmail.com");
		User u2 = new User(null, "Noah White", "noahnoah45@gmail.com");
		User u3 = new User(null, "Sophie Kenz", "sophie494522@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		
		Post post1 = new Post(null, LocalDate.parse("21/07/2026", fmt), "Partiu viagem!", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(u3));
		Post post2 = new Post(null, LocalDate.parse("24/07/2026", fmt), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(u3));
		Post post3 = new Post(null, LocalDate.parse("22/07/2026", fmt), "Viagem a trabalho logo hoje cedo", "Vou precisar atender a uma conferencia em SJC de ultima hora; fazer o que, né?", new AuthorDTO(u2));
		
		postRepository.saveAll(Arrays.asList(post1, post2, post3));
		
	}

}
