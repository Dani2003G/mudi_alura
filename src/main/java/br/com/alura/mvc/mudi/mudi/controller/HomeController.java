package br.com.alura.mvc.mudi.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        Pedido pedido = new Pedido();
        pedido.setNomeProduto("Novo Kindle (16 GB - modelo 2024)");
        pedido.setUrlImagem("https://m.media-amazon.com/images/I/810j-Zlo7ZL._AC_SL1500_.jpg");
        pedido.setUrlProduto("https://www.amazon.com.br/kindle-16gb-verde/dp/B0CP31QS6R/ref=sr_1_1?crid=2S0QTMNAF5OBX&dib=eyJ2IjoiMSJ9.sn2T8eCvEb7o127UFULifTqeZoocF7Navyl81MnSNNfwddr7EDw3kO5mx6mXxtvhUOSMn4_g-10-3SCJrzkpZ6SdKMXbjTAh-wRC6zcGC6c-9HegG-ert2-ndHaJ0bKS2_XaLwmkztuvfJT3QQkjtScoPpPcDpH3pl1kTw78Hdcsjm6qIa_Cm1mAG2A_5DhXqz0EcurUp9qjD-5LDbjN62ajuTAzR_drmKOgu-IVWO16zVtMrQmhyQUeDoQ_3-ZrMfE6BQrNyhJ2pvDIvLZv_ROqCKqx9Rr6gDKjwF3FpLk.UauCRYEufHQSkAZPDcA1Ppx8Z_8eHskFaOtU7yGnQto&dib_tag=se&keywords=kindle&qid=1730932941&sprefix=KIND%2Caps%2C200&sr=8-1&ufe=app_do%3Aamzn1.fos.95de73c3-5dda-43a7-bd1f-63af03b14751&th=1");
        pedido.setDescricao("Descrição qualquer");

        List<Pedido> pedidos = Arrays.asList(pedido);

        model.addAttribute("pedidos", pedidos);

        return "home";
    }

}
