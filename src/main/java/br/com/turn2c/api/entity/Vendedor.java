package br.com.turn2c.api.entity;

import br.com.turn2c.api.entity.enums.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Vendedor extends Usuario implements Serializable {
    private static final long serialVersionUID = 1l;


    private String comissao;
    private String vendasRealizadas;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "vendedores-perfis", joinColumns = @JoinColumn(name = "vendedor_id"))
    @Enumerated(EnumType.STRING)
    private Set<Perfil> perfis = new HashSet<>();



    public void setComissao(String comissao) {
        this.comissao = comissao;
    }

    public void setVendasRealizadas(String vendasRealizadas) {
        this.vendasRealizadas = vendasRealizadas;
    }

    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }
}






