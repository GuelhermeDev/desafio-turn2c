package br.com.turn2c.api.entity;

import br.com.turn2c.api.entity.enums.Perfil;
import jakarta.persistence.*;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Vendedor extends Usuario implements Serializable {
    private static final long serialVersionUID = 1l;


    private String comissao;
    private String vendasRealizadas;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "vendedores-perfis", joinColumns = @JoinColumn(name = "vendedor_id"))
    @Enumerated(EnumType.STRING)
    private Set<Perfil> perfis = new HashSet<>();

    public Vendedor(){
    }

    public Vendedor(String comissao, String vendasRealizadas, Set<Perfil> perfis) {
        this.comissao = comissao;
        this.vendasRealizadas = vendasRealizadas;
        this.perfis = perfis;
    }

    public Vendedor(Long id, String nome, String email, String comissao, String vendasRealizadas, Set<Perfil> perfis) {
        super(id, nome, email);
        this.comissao = comissao;
        this.vendasRealizadas = vendasRealizadas;
        this.perfis = perfis;
    }

    public String getComissao() {

        return comissao;
    }

    public void setComissao(String comissao) {
        this.comissao = comissao;
    }

    public String getVendasRealizadas() {

        return vendasRealizadas;
    }

    public void setVendasRealizadas(String vendasRealizadas) {

        this.vendasRealizadas = vendasRealizadas;
    }

    public Set<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }
}






