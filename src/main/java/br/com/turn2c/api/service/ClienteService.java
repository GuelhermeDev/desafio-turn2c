package br.com.turn2c.api.service;


import br.com.turn2c.api.dto.ClienteDTO;
import br.com.turn2c.api.entity.Cliente;
import br.com.turn2c.api.exceptions.ResourceNotFoundException;
import br.com.turn2c.api.mapper.Mapper;
import br.com.turn2c.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<ClienteDTO> listarTodos() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(Mapper.INSTANCE::toDTO).toList();
    }

    public ClienteDTO buscaPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.map(Mapper.INSTANCE::toDTO).orElse(null);
    }

    public ClienteDTO salvar(ClienteDTO clienteDTO) {
        Cliente cliente = Mapper.INSTANCE.toEntity(clienteDTO);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return Mapper.INSTANCE.toDTO(clienteSalvo);
    }

    public void excluir(Long id) {
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException(id);
        }
    }

    public ClienteDTO atualizar(Long id, ClienteDTO clienteDTO) {
        if(!clienteRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }
        clienteDTO.setId(id);
        Cliente cliente = Mapper.INSTANCE.toEntity(clienteDTO);
        Cliente atualizaCliente = clienteRepository.save(cliente);
        return Mapper.INSTANCE.toDTO(atualizaCliente);
    }

}
