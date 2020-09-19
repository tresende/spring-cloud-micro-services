package br.com.thiagoresende.microservice.loja.service;

import br.com.thiagoresende.microservice.loja.repository.CompraRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thiagoresende.microservice.loja.client.FornecedorClient;
import br.com.thiagoresende.microservice.loja.dto.CompraDTO;
import br.com.thiagoresende.microservice.loja.dto.InfoFornecedorDTO;
import br.com.thiagoresende.microservice.loja.dto.InfoPedidoDTO;
import br.com.thiagoresende.microservice.loja.model.Compra;

@Service
public class CompraService {

    @Autowired
    private FornecedorClient fornecedorClient;

    @Autowired
    private CompraRepository compraRepository;


    @HystrixCommand(fallbackMethod = "realizaCompraFallback", threadPoolKey = "realizaCompraThreadPool")
    public Compra realizaCompra(CompraDTO compra) {

        final String estado = compra.getEndereco().getEstado();

        InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(estado);

        InfoPedidoDTO infoPedido = fornecedorClient.realizaPedido(compra.getItens());

        Compra compraSalva = new Compra();
        compraSalva.setPedidoId(infoPedido.getId());
        compraSalva.setTempoDePreparo(infoPedido.getTempoDePreparo());
        compraSalva.setEnderecoDestino(info.getEndereco());

        compraRepository.save(compraSalva);
        /*
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */

        System.out.println(info.getEndereco());

        return compraSalva;
    }

    public Compra realizaCompraFallback(CompraDTO compra) {
        Compra compraFallback = new Compra();
        compraFallback.setEnderecoDestino(compra.getEndereco().toString());
        return compraFallback;
    }

    @HystrixCommand(threadPoolKey = "getByIdThreadPool")
    public Compra getById(Long id) {
        return compraRepository.findById(id).orElse(new Compra());
    }
}
