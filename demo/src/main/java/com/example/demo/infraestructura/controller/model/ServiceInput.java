package com.example.demo.infraestructura.controller.model;

import java.time.LocalDateTime;

//lo que vamos a recibir de entrada
public class ServiceInput {

    private LocalDateTime startService;
    private LocalDateTime endService;
    private String description;

    public ServiceInput(LocalDateTime startService, LocalDateTime endService, String description) {
        this.startService = startService;
        this.endService = endService;
        this.description = description;
    }

    public ServiceInput() {
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
