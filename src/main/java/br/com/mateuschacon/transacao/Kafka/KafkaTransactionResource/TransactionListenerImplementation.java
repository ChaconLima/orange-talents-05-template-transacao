package br.com.mateuschacon.transacao.Kafka.KafkaTransactionResource;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mateuschacon.transacao.TransactionResourece.Dtos.TransactionMessageDto;
import br.com.mateuschacon.transacao.TransactionResourece.Repositorys.TransactionRepository;

@Component
public class TransactionListenerImplementation {
    
    private TransactionRepository transactionRepository;

    private static Logger logger = LoggerFactory.getLogger(TransactionListenerImplementation.class);

    @Autowired
    public TransactionListenerImplementation(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void consumeTransation(String transaction) {

        try {

            if (transaction != null){

                //System.out.println(" Transaction " + transaction);

                ObjectMapper mapper = new ObjectMapper();

                TransactionMessageDto transactionMessageDto = 
                    mapper.readValue( transaction , TransactionMessageDto.class);

                this.transactionRepository.save( transactionMessageDto.toModel());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("Transaction processed");
    }
}
