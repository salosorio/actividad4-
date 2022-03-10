package com.example.demo.infraestructura.controller.model;

import com.example.demo.core.dominio.MaintenanceService;

import java.time.LocalDateTime;

//esto es un objeto de transferencia  de datos entre capas
public class ServiceDTO {

    private String id;
    private LocalDateTime startService;
    private LocalDateTime endService;
    private String description;

    public ServiceDTO(String id, LocalDateTime startService, LocalDateTime endService, String description) {
        this.id = id;
        this.startService = startService;
        this.endService = endService;
        this.description = description;
    }

    public ServiceDTO() { //constructor vacio

    }

    public static ServiceDTO fromDomain(MaintenanceService maintenanceService) {
        return new ServiceDTO(
                maintenanceService.getId().toString(),
                maintenanceService.getStartDateTime(),
                maintenanceService.getEndDateTime(),
                maintenanceService.getDescriptionService().toString()
        );
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getStartService() {
        return startService;
    }

    public void setStartService(LocalDateTime startService) {
        this.startService = startService;
    }

    public LocalDateTime getEndService() {
        return endService;
    }

    public void setEndService(LocalDateTime endService) {
        this.endService = endService;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
