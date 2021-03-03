package br.com.zup.transacoes.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TransacaoResponse {
    private String estabelecimento;
    private LocalDateTime efetivadaEm;
    private BigDecimal valor;

    public TransacaoResponse(Transacao transacao) {
        this.estabelecimento = transacao.getEstabelecimento().getNome();
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.valor = transacao.getValor();
    }

    public static List<TransacaoResponse> toListResponse(List<Transacao> trasacoes) {
        return trasacoes.stream().map(TransacaoResponse::new)
                .collect(Collectors.toList());
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
