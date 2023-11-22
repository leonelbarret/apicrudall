package com.leomarques.api.pacientes;

import com.leomarques.api.medico.Especialidade;
import com.leomarques.api.medico.Medico;

public record DadosListagemPaciente(String nome, String email, String cpf) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
