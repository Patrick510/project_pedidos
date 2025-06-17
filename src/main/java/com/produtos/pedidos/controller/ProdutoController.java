package com.produtos.pedidos.controller;

import com.produtos.pedidos.javabeans.Produto;
import com.produtos.pedidos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  @Autowired
  private ProdutoService produtoService;

  @GetMapping
  public ResponseEntity<List<Produto>> listarProdutos() {
    return ResponseEntity.ok(produtoService.listarProdutos());
  }

  @PostMapping
  public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto) {
    Produto salvo = produtoService.adicionarProduto(produto);
    return ResponseEntity.ok(salvo);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
    return produtoService.buscarProdutoPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
    Produto atualizado = produtoService.atualizarProduto(id, produtoAtualizado);
    if (atualizado == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(atualizado);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletarProduto(@PathVariable Long id) {
    if (produtoService.deletarProduto(id)) {
      return ResponseEntity.ok("Produto removido com sucesso!");
    }
    return ResponseEntity.notFound().build();
  }
}
