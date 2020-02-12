package com.estudo.estudo.tarefa.repository;

import com.estudo.estudo.tarefa.entity.TarefaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends CrudRepository<TarefaEntity, Integer> {
}
