package br.com.turn2c.api.controller;
import br.com.turn2c.api.dto.VendedorDTO;
import br.com.turn2c.api.service.VendedorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedores")
@Tag(name = "Vendedor", description = "Controlador de Vendedores")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;


    @GetMapping("lista-vendedores")
    public ResponseEntity<List<VendedorDTO>> listarTodos(){
        List<VendedorDTO> vendedor = vendedorService.listarTodos();
        return new ResponseEntity<>(vendedor, HttpStatus.OK);
    }

    @GetMapping("buscar-por-id/{id}")
    public ResponseEntity<VendedorDTO> buscarPorId(@PathVariable Long id){
        VendedorDTO vendedorDTO = vendedorService.buscaPorId(id);
        if(vendedorDTO != null){
            return new ResponseEntity<>(vendedorDTO, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("incluir-vendedor")
    public ResponseEntity<Void> criarVendedor(@RequestBody VendedorDTO vendedorDTO){
        vendedorService.salvar(vendedorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("deletar-vendedor/{id}")
    public ResponseEntity<Void> deletarVendedor(@PathVariable Long id){
        vendedorService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("atualizar-vendedor/{id}")
    public ResponseEntity<VendedorDTO> atualizarVendedor(@PathVariable Long id, @RequestBody VendedorDTO vendedorDTO){
        VendedorDTO atualizaVendedorDTO = vendedorService.atualizar(id, vendedorDTO);
        if(atualizaVendedorDTO != null){
            return new ResponseEntity<>(atualizaVendedorDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}





