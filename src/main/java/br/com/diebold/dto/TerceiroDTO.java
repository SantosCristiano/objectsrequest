package br.com.diebold.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TerceiroDTO {

    @JsonProperty("CodProduto")
    private String codProduto;

    @JsonProperty("ListaTecnicos")
    private List<TecnicosDTO> listaTecnicos = new ArrayList<TecnicosDTO>();

    @JsonProperty("CodigoMensagem")
    private String codigoMensagem;

    @JsonProperty("CodFilial")
    private String codFilial;

    @JsonProperty("QtdeTotal")
    private Long qtdeTotal;

    @JsonProperty("Mensagem")
    private String mensagem;
}
