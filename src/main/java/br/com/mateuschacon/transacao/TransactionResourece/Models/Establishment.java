package br.com.mateuschacon.transacao.TransactionResourece.Models;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Establishment {

    @Id
    private String id;

    @NotBlank
    private String nome;

    @NotBlank
    private String cidade;

    @NotBlank
    private String endereco;

    @Deprecated
    public Establishment(){}

    public Establishment( 
        @NotBlank String nome, 
        @NotBlank String cidade, 
        @NotBlank String endereco
    ) {

        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return this.nome;
    }
    public String getCidade() {
        return this.cidade;
    }
    public String getEndereco() {
        return this.endereco;
    }
}
