package com.estudo.estudo.tarefa.controller;

import com.estudo.estudo.projeto.service.ProjetoService;
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
    private TarefaService tarefaService;

    @Autowired
    private ProjetoService projetoService;

    @GetMapping("cadastrar")
    public String createAndRedirectTask (Model model) {
        return tarefaService.getTaskById(0)
                .addResponseAttribute("projetos", projetoService.listarTodos())
                .uploadAttributesModel(model)
                .redirect(TarefaActionsEnun.NEW_TASK_PAGE);
    }

    @RequestMapping(path = "salvar", method = RequestMethod.POST)
    public String saveAndRedirect (TarefaEntity tarefa) {
        return tarefaService.salvar(tarefa).redirect(TarefaActionsEnun.REDIRECT_TASK);
    }

    @GetMapping("listar")
    public String listAndRedirect (Model model) {
        return tarefaService.getAllTasks()
                .uploadAttributesModel(model)
                .redirect(TarefaActionsEnun.LIST_TASKS_PAGE);
    }

    @RequestMapping(path = "/deletar/{id}")
    public String deleteAndGetUserAndRedirect (@PathVariable("id") Integer id, Model model) {
        return tarefaService.deleteTaskById(id).getAllTasks().uploadAttributesModel(model)
                .redirect(TarefaActionsEnun.REDIRECT_TASK);
    }

    @GetMapping("atualizar/{id}")
    public String updateAndRedirect (@PathVariable("id") Integer id, Model model) {
        return tarefaService.getTaskById(id)
                .addResponseAttribute("projetos", projetoService.listarTodos())
                .uploadAttributesModel(model)
                .redirect(TarefaActionsEnun.NEW_TASK_PAGE);
    }
}
