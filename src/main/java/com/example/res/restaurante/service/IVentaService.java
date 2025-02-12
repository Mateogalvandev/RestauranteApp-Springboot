package com.example.res.restaurante.service;

import com.example.res.restaurante.model.Cliente;
import com.example.res.restaurante.model.Producto;
import com.example.res.restaurante.model.Venta;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IVentaService {

    void saveVenta(Venta venta); // Guarda una venta.

    void deleteVenta(Long id); // Elimina una venta por ID.

    Venta findVenta(Long id); // Busca una venta por ID.

    List<Venta> getVenta(); // Obtiene todas las ventas.

    void editVenta(Long id, LocalDate fecha, Double total, List<Producto> productosList, Cliente cliente); // Edita una venta.

    List<Producto> traerproducto(Long id); // Obtiene los productos de una venta.

    double totalvente(LocalDate fecha); // Calcula la cantidad de ventas en una fecha.

    double dineraventa(LocalDate fecha); // Calcula el total de dinero generado en ventas.

    Venta mayorventa(); // Obtiene la venta con el mayor monto total.


}
