package com.example.res.restaurante.service;

import com.example.res.restaurante.model.Producto;
import com.example.res.restaurante.model.Venta;

import java.util.List;

public interface IProductoService {
    void saveProducto(Producto pro); // Guarda un producto.

    void deleteProducto(Long id); // Elimina un producto por ID.

    Producto findProdcuto(Long id); // Busca un producto por ID.

    List<Producto> getProducto(); // Obtiene todos los productos.

    void editProducto(Long id, String nombre, String marca, Double costo, Integer Stock); // Edita un producto.

    List<Producto> faltaStock(); // Obtiene productos con bajo stock.

    void saveProductos(List<Producto> producto); // Guarda una lista de productos.
}
