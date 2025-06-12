package com.produtos.pedidos.controller;

import com.produtos.pedidos.javabeans.Pedido;
import com.produtos.pedidos.javabeans.Produto;
import com.produtos.pedidos.repository.PedidoRepository;
import com.produtos.pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public String addProduto(List<Produto> request) {
        produtoRepository.saveAll(request);
        return "Produto(s) adicionado com sucesso!";
    }

    public List<Produto> listProdutos() {
        return produtoRepository.findAll();
    }

    public List<Pedido> listPedidos() {
        return pedidoRepository.findAll();

    }

    public String addPedido(Pedido request) {
        Pedido pedido = new Pedido();
        if (pedido.getQuantidade() < 0) {
            pedido.setDataPedido(request.getDataPedido());
            pedido.setQuantidade(request.getQuantidade());

            List<Produto> produtos = request.getProdutos().stream()
                    .map(produto -> produtoRepository.findById(produto.getIdProduto())
                            .orElse(null))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            pedido.setProdutos(produtos);

            try {
                Pedido pedidoSaved = pedidoRepository.save(pedido);

                pedidoRepository.save(pedidoSaved);

                if (pedidoSaved.getQuantidade() < 0) {
                    throw new Exception("Simulando um erro");
                }

                pedidoRepository.save(pedidoSaved);
            } catch (Exception e) {
                e.printStackTrace();
                pedidoRepository.save(pedido);
            }
        }
        return "Pedido recebido e em processamento";
    }

    public String editarPedido(long id, Pedido request) {
        Optional<Pedido> pedidoExistente = pedidoRepository.findById(id);

        if (pedidoExistente.isPresent()) {
            atualizaPedido(pedidoExistente.get(), request);
            pedidoRepository.save(pedidoExistente.get());
            return "Pedido atualizado com sucesso!";
        } else {
            return "Pedido não encontrado";
        }
    }

    public String atualizaPedido(Pedido existente, Pedido novo) {
        existente.setDataPedido(novo.getDataPedido());
        existente.setQuantidade(novo.getQuantidade());
        existente.setProdutos(novo.getProdutos());
        return "";
    }
}
