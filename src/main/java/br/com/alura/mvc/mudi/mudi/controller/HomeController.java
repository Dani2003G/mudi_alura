package br.com.alura.mvc.mudi.mudi.controller;

import br.com.alura.mvc.mudi.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.mudi.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
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
        Sort sort = Sort.by("dataEntrega").descending();
        PageRequest pageRequest = PageRequest.of(0, 10, sort);

        mv.addObject("pedidos", pedidoRepository.findByStatus(StatusPedido.ENTREGUE, pageRequest));
        return mv;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView onError() {
        return new ModelAndView("redirect:/home");
    }

}
