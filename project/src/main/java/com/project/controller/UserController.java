package com.project.controller;

import com.project.dto.UserRequest;
import com.project.entity.User;
import com.project.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    UserService service;

    /**
     * To add User
     *
     * @param req
     */
    @PostMapping("/users")
    @Operation(summary = "To add User", tags = "Users")
    public ResponseEntity<User> addUser(@RequestBody UserRequest req) {

        return service.addUser(req);
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

        return service.updateUser(id, req);
    }

    /**
     * To delete user
     *
     * @param id
     */
    @DeleteMapping("/users/{id}")
    @Operation(summary = "To delete User", tags = "Users")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {

        return service.deleteUser(id);
    }
}
