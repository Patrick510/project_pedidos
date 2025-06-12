package com.produtos.pedidos.controller;

import com.produtos.pedidos.javabeans.Pedido;
import com.produtos.pedidos.javabeans.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RequisicaoPedido {
    @Autowired private PedidoService requisicao;

    @PostMapping("/addProduto")
    public String adicionarProduto(@RequestBody List<Produto> request){
        return requisicao.addProduto(request);
    }

    @GetMapping("/listProdutos")
    public List<Produto> listarProdutos(){
        return requisicao.listProdutos();
    }

    @GetMapping("/listPedidos")
    public List<Pedido> listarPedidos(){
        return requisicao.listPedidos();
    }

    @PostMapping("/editarPedido/{id}")
    public String editarPedido(@PathVariable long id, @RequestBody Pedido pedido){
        return requisicao.editarPedido(id, pedido);
    }


    @PostMapping("/addPedido")
    public String adicionarPedido(@RequestBody Pedido request){
        return requisicao.  addPedido(request);
    }
}
