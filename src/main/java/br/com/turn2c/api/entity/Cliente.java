package br.com.turn2c.api.entity;



import br.com.turn2c.api.entity.enums.Perfil;
import jakarta.persistence.*;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Cliente extends Usuario implements Serializable {

    private static final long serialVersionUID = 1l;

    private String cpf;
    private String historicoCompras;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "cliente_perfis", joinColumns = @JoinColumn(name = "cliente_id"))
    @Enumerated(EnumType.STRING)
    private Set<Perfil> perfis = new HashSet<>();


    public Cliente (){

    }

    public Cliente(String cpf, String historicoCompras, Set<Perfil> perfis) {
        this.cpf = cpf;
        this.historicoCompras = historicoCompras;
        this.perfis = perfis;
    }

    public Cliente(Long id, String nome, String email, String cpf, String historicoCompras, Set<Perfil> perfis) {
        super(id, nome, email);
        this.cpf = cpf;
        this.historicoCompras = historicoCompras;
        this.perfis = perfis;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getHistoricoCompras() {
        return historicoCompras;
    }

    public void setHistoricoCompras(String historicoCompras) {
        this.historicoCompras = historicoCompras;
    }

    public Set<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }
}