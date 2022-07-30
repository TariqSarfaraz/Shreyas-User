package com.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.dao.UserDao;
import com.project.dto.User;
import com.project.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;

	@Override
	public ResponseEntity<User> addUser(User req) {
		User user = dao.save(req);
		return ResponseEntity.ok(user);
	}

	@Override
	public ResponseEntity<List<User>> getAllUsers() {

		List<User> users = dao.findAll();
//		UserResponse resp = new UserResponse();
//		resp.setUsers(users);

		return ResponseEntity.ok(users);
	}

	@Override
	public ResponseEntity<User> getUserById(int id) {

		try {
			User user = dao.findById(id).get();
			return ResponseEntity.status(HttpStatus.OK).body(user);
		} catch (Exception e) {
			throw new UserNotFoundException("User Not Found");
		}

	}

	@Override
	public ResponseEntity<User> updateUser(User user) {

		User resp = dao.save(user);
		return ResponseEntity.ok(resp);
	}

	@Override
	public ResponseEntity<Map<String, Boolean>> deleteUser(int id) {
		dao.deleteById(id);

		Map<String, Boolean> resp = new HashMap<>();
		resp.put("Deleted", Boolean.TRUE);

		return ResponseEntity.ok(resp);
	}

}
