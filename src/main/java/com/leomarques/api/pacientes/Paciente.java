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

    @Embedded
    private Endereco endereco;


    public Paciente(DadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());

    }


}
