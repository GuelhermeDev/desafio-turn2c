package br.com.turn2c.api.service;


import br.com.turn2c.api.entity.Cliente;
import br.com.turn2c.api.entity.Master;
import br.com.turn2c.api.entity.Usuario;
import br.com.turn2c.api.entity.Vendedor;
import br.com.turn2c.api.entity.enums.Perfil;
import br.com.turn2c.api.repository.ClienteRepository;
import br.com.turn2c.api.repository.MasterRepository;
import br.com.turn2c.api.repository.UsuarioRepository;
import br.com.turn2c.api.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MasterService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private MasterRepository masterRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTudo(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public Usuario salvar(Usuario master){
        return usuarioRepository.save(master);
    }

    public void excluir(Long id){
        masterRepository.deleteById(id);
    }

    public Usuario atualizar(Usuario masterAtualizado){
        return usuarioRepository.save(masterAtualizado);
    }
}
