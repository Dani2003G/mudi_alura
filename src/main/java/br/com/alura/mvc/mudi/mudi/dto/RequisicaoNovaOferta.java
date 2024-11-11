package br.com.alura.mvc.mudi.mudi.dto;

import br.com.alura.mvc.mudi.mudi.model.Oferta;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class RequisicaoNovaOferta {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Long pedidoId;

    @NotNull
    @Pattern(regexp = "^\\d+(\\.\\d+{2})?$")
    private String valor;

    @NotNull
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
    private String dataEntrega;

    private String comentario;

    public Oferta toOferta() {
        Oferta oferta = new Oferta();
        oferta.setComentario(this.comentario);
        oferta.setDataEntrega(LocalDate.parse(this.dataEntrega, formatter));
        oferta.setValor(new BigDecimal(this.valor));
        return oferta;
    }
}
