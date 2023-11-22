package com.leomarques.api.pacientes;

import com.leomarques.api.endereco.DadosEndereco;
import com.leomarques.api.medico.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPaciente(
        @NotBlank
        String nome,

        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotNull
        @Valid
        DadosEndereco endereco) {
}
