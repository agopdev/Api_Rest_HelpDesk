/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lasalle.services.controller;

import org.lasalle.services.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alonso
 */
public class ControllerUsuario {
    
    public void validar(){
        
    }
    
    public List<Usuario> getAll(){
        List<Usuario> listUsers = new ArrayList<>();
        String query = "SELECT * FROM usuario";
        try {
            ConnectionMysql connectionMySql = new  ConnectionMysql();
            Connection connection = connectionMySql.open();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultSet.getInt("idUsuario"));
                usuario.setUsername(resultSet.getString("username"));
                usuario.setPassword(resultSet.getString("password"));
                usuario.setToken(resultSet.getString("token"));
                usuario.setLastConnection(resultSet.getDate("lastConnection"));
                listUsers.add(usuario);
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
            return listUsers;
    }
    
    public Usuario getAllLogin(String username, String password) throws Exception{
        List<Usuario> usuarios = getAll();
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        
        throw new Exception("Usuario o contraseña incorrectos");
    }
    
    public Usuario saveUsuario(Usuario usuario){
        String query = "INSERT INTO usuario (username, password, token, lastConnection) VALUES (?,?,?,?)";
        try {
            ConnectionMysql connectionMySql = new ConnectionMysql();
            Connection connection = connectionMySql.open();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, usuario.getUsername());
            preparedStatement.setString(2, usuario.getPassword());
            preparedStatement.setString(3, usuario.getToken());
            preparedStatement.setTimestamp(4, new java.sql.Timestamp(usuario.getLastConnection().getTime()));
            preparedStatement.executeUpdate();
            System.out.println("Usuario registrado correctamente");
            preparedStatement.close();
            connectionMySql.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
        return usuario;
    }
    
    public Usuario getUsuarioByUsernameAndPassword(String username, String password) {
        String query = "SELECT * FROM usuario WHERE username = ? AND password = ?";
        try {
            ConnectionMysql connectionMySql = new ConnectionMysql();
            Connection connection = connectionMySql.open();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultSet.getInt("idUsuario"));
                usuario.setUsername(resultSet.getString("username"));
                usuario.setPassword(resultSet.getString("password"));
                usuario.setToken(resultSet.getString("token"));
                usuario.setLastConnection(resultSet.getTimestamp("lastConnection"));
                return usuario;
            }
            
            resultSet.close();
            preparedStatement.close();
            connectionMySql.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al obtener usuario: " + e.getMessage());
        }
        return null; 
    }
}