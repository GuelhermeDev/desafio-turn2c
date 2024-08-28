package br.com.turn2c.api.services;


import br.com.turn2c.api.dto.ClienteDTO;
import br.com.turn2c.api.entity.Cliente;
import br.com.turn2c.api.entity.Usuario;
import br.com.turn2c.api.entity.enums.Perfil;
import br.com.turn2c.api.mapper.Mapper;
import br.com.turn2c.api.repository.ClienteRepository;
import br.com.turn2c.api.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;

class ClienteTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente cliente;
    private ClienteDTO clienteDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Set<Perfil> perfis = new HashSet<>();
        perfis.add(Perfil.CLIENTE);

        cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Guilherme");
        cliente.setEmail("guilherme@example.com");
        cliente.setCpf("48485448820");
        cliente.setHistoricoCompras("10");
        cliente.setPerfis(perfis);
    }


    @Test
    public void testBuscaPorId_ClienteInexistente() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());
        ClienteDTO result = clienteService.buscaPorId(1L);
        assertNull(result);
    }
}



