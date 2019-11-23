package br.com.thiagoresende.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thiagoresende.loja.client.FornecedorClient;
import br.com.thiagoresende.loja.controller.dto.CompraDTO;
import br.com.thiagoresende.loja.controller.dto.InfoFornecedorDTO;

@Service
public class CompraService {

	@Autowired
	private FornecedorClient fornecedorClient;

	public void realizaCompra(CompraDTO compra) {

		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		System.out.println(info.getEndereco());
	}

}
