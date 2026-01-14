package com.project.front.util;

import com.project.auth.model.User;
import com.project.front.dto.UserDTO;
import com.project.signalement.model.Signalement;
import com.project.front.dto.SignalementDTO;

public final class MapperUtil {

    private MapperUtil() {
        // utility
    }

    public static UserDTO toUserDTO(User user) {
        if (user == null) {
            return null;
        }
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .role(user.getRole() != null ? user.getRole().getName() : "")
                .build();
    }

    public static SignalementDTO toSignalementDTO(Signalement signalement) {
        if (signalement == null) {
            return null;
        }
        return SignalementDTO.builder()
                .id(signalement.getId())
                .title(signalement.getTitle())
                .status(signalement.getStatus())
                .priority(signalement.getPriority())
                .latitude(signalement.getLatitude())
                .longitude(signalement.getLongitude())
                .build();
    }
}
