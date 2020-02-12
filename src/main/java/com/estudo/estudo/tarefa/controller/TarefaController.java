package com.estudo.estudo.tarefa.controller;

import com.estudo.estudo.tarefa.entity.TarefaEntity;
import com.estudo.estudo.tarefa.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tService;

    @GetMapping("cadastrar")
    public String inserir (Model model) {
        TarefaEntity tarefa = new TarefaEntity();
        model.addAttribute("tarefa", tarefa);
        return "tarefa/cadastrar";
    }

    public String salvar (TarefaEntity tarefa){
        tService.salvar(tarefa);
        return "redirect:/tarefas/listar";
    }
}
