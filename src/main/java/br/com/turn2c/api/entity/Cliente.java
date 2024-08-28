package br.com.turn2c.api.entity;



import br.com.turn2c.api.entity.enums.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Usuario implements Serializable {

    private static final long serialVersionUID = 1l;

    private String cpf;
    private String historicoCompras;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "cliente_perfis", joinColumns = @JoinColumn(name = "cliente_id"))
    @Enumerated(EnumType.STRING)
    private Set<Perfil> perfis = new HashSet<>();

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setHistoricoCompras(String historicoCompras) {
        this.historicoCompras = historicoCompras;
    }

    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }
}