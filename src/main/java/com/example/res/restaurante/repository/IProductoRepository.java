package com.example.res.restaurante.repository;

import com.example.res.restaurante.model.Producto;
import com.example.res.restaurante.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {


}
