package br.com.thiagoresende.microservice.loja.repository;

import br.com.thiagoresende.microservice.loja.model.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Long> {
}
