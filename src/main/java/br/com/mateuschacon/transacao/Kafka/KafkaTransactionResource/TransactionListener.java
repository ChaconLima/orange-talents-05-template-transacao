package br.com.mateuschacon.transacao.Kafka.KafkaTransactionResource;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;


@Configuration
public class TransactionListener {
    
    @Value("${kafka.topic}")
    private String topic;

    private static Logger logger = LoggerFactory.getLogger(TransactionListener.class);

    private final TransactionListenerImplementation transactionListenerImplementation;

    @Autowired
    public TransactionListener( TransactionListenerImplementation transactionListenerImplementation) {
        this.transactionListenerImplementation = transactionListenerImplementation;
    }

    @KafkaListener(topics = "${kafka.topic}")
    public void listenKafkaTransaction(ConsumerRecord<?, ?> consumerRecord, Acknowledgment acknowledgment) {
       
        System.out.println("------------------------------------");
        logger.info("Listener topic: "+this.topic, consumerRecord);
        logger.info("\tkey: "+ consumerRecord.key());
        logger.info("\toffset: "+ consumerRecord.offset());
        logger.info("\tpartition: "+ consumerRecord.partition());

        acknowledgment.acknowledge();
        
        this.transactionListenerImplementation.consumeTransation(
            (String) consumerRecord.value()
        );
    }
}
