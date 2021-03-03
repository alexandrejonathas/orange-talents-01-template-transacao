package br.com.zup.transacoes.transacao;

import br.com.zup.transacoes.cartao.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String> {
    List<Transacao> findTop10ByCartaoOrderByEfetivadaEmDesc(Cartao cartao);
}
