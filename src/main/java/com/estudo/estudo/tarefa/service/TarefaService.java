package com.estudo.estudo.tarefa.service;
import com.estudo.estudo.tarefa.entity.TarefaEntity;
import com.estudo.estudo.tarefa.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    public void salvar (TarefaEntity tarefa){
        repository.save(tarefa);
    }

    public List<TarefaEntity> listarTodos () {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void deletar (Integer id) {
        repository.deleteById(id);
    }

    public TarefaEntity obterPorId (Integer id) {
        return repository.findById(id).get();
    }
}
