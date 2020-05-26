package com.estudo.estudo.usuario.controller;

import com.estudo.estudo.projeto.service.ProjetoService;
import com.estudo.estudo.usuario.entity.UsuarioEntity;
import com.estudo.estudo.usuario.service.UsuarioActionsEnun;
import com.estudo.estudo.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("usuarios")
public class UsuarioController {

    private UsuarioService uService;
    private ProjetoService pService;

    @Autowired
    public UsuarioController(UsuarioService uService, ProjetoService pService) {
        this.uService = uService;
        this.pService = pService;
    }

    @GetMapping("cadastrar")
    public String createAndRedirect (Model model){
        return uService.obterPorId(0)
                .addResponseAttribute("projetos", pService.listarTodos())
                .uploadAttributesModel(model)
                .redirect(UsuarioActionsEnun.NEW_USER_PAGE);
    }

    @RequestMapping(path = "/salvar", method = RequestMethod.POST)
    public String saveEndRedirect (UsuarioEntity usuario){
        return uService.salvar(usuario).redirect(UsuarioActionsEnun.REDIRECT_USERS);
    }

    @GetMapping("listar")
    public String listAndRedirect (Model model){
        return uService.getAllUsers()
                .uploadAttributesModel(model)
                .redirect(UsuarioActionsEnun.LIST_USERS_PAGE);
    }

    @RequestMapping(path = "/deletar/{id}")
    public String deleteAndGetUserAndRedirect (@PathVariable("id") Integer id, Model model){
        return uService.deleteUser(id).getAllUsers().uploadAttributesModel(model)
                .redirect(UsuarioActionsEnun.REDIRECT_USERS);
    }

    @GetMapping ("atualizar/{id}")
    public String updateAndRedirect (@PathVariable("id") Integer id, Model model){
        return uService.obterPorId(id)
                .addResponseAttribute("projetos", pService.listarTodos())
                .uploadAttributesModel(model)
                .redirect(UsuarioActionsEnun.NEW_USER_PAGE);
    }
}
