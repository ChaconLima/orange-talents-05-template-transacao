package br.com.mateuschacon.transacao.Kafka.TransactionResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionListenerImplementation {
    
    @Autowired
    public TransactionListenerImplementation() {

    }

    public void consumeTransation(String transaction) {

        try {
            if (transaction != null){
                System.out.println(" Transaction " + transaction);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Transaction processed");
    }
}
