package com.estudo.estudo.tarefa.controller;

import com.estudo.estudo.tarefa.entity.TarefaEntity;
import com.estudo.estudo.tarefa.service.TarefaActionsEnun;
import com.estudo.estudo.tarefa.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping ("tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tService;

    @GetMapping("cadastrar")
    public String createAndRedirectTask (Model model) {
        return tService.getTaskById(0)
                .uploadAttributesModel(model)
                .redirect(TarefaActionsEnun.NEW_TASK_PAGE);
    }

    @RequestMapping(path = "salvar", method = RequestMethod.POST)
    public String saveAndRedirect (TarefaEntity tarefa) {
        return tService.salvar(tarefa).redirect(TarefaActionsEnun.REDIRECT_TASK);
    }

    @GetMapping("listar")
    public String listAndRedirect (Model model) {
        return tService.getAllTasks()
                .uploadAttributesModel(model)
                .redirect(TarefaActionsEnun.LIST_TASKS_PAGE);
    }

    @RequestMapping(path = "/deletar/{id}")
    public String deleteAndGetUserAndRedirect (@PathVariable("id") Integer id, Model model) {
        return tService.deleteTaskById(id).getAllTasks().uploadAttributesModel(model)
                .redirect(TarefaActionsEnun.REDIRECT_TASK);
    }

    @GetMapping("atualizar/{id}")
    public String updateAndRedirect (@PathVariable("id") Integer id, Model model) {
        return tService.getTaskById(id).uploadAttributesModel(model)
                .redirect(TarefaActionsEnun.NEW_TASK_PAGE);
    }
}
