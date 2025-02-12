package com.example.res.restaurante.controller;

import com.example.res.restaurante.dto.totalDto;
import com.example.res.restaurante.model.Cliente;
import com.example.res.restaurante.model.Producto;
import com.example.res.restaurante.model.Venta;
import com.example.res.restaurante.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class ventacontroller {

    @Autowired
    public IVentaService ventaser;

    @PostMapping("/venta/crear") // Crear una nueva venta, recibo un body en formato JSON y devuelvo un mensaje de confirmación.
    public String crearVenta(@RequestBody Venta ven){
        ventaser.saveVenta(ven);

        return "la venta se creo con exito";
    }

    @PostMapping("/venta/eliminar/{id}") // Eliminar una venta por su ID, devuelvo un mensaje de confirmación.
    public String eliminarVenta(@PathVariable Long id){
        ventaser.deleteVenta(id);
        return "la venta se elimino con exito";
    }

    @GetMapping("/venta/traer") // Obtener la lista de todas las ventas registradas, devuelvo una lista de ventas en formato JSON.
    public List<Venta> traerVenta(){
        List<Venta> listvent = ventaser.getVenta();

        return listvent;
    }

    @GetMapping("/venta/traer/{id}") // Obtener una venta por su ID, devuelvo el objeto Venta en formato JSON.
    public Venta traerVenta(@PathVariable Long id){
        Venta venta = ventaser.findVenta(id);
        return venta;
    }

    @PutMapping("/venta/editar/{id}") // Editar una venta por su ID, recibo parámetros opcionales y devuelvo la venta actualizada.
    public Venta editarVenta(@PathVariable Long id,
                              @RequestParam(required = false, name = "fecha_venta") LocalDate nfecha,
                              @RequestParam(required = false, name = "total")Double ntotal,
                              @RequestParam(required = false, name = "lista_productos")List<Producto> nproductos,
                              @RequestParam(required = false, name = "cliente")Cliente ncliente){
        ventaser.editVenta(id, nfecha, ntotal, nproductos, ncliente);
        Venta ven = ventaser.findVenta(id);
        return ven;
    }

    @GetMapping("/venta/productos/{id}") // Obtener la lista de productos de una venta específica, devuelvo una lista de productos.
    public List<Producto> traerList(@PathVariable Long id){
        List<Producto> list = ventaser.traerproducto(id);
        return list;
    }

    @GetMapping("/venta/{fecha}") // Obtener estadísticas de ventas en una fecha específica, devuelvo un resumen en String.
    public String fechaventa(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha){
        Double total;
        Double cantidad;

        total = ventaser.dineraventa(fecha);
        cantidad = ventaser.totalvente(fecha);
        return "La cantidad de dinero que se hizo en el dia " + fecha + " es: " + total + " y ese mismo dia se realizaron: " + cantidad + " ventas.";
    }

    @GetMapping("/venta/mayorventa") // Obtener la venta con mayor total facturado, devuelvo un objeto DTO con la información.
    public totalDto total(){
        Venta ven = ventaser.mayorventa();
        Cliente cli = ven.getCliente();
        totalDto total = new totalDto();

        total.setTotal(ven.getTotal());
        total.setNombre(cli.getNombre());
        total.setApellido(cli.getApellido());
        total.setLista_productos(ven.getLista_productos());
        total.setIdventa(ven.getIdventa());

        return total;


    }
}
