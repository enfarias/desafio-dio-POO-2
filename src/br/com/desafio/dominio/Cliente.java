package br.com.desafio.dominio;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Cliente {
    private String nome;
    private Set<Produto> produtosNoCarrinho = new LinkedHashSet<>();
    private Set<Produto> produtosComprados = new LinkedHashSet<>();

    public void participarDaPromocao(Promocao promocao) {

        if (promocao.estaAtiva()) {
            // Adiciona os produtos da promoção ao carrinho
            this.produtosNoCarrinho.addAll(promocao.getProdutosElegiveis());

            // Adiciona o cliente na lista da promoção
            promocao.getCliente().add(this);
        } else {
            System.err.println("Erro: A promoção '" + promocao.getNome() + "' não está ativa hoje.");
        }

    }

    public void finalizarCompra() {
/*
        // Pega o primeiro item do carrinho
        Optional<Produto> produto = this.produtosNoCarrinho.stream().findFirst();

        if(produto.isPresent()) {
            // Adiciona aos comprados e remove do carrinho
            this.produtosComprados.add(produto.get());
            this.produtosNoCarrinho.remove(produto.get());
        } else {
            System.err.println("Seu carrinho está vazio!");
        }
 */
        if (!this.produtosNoCarrinho.isEmpty()) {
            // Adiciona todos os itens do carrinho aos comprados
            this.produtosComprados.addAll(this.produtosNoCarrinho);
            // Limpa o carrinho
            this.produtosNoCarrinho.clear();
            System.out.println("Compra finalizada com sucesso!");
        } else {
            System.err.println("Seu carrinho está vazio!");
        }

    }

    public BigDecimal calcularTotalCashback() {
        return this.produtosComprados
                .stream()
                .map(Produto::calcularCashback) // Retorna um Stream<BigDecimal>
                .reduce(BigDecimal.ZERO, BigDecimal::add); // Soma todos começando do zero
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Produto> getProdutosNoCarrinho() {
        return produtosNoCarrinho;
    }

    public void setProdutosNoCarrinho(Set<Produto> produtosNoCarrinho) {
        this.produtosNoCarrinho = produtosNoCarrinho;
    }

    public Set<Produto> getProdutosComprados() {
        return produtosComprados;
    }

    public void setProdutosComprados(Set<Produto> produtosComprados) {
        this.produtosComprados = produtosComprados;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;
        return Objects.equals(nome, cliente.nome) && Objects.equals(produtosNoCarrinho, cliente.produtosNoCarrinho) && Objects.equals(produtosComprados, cliente.produtosComprados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, produtosNoCarrinho, produtosComprados);
    }
}
