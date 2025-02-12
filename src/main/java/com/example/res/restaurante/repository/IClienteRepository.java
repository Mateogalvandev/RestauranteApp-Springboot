package com.example.res.restaurante.repository;

import com.example.res.restaurante.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IClienteRepository extends JpaRepository <Cliente, Long> {
}
