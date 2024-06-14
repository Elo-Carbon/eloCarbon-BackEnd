package br.com.fiap.EloCarbon.service;

import br.com.fiap.EloCarbon.DAO.CarteiraDAO;
import br.com.fiap.EloCarbon.DAO.TransacaoDAO;
import br.com.fiap.EloCarbon.model.Carteira;
import br.com.fiap.EloCarbon.model.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoDAO transacaoDAO;

    @Autowired
    private CarteiraDAO carteiraDAO;

    public Transacao registrarTransacao(Long carteiraId, Transacao transacao) {
        Carteira carteira = carteiraDAO.findById(carteiraId)
                .orElseThrow(() -> new RuntimeException("Carteira não encontrada"));

        transacao.setCarteira(carteira);
        transacao.setData(LocalDateTime.now());
        carteira.setSaldo(carteira.getSaldo() + transacao.getValor());

        carteiraDAO.save(carteira);
        return transacaoDAO.save(transacao);
    }
}
