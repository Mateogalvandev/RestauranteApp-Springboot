package com.example.res.restaurante.service;

import com.example.res.restaurante.model.Producto;
import com.example.res.restaurante.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductoService implements IProductoService {

    @Autowired
    public IProductoRepository repo;

    @Override
    public void saveProducto(Producto pro) { // Guarda un nuevo producto en la base de datos.
        repo.save(pro);

    }

    public void saveProductos(List<Producto> productos) { // Guarda una lista de productos en la base de datos.
        repo.saveAll(productos);
    }

    @Override
    public void deleteProducto(Long id) { // Elimina un producto por su ID.
        repo.deleteById(id);
    }

    @Override
    public Producto findProdcuto(Long id) { // Busca un producto por su ID, si no existe retorna null.
        Producto pro = repo.findById(id).orElse(null);
        return pro;
    }

    @Override
    public List<Producto> getProducto() { // Obtiene una lista de todos los productos registrados.
        List<Producto> pro = repo.findAll();
        return pro;
    }

    @Override
    public void editProducto(Long id, String nombre, String marca, Double costo, Integer Stock) { // Edita un producto existente, actualizando sus valores si se proporcionan.
        Producto pro = this.findProdcuto(id);
        if (nombre != null) pro.setNombre(nombre);
        if (marca != null) pro.setMarca(marca);
        if (costo != null) pro.setCosto(costo);
        if (Stock != null) pro.setCantidad_disponible(Stock);
        this.saveProducto(pro);
    }

    @Override
    public List<Producto> faltaStock() { // Devuelve una lista de productos que tienen 5 o menos unidades en stock.
        List<Producto> productoList = this.getProducto();
        List<Producto> faltaStock = new ArrayList<Producto>();

        for(Producto stock : productoList){
            if(stock.getCantidad_disponible() <= 5) {
                faltaStock.add(stock);
            }
        }
        return faltaStock;
    }

}
