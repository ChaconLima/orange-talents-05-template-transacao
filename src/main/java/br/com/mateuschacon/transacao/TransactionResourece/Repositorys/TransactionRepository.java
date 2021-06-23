package br.com.mateuschacon.transacao.TransactionResourece.Repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mateuschacon.transacao.TransactionResourece.Models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,String>{
    
    /**
     * @Docs https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods
     */
    List<Transaction> queryFirst10ByCartao_IdOrderByEfetivadaEmDesc(String card_id); 
}
