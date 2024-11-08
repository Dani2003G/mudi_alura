package br.com.alura.mvc.mudi.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.mudi.dto.RequisicaoNovoPedidoDTO;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoRepository pedidoRepository;

    @GetMapping("/formulario")
    public ModelAndView formulario(RequisicaoNovoPedidoDTO requisicao) {
        return new ModelAndView("pedido/formulario");
    }

    @PostMapping("/novo")
    public ModelAndView novo(@Valid RequisicaoNovoPedidoDTO requisicao, BindingResult result) {
        if(result.hasErrors()) {
            return new ModelAndView("pedido/formulario");
        }
        Pedido pedido = requisicao.toPedido();
        pedidoRepository.save(pedido);
        return new ModelAndView("redirect:/home");
    }

}
