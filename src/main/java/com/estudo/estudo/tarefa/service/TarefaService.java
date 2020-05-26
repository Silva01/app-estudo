package com.estudo.estudo.tarefa.service;
import com.estudo.estudo.ResponseAbstract;
import com.estudo.estudo.tarefa.entity.TarefaEntity;
import com.estudo.estudo.tarefa.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TarefaService extends ResponseAbstract {

    @Autowired
    private TarefaRepository repository;
    private static final String ATTRIBUTE_TASK_LIST = "tarefasLista";
    private static final String ATTRIBUTE_TASK = "tarefa";

    public TarefaService(){
        super();
    }

    public TarefaService salvar(TarefaEntity tarefa) {
        repository.save(tarefa);
        return this;
    }

    public TarefaService getAllTasks(){
        addResponseAttribute(ATTRIBUTE_TASK_LIST, StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList()));
        return this;
    }

    public TarefaService deleteTask (Integer id) {
        repository.deleteById(id);
        return this;
    }

    public TarefaService getTaskById (Integer id) {
        addResponseAttribute(ATTRIBUTE_TASK, repository.findById(id).orElseGet(TarefaEntity::new));
        return this;
    }

    public TarefaService deleteTaskById (Integer id) {
        repository.deleteById(id);
        return this;
    }

}
