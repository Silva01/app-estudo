package com.estudo.estudo.projeto.service;

import com.estudo.estudo.projeto.entity.ProjetoEntity;
import com.estudo.estudo.projeto.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository repository;

    public void salvar (ProjetoEntity projeto) {
        repository.save(projeto);
    }

    public List<ProjetoEntity> listarTodos (){
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void deletar (Integer id) {
        repository.deleteById(id);
    }

    public ProjetoEntity obterPorId (Integer id){
        return repository.findById(id).get();
    }

    public List<ProjetoEntity> getByIds(List<Integer> ids) {
        return StreamSupport.stream(repository.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }


}
