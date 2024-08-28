package br.com.turn2c.api.dto;


import jakarta.validation.constraints.Email;

public class UsuarioDTO {

    private String nome;
    @Email
    private String email;


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
}
