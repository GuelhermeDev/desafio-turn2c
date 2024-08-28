package br.com.turn2c.api.controller;


import br.com.turn2c.api.entity.Usuario;
import br.com.turn2c.api.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


    @Autowired
    private UsuarioService service;


    @PostMapping("incluir-usuario")
    public ResponseEntity<Usuario> incluirUsuario(@RequestBody Usuario usuario){
        Usuario novoUsuario = service.incluirUsuario(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

    @GetMapping("lista-usuarios")
    public ResponseEntity<List<Usuario>> mostrarUsuario(){
        List<Usuario> usuarios = service.mostrarUsuario();
        return ResponseEntity.ok(usuarios);
    }


}
