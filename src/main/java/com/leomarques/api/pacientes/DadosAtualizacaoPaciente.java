package com.leomarques.api.pacientes;

import com.leomarques.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(@NotNull Long id, String nome, String telefone, DadosEndereco endereco) {
}
