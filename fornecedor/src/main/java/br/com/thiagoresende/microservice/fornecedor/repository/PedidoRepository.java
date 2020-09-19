package br.com.thiagoresende.microservice.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.thiagoresende.microservice.fornecedor.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
