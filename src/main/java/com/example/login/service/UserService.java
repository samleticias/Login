package com.example.login.service;

import com.example.login.dto.UserDTO;
import com.example.login.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDto);

    User findUserByEmail(String email);

    List<UserDTO> findAllUsers();
}
