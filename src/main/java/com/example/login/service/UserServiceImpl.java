package com.example.login.service;

import com.example.login.dto.UserDTO;
import com.example.login.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser(UserDTO userDto) {
        
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return null;
    }
}
