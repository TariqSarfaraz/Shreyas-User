package com.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.project.dto.User;

public interface UserService {

	public ResponseEntity<User> addUser(User req);

	public ResponseEntity<List<User>> getAllUsers();

	public ResponseEntity<User> getUserById(int id);

	public ResponseEntity<User> updateUser(User user);

	public ResponseEntity<Map<String, Boolean>> deleteUser(int id);
}
