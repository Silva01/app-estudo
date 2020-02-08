package com.estudo.estudo.usuario.repository;

import com.estudo.estudo.usuario.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository <UsuarioEntity, Integer>{

}
