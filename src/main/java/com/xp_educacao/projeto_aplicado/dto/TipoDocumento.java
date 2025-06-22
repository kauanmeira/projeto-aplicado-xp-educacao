package com.xp_educacao.projeto_aplicado.dto;

import lombok.Getter;

@Getter
public enum TipoDocumento {
    CPF(11),
    CNPJ(14);

    private final int tamanho;

    TipoDocumento(int tamanho) {
        this.tamanho = tamanho;
    }
}
