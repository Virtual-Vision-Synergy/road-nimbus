package com.project.front.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignalementDTO {
    private String id;
    private String title;
    private String status;
    private String priority;
    private double latitude;
    private double longitude;
}

