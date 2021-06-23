package br.com.mateuschacon.transacao.TransactionResourece.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Card {
    
    @Id @NotBlank
    private String id;

    @NotBlank
    private String email;

    @Deprecated
    public Card(){}

    public Card(@NotBlank String id, @NotBlank String email) {
        this.id = id;
        this.email = email;
    }
}
