package br.com.mateuschacon.transacao.TransactionResourece.Dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.mateuschacon.transacao.TransactionResourece.Models.Card;
import br.com.mateuschacon.transacao.TransactionResourece.Models.Establishment;
import br.com.mateuschacon.transacao.TransactionResourece.Models.Transaction;

class EstablishmentMessage{
 
    private String nome, cidade, endereco;

    
    /**
     * Gets for TransactionMessageDto
     * @return
     */
    public String getNome() {
        return nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getCidade() {
        return cidade;
    }
    /**
     * Sets for Jackson 
     * @return
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}

class CardMessage{
 
    private String id , email;

    /**
     * Gets for TransactionMessageDto
     * @return
     */
    public String getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    /**
     * Sets for Jackson 
     * @return
     */
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(String id) {
        this.id = id;
    }

}

public class TransactionMessageDto {

  
    private String id;
    private BigDecimal valor;
    private EstablishmentMessage estabelecimento;
    private CardMessage cartao;
    private LocalDateTime efetivadaEm;


    public Transaction toModel(){
        return new Transaction(
            this.id,
            this.valor,
            new Establishment(
                this.estabelecimento.getNome(), 
                this.estabelecimento.getCidade(), 
                this.estabelecimento.getEndereco()
            ),
            new Card( 
                this.cartao.getId(), 
                this.cartao.getEmail()
            ),
            this.efetivadaEm
        );
    }
    /**
     * Sets for Jackson 
     * @return
     */
    public void setEfetivadaEm(String efetivadaEm) {
        LocalDateTime dateTime = LocalDateTime.parse(efetivadaEm);
        this.efetivadaEm =dateTime;
    }
    public void setCartao(CardMessage cartao) {
        this.cartao = cartao;
    }
    public void setEstabelecimento(EstablishmentMessage estabelecimento) {
        this.estabelecimento = estabelecimento;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public void setId(String id) {
        this.id = id;
    }
}
