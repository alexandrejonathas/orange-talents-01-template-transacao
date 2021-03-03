package br.com.zup.transacoes.transacao;

import br.com.zup.transacoes.cartao.Cartao;
import br.com.zup.transacoes.cartao.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TransacaoController {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping("/cartoes/{id}/transacoes")
    public ResponseEntity<?> busca(@PathVariable Long id) {

        Optional<Cartao> possivelCartao = cartaoRepository.findById(id);

        if(possivelCartao.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        List<Transacao> transacoes = transacaoRepository.findTop10ByCartaoOrderByEfetivadaEmDesc(possivelCartao.get());

        return ResponseEntity.ok(TransacaoResponse.toListResponse(transacoes));
    }

}
