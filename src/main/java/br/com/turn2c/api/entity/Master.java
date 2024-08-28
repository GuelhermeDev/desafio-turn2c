package br.com.turn2c.api.entity;


import br.com.turn2c.api.entity.enums.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Master extends Usuario{


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "master_perfis", joinColumns = @JoinColumn(name = "master_id"))
    @Enumerated(EnumType.STRING)
    private Set<Perfil> perfis = new HashSet<>();


    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }
}

