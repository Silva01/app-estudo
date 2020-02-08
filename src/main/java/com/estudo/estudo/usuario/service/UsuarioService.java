package com.estudo.estudo.usuario.service;

import com.estudo.estudo.usuario.entity.UsuarioEntity;
import com.estudo.estudo.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public void salvar(UsuarioEntity usuario){
        repository.save(usuario);
    }
}
