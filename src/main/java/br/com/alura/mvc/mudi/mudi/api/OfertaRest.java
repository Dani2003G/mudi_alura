package br.com.alura.mvc.mudi.mudi.api;

import br.com.alura.mvc.mudi.mudi.dto.RequisicaoNovaOferta;
import br.com.alura.mvc.mudi.mudi.model.Oferta;
import br.com.alura.mvc.mudi.mudi.model.Pedido;
import br.com.alura.mvc.mudi.mudi.repository.PedidoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ofertas")
public class OfertaRest {

    private final PedidoRepository pedidoRepository;

    @PostMapping
    public Oferta criarOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao) {
        Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
        if (pedidoBuscado.isEmpty()) {
            return null;
        }

        Pedido pedido = pedidoBuscado.get();

        Oferta nova = requisicao.toOferta();
        nova.setPedido(pedido);
        pedido.getOfertas().add(nova);
        pedidoRepository.save(pedido);
        return nova;
    }

}
