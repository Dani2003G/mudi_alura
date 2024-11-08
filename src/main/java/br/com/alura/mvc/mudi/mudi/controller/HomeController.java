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

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    private final PedidoRepository pedidoRepository;

    @GetMapping
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("pedidos", pedidoRepository.findAll());
        return mv;
    }

    @GetMapping("/{status}")
    public ModelAndView porStatus(@PathVariable("status") String status) {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("pedidos", pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase())));
        mv.addObject("status", status);
        return mv;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView onError() {
        return new ModelAndView("redirect:/home");
    }

}
