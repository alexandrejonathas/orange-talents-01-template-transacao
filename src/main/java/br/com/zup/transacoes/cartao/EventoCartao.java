package br.com.zup.transacoes.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class EventoCartao {

    private String id;

    private String email;

    @Override
    public String toString() {
        return "Cartao{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
