package br.com.fiap.EloCarbon.service;

import br.com.fiap.EloCarbon.DAO.CarteiraDAO;
import br.com.fiap.EloCarbon.DAO.UsuarioDAO;
import br.com.fiap.EloCarbon.model.Carteira;
import br.com.fiap.EloCarbon.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarteiraService {

    @Autowired
    private CarteiraDAO carteiraDAO;

    @Autowired
    private UsuarioDAO usuarioDAO;



    public Carteira criarCarteira(Carteira carteira) {
        return carteiraDAO.save(carteira);
    }


    public Optional<Carteira> buscarPorUsuarioId(Long usuarioId) {
        return carteiraDAO.findByUsuarioId(usuarioId);
    }

    public Optional<Carteira> buscarPorId(Long id) {
        return carteiraDAO.findById(id);
    }
}
