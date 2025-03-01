package com.devemersonc.gymbooking.controller;

import com.devemersonc.gymbooking.dto.UpdateUserDTO;
import com.devemersonc.gymbooking.dto.UserDTO;
import com.devemersonc.gymbooking.dto.UserRegisterDTO;
import com.devemersonc.gymbooking.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        UserDTO user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/normal-user")
    public ResponseEntity<String> saveNormalUser(@Valid @RequestBody UserRegisterDTO userRegisterDTO) {
        userService.saveNormalUser(userRegisterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado.");
    }

    @PostMapping("/admin-user")
    public ResponseEntity<String> saveAdminUser(@Valid @RequestBody UserRegisterDTO userRegisterDTO) {
        userService.saveAdminUser(userRegisterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado.");
    }

    @PostMapping("/coach-user")
    public ResponseEntity<String> saveCoachUser(@Valid @RequestBody UserRegisterDTO userRegisterDTO) {
        userService.saveCoachUser(userRegisterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@Valid @RequestBody UpdateUserDTO updateUserDTO, @PathVariable Long id) {
        userService.updateUser(id, updateUserDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario actualizado.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Usuario eliminado.");
    }
}
