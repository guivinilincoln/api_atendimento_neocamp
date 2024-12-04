package br.com.mercadolivre.api_atendimento_neocamp.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;


@Entity
public class Atendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToOne(mappedBy = "atendente", cascade = CascadeType.ALL)
    private Balcao balcao;

    @OneToMany(mappedBy = "atendente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chamado> chamados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
