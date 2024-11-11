package br.com.alura.mvc.mudi.mudi.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InterceptadorDeAcessos implements HandlerInterceptor {

    public static List<Acesso> acessos = new ArrayList<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Acesso acesso = new Acesso();
        acesso.path = request.getRequestURI();
        acesso.data = LocalDateTime.now();
        request.setAttribute("acesso", acesso);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Acesso acesso = (Acesso) request.getAttribute("acesso");
        acesso.duracao = Duration.between(acesso.data, LocalDateTime.now());
        acessos.add(acesso);
    }

    @Getter
    @Setter
    public static class Acesso {
        private String path;
        private LocalDateTime data;
        private Duration duracao;
    }
}
