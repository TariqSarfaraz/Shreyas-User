package com.project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.User;
import com.project.dto.UserRequest;
import com.project.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin("*")
@RestController
public class UserController {

	@Autowired
	UserService service;

	/**
	 * To add User
	 * 
	 * @param user
	 */
	@PostMapping("/users")
	@Operation(summary = "To add User", tags = "Users")
	public ResponseEntity<User> addUser(@RequestBody UserRequest req) {

		User user = new User();

		user.setName(req.getName());
		user.setAge(req.getAge());
		user.setEmail(req.getEmail());
		user.setPhone(req.getPhone());

		return service.addUser(user);
	}

	/**
	 * To get all Users
	 * 
	 * @return
	 */
	@GetMapping("/users")
	@Operation(summary = "To retrieve all Users", tags = "Users")
	public ResponseEntity<List<User>> getUsers() {
		return service.getAllUsers();
	}

	/**
	 * To get User by Id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/users/{id}")
	@Operation(summary = "To retrieve User by Id", tags = "Users")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		return service.getUserById(id);
	}

	/**
	 * To update user
	 * 
	 * @param id
	 * @param req
	 * @return
	 */
	@PutMapping("/users/{id}")
	@Operation(summary = "To update User", tags = "Users")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody UserRequest req) {

		User user = service.getUserById(id).getBody();
		user.setName(req.getName());
		user.setAge(req.getAge());
		user.setEmail(req.getEmail());
		user.setPhone(req.getPhone());

		return service.updateUser(user);
	}

	/**
	 * To delete user
	 * 
	 * @param id
	 */
	@DeleteMapping("/users/{id}")
	@Operation(summary = "To delete User", tags = "Users")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable int id) {

		service.getUserById(id);
		return service.deleteUser(id);
	}
}
