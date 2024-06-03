package br.com.diebold.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TecnicosDTO {

    @JsonProperty("nomeEmit")
    private String nomeEmit;

    @JsonProperty("quantidade")
    private Long quantidade;

    @JsonProperty("codEmitente")
    private Integer codEmitente;
}
