package com.example.res.restaurante.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase que representa una venta en el restaurante.
 * Cada venta está asociada a un cliente y contiene una lista de productos vendidos.
 */
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idventa; // Identificador único de la venta
    private LocalDate fecha_venta; // Fecha en la que se realizó la venta
    private Double total; // Monto total de la venta
    @ManyToMany
    private List<Producto> lista_productos; // Lista de productos vendidos en esta venta
    @OneToOne
    private Cliente cliente; // Cliente que realizó la compra

    // Constructor vacío
    public Venta() {
    }

    // Constructor con parámetros para inicializar un objeto Venta
    public Venta(Long idventa, LocalDate fecha_venta, Double total, List<Producto> lista_productos, Cliente cliente) {
        this.idventa = idventa;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.lista_productos = lista_productos;
        this.cliente = cliente;
    }

    public Long getIdventa() {
        return idventa;
    }

    public void setIdventa(Long idventa) {
        this.idventa = idventa;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Metodo para representar el objeto en forma de String, sirve para su posterior lectura
    @Override
    public String toString() {
        return "Venta{" +
                "idventa=" + idventa +
                ", fecha_venta=" + fecha_venta +
                ", total=" + total +
                ", lista_productos=" + lista_productos +
                ", cliente=" + cliente +
                '}';
    }
}
