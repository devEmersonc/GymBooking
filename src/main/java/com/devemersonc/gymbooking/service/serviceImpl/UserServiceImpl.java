package com.devemersonc.gymbooking.service.serviceImpl;

import com.devemersonc.gymbooking.dto.UserDTO;
import com.devemersonc.gymbooking.dto.UserRegisterDTO;
import com.devemersonc.gymbooking.mapper.UserMapper;
import com.devemersonc.gymbooking.model.User;
import com.devemersonc.gymbooking.repository.RoleRepository;
import com.devemersonc.gymbooking.repository.UserRepository;
import com.devemersonc.gymbooking.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository ,UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toDtoList(users);
    }

    @Override
    public UserDTO getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceAccessException("El usuario ingresado no se ha encontrado."));
        return userMapper.toDto(user);
    }

    @Override
    public void saveNormalUser(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        user.setUsername(userRegisterDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        user.setEmail(userRegisterDTO.getEmail());
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }

    @Override
    public void saveAdminUser(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        user.setUsername(userRegisterDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        user.setEmail(userRegisterDTO.getEmail());
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, UserRegisterDTO userRegisterDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceAccessException("El usuario ingresado no se ha encontrado."));
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        user.setEmail(userRegisterDTO.getEmail());
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceAccessException("El usuario ingresado no se ha encontrado."));
        userRepository.deleteById(user.getId());
    }
}
