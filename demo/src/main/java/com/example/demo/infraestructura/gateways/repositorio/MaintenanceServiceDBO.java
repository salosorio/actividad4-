package com.example.demo.infraestructura.gateways.repositorio;

import com.example.demo.core.dominio.DescriptionService;
import com.example.demo.core.dominio.MaintenanceService;
import com.example.demo.core.dominio.ServiceId;

import java.time.LocalDateTime;
import java.util.UUID;

public class MaintenanceServiceDBO {

    private String id;
    private LocalDateTime startService;
    private LocalDateTime endService;
    private String description;

    public MaintenanceServiceDBO(String id, LocalDateTime startService, LocalDateTime endService, String description) {
        this.id = id;
        this.startService = startService;
        this.endService = endService;
        this.description = description;
    }

    public MaintenanceServiceDBO() { //aca van las anotaciones como colum,table
    }

    //en este punto necesitamos trnsformar la info de repo a dominio y los de dominio a repo

    public MaintenanceService toDomain() { //este método es para transformar una instancia en el dominio
       return new MaintenanceService(               //retorna una nueva instancia de  servicio
                new ServiceId(UUID.fromString(id)),
                    startService,
                     endService,
                new DescriptionService(description)

        );
    }

    public static MaintenanceServiceDBO fromDomain(MaintenanceService maintenanceService){ //del dominio al repositorio
        return new MaintenanceServiceDBO(
                maintenanceService.getId().toString(),
                maintenanceService.getStartDateTime(),
                maintenanceService.getEndDateTime(),
                maintenanceService.getDescriptionService().toString() //el método toString devuelve el vlaor interno
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