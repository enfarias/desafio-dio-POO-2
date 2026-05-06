package br.com.desafio.dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CompraMercearia extends Produto{

    private double peso;

    @Override
    public BigDecimal calcularCashback() {
        return CASHBACK_PADRAO.multiply(new BigDecimal(getQuantidade()))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public CompraMercearia(){
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "CompraMercearia{" +
                "nome='" + getNome() + '\'' +
                ", quantidade=" + getQuantidade() +
                ", peso=" + peso + "kg" +
                ", unidade='" + getUnidade() + '\'' +
                ", preco=" + getPreco() +
                '}';
    }

}
