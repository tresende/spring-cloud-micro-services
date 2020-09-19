package br.com.thiagoresende.microservice.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.thiagoresende.microservice.loja.dto.CompraDTO;
import br.com.thiagoresende.microservice.loja.model.Compra;
import br.com.thiagoresende.microservice.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private CompraService compraService;

	@RequestMapping(method = RequestMethod.POST)
	public Compra realizaCompra(@RequestBody CompraDTO compra) {
		return compraService.realizaCompra(compra);
	}

	@RequestMapping("/{id}")
	public Compra getByID(@PathVariable("id") Long id) {
		return compraService.getById(id);
	}
}
