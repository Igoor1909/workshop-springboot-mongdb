package com.igorgomes.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igorgomes.workshopmongo.domain.User;
import com.igorgomes.workshopmongo.dto.UserDTO;
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
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
	    Optional<User> optionalUser = repo.findById(obj.getId());
	    
	    if (optionalUser.isPresent()) {
	        User existingUser = optionalUser.get();
	        updateData(existingUser, obj);
	        return repo.save(existingUser);
	    } else {
	        return null;
	    }
	}
	private void updateData(User newOBJ, User obj) {
		newOBJ.setName(obj.getName());
		newOBJ.setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
	
}
