package br.com.fiap.EloCarbon.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Data
@Table(name = "tbl_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nr_cnpj")
    @NotNull
    private String cnpj;

    @Column(name = "nm_fantasia")
    @NotNull
    private String nomeFantasia;

    @Column(name = "ds_email")
    @NotNull
    private String email;

    @Column(name = "ds_senha")
    @NotNull
    private String senha;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("usuario")
    private List<Transacao> transacaoList;

    public Usuario() {
    }



}
