package com.produtos.pedidos.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.produtos.pedidos.service.ProdutoService;

@Component
public class ProdutoConsumer {

  @Autowired
  private ProdutoService produtoService;

  @RabbitListener(queues = "${spring.rabbitmq.queue}")
  public void listenProdutoQueue(String message) {
    System.out.println("Mensagem recebida na fila: " + message);
  }
}
