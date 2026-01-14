package com.project.map.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MapTile {
    private String id;
    private String name;
    private Double latitude;
    private Double longitude;
    private String status;
}

