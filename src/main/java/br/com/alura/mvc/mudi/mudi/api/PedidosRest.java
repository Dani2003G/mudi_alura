package br.com.alura.mvc.mudi.mudi.api;

import br.com.alura.mvc.mudi.mudi.model.Pedido;
import br.com.alura.mvc.mudi.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.mudi.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pedidos")
public class PedidosRest {

    private final PedidoRepository pedidoRepository;

    @GetMapping("/aguardando")
    public List<Pedido> getPedidosAguardandoOfertas() {
        Sort sort = Sort.by("id").descending();
        PageRequest paginacao = PageRequest.of(0, 10, sort);
        return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, paginacao);
    }

}
