package com.leomarques.api.pacientes;

import com.leomarques.api.endereco.Endereco;
import com.leomarques.api.medico.DadosCadastroMedico;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Paciente")
@Table(name = "paciente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Boolean ativo;

    @Embedded
    private Endereco endereco;


    public Paciente(DadosCadastroPaciente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());

    }


    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }

        if (dados.endereco() != null) {
            this.endereco.atualizarEndereco(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
