/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lasalle.services.model;

/**
 *
 * @author alonso
 */
public class Categoria {
    
    private int idCategoria;
    private String categoria;
    private String departamento;
    private int responsable;

    public Categoria() {}
    
    public Categoria(int idCategoria, String categoria, String departamento, int responsable) {
        this.idCategoria = idCategoria;
        this.categoria = categoria;
        this.departamento = departamento;
        this.responsable = responsable;
    }
    
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getResponsable() {
        return responsable;
    }

    public void setResponsable(int responsable) {
        this.responsable = responsable;
    }
    
    
    
}
