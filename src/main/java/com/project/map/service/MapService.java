package com.project.map.service;

import com.project.map.model.MapTile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapService {

    public List<MapTile> fetchTiles() {
        return List.of(
                MapTile.builder().id("tile-1").name("Chantier A").latitude(46.2044).longitude(6.1432).status("En cours").build(),
                MapTile.builder().id("tile-2").name("Chantier B").latitude(44.8378).longitude(-0.5792).status("Prévu").build(),
                MapTile.builder().id("tile-3").name("Chantier C").latitude(48.8566).longitude(2.3522).status("Terminé").build()
        );
    }

    public List<MapTile> fetchMarkers() {
        return fetchTiles();
    }
}

