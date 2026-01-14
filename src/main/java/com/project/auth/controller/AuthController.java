package com.project.auth.controller;

import com.project.auth.service.AuthService;
import com.project.front.dto.UserDTO;
import com.project.front.util.ApiResponse;
import com.project.front.util.MapperUtil;
import com.project.auth.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserDTO>> login(@RequestBody Map<String, String> payload) {
        User user = authService.login(payload.get("email"), payload.get("password"));
        return ResponseEntity.ok(ApiResponse.ok(MapperUtil.toUserDTO(user), "mock login"));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserDTO>> register(@RequestBody Map<String, String> payload) {
        User user = authService.register(payload.get("email"), payload.get("password"));
        return ResponseEntity.ok(ApiResponse.ok(MapperUtil.toUserDTO(user), "mock register"));
    }

    @PutMapping("/me")
    public ResponseEntity<ApiResponse<UserDTO>> updateProfile(@RequestBody Map<String, String> payload) {
        User user = authService.updateProfile(payload.get("email"), payload.get("nickname"));
        return ResponseEntity.ok(ApiResponse.ok(MapperUtil.toUserDTO(user), "mock profile update"));
    }
}
