package com.a1.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.a1.workshopmongo.domain.User;
import com.a1.workshopmongo.dto.UserDTO;
import com.a1.workshopmongo.repository.UserRepository;
import com.a1.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	private final UserRepository repo;

	UserService(UserRepository repo) {
		this.repo = repo;
	}
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));	
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
