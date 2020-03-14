package com.estudo.estudo.usuario.service;

public enum UsuarioActionsEnun {
    REDIRECT_USERS("redirect:/usuarios/listar"),
    LIST_USERS_PAGE("usuario/listar"),
    NEW_USER_PAGE("usuario/cadastrar");

    private String action;

    public String getAction() {
        return action;
    }

    UsuarioActionsEnun(String action) {
        this.action = action;
    }
}
