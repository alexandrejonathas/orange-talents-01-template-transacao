package br.com.zup.transacoes.transacao;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransacaoConsumer {

    @KafkaListener(topics = "${transaction.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord record) {
        System.out.println(record.partition());
        System.out.println(record.key());
        System.out.println(record.value());
    }
}
