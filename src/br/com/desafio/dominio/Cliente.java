package br.com.desafio.dominio;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Cliente {
    private String nome;
    private CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
    private Set<Produto> produtosComprados = new LinkedHashSet<>();

    public void participarDaPromocao(Promocao promocao) {
        if (promocao.estaAtiva()) {
            // Adiciona os itens da promoção ao objeto carrinho
            promocao.getProdutosElegiveis().forEach(p -> this.carrinho.adicionarProduto(p));
            promocao.getCliente().add(this);
            System.out.println("Promoção '" + promocao.getNome() + "' aplicada ao carrinho!");
        } else {
            System.err.println("Promoção expirada!");
        }
    }

    public void finalizarCompra() {
        if (!this.carrinho.estaVazio()) {
            this.produtosComprados.addAll(this.carrinho.getItens());
            this.carrinho.limparCarrinho();
            System.out.println("Compra finalizada com sucesso!");
        } else {
            System.err.println("O carrinho está vazio!");
        }
    }

    public BigDecimal calcularTotalCashback() {
        return this.produtosComprados.stream()
                .map(Produto::calcularCashback)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public CarrinhoDeCompras getCarrinho() {
        return carrinho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;
        return Objects.equals(nome, cliente.nome) && Objects.equals(carrinho, cliente.carrinho) && Objects.equals(produtosComprados, cliente.produtosComprados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, carrinho, produtosComprados);
    }
}