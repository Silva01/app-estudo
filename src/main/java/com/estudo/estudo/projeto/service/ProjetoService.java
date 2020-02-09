package com.estudo.estudo.projeto.service;

import com.estudo.estudo.projeto.entity.ProjetoEntity;
import com.estudo.estudo.projeto.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository repository;

    public void salvar (ProjetoEntity projeto) {
        repository.save(projeto);
    }
}
