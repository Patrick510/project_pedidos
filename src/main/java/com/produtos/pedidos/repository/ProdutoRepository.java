package com.produtos.pedidos.repository;

import com.produtos.pedidos.javabeans.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
