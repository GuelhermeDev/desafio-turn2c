package br.com.turn2c.api.controller;


import br.com.turn2c.api.dto.ClienteDTO;
import br.com.turn2c.api.dto.VendedorDTO;
import br.com.turn2c.api.service.ClienteService;

import br.com.turn2c.api.service.VendedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/vendedor")
@Tag(name = "Vendedor", description = "Controlador de Vendedores")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;


    @GetMapping("busca-todos-vendedores")
    @Operation(summary = "Buscar por Todos os Vendedores", description = "Retorna todos vendedores.")
    public ResponseEntity<List<VendedorDTO>> listarTodosVendedores(){
        List<VendedorDTO> clientes = vendedorService.listarTodos();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("buscar-vendedor-pelo-id/{id}")
    @Operation(summary = "Buscar Vendedor por ID", description = "Retorna um vendedor com base no ID fornecido.")
    public ResponseEntity<VendedorDTO> buscarVendedorPorId(@PathVariable Long id){
        VendedorDTO vendedorDTO = vendedorService.buscaPorId(id);
        if(vendedorDTO != null){
            return new ResponseEntity<>(vendedorDTO, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("incluir-novo-vendedor")
    @Operation(summary = "Criar Novo Vendedor", description = "Cria um novo vendedor.")
    public ResponseEntity<Void> criarVendedor(@RequestBody VendedorDTO vendedorDTO){
        vendedorService.salvar(vendedorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("deletar-vendedor-pelo-id/{id}")
    @Operation(summary = "Deletar Vendedor", description = "Deleta um vendedor com base no ID fornecido.")
    public ResponseEntity<Void> deletarVendedor(@PathVariable Long id){
        vendedorService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("atualiza-vendedor-pelo-id/{id}")
    @Operation(summary = "Atualizar Vendedor", description = "Atualiza um vendedor existente com base no ID fornecido.")
    public ResponseEntity<VendedorDTO> atualizarVendedor(@PathVariable Long id, @RequestBody VendedorDTO vendedorDTO){
        VendedorDTO atualizaVendedorDTO = vendedorService.atualizar(id, vendedorDTO);
        if(atualizaVendedorDTO != null){
            return new ResponseEntity<>(atualizaVendedorDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
