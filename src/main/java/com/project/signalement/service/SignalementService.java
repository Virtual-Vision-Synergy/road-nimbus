package com.project.signalement.service;

import com.project.signalement.model.Signalement;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SignalementService {

    public List<Signalement> listSignalements() {
        return List.of(
                createMock("SIG-001", "Travaux rue A", "Route fermée", "Prévu", "Haute"),
                createMock("SIG-002", "Réhabilitation pont", "Piste cyclable" , "En cours", "Moyenne"),
                createMock("SIG-003", "Fermeture nocturne", "Travaux de nuit", "Terminé", "Basse")
        );
    }

    public Signalement createSignalement(Signalement input) {
        return createMock(input.getId(), input.getTitle(), input.getDescription(), "Prévu", "Haute");
    }

    private Signalement createMock(String id, String title, String desc, String status, String priority) {
        return Signalement.builder()
                .id(id)
                .title(title)
                .description(desc)
                .status(status)
                .priority(priority)
                .latitude(48.8566)
                .longitude(2.3522)
                .submittedAt(LocalDateTime.now())
                .build();
    }
}

