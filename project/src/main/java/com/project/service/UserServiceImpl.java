package com.project.service;

import com.project.dao.UserDao;
import com.project.dto.UserRequest;
import com.project.entity.User;
import com.project.exception.UserNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;

    @Override
    public ResponseEntity<User> addUser(UserRequest req) {

        User user = new User();
        BeanUtils.copyProperties(req, user);
        User response = dao.save(user);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = dao.findAll();
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<User> getUserById(int id) {

        User user = dao.findById(id).orElseThrow(() -> new UserNotFoundException("User not found!!"));
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<User> updateUser(int id, UserRequest req) {

        User user = dao.findById(id).orElseThrow(() -> new UserNotFoundException("User not found!!"));
        BeanUtils.copyProperties(req, user);
        user = dao.save(user);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<String> deleteUser(int id) {

        dao.findById(id).orElseThrow(() -> new UserNotFoundException("User not found!!"));
        dao.deleteById(id);

        return ResponseEntity.ok("Deleted");
    }

}
