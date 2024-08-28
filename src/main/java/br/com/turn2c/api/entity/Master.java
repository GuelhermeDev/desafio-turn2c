package br.com.turn2c.api.entity;


import br.com.turn2c.api.entity.enums.Perfil;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Master extends Usuario{


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "master_perfis", joinColumns = @JoinColumn(name = "master_id"))
    @Enumerated(EnumType.STRING)
    private Set<Perfil> perfis = new HashSet<>();

    public Master(){
    }

    public Master(Set<Perfil> perfis) {
        this.perfis = perfis;
    }

    public Master(Long id, String nome, String email, Set<Perfil> perfis) {
        super(id, nome, email);
        this.perfis = perfis;
    }


    public Set<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }
}

