package com.xp_educacao.projeto_aplicado.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto implements Serializable {

    private String nome;
    private String email;
    private String documento;
    private TipoDocumento tipoDocumento;
}
