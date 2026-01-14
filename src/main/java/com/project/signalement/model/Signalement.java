package com.project.signalement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class Signalement {
    private String id;
    private String title;
    private String description;
    private String status;
    private String priority;
    private double latitude;
    private double longitude;
    private LocalDateTime submittedAt;
}

