package br.com.mateuschacon.transacao.TransactionResourece.Dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.mateuschacon.transacao.TransactionResourece.Models.Establishment;
import br.com.mateuschacon.transacao.TransactionResourece.Models.Transaction;

public class TransactionResponseDto {
 
    @NotBlank
    private String id;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private Establishment estabelecimento;

    @NotNull
    private LocalDateTime efetivadaEm;

    public TransactionResponseDto(Transaction transaction) {
        this.id = transaction.getId();
        this.valor = transaction.getValor();
        this.estabelecimento = transaction.getEstabelecimento();
        this.efetivadaEm = transaction.getEfetivadaEm();
    }

    /**
     * Gets For Jackson
     * @return
     */
    public String getId() {
        return id;
    }
    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
    public Establishment getEstabelecimento() {
        return estabelecimento;
    }
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * @return List
     */
    public static List<TransactionResponseDto> converter( List<Transaction> transactions){
        return transactions.stream().map(TransactionResponseDto::new).collect(Collectors.toList());
    }

}
