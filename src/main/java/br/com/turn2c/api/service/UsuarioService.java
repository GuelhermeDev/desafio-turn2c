package br.com.turn2c.api.service;


import br.com.turn2c.api.entity.Usuario;
import br.com.turn2c.api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario incluirUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> mostrarUsuario(){
        return usuarioRepository.findAll();
    }



}
