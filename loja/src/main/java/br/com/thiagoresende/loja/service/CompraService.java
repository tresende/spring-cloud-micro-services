package br.com.thiagoresende.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.thiagoresende.loja.controller.dto.CompraDTO;
import br.com.thiagoresende.loja.controller.dto.InfoFornecedorDTO;

@Service
public class CompraService {

	@Autowired
	@LoadBalanced
	private RestTemplate client;

	public void realizaCompra(CompraDTO compra) {

		String url = "http://fornecedor/info/" + compra.getEndereco().getEstado();
		System.out.println(url);
		ResponseEntity<InfoFornecedorDTO> exchange = client.exchange(url, HttpMethod.GET, null,
				InfoFornecedorDTO.class);
		System.out.println(exchange.getBody().getEndereco());
	}

}
