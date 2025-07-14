package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.example.demo.entity.User;
import com.example.demo.service.ServiceMain;

import jakarta.validation.Valid;

@RestController
public class RestControllerHandler {

	@Autowired
	ServiceMain servicemain;

	@Autowired
	ErrorClass errorClass;

	@GetMapping(path = "/hello")
	@ResponseBody
	public String hello() {
		return "hello Api !!";
	}

	@GetMapping(path = "/api/v1/users", produces = "application/json")
	public ResponseEntity<Object> getAllUsers() {
		List<User> user = servicemain.getAllUsers();
		if (user.isEmpty()) {
			errorClass.setMessage("There are no users in the database");
			errorClass.setErrorCode(404);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorClass);

		}
		return ResponseEntity.status(HttpStatus.OK).body(servicemain.getAllUsers());

	}

	
	@GetMapping(path = "/api/v1/users/{userid}", produces = "application/json")
	public ResponseEntity<Object> getUserByyId(@PathVariable("userid") String userid) {
		if (!isNumeric(userid)) {
			errorClass.setMessage("user id must be a number");
			errorClass.setErrorCode(404);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorClass);
		}
		int ID = Integer.parseInt(userid);
		Optional<User> user = servicemain.getUserById(ID);
		if (!user.isPresent()) {
			errorClass.setMessage("User not found");
			errorClass.setErrorCode(404);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorClass);

		}
		return ResponseEntity.status(HttpStatus.OK).body((user.get()));
	}

	
	
	@PostMapping(path ="/api/v1/adduser", produces= "application/json", consumes = "application/json", headers = {"Accept=application/json", "Content-Type=application/json" })	
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user, BindingResult BR) {

		if (BR.hasFieldErrors() ) {
			System.out.println(BR.getAllErrors());
			List<ObjectError> iterable = BR.getAllErrors();
			List<String> list = new ArrayList<String>(); 
	        for (ObjectError objectError : iterable) {
				list.add(objectError.getDefaultMessage());
			}
			errorClass.setMessage(list.toString());
			errorClass.setErrorCode(404);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorClass);
		}
		// My Custom logic for Null and Empty checking , It should not be mandatory
//		if (user.getName().isEmpty() || user.getName().isBlank() || user == null || user.getEmail().isEmpty()
//				|| user.getEmail().isBlank() || user.getRole().isEmpty() || user.getRole().isBlank()
//				|| user.getRole().isEmpty() || user.getRole().isBlank()) {
//			errorClass.setMessage("name, email and role must not be empty");
//			errorClass.setErrorCode(404);
//			return ResponseEntity.status(404).body(errorClass);
//		}
		servicemain.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}

	@PutMapping(path="/api/v1/updateuser/", produces= "application/json", consumes = "application/json", headers = {"Accept=application/json", "Content-Type=application/json" })
	public ResponseEntity<Object> updateUser(@Valid @RequestBody User user, BindingResult BR) {
		if (BR.hasFieldErrors() ) {
			System.out.println(BR.getAllErrors());
			List<ObjectError> iterable = BR.getAllErrors();
			List<String> list = new ArrayList<String>(); 
	        for (ObjectError objectError : iterable) {
				list.add(objectError.getDefaultMessage());
			}
			errorClass.setMessage(list.toString());
			errorClass.setErrorCode(404);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorClass);
		}
		int ID = user.getUserId();
		Optional<User> userCheck = servicemain.getUserById(ID);
		if (!userCheck.isPresent()) {
			errorClass.setMessage("User not found");
			errorClass.setErrorCode(404);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorClass);

		}
		if (user.getName().isEmpty() || user.getName().isBlank() || user == null || user.getEmail().isEmpty()
				|| user.getEmail().isBlank() || user.getRole().isEmpty() || user.getRole().isBlank()
				|| user.getRole().isEmpty() || user.getRole().isBlank()) {
			errorClass.setMessage("name, email and role must not be empty");
			errorClass.setErrorCode(404);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorClass);
		}
		return ResponseEntity.status(HttpStatus.OK).body(servicemain.updateUser(user, ID));

	}

	
	@DeleteMapping(path="/api/v1/deleteuser/{userid}", produces= "application/json")
	public ResponseEntity<Object> deleteUser(@PathVariable("userid") String userid) {
		if (!isNumeric(userid)) {
			errorClass.setMessage("user id must be a number");
			errorClass.setErrorCode(404);
			return ResponseEntity.status(404).body(errorClass);
		}
		int ID = Integer.parseInt(userid);
		Optional<User> user = servicemain.getUserById(ID);
		if (!user.isPresent()) {
			errorClass.setMessage("User not found");
			errorClass.setErrorCode(404);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorClass);
		}
		try {
		servicemain.deleteUserById(Integer.parseInt(userid));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body("{\"Message\": \"User deleted successfully\"}");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private boolean isNumeric(String str) {
		if (str == null) {
			return false;
		}
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
