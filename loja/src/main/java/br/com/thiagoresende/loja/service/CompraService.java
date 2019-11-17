package br.com.thiagoresende.loja.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.thiagoresende.loja.controller.dto.CompraDTO;
import br.com.thiagoresende.loja.controller.dto.InfoFornecedorDTO;

public class CompraService {

	public void realizaCompra(CompraDTO compra) {

		RestTemplate client = new RestTemplate();
		String url = "http://localhost:8081/info" + compra.getEndereco().getEstado();
		ResponseEntity<InfoFornecedorDTO> exchange = client.exchange(url, HttpMethod.GET, null,
				InfoFornecedorDTO.class);
		System.out.println(exchange.getBody().getEndereco());
	}

}
