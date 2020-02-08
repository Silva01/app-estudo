package com.estudo.estudo.usuario.controller;

import com.estudo.estudo.usuario.entity.UsuarioEntity;
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

    @Autowired
    private UsuarioService uService;

    //GetMapping faz referencia ao que será carregado na URL.
    @GetMapping("cadastrar")
    public String inserir (Model model){
        UsuarioEntity u = new UsuarioEntity();
        model.addAttribute("usuario",u);
        //o return é local no projeto onde será encontrado o html
        return "usuario/cadastrar";
    }

    @RequestMapping(path = "/salvar", method = RequestMethod.POST)
    public String salvar (UsuarioEntity usuario){
        usuario.setAtivo(true);
        uService.salvar(usuario);
        return "redirect:/usuarios/listar";
    }

    @GetMapping("listar")
    public String listar (Model model){
        model.addAttribute("usuariosLista", uService.listarTodos());
        return "usuario/listar";
    }

    @RequestMapping(path = "/deletar/{id}")
    public String deletar (@PathVariable("id") Integer id, Model model){
        uService.deletar(id);
        model.addAttribute("usuariosLista", uService.listarTodos());
        return "redirect:/usuarios/listar";
    }

    @GetMapping ("atualizar/{id}")
    public String atualizar (@PathVariable("id") Integer id, Model model){
        model.addAttribute("usuario", uService.obterPorId(id));
        return "usuario/cadastrar";
    }
}
