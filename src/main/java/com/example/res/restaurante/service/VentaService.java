package com.example.res.restaurante.service;

import com.example.res.restaurante.model.Cliente;
import com.example.res.restaurante.model.Producto;
import com.example.res.restaurante.model.Venta;
import com.example.res.restaurante.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    public IVentaRepository repo;


    @Override
    public void saveVenta(Venta venta) { // Guarda una nueva venta en la base de datos.
        repo.save(venta);
    }

    @Override
    public void deleteVenta(Long id) { // Elimina una venta por su ID.
        repo.deleteById(id);
    }

    @Override
    public Venta findVenta(Long id) { // Busca una venta por su ID, si no existe retorna null.
        Venta venta = repo.findById(id).orElse(null);
        return venta;
    }

    @Override
    public List<Venta> getVenta() { // Obtiene una lista de todas las ventas registradas.
        List<Venta> venta = repo.findAll();
        return venta;
    }

    @Override
    public void editVenta(Long id, LocalDate fecha, Double total, List<Producto> productosList, Cliente cliente) { // Edita una venta existente, actualizando sus valores si se proporcionan.
        Venta venta = this.findVenta(id);
        venta.setFecha_venta(fecha);
        venta.setTotal(total);
        venta.setLista_productos(productosList);
        venta.setCliente(cliente);
        this.saveVenta(venta);
    }

    @Override
    public List<Producto> traerproducto(Long id) { // Devuelve la lista de productos de una venta específica.
        Venta temp = this.findVenta(id);
        List<Producto> list = temp.getLista_productos();
        return list;
    }

    @Override
    public double totalvente(LocalDate fecha) {  // Calcula la cantidad total de ventas realizadas en una fecha específica.
        List<Venta> ven = repo.findAll();
        return ven.stream().filter(venta -> venta.getFecha_venta().equals(fecha)).count();

    }

    @Override
    public double dineraventa(LocalDate fecha) {  // Calcula el total de dinero generado en ventas en una fecha específica.
        List<Venta> ven = repo.findAll();
        return ven.stream().filter(venta -> venta.getFecha_venta().equals(fecha)).mapToDouble(Venta::getTotal).sum();
    }

    @Override
    public Venta mayorventa() { // Devuelve la venta con el mayor monto total.
        List<Venta> listaVenta = repo.findAll();
        if (listaVenta.isEmpty()){
            return null;
        }

        Venta mayor = listaVenta.get(0);
        for (Venta venta : listaVenta){
            if (venta.getTotal() > mayor.getTotal()) {
                mayor = venta;

            }
        }
        return mayor;

    }


}
