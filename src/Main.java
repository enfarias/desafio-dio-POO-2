import br.com.desafio.dominio.*;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        //Criando Produtos de Mercearia
        CompraMercearia arroz = new CompraMercearia();
        arroz.setNome("Arroz 5kg");
        arroz.setPreco(new BigDecimal("25.90"));
        arroz.setQuantidade(1);
        arroz.setPeso(5.0);
        arroz.setUnidade("KG");

        CompraMercearia feijao = new CompraMercearia();
        feijao.setNome("Feijão Carioca");
        feijao.setPreco(new BigDecimal("8.50"));
        feijao.setQuantidade(2);
        feijao.setPeso(1.0);
        feijao.setUnidade("KG");

        //Criando Bebidas (Alcoólica e Não Alcoólica)
        CompraBebida suco = new CompraBebida();
        suco.setNome("Suco de Uva Integral");
        suco.setPreco(new BigDecimal("12.00"));
        suco.setQuantidade(1);
        suco.setVolume(1500);
        suco.setAlcoolica(false);

        CompraBebida cerveja = new CompraBebida();
        cerveja.setNome("Cerveja Artesanal");
        cerveja.setPreco(new BigDecimal("15.00"));
        cerveja.setQuantidade(4);
        cerveja.setVolume(500);
        cerveja.setAlcoolica(true); // Cashback deve ser metade (5 centavos cada)

        //Criando a Promoção
        Promocao promocaoFidelidade = new Promocao("Festival de Bebidas", 7);
        promocaoFidelidade.setNome("Semana do Consumidor");
        promocaoFidelidade.getProdutosElegiveis().add(arroz);
        promocaoFidelidade.getProdutosElegiveis().add(suco);
        promocaoFidelidade.getProdutosElegiveis().add(cerveja);

        System.out.println("=====");
        System.out.println(arroz);
        System.out.println(suco);
        System.out.println(promocaoFidelidade);
        System.out.println("=====");

        //Criando o Cliente e Simulando a Compra
        Cliente cliente = new Cliente();
        cliente.setNome("Edson");

        // Participando da promoção
        cliente.participarDaPromocao(promocaoFidelidade);

        // Adicionando um item extra, que não estava na promoção
        cliente.getProdutosNoCarrinho().add(feijao);

        System.out.println("Produtos no Carrinho: " + cliente.getProdutosNoCarrinho().size());

        //Finalizando a Compra e Calculando Cashback
        cliente.finalizarCompra();

        System.out.println("--- Resumo da Compra ---");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Total de Cashback Acumulado: R$ " + cliente.calcularTotalCashback());
    }
}