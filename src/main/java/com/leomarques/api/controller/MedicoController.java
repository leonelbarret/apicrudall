package com.leomarques.api.controller;

import com.leomarques.api.medico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repo;

    @GetMapping
    public Page<DadosListagemMedico> listar(Pageable paginacao){
        return repo.findAllAbyAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repo.save(new Medico(dados));

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repo.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void exlcluir(@PathVariable Long id){
        var medico = repo.getReferenceById(id);
        medico.excluir();
    }

}
