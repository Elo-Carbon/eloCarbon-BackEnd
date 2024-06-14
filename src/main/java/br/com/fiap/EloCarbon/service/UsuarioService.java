package br.com.fiap.EloCarbon.service;

import br.com.fiap.EloCarbon.DAO.UsuarioDAO;
import br.com.fiap.EloCarbon.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioDAO usuarioDAO;

    public Usuario cadastrarUsuario(Usuario usuario){

        if(usuarioDAO.findByCnpj(usuario.getCnpj()).isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "CNPJ já cadastrado.", null
            );
        }

        return usuarioDAO.save(usuario);
    }


    public Optional<Usuario> atualizarUsuario(Usuario usuario){

       if(usuarioDAO.findById(usuario.getId()).isPresent()){
           return Optional.of(usuarioDAO.save(usuario));
       }
         else {
             throw new ResponseStatusException(
                     HttpStatus.NOT_FOUND, "Usuario não encontrado", null
             );
       }
    }


    public Usuario login (String email, String senha){
        Optional<Usuario> usuarioOpt = usuarioDAO.findByEmail(email);
        return usuarioOpt
                .filter(usuario -> usuario.getSenha().equals(senha))
                .orElseThrow(() -> new RuntimeException("Email ou senha inválidos"));
    }
}
