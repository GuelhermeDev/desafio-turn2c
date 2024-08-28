package br.com.turn2c.api.service;



import br.com.turn2c.api.dto.VendedorDTO;
import br.com.turn2c.api.entity.Vendedor;
import br.com.turn2c.api.exceptions.DatabaseException;
import br.com.turn2c.api.exceptions.ResourceNotFoundException;
import br.com.turn2c.api.mapper.Mapper;
import br.com.turn2c.api.repository.VendedorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public List<VendedorDTO> listarTodos(){
        List<Vendedor> vendedores = vendedorRepository.findAll();
        return vendedores.stream().map(Mapper.INSTANCE::toDTOVendedor).toList();

    }

    public VendedorDTO buscaPorId(Long id){
        Optional<Vendedor> vendedor = vendedorRepository.findById(id);
        return vendedor.map(Mapper.INSTANCE::toDTOVendedor).orElse(null);
    }

    public VendedorDTO salvar(VendedorDTO vendedorDTO) {
        Vendedor vendedor = Mapper.INSTANCE.toEntityVendedor(vendedorDTO);
        Vendedor vendedorSalvo = vendedorRepository.save(vendedor);
        return Mapper.INSTANCE.toDTOVendedor(vendedorSalvo);
    }

    public void excluir(Long id){
        if(vendedorRepository.existsById(id)){
            vendedorRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException(id);
        }
    }

    public VendedorDTO atualizar(Long id, VendedorDTO vendedorDTO){
        if(!vendedorRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }
        vendedorDTO.setId(id);
        Vendedor vendedor = Mapper.INSTANCE.toEntityVendedor(vendedorDTO);
        Vendedor atualizaVendedor = vendedorRepository.save(vendedor);
        return Mapper.INSTANCE.toDTOVendedor(atualizaVendedor);
    }
}


