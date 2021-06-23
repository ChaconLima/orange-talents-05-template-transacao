package br.com.mateuschacon.transacao.TransactionResourece.Models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Transaction {
    

    @Id @NotBlank
    private String id;

    @NotNull
    private BigDecimal valor;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Establishment estabelecimento;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Card cartao;

    @NotNull
    private LocalDateTime efetivadaEm;
    
    @Deprecated
    public Transaction(){}

    public Transaction(
        @NotBlank String id, 
        @NotNull BigDecimal valor, 
        Establishment estabelecimento,
        Card cartao, 
        @NotNull LocalDateTime efetivadaEm
    ) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }


    public String getId() {
        return this.id;
    }
    public BigDecimal getValor() {
        return this.valor;
    }
    public Card getCartao() {
        return this.cartao;
    }
    public Establishment getEstabelecimento() {
        return this.estabelecimento;
    }
    public LocalDateTime getEfetivadaEm() {
        return this.efetivadaEm;
    }
 

}
