package br.com.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Promocao {

    private String nome;
    private final LocalDate dataInicial;
    private final LocalDate dataFinal;
    private Set<Cliente> clientes = new HashSet<>();
    private final Set<Produto> produtosElegiveis = new LinkedHashSet<>();

    public Promocao(String nome, int diasDuracao) {
        this.nome = nome;
        this.dataInicial = LocalDate.now();
        this.dataFinal = this.dataInicial.plusDays(diasDuracao);
    }

    public boolean estaAtiva() {
        LocalDate hoje = LocalDate.now();
        return (hoje.isEqual(dataInicial) || hoje.isAfter(dataInicial)) &&
                (hoje.isEqual(dataFinal) || hoje.isBefore(dataFinal));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Cliente> getCliente() {
        return clientes;
    }

    public Set<Produto> getProdutosElegiveis() {
        return produtosElegiveis;
    }

    @Override
    public String toString() {
        return "Promocao{" +
                "nome='" + nome + '\'' +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", produtosElegiveis=" + produtosElegiveis +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promocao promocao = (Promocao) o;
        return Objects.equals(nome, promocao.nome) && dataInicial.equals(promocao.dataInicial) && dataFinal.equals(promocao.dataFinal) && Objects.equals(clientes, promocao.clientes) && produtosElegiveis.equals(promocao.produtosElegiveis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataInicial, dataFinal, clientes, produtosElegiveis);
    }
}
