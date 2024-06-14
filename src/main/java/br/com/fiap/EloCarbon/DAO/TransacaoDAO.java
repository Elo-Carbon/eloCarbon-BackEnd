package br.com.fiap.EloCarbon.DAO;

import br.com.fiap.EloCarbon.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoDAO extends JpaRepository<Transacao, Long> {
    List<Transacao> findByCarteiraId(Long carteiraId);
}
