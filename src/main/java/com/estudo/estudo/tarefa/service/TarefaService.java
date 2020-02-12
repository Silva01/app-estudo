package com.estudo.estudo.tarefa.service;
import com.estudo.estudo.tarefa.entity.TarefaEntity;
import com.estudo.estudo.tarefa.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    public void salvar (TarefaEntity tarefa){
        repository.save(tarefa);
    }


}
