package br.com.fiap.EloCarbon.controller;

import br.com.fiap.EloCarbon.model.Transacao;
import br.com.fiap.EloCarbon.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/registrar")
    public Transacao registrarTransacao(@RequestParam Long carteiraId, @RequestBody Transacao transacao) {
        return transacaoService.registrarTransacao(carteiraId, transacao);
    }
}
