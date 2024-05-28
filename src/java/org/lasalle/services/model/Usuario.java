/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lasalle.services.model;

import java.util.Date;

/**
 *
 * @author alonso
 */
public class Usuario {
    
    private int idUsuario;
    private String username;
    private String password;    
    private String token;
    private Date lastConnection;

    public Usuario() {}
    
    public Usuario(int idUsuario, String username, String password, String token, Date lastConnection) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.token = token;
        this.lastConnection = lastConnection;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLastConnection() {
        return lastConnection;
    }

    public void setLastConnection(Date lastConnection) {
        this.lastConnection = lastConnection;
    }  
}