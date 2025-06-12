package com.produtos.pedidos.repository;

import com.produtos.pedidos.javabeans.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
