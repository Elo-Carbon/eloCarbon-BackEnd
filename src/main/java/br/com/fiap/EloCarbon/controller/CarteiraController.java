package br.com.fiap.EloCarbon.controller;


import br.com.fiap.EloCarbon.model.Carteira;
import br.com.fiap.EloCarbon.service.CarteiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carteira")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarteiraController {

    @Autowired
    private CarteiraService carteiraService;

    @PostMapping("/criar")
    public Carteira criarCarteira(@RequestBody Carteira carteira) {
        return carteiraService.criarCarteira(carteira);
    }

    @GetMapping("/usuario/{usuarioId}")
    public Carteira buscarPorUsuarioId(@PathVariable Long usuarioId) {
        return carteiraService.buscarPorUsuarioId(usuarioId)
                .orElseThrow(() -> new RuntimeException("Carteira não encontrada para o usuário"));
    }
}
