package com.igorgomes.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igorgomes.workshopmongo.domain.User;
import com.igorgomes.workshopmongo.repository.UserRepository;
import com.igorgomes.workshopmongo.services.exception.ObjectoNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		User user = repo.findById(id).orElse(null);
		if(user == null) {
			throw new ObjectoNotFoundException("Objeto não encontrado");
		}
		return user;
	}
}
