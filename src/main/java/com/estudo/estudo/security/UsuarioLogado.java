package com.estudo.estudo.security;

import com.estudo.estudo.usuario.entity.UsuarioEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UsuarioLogado implements UserDetails {

    private String name;
    private Integer id;
    private String senha;
    private String login;
    private boolean ativo;

    public UsuarioLogado(UsuarioEntity usuario) {
        this.name = usuario.getNome();
        this.senha = usuario.getSenha();
        this.login = usuario.getCpf();
        this.ativo = usuario.isAtivo();
        this.id = usuario.getId();
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return ativo;
    }
}
