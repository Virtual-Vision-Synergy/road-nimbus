package com.project.auth.service;

import com.project.auth.model.Role;
import com.project.auth.model.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public User login(String email, String password) {
        return createMockUser(email, "ROLE_USER", 1L);
    }

    public User register(String email, String password) {
        return createMockUser(email, "ROLE_CONTRIBUTOR", 2L);
    }

    public User updateProfile(String email, String nickname) {
        return createMockUser(email, "ROLE_USER", 1L);
    }

    private User createMockUser(String email, String roleName, long id) {
        return User.builder()
                .id(id)
                .email(email)
                .password("***")
                .role(new Role(id, roleName))
                .build();
    }
}
