package com.project.map.controller;

import com.project.front.util.ApiResponse;
import com.project.map.model.MapTile;
import com.project.map.service.MapService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/map")
public class MapController {

    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping("/tiles")
    public ResponseEntity<ApiResponse<List<MapTile>>> getTiles() {
        return ResponseEntity.ok(ApiResponse.ok(mapService.fetchTiles(), "mock tiles"));
    }

    @GetMapping("/markers")
    public ResponseEntity<ApiResponse<List<MapTile>>> getMarkers() {
        return ResponseEntity.ok(ApiResponse.ok(mapService.fetchMarkers(), "mock markers"));
    }
}
