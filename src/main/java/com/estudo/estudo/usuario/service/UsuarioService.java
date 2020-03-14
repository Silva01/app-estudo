package com.estudo.estudo.usuario.service;

import com.estudo.estudo.ResponseAbstract;
import com.estudo.estudo.usuario.entity.UsuarioEntity;
import com.estudo.estudo.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UsuarioService extends ResponseAbstract {

    @Autowired
    private UsuarioRepository repository;

    private static final String ATTRIBUTE_LIST_USER = "usuariosLista";
    private static final String ATTRIBUTE_USER = "usuario";

    public UsuarioService() {
        super();
    }

    public UsuarioService salvar(UsuarioEntity usuario){
        repository.save(usuario);
        return this;
    }

    public UsuarioService getAllUsers(){
        addResponseAttribute(ATTRIBUTE_LIST_USER, StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList()));
        return this;
    }

    public UsuarioService deleteUser(Integer id){
        repository.deleteById(id);
        return this;
    }

    public UsuarioService obterPorId (Integer id) {
        addResponseAttribute(ATTRIBUTE_USER, repository.findById(id).orElseGet(UsuarioEntity::new));
        return this;
    }

    public UsuarioEntity buscarPorCpf(String cpf) {
        return repository.getUsuarioByCpf(cpf);
    }
}
