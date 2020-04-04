package com.estudo.estudo.usuario.entity;

import com.estudo.estudo.projeto.entity.ProjetoEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 2, max = 500)
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Size(min = 14, max = 14)
    @Column(nullable = false, length = 14)
    private String cpf;

    @Column(length = 11)
    private String telefone;

    @NotBlank
    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private Boolean ativo;

    @ManyToMany
    @JoinTable(name = "UsuariosProjetos",
            joinColumns = { @JoinColumn(name = "idUsuario") },
            inverseJoinColumns = { @JoinColumn(name = "idProjeto") })
    private List<ProjetoEntity> projetos;

    public UsuarioEntity() {
        ativo = true;
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = new BCryptPasswordEncoder().encode(senha);
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<ProjetoEntity> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<ProjetoEntity> projetos) {
        this.projetos = projetos;
    }
}
