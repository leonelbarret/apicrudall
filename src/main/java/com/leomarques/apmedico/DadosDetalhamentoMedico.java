package com.leomarques.apmedico;

import com.leomarques.api.endereco.Endereco;
import com.leomarques.api.medico.Especialidade;
import com.leomarques.api.medico.Medico;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone,Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
