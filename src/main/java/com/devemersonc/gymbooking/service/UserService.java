package com.devemersonc.gymbooking.service;

import com.devemersonc.gymbooking.dto.UserDTO;
import com.devemersonc.gymbooking.dto.UserRegisterDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
    UserDTO getUser(Long id);
    void saveNormalUser(UserRegisterDTO userRegisterDTO);
    void saveAdminUser(UserRegisterDTO userRegisterDTO);
    void updateUser(Long id, UserRegisterDTO userRegisterDTO);
    void deleteUser(Long id);
}
