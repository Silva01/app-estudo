package com.estudo.estudo.tarefa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends CrudRepository<TarefaRepository, Integer> {
}
