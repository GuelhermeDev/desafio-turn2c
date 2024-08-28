package br.com.turn2c.api.controller;


import br.com.turn2c.api.entity.Master;
import br.com.turn2c.api.entity.Usuario;
import br.com.turn2c.api.entity.dto.UsuarioDTO;
import br.com.turn2c.api.entity.dto.VendedorDTO;
import br.com.turn2c.api.service.MasterService;
import br.com.turn2c.api.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuario", description = "Controlador de Usuários")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("lista-usuarios")
    @Operation(summary = "Buscar por Todos os Usuário", description = "Retorna todos usuário.")
    public ResponseEntity<List<UsuarioDTO>> listarTudo() {
        List<UsuarioDTO> lista = usuarioService.listarTudo();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("buscar-por-id/{id}")
    @Operation(summary = "Buscar Usuário por ID", description = "Retorna um usuário com base no ID fornecido.")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id){
        UsuarioDTO usuarioDTO = usuarioService.buscaPorId(id);
        if(usuarioDTO != null){
            return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("incluir-usuarios")
    @Operation(summary = "Criar Novo Usuário", description = "Cria um novo usuário .")
    public ResponseEntity<Void> criarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        usuarioService.salvar(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("deletar-usuarios/{id}")
    @Operation(summary = "Deletar Usuário", description = "Deleta um usuário com base no ID fornecido.")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
        usuarioService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

   @PutMapping("atualizar-usuarios/{id}")
    @Operation(summary = "Atualizar Usuário", description = "Atualiza um usuário existente com base no ID fornecido.")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO atualizaUsuarioDTO = usuarioService.atualizar(id, usuarioDTO);
       if(atualizaUsuarioDTO != null){
           return new ResponseEntity<>(atualizaUsuarioDTO, HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }
}
