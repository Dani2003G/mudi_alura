package br.com.alura.mvc.mudi.mudi.controller;

import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private final PedidoRepository pedidoRepository;

    @GetMapping("/pedidos")
    public ModelAndView home(Principal principal) {
        ModelAndView mv = new ModelAndView("usuario/home");
        mv.addObject("pedidos", pedidoRepository.findByUsuario(principal.getName()));
        return mv;
    }

    @GetMapping("/pedidos/{status}")
    public ModelAndView porStatus(@PathVariable("status") String status, Principal principal) {
        ModelAndView mv = new ModelAndView("usuario/home");
        mv.addObject("pedidos", pedidoRepository.findByStatusEusuario(StatusPedido.valueOf(status.toUpperCase()), principal.getName()));
        mv.addObject("status", status);
        return mv;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView onError() {
        return new ModelAndView("redirect:/usuario/home");
    }

}
