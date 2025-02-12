package com.example.res.restaurante.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

/**
 * Clase que representa un producto en el sistema.
 * Un producto puede ser un ingrediente o una comida que se vende en el restaurante.
 */
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idprecio; // Identificador único del producto
private String nombre; // Nombre del producto (Ej: Carne, Hamburguesa, Papas Fritas)
private String marca; // Marca del producto o descripción si es una comida
private Double costo; // Precio del producto
private int cantidad_disponible; // Cantidad disponible en stock (solo para ingredientes)
@ManyToMany(mappedBy = "lista_productos")
@JsonIgnore // Se ignora para evitar una referencia circular en la serialización JSON
private List<Venta> venta; // Lista de ventas en las que se ha utilizado este producto

    // Constructor vacío
    public Producto() {
    }
    // Constructor con parámetros para inicializar un objeto Producto
    public Producto(Long idprecio, String nombre, String marca, Double costo, int cantidad_disponible, List<Venta> venta) {
        this.idprecio = idprecio;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
        this.venta = venta;
    }

    // Métodos getters y setters para acceder y modificar los atributos
    public Long getIdprecio() {
        return idprecio;
    }

    public void setIdprecio(Long idprecio) {
        this.idprecio = idprecio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public int getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public List<Venta> getVenta() {
        return venta;
    }

    public void setVenta(List<Venta> venta) {
        this.venta = venta;
    }

    // Metodo para representar el objeto en forma de String, sirve para su posterior lectura
    @Override
    public String toString() {
        return "Producto{" +
                "idprecio=" + idprecio +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                ", cantidad_disponible=" + cantidad_disponible +
                ", venta=" + venta +
                '}';
    }
}
