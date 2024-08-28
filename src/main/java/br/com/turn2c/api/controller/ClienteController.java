package br.com.turn2c.api.controller;

import br.com.turn2c.api.entity.dto.ClienteDTO;
import br.com.turn2c.api.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@Tag(name = "Cliente", description = "Controlador de Clientes")
public class ClienteController {


    @Autowired
    private ClienteService clienteService;

    @GetMapping("busca-todos-clientes")
    @Operation(summary = "Buscar por todos os clientes", description = "Retorna todos clientes.")
    public ResponseEntity<List<ClienteDTO>> listarTodosClientes(){
        List<ClienteDTO> clientes = clienteService.listarTodos();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("buscar-cliente-pelo-id/{id}")
    @Operation(summary = "Buscar cliente pelo ID", description = "Retorna um cliente com base no ID fornecido.")
    public ResponseEntity<ClienteDTO> buscarClientePorID(@PathVariable Long id){
        ClienteDTO clienteDTO = clienteService.buscaPorId(id);
        if(clienteDTO != null){
            return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("incluir-novo-cliente")
    @Operation(summary = "Criar Novo Cliente", description = "Cria um novo cliente.")
    public ResponseEntity<Void> criarCliente(@RequestBody @Valid ClienteDTO clienteDTO){
        clienteService.salvar(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("deletar-cliente-pelo-id/{id}")
    @Operation(summary = "Deletar Usuário", description = "Deleta um cliente com base no ID fornecido.")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        clienteService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("atualiza-cliente-pelo-id/{id}")
    @Operation(summary = "Atualizar Usuário", description = "Atualiza um cliente existente com base no ID fornecido.")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){
        ClienteDTO atualizaClienteDTO = clienteService.atualizar(id, clienteDTO);
        if(atualizaClienteDTO != null){
            return new ResponseEntity<>(atualizaClienteDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
