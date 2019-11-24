package br.com.thiagoresende.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	@Autowired
	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

	public Compra realizaCompra(CompraDTO compra) {

		String estado = compra.getEndereco().getEstado();
		LOG.info("Buscando fornecedor de " + estado);
		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(estado);
		LOG.info("Info " + info);
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		LOG.info("Realizando pedido " + pedido);
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		return compraSalva;
	}

}
