package com.project.signalement.controller;

import com.project.front.dto.SignalementDTO;
import com.project.front.util.ApiResponse;
import com.project.front.util.MapperUtil;
import com.project.signalement.model.Signalement;
import com.project.signalement.service.SignalementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/signalements")
public class SignalementController {

    private final SignalementService signalementService;

    public SignalementController(SignalementService signalementService) {
        this.signalementService = signalementService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SignalementDTO>>> list() {
        List<Signalement> signalements = signalementService.listSignalements();
        return ResponseEntity.ok(ApiResponse.ok(signalements.stream()
                .map(MapperUtil::toSignalementDTO)
                .toList(), "mock signalements"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SignalementDTO>> create(@RequestBody Signalement signalement) {
        Signalement created = signalementService.createSignalement(signalement);
        return ResponseEntity.ok(ApiResponse.ok(MapperUtil.toSignalementDTO(created), "signalement créé"));
    }
}
