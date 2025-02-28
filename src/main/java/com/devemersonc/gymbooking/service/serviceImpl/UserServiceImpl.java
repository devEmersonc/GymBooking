package com.devemersonc.gymbooking.service.serviceImpl;

import com.devemersonc.gymbooking.dto.UserDTO;
import com.devemersonc.gymbooking.dto.UserRegisterDTO;
import com.devemersonc.gymbooking.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<UserDTO> getUsers() {
        return List.of();
    }

    @Override
    public UserDTO getUser(Long id) {
        return null;
    }

    @Override
    public void saveNormalUser(UserRegisterDTO userRegisterDTO) {

    }

    @Override
    public void saveAdminUser(UserRegisterDTO userRegisterDTO) {

    }

    @Override
    public void updateUser(Long id, UserRegisterDTO userRegisterDTO) {

    }

    @Override
    public void deleteUser(Long id) {

    }
}
