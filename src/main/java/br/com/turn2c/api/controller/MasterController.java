package br.com.turn2c.api.controller;


import br.com.turn2c.api.entity.Master;
import br.com.turn2c.api.entity.Usuario;
import br.com.turn2c.api.service.MasterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/master")
@Tag(name = "Admin", description = "Controlador de Usuários Master")
public class MasterController {

    @Autowired
    private MasterService masterService;

    @GetMapping("lista-masters")
    @Operation(summary = "Buscar por Todos os Usuário", description = "Retorna todos usuário.")
    public ResponseEntity<List<Usuario>> listarTudo() {
        List<Usuario> lista = masterService.listarTudo();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("buscar-por-id/{id}")
    @Operation(summary = "Buscar Usuário por ID", description = "Retorna um usuário com base no ID fornecido.")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
        Optional<Usuario> master = masterService.buscarPorId(id);
        if(master.isPresent()){
            return ResponseEntity.ok(master.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("incluir-master")
    @Operation(summary = "Criar Novo Usuário Master", description = "Cria um novo usuário Master.")
    public ResponseEntity<Usuario> criarMaster(@RequestBody Master master){
        Usuario novoMaster = masterService.salvar(master);
        return ResponseEntity.ok(novoMaster);
    }

    @DeleteMapping("deletar-master/{id}")
    @Operation(summary = "Deletar Usuário", description = "Deleta um usuário com base no ID fornecido.")
    public ResponseEntity<Void> deletarMaster(@PathVariable Long id){
        Optional<Usuario> master = masterService.buscarPorId(id);
        if(master.isPresent()){
            masterService.excluir(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

   @PutMapping("atualizar-master/{id}")
    @Operation(summary = "Atualizar Usuário", description = "Atualiza um usuário existente com base no ID fornecido.")
    public ResponseEntity<Usuario> atualizarMaster(@PathVariable Long id, @RequestBody Usuario masterAtualizado){
        Optional<Usuario> masterOptional = masterService.buscarPorId(id);
        if(masterOptional.isPresent()){
            Usuario masterExistente = masterOptional.get();
            masterExistente.setNome(masterAtualizado.getNome());
            masterExistente.setEmail(masterAtualizado.getEmail());
            Usuario masterAtualizadoSalvo = masterService.atualizar(masterExistente);
            return ResponseEntity.ok(masterAtualizadoSalvo);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
