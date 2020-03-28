package com.estudo.estudo.tarefa.service;

import com.estudo.estudo.Action;

public enum TarefaActionsEnun implements Action {
    REDIRECT_TASK("redirect:/tarefas/listar"),
    LIST_TASKS_PAGE("tarefa/listar"),
    NEW_TASK_PAGE("tarefa/cadastrar");

    private String action;

    @Override
    public String getAction(){
        return action;
    }

    TarefaActionsEnun (String action) {
        this.action = action;
    }
}
