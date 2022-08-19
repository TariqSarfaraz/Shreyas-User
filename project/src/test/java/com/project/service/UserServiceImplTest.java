package com.project.service;

import com.project.dao.UserDao;
import com.project.dto.UserRequest;
import com.project.entity.User;
import com.project.exception.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceImpl userService;

    private UserRequest userRequest;

    @BeforeEach
    void setup() {
        userRequest = new UserRequest();
        userRequest.setName("Shreyas");
        userRequest.setAge(23);
        userRequest.setEmail("shreyas@gmail.com");
        userRequest.setPhone(9876543125L);
    }

    @Test
    void unitTest_addUser_success() {

        User user = new User(1, "Shreyas", 23, "shreyas@gmail.com", 9876543125L);
        ResponseEntity<User> expected = ResponseEntity.ok(user);
        Mockito.when(userDao.save(Mockito.any())).thenReturn(user);

        ResponseEntity<User> actual = userService.addUser(userRequest);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void unitTest_getAllUsers_success() {

        List<User> users = new ArrayList<>();
        ResponseEntity<List<User>> expected = ResponseEntity.ok(users);
        users.add(new User(1, "shreyas", 23, "shreyas@gmail.com", 987654321L));
        users.add(new User(2, "tariq", 22, "tariq@gmail.com", 6362355944L));
        Mockito.when(userDao.findAll()).thenReturn(users);

        ResponseEntity<List<User>> actual = userService.getAllUsers();

        assertThat(actual.getBody()).isEqualTo(expected.getBody());
    }

    @Test
    void unitTest_getUserById_success() {

        int id = 1;
        User user = new User(1, "Shreyas", 23, "shreyas@gmail.com", 9876543215L);
        ResponseEntity<User> expected = ResponseEntity.ok(user);
        Mockito.when(userDao.findById(id)).thenReturn(Optional.of(user));

        ResponseEntity<User> actual = userService.getUserById(id);

        assertThat(actual.getBody()).isEqualTo(expected.getBody());

    }

    @Test
    void unitTest_updateUser_success() {
    }

    @Test
    void deleteUser() {
    }
}