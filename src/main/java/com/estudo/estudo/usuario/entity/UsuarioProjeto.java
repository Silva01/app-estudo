package com.estudo.estudo.usuario.entity;

import com.estudo.estudo.projeto.entity.ProjetoEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "UsuarioProjeto")
public class UsuarioProjeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UsuarioEntity usuario;

    @OneToMany
    @JoinColumn(name = "projetoId")
    private List<ProjetoEntity> projetos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UsuarioEntity getUsuarioId() {
        return usuario;
    }

    public void setUsuarioId(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public List<ProjetoEntity> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<ProjetoEntity> projetos) {
        this.projetos = projetos;
    }
}
