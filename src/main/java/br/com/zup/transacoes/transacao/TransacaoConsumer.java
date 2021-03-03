package br.com.zup.transacoes.transacao;

import br.com.zup.transacoes.cartao.Cartao;
import br.com.zup.transacoes.cartao.CartaoRepository;
import br.com.zup.transacoes.estabelecimento.Estabelecimento;
import br.com.zup.transacoes.estabelecimento.EstabelecimentoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class TransacaoConsumer {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @KafkaListener(topics = "${transaction.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(EventoTransacao eventoTransacao) {
        System.out.println(eventoTransacao);

        Transacao transacao = eventoTransacao.toModel(cartaoRepository, estabelecimentoRepository);

        transacaoRepository.save(transacao);
    }
}
