package com.example.demo.core.dominio;

import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;

public class MaintenanceService {
    private final ServiceId id;
    private  final LocalDateTime startService;
    private  final LocalDateTime endService;
    private final DescriptionService description;


    public MaintenanceService(ServiceId id, LocalDateTime startService, LocalDateTime endService, DescriptionService description) {
        this.id = Validate.notNull(id);
        this.startService = Validate.notNull(startService);
        Validate.isTrue(LocalDateTime.now().isAfter(startService), "la fecha no debe ser futura");
        this.endService = Validate.notNull(endService);
        Validate.isTrue(LocalDateTime.now().isAfter(startService) && endService.isBefore(LocalDateTime.now()), "la fecha no puede ser antes de startService");
        this.description = Validate.notNull(description);
    }


    public ServiceId getId() {
        return id;
    }

    public LocalDateTime getStartDateTime() {
        return startService;
    }

    public LocalDateTime getEndDateTime() {
        return endService;
    }

    public DescriptionService getDescriptionService() {
        return description;
    }
}
