package br.com.turn2c.api.dto;


import br.com.turn2c.api.entity.enums.Perfil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.HashSet;
import java.util.Set;

public class VendedorDTO {

    private Long id;
    private String nome;
    @NotBlank
    private String email;
    private String comissao;
    private String vendasRealizadas;
    @NotEmpty
    private Set<Perfil> perfis = new HashSet<>();

    public VendedorDTO(VendedorDTO vendedorDTO) {
    }


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
