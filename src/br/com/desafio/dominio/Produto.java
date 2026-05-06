package br.com.desafio.dominio;

import java.math.BigDecimal;

public abstract class Produto {

    protected static final BigDecimal CASHBACK_PADRAO = new BigDecimal("0.10");

    private String nome;
    private int quantidade;
    private String unidade;
    private BigDecimal preco;

    public abstract BigDecimal calcularCashback();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
