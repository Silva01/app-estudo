package com.estudo.estudo.security;

import com.estudo.estudo.usuario.entity.UsuarioEntity;
import com.estudo.estudo.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class EstudoDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UsuarioEntity entity = usuarioService.buscarPorCpf(s);

        if (entity == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return new UsuarioLogado(entity);
    }
}
