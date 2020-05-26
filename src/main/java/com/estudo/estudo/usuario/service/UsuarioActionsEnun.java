package com.estudo.estudo.usuario.service;

import com.estudo.estudo.Action;

public enum UsuarioActionsEnun implements Action {
    REDIRECT_USERS("redirect:/usuarios/listar"),
    LIST_USERS_PAGE("usuario/listar"),
    NEW_USER_PAGE("usuario/cadastrar");

    private String action;

    @Override
    public String getAction() {
        return action;
    }

    UsuarioActionsEnun(String action) {
        this.action = action;
    }
}
