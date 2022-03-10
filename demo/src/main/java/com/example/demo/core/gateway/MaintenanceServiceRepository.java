package com.example.demo.core.gateway;


import com.example.demo.core.dominio.MaintenanceService;
import com.example.demo.core.dominio.ServiceId;
import com.example.demo.shared.domain.PageQuery;

import java.util.List;
import java.util.Optional;


//Representacion de lo que puede hacer el repositorio (Contrato)
public interface MaintenanceServiceRepository {

    List<MaintenanceService> query(PageQuery pageQuery); // cada q consulten un lista de servicio va tener el limite y el skip

    Optional<MaintenanceService> get(ServiceId serviceId); //es para que me devuelva un valor opcional ya que puede devolver null u el objeto como tal

    void atention(MaintenanceService maintenanceService); //no nos retorna nada este método, porque ya esta guardado a no ser de que encarguemos al Db generar el id


}
