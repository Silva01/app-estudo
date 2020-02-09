package com.estudo.estudo.projeto.repository;

import com.estudo.estudo.projeto.entity.ProjetoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends CrudRepository<ProjetoEntity, Integer> {

}
