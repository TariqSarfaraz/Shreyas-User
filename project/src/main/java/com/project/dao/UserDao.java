package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dto.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
