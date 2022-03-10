package com.example.demo.infraestructura.gateways;

import com.example.demo.core.dominio.MaintenanceService;
import com.example.demo.core.dominio.ServiceId;
import com.example.demo.core.gateway.MaintenanceServiceRepository;
import com.example.demo.infraestructura.gateways.repositorio.MaintenanceServiceDBO;
import com.example.demo.shared.domain.PageQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//implementa la interfaz
@Repository
public class SqlMaintenanceRepository implements MaintenanceServiceRepository {

    private final DataSource dataSource;

    public SqlMaintenanceRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<MaintenanceService> query(PageQuery pageQuery) {
        //antes de ejecutar se debe suplir estas dos variables
        String sql = "SELECT * FROM maintenance LIMIT ? OFFSET ?"; //creamosesto con tokens para que no existe inyección sql
        try (Connection connection = dataSource.getConnection(); //las conexiones pueden fallar
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, pageQuery.getLimit().getValue());
            preparedStatement.setInt(2, pageQuery.getSkip().getValue());


            ResultSet resultSet = preparedStatement.executeQuery(); //recorre los registros y guardarlos en la lista
            List<MaintenanceService> result = new ArrayList<>();

            //formatear las fechas ya q SQl maneja otro formato
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            //acá recorremos los registros con
            while (resultSet.next()) {
                MaintenanceServiceDBO dbo = new MaintenanceServiceDBO();//vamos a crear uno nuevo en cada interaccion de Resultset
                dbo.setId(resultSet.getString("service_id")); //DBO lo vamos a transformar en el objeto del dominio
                dbo.setStartService(LocalDateTime.parse(resultSet.getString("start_service"),formatter));
                dbo.setEndService(LocalDateTime.parse(resultSet.getString("end_service"),formatter));
                dbo.setDescription(resultSet.getString("description_service"));
                MaintenanceService domainMaintenanceServiceDBO = dbo.toDomain();
                result.add(domainMaintenanceServiceDBO);
            }

            resultSet.close(); //aca cerramos la conexión

            return result;
        } catch (SQLException exception) {
            throw new RuntimeException("Error querying database", exception);
        }
    }

    @Override
    public Optional<MaintenanceService> get(ServiceId serviceId) {
        return Optional.empty();
    }

    @Override
    public void atention(MaintenanceService maintenanceService) {

    }
}
