package com.example.res.restaurante.dto;

import com.example.res.restaurante.model.Producto;

import java.util.List;

public class totalDto {
    private Long idventa;
    private Double total;
    private List<Producto> lista_productos;
    private String nombre;
    private String apellido;

    public totalDto() {
    }

    public totalDto(Long idventa, Double total, List<Producto> lista_productos, String nombre, String apellido) {
        this.idventa = idventa;
        this.total = total;
        this.lista_productos = lista_productos;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getIdventa() {
        return idventa;
    }

    public void setIdventa(Long idventa) {
        this.idventa = idventa;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Producto> getLista_productos() {
        return lista_productos;
    }

    public void setLista_productos(List<Producto> lista_productos) {
        this.lista_productos = lista_productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
