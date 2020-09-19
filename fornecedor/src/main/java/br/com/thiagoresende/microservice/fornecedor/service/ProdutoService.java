package br.com.thiagoresende.microservice.fornecedor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.thiagoresende.microservice.fornecedor.model.Produto;
import br.com.thiagoresende.microservice.fornecedor.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private ProdutoRepository produtoRepository;
	
	public List<Produto> getProdutosPorEstado(String estado) {
		return produtoRepository.findByEstado(estado);
	}

	
}
