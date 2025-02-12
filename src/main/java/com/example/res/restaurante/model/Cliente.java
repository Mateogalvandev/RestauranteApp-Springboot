package com.example.res.restaurante.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Clase que representa a un cliente en el sistema.
 * Contiene información básica como nombre, apellido y DNI.
 */

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcliente; // Identificador único del cliente en la base de datos
    private String nombre; // Nombre del cliente
    private String apellido; // Apellido del cliente
    private String dni; // Documento Nacional de Identidad (DNI) del cliente

    // Constructor vacío necesario para JPA
    public Cliente() {
    }

    // Constructor con parámetros para inicializar un objeto Cliente
    public Cliente(Long idcliente, String nombre, String apellido, String dni) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    // Métodos getters y setters para acceder y modificar los atributos
    public Long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // Metodo para representar el objeto en forma de String, sirve para su posterior lectura
    @Override
    public String toString() {
        return "Cliente{" +
                "idcliente=" + idcliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
