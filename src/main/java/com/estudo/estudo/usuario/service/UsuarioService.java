package com.estudo.estudo.usuario.service;

import com.estudo.estudo.usuario.entity.UsuarioEntity;
import com.estudo.estudo.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public void salvar(UsuarioEntity usuario){
        repository.save(usuario);
    }

    public List<UsuarioEntity> listarTodos (){
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void deletar (Integer id){
        repository.deleteById(id);
    }

    public UsuarioEntity obterPorId (Integer id) {
        return repository.findById(id).get();
    }
}
