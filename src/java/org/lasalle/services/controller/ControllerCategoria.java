package org.lasalle.services.controller;

import org.lasalle.services.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author alonso
 */
public class ControllerCategoria {
    public Categoria saveCategoria(Categoria categoria){
        String query = "INSERT INTO categoria VALUES (0,?,?,?)";
        try {
            ConnectionMysql connectionMySql = new ConnectionMysql();
            Connection connection = connectionMySql.open();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, categoria.getCategoria());
            preparedStatement.setString(2, categoria.getDepartamento());
            preparedStatement.setInt(3, categoria.getResponsable());
            preparedStatement.execute();
            System.out.println("Registro generado");
            preparedStatement.close();
            connectionMySql.close();
        } catch (Exception e) {
        
        }
        
        return categoria;
    }
}