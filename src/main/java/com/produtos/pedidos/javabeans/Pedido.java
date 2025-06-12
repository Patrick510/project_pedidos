package com.produtos.pedidos.javabeans;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPedido;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dataPedido = new Date();

    private int quantidade;

    @ManyToMany
    @JoinTable(name = "produto_pedido", joinColumns = @JoinColumn(name = "idPedido"), inverseJoinColumns = @JoinColumn(name = "idProduto"))
    private List<Produto> produtos;

}
