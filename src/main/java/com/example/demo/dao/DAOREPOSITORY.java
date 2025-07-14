package com.example.demo.dao;

import org.springframework.data.annotation.Persistent;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

@Persistent
public interface DAOREPOSITORY extends JpaRepository<User, Integer> {

}
