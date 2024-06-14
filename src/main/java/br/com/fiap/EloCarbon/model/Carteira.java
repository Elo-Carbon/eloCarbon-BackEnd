package br.com.fiap.EloCarbon.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "tbl_carteira")
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private double saldo;

    @OneToMany(mappedBy = "carteira", cascade = CascadeType.ALL)
    private List<Transacao> transacoes;

    public Carteira() {
    }


}
