package com.leomarques.api.controller;

import com.leomarques.api.medico.DadosCadastroMedico;
import com.leomarques.api.medico.DadosListagemMedico;
import com.leomarques.api.medico.Medico;
import com.leomarques.api.medico.MedicoRepository;
import com.leomarques.api.pacientes.DadosCadastroPaciente;
import com.leomarques.api.pacientes.DadosListagemPaciente;
import com.leomarques.api.pacientes.Paciente;
import com.leomarques.api.pacientes.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repo;

    @GetMapping
    public Page<DadosListagemPaciente> listar(Pageable paginacao){
        return repo.findAll(paginacao).map(DadosListagemPaciente::new);
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
        repo.save(new Paciente(dados));

    }

}

