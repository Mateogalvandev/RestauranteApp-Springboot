package com.example.res.restaurante.controller;

import com.example.res.restaurante.model.Cliente;
import com.example.res.restaurante.model.Producto;
import com.example.res.restaurante.model.Venta;
import com.example.res.restaurante.service.IClienteService;
import com.example.res.restaurante.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productocontroller {

    @Autowired
    public IProductoService pro;

    @PostMapping("/producto/crear") // Crear un nuevo producto, recibo un body en formato JSON y devuelvo un mensaje confirmando la creación.
    public String crearProducot(@RequestBody Producto producto){
        pro.saveProducto(producto);
        return "El producto fue creado exitosamente";
    }

    @PostMapping("/producto/crearlista") // Crear una lista de productos en una sola solicitud, devuelvo un mensaje de confirmación.
    public String crearProductoLista(@RequestBody List<Producto> producto){
        pro.saveProductos(producto);

        return "La lista de productos se creo correctamente";

    }

    @PostMapping("/producto/eliminar/{id}")  // Eliminar un producto por su ID, devuelvo un mensaje confirmando la eliminación.
    public String eliminarProducto(@PathVariable Long id){
        pro.deleteProducto(id);
        return "El producto fue eliminado exitosamente";
    }

    @GetMapping("/producto/traer/{id}") // Obtener un producto por su ID, devuelvo el objeto Producto en formato JSON.
    public Producto traerProducto(@PathVariable Long id){
        Producto producto = traerProducto(id);
        return producto;
    }

    @GetMapping("/producto/traer") // Obtener la lista de todos los productos, devuelvo una lista de productos en formato JSON.
    public List<Producto> listaProducto(){
        List<Producto> proList = pro.getProducto();
        return proList;
    }

    @PutMapping("/producto/editar/{id}") // Editar un producto por su ID, recibo parámetros opcionales y devuelvo el producto actualizado.
    public Producto editarProducto(@PathVariable Long id,
                                   @RequestParam(required = false, name = "nombre")String nnombre,
                                   @RequestParam(required = false, name = "marca")String nmarca,
                                   @RequestParam(required = false, name = "costo")Double ncosto,
                                   @RequestParam(required = false, name = "cantidad_disponible")Integer nstock){

        pro.editProducto(id, nnombre, nmarca, ncosto, nstock);
        Producto prod = pro.findProdcuto(id);
        return prod;
    }

    @GetMapping("/producto/faltastock") // Obtener lista de productos con bajo stock, devuelvo una lista de productos.
    public List<Producto> stock() {
        return pro.faltaStock();
    }




}
