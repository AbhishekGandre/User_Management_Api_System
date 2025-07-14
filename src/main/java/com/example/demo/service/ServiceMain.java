package com.example.demo.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DAOREPOSITORY;
import com.example.demo.entity.User;

@Service
public class ServiceMain {
	
	@Autowired
	DAOREPOSITORY dao;

	
	
	public List<User> getAllUsers() {
		return dao.findAll();
		}
	
	
	public Optional<User> getUserById(int id){
		return dao.findById(id);
	}
	
	public User addUser(User user) {
		Date date = new Date();
		user.setDate(date);
		return dao.save(user);
	}


	public User updateUser(User user, int userId) {
		User tmpUser=dao.findById(userId).get();
		tmpUser.setName(user.getName());
		tmpUser.setEmail(user.getEmail());
		tmpUser.setRole(user.getRole());
		Date date = new Date();
		tmpUser.setModificationDate(date);
		dao.save(tmpUser);
		return dao.findById(userId).get();
		
	}


	public void deleteUserById(int userid) {
		try {
			dao.deleteById(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	

}
