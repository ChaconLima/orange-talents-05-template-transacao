package br.com.mateuschacon.transacao.TransactionResourece.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateuschacon.transacao.TransactionResourece.Dtos.TransactionResponseDto;
import br.com.mateuschacon.transacao.TransactionResourece.Models.Transaction;
import br.com.mateuschacon.transacao.TransactionResourece.Repositorys.TransactionRepository;


@RestController
@RequestMapping(value = "/api/transaction")
public class TransactionsController {


   
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionsController(TransactionRepository transactionRepository){
        this.transactionRepository=transactionRepository;
    }
    

    @GetMapping(value="{id}/list")
    public ResponseEntity<?> getTrancationsList(
        @PathVariable("id") UUID id_card
        ) {
       
        List<Transaction> transactionsList = 
            this.transactionRepository.
                queryFirst10ByCartao_IdOrderByEfetivadaEmDesc( 
                    id_card.toString() 
                );
        
        if( transactionsList.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(TransactionResponseDto.converter(transactionsList));
    }
    
}
