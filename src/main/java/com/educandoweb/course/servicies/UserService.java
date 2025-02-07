package com.educandoweb.course.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository respository;
	
	public List<User> findAll(){
		return respository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = respository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return respository.save(obj);
	}
	
	public void delete(Long id) {
		respository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = respository.getReferenceById(id);
		updateData(entity, obj);
		return respository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
}
