package br.com.ucanbank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "conta")
public class Conta {

    //As entidades Conta e Transação possuem uma relação 1-N.
    @OneToMany(mappedBy = "contaOrigem")
    @JsonIgnore
    List<Transacao> transacao;

    //As entidades ClientePF e Conta possuem uma relação 1-1.
    @OneToOne
    private ClientePF clientePF;

    //As entidades ClientePJ e Conta possuem uma relação 1-1.
    @OneToOne
    private ClientePJ clientePJ;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_conta")
    private Long IdContaOrigem;

    @Column(name = "agencia")
    private String agencia;
    @Column(name = "numconta")
    private String numConta;
    @Column(name = "saldo")
    private double saldo;

}
