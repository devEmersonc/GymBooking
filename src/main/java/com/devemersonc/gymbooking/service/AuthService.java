package com.devemersonc.gymbooking.service;

import com.devemersonc.gymbooking.dto.AuthRequest;
import com.devemersonc.gymbooking.dto.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthRequest authRequest);
}
