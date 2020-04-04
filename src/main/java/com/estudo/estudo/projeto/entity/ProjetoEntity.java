package com.estudo.estudo.projeto.entity;

import com.estudo.estudo.tarefa.entity.TarefaEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "projeto")
public class ProjetoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 2, max = 500)
    private String nome;

    @Column(nullable = false)
    private boolean ativo;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "projeto")
    @OrderBy("nome ASC")
    private List<TarefaEntity> tarefas;

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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<TarefaEntity> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<TarefaEntity> tarefas) {
        this.tarefas = tarefas;
    }
}
