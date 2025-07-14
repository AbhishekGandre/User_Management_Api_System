package com.example.demo;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.DAOREPOSITORY;
import com.example.demo.entity.User;

@SpringBootApplication
public class SpringBootJpaPractice1Application  {

	public static void main(String[] args) {
		
	ApplicationContext	context= SpringApplication.run(SpringBootJpaPractice1Application.class, args);
	
//	DAOREPOSITORY dao=context.getBean(DAOREPOSITORY.class);
//	
//	User user=new User();
//	user.setName("Abhishek Gandre");
//	user.setEmail("gandreabhishek@gmail.com");
//	Date date = new Date();
//	user.setDate(date);
//	user.setModificationDate(null);
//	user.setRole("Software Developer");
//	
//	dao.save(user);
	
	}

}
