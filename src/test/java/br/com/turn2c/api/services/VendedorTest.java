package br.com.turn2c.api.services;

import br.com.turn2c.api.dto.ClienteDTO;
import br.com.turn2c.api.dto.VendedorDTO;

import br.com.turn2c.api.entity.Vendedor;
import br.com.turn2c.api.entity.enums.Perfil;
import br.com.turn2c.api.repository.VendedorRepository;
import br.com.turn2c.api.service.VendedorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


class VendedorTest {

    @Mock
    private VendedorRepository vendedorRepository;

    @InjectMocks
    private VendedorService vendedorService;

    private Vendedor vendedor;
    private VendedorDTO vendedorDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Set<Perfil> perfis = new HashSet<>();
        perfis.add(Perfil.VENDEDOR);

        vendedor = new Vendedor();
        vendedor.setId(1L);
        vendedor.setNome("Guilherme");
        vendedor.setEmail("guilherme@example.com");
        vendedor.setVendasRealizadas("10");
        vendedor.setComissao("10%");
        vendedor.setPerfis(perfis);
    }

    @Test
    public void testBuscaPorId_VendedorInexistente() {
        when(vendedorRepository.findById(1L)).thenReturn(Optional.empty());
        VendedorDTO result = vendedorService.buscaPorId(1L);
        assertNull(result);
    }




}