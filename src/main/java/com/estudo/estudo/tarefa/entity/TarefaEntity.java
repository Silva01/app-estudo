package com.estudo.estudo.tarefa.entity;

import com.estudo.estudo.projeto.entity.ProjetoEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table (name = "tarefa")
public class TarefaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 2, max = 200)
    private String nome;

    @Column
    private String descricao;

    @Column
    private String nomeProjeto;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name = "idProjeto")
    private ProjetoEntity projeto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProjetoEntity getProjeto() {
        return projeto;
    }

    public void setProjeto(ProjetoEntity projeto) {
        this.projeto = projeto;
    }
}
