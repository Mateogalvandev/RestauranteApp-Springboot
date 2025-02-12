package com.example.res.restaurante.service;

import com.example.res.restaurante.model.Cliente;

import java.util.List;

public interface IClienteService {

    void saveCliente(Cliente cliente); // Guarda un cliente.

    List<Cliente> getCliente(); // Obtiene todos los clientes.

    void deleteCliente(Long id); // Elimina un cliente por ID.

    Cliente findCliente(Long id); // Busca un cliente por ID.

    void editCliente(Long idoriginal, String nombre, String apellido, String dni); // Edita un cliente existente.
}
