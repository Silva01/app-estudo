package com.estudo.estudo.usuario.repository;

import com.estudo.estudo.usuario.entity.UsuarioEntity;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository <UsuarioEntity, Integer>{

    @Query(value = "SELECT u FROM UsuarioEntity u WHERE u.cpf = :cpf")
    UsuarioEntity getUsuarioByCpf(@Param("cpf") String cpf);
}
