package com.a1.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.a1.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	
	
}
