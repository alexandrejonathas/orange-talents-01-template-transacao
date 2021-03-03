package br.com.zup.transacoes.transacao;

import br.com.zup.transacoes.cartao.Cartao;
import br.com.zup.transacoes.cartao.CartaoRepository;
import br.com.zup.transacoes.cartao.EventoCartao;
import br.com.zup.transacoes.estabelecimento.Estabelecimento;
import br.com.zup.transacoes.estabelecimento.EstabelecimentoRepository;
import br.com.zup.transacoes.estabelecimento.EventoEstabelecimento;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;


public class EventoTransacao {

    private String id;

    private BigDecimal valor;

    private EventoEstabelecimento estabelecimento;

    private EventoCartao cartao;

    private LocalDateTime efetivadaEm;

    public Transacao toModel(CartaoRepository cartaoRepository, EstabelecimentoRepository estabelecimentoRepository) {

        Optional<Cartao> possivelCartao = cartaoRepository.findByNumero(cartao.getId());

        Cartao cartao = possivelCartao.isPresent() ? possivelCartao.get() :
            new Cartao(this.cartao.getId(), this.cartao.getEmail());

        Optional<Estabelecimento> possivelEstabelecimento = estabelecimentoRepository.findByNome(estabelecimento.getNome());
        Estabelecimento estabelecimento = possivelEstabelecimento.isPresent()
                ? possivelEstabelecimento.get() : new Estabelecimento(this.estabelecimento.getNome(), this.estabelecimento.getCidade(), this.estabelecimento.getEndereco());

        return new Transacao(id, valor, estabelecimento, cartao, this.efetivadaEm);
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EventoEstabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public EventoCartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
