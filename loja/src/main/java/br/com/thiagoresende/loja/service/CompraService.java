package br.com.thiagoresende.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thiagoresende.loja.client.FornecedorClient;
import br.com.thiagoresende.loja.dto.CompraDTO;
import br.com.thiagoresende.loja.dto.InfoFornecedorDTO;
import br.com.thiagoresende.loja.dto.InfoPedidoDTO;
import br.com.thiagoresende.loja.model.Compra;

@Service
public class CompraService {

	@Autowired
	private FornecedorClient fornecedorClient;

	public Compra realizaCompra(CompraDTO compra) {

		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		System.out.println(info.getEndereco());

		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		return compraSalva;
	}

}
