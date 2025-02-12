package com.example.res.restaurante.controller;

import com.example.res.restaurante.model.Cliente;
import com.example.res.restaurante.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para manejar las operaciones relacionadas con los clientes.
 */
@RestController
public class clienteController {
    @Autowired
    public IClienteService cliser; // Inyección de dependencia del servicio de Cliente

    @PostMapping("/cliente/crear") // Crear un nuevo cliente, recibo un body en formato Json y devuelvo un String informado que se creo exitosamente
    public String crearCliente(@RequestBody Cliente cliente) {
        cliser.saveCliente(cliente);
        return "el cliente se creo con exito";
    }

    @PostMapping("/cliente/eliminar/{id}") // Eliminar un cliente por su ID, devuelvo un String confirmando la eliminación.
    public String eliminarCliente(@PathVariable Long id){
        cliser.deleteCliente(id);
        return "el cliente fue eliminado";
    }

    @GetMapping("/cliente/traer/{id}") // Obtener un cliente por su ID, devuelvo el objeto Cliente en formato JSON.
    public Cliente traerCliente(@PathVariable Long id){
        Cliente cliente = cliser.findCliente(id);
        return cliente;
    }

    @GetMapping("/cliente/traer") // Obtener la lista de todos los clientes registrados, devuelvo una lista de clientes.
    public List<Cliente> traerListaCliente(){
        return cliser.getCliente();
    }

    @PutMapping("/cliente/editar/{id}") // Editar un cliente por su ID, recibo parámetros opcionales y devuelvo el cliente actualizado.
    public Cliente editarCliente(@PathVariable Long id,
                                 @RequestParam(required = false, name = "nombre")String nnombre,
                                 @RequestParam(required = false, name = "apellido") String napellido,
                                 @RequestParam(required = false, name = "dni")String ndni){
        cliser.editCliente(id,nnombre,napellido,ndni);
        Cliente cliente = cliser.findCliente(id);
        return cliente;

    }
}
