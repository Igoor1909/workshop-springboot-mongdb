package com.igorgomes.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igorgomes.workshopmongo.domain.Post;
import com.igorgomes.workshopmongo.repository.PostRepository;
import com.igorgomes.workshopmongo.services.exception.ObjectoNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Post user = repo.findById(id).orElse(null);
		if (user == null) {
			throw new ObjectoNotFoundException("Objeto não encontrado");
		}
		return user;
	}
	
	public List<Post> findByTitle(String text){
		return repo.SearchTitle(text);
	}

}
