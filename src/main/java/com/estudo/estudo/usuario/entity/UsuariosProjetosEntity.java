package com.estudo.estudo.usuario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "UsuariosProjetos")
public class UsuariosProjetosEntity implements Serializable {

    @Id
    @Column(name = "idUsuario", nullable = false)
    private Integer idUsuario;

    @Id
    @Column(name = "idProjeto", nullable = false)
    private Integer idProjeto;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Integer idProjeto) {
        this.idProjeto = idProjeto;
    }
}
