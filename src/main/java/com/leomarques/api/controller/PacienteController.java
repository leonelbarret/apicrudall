package com.leomarques.api.controller;

import com.leomarques.api.medico.*;
import com.leomarques.api.pacientes.*;
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
        return repo.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
        repo.save(new Paciente(dados));

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados){
        var paciente = repo.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void exlcluir(@PathVariable Long id){
        var paciente = repo.getReferenceById(id);
        paciente.excluir();
    }

}

