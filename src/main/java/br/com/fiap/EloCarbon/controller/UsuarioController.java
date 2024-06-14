package br.com.fiap.EloCarbon.controller;

import br.com.fiap.EloCarbon.DAO.UsuarioDAO;
import br.com.fiap.EloCarbon.model.Usuario;
import br.com.fiap.EloCarbon.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    UsuarioDAO usuarioDAO;

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/logar")
    public Usuario login(@RequestBody Usuario usuario) {
        String email = usuario.getEmail();
        String senha = usuario.getSenha();
        return usuarioService.login(email, senha);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario){
        Usuario usuarioResp = usuarioService.cadastrarUsuario(usuario);
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioResp);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/alterar")
    public ResponseEntity<Usuario> Put(@RequestBody Usuario usuario){
        Optional<Usuario> user = usuarioService.atualizarUsuario(usuario);
        try {
            return ResponseEntity.ok(user.get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
