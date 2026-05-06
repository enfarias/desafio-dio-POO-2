package br.com.desafio.dominio;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

public class CarrinhoDeCompras {
    private Set<Produto> itens = new LinkedHashSet<>();

    public void adicionarProduto(Produto produto) {
        this.itens.add(produto);
    }

    public void removerProduto(Produto produto) {
        this.itens.remove(produto);
    }

    public void limparCarrinho() {
        this.itens.clear();
    }

    public boolean estaVazio() {
        return itens.isEmpty();
    }

    public BigDecimal calcularSubtotal() {
        return itens.stream()
                .map(Produto::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Set<Produto> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
                "totalItens=" + itens.size() +
                ", subtotal=R$ " + calcularSubtotal() +
                '}';
    }
}
