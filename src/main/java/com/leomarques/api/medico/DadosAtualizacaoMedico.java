package com.leomarques.api.medico;

import com.leomarques.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
