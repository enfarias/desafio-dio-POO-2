package br.com.desafio.dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CompraBebida extends Produto {

    private double volume; // ex: 350 (ml)
    private boolean alcoolica;

    public CompraBebida() {
    }

    @Override
// Alterado de double para BigDecimal
    public BigDecimal calcularCashback() {

        if (alcoolica) {
            return CASHBACK_PADRAO.divide(new BigDecimal("2"), RoundingMode.HALF_UP)
                    .multiply(BigDecimal.valueOf(getQuantidade()))
                    .setScale(2, RoundingMode.HALF_UP);
        }

        // Agora o retorno combina com o tipo BigDecimal
        return CASHBACK_PADRAO.multiply(BigDecimal.valueOf(getQuantidade()))
                .setScale(2, RoundingMode.HALF_UP);
    }

    // Getters e Setters
    public boolean isAlcoolica() {
        return alcoolica;
    }

    public void setAlcoolica(boolean alcoolica) {
        this.alcoolica = alcoolica;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "CompraBebida{" +
                "nome='" + getNome() + '\'' +
                ", quantidade=" + getQuantidade() +
                ", volume=" + volume + "ml" +
                ", alcoolica=" + (alcoolica ? "Sim" : "Não") +
                ", preco=" + getPreco() +
                '}';
    }
}
