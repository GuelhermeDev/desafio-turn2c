package br.com.turn2c.api.service;


import br.com.turn2c.api.entity.Usuario;

import br.com.turn2c.api.entity.Vendedor;
import br.com.turn2c.api.entity.dto.UsuarioDTO;
import br.com.turn2c.api.entity.dto.VendedorDTO;
import br.com.turn2c.api.exceptions.ResourceNotFoundException;
import br.com.turn2c.api.mapper.Mapper;
import br.com.turn2c.api.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarTudo(){
        List<Usuario> usuario = usuarioRepository.findAll();
        return usuario.stream().map(Mapper.INSTANCE::toDTOUsuario).toList();

    }

    public UsuarioDTO buscaPorId(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.map(Mapper.INSTANCE::toDTOUsuario).orElse(null);
    }

    public UsuarioDTO salvar(UsuarioDTO usuarioDTO){
        Usuario usuario = Mapper.INSTANCE.toEntityUsuario(usuarioDTO);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return Mapper.INSTANCE.toDTOUsuario(usuarioSalvo);
    }

    public void excluir(Long id){
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException(id);
        }
    }

    public UsuarioDTO atualizar(Long id, UsuarioDTO usuarioDTO){
        if(!usuarioRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }
        usuarioDTO.setId(id);
        Usuario usuario = Mapper.INSTANCE.toEntityUsuario(usuarioDTO);
        Usuario atualizaUsuario = usuarioRepository.save(usuario);
        return Mapper.INSTANCE.toDTOUsuario(atualizaUsuario);
    }
}
