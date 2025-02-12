package com.example.res.restaurante.service;

import com.example.res.restaurante.model.Cliente;
import com.example.res.restaurante.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    public IClienteRepository clirepo;

    @Override
    public void saveCliente(Cliente cliente) { // Guarda un nuevo cliente en la base de datos.
        clirepo.save(cliente);

    }

    @Override
    public List<Cliente> getCliente() { // Obtiene una lista de todos los clientes registrados.
    List<Cliente>listaCliente = clirepo.findAll();
    return  listaCliente;
    }

    @Override
    public void deleteCliente(Long id) { // Elimina un cliente por su ID.
        clirepo.deleteById(id);

    }

    @Override
    public Cliente findCliente(Long id) { // Busca un cliente por su ID, si no existe retorna null.
        Cliente cliente = clirepo.findById(id).orElse(null);
        return cliente;


    }

    @Override
    public void editCliente(Long idoriginal, String nombre, String apellido, String dni) { // Edita un cliente existente, cambiando sus valores si se proporcionan.
        Cliente cliente = this.findCliente(idoriginal);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDni(dni);
        this.saveCliente(cliente);
    }
}
