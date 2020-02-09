package com.estudo.estudo.projeto.controller;

import com.estudo.estudo.projeto.entity.ProjetoEntity;
import com.estudo.estudo.projeto.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService pService;

    @GetMapping("cadastrar")
    public String inserir (Model model){
        ProjetoEntity p = new ProjetoEntity();
        model.addAttribute("projeto", p);
        return "projeto/cadastrar";
    }

    @RequestMapping(path = "salvar", method = RequestMethod.POST)
    public String salvar (ProjetoEntity projeto){
        projeto.setAtivo(true);
        pService.salvar(projeto);
        return "redirect:/projetos/listar";
    }

    @GetMapping("listar")
    public String listar (Model model) {
        model.addAttribute("projetosLista", pService.listarTodos());
        return "projeto/listar";
    }
}
