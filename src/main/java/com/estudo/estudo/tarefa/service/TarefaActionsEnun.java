package com.estudo.estudo.tarefa.service;

public enum TarefaActionsEnun {
    REDIRECT_TASK("redirect:/tarefas/listar"),
    LIST_TASKS_PAGE("tarefa/listar"),
    NEW_TASK_PAGE("tarefa/cadastrar");

    private String action;

    public String getAction(){
        return action;
    }

    TarefaActionsEnun (String action) {
        this.action = action;
    }
}
