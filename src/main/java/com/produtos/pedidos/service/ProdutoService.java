package com.produtos.pedidos.service;

import com.produtos.pedidos.javabeans.Produto;
import com.produtos.pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

  @Autowired
  private ProdutoRepository produtoRepository;

  public List<Produto> listarProdutos() {
    return produtoRepository.findAll();
  }

  public Produto adicionarProduto(Produto produto) {
    return produtoRepository.save(produto);
  }

  public Optional<Produto> buscarProdutoPorId(Long id) {
    return produtoRepository.findById(id);
  }

  public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
    return produtoRepository.findById(id).map(produto -> {
      produto.setNome(produtoAtualizado.getNome());
      produto.setPreco(produtoAtualizado.getPreco());
      return produtoRepository.save(produto);
    }).orElse(null);
  }

  public boolean deletarProduto(Long id) {
    if (produtoRepository.existsById(id)) {
      produtoRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
