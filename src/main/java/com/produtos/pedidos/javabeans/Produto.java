package com.produtos.pedidos.javabeans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduto;
    private String nome;
    private String descricao;
    private double preco;

    @ManyToMany(mappedBy = "produtos")
    @JsonIgnore
    private List<Pedido> pedidos;
}
