package com.devemersonc.gymbooking.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UpdateUserDTO {
    @NotBlank(message = "La contraseña es obligatoria")
    private String password;
    @Email(message = "Ingresa un email válido.")
    @NotBlank(message = "El email es obligatorio.")
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
