package com.a1.workshopmongo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.a1.workshopmongo.domain.User;
import com.a1.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository repo;

	UserService(UserRepository repo) {
		this.repo = repo;
	}
	
	public List<User> findAll() {
		return repo.findAll();
	}

}
