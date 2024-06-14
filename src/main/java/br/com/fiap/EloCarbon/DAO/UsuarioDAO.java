package br.com.fiap.EloCarbon.DAO;

import br.com.fiap.EloCarbon.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
   public Optional <Usuario> findByEmail(String email);

   public Optional<Usuario> findByCnpj(String cnpj);

   public  Optional<Usuario> findById(Long id);
}
