package com.leomarques.api.controller;

import com.leomarques.api.medico.DadosCadastroMedico;
import com.leomarques.api.medico.DadosListagemMedico;
import com.leomarques.api.medico.Medico;
import com.leomarques.api.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<DadosListagemMedico> listar(){
        return repo.findAll().stream().map(DadosListagemMedico::new).toList();
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repo.save(new Medico(dados));

    }

}
