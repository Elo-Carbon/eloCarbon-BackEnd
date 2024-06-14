package br.com.fiap.EloCarbon.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tbl_transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transacao0")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carteira_id")
    @JsonIgnoreProperties("transacao")
    private Carteira carteira;

    @ManyToOne
    @JoinColumn(name ="usuario_id")
    @JsonIgnoreProperties("transacao")
    private Usuario usuario;


    @Column(name = "vl_transacao")
    private double valor;

    @Column(name = "dt_transacao")
    private LocalDateTime data;

    @Column(name = "ds_transacao")
    private String descricao;

    public Transacao() {
    }


}
