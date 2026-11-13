package com.a1.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.a1.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	
	
}
