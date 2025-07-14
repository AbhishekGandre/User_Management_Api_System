package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "USER_DETAILS")
public class User {
	
	@Id
	@Column(name = "UserId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userId;
	
	@Pattern(regexp = "^[A-Za-z]+(?:\\s[A-Za-z]+)+$", message = "name should contain only alphabets")
	@NotBlank(message = "name is mandatory")
    @Size(min = 1, max = 100)
	@Column(name = "UserName",nullable = false)
	String name;
	

    @NotBlank(message = "email is mandatory")
	@Email(message = "email should be valid")
	@Column(name = "UserEmail",nullable = false, unique = true)
	String email;
    
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "role should contain only alphabets")
    @NotBlank(message = "role is mandatory")
	@Column(name = "UserRole")
	String role;
    
	@Column(name = "CreationDate")
	Date date;
	@Column(name = "ModificationDate")
	Date modificationDate;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	
	
	
}
