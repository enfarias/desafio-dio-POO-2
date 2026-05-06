# 🛒 Sistema de Simulação de Cashback - Varejo

<!-- Badges das Tecnologias -->
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)

Este projeto é um ecossistema de simulação de compras e fidelidade desenvolvido em **Java 21**. Ele demonstra a aplicação de padrões de projeto, arquitetura orientada a objetos e tratamento preciso de dados financeiros em um cenário de varejo.

O projeto foi evoluído a partir de um desafio de Bootcamp para uma estrutura robusta que reflete regras de negócio reais, como vigência de promoções e cálculos de cashback diferenciados.

## 🚀 Tecnologias Utilizadas

*   **Java 21** (LTS)
*   **Java Streams API** (Processamento de coleções)
*   **Java Time API** (Gestão de datas e vigência)
*   **BigDecimal** (Precisão para cálculos monetários)

## 🏗️ Arquitetura e Decisões Técnicas

O projeto foi construído seguindo princípios de **Clean Code** e **Domain-Driven Design (DDD)** simplificado:

### 1. Modelo de Domínio (Domain)
As classes refletem entidades reais do negócio. A classe abstrata `Produto` serve como base para `CompraMercearia` e `CompraBebida`, utilizando **Polimorfismo** para calcular cashback de forma personalizada:
*   **Mercearia:** Cashback padrão baseado na quantidade.
*   **Bebidas:** Validação de tipo (alcoólica ou não). Bebidas alcoólicas geram 50% do cashback padrão por unidade.

### 2. Gestão de Vigência (Temporalidade)
A classe `Promocao` é responsável por sua própria validade. Através do método `estaAtiva()`, o sistema valida se a data atual está dentro do intervalo de duração definido, impedindo que benefícios expirem ou sejam aplicados indevidamente.

### 3. Encapsulamento e Separação de Responsabilidades
Introduzimos a classe `CarrinhoDeCompras` para desacoplar a lógica de armazenamento temporário de produtos da classe `Cliente`. 
*   O **Cliente** foca em sua identidade e histórico.
*   O **Carrinho** foca na gestão de itens e subtotal.

## ⚙️ Como Funciona

1.  **Instanciação:** Produtos são criados com valores em `BigDecimal`.
2.  **Configuração de Promoção:** Uma `Promocao` é instanciada com um nome e um prazo de validade (ex: 7 dias).
3.  **Adesão:** O `Cliente` tenta participar da promoção. O sistema valida automaticamente se a promoção `estaAtiva()`.
4.  **Processamento:** Ao `finalizarCompra()`, os itens saem do carrinho, entram no histórico do cliente e o cashback total é calculado via `reduce` de Streams.

## 📊 Exemplo de Saída (Console)
```text
Promoção 'Semana do Consumidor' aplicada ao carrinho!
Produtos no Carrinho: 4
Compra finalizada com sucesso!
--- Resumo da Compra ---
Cliente: Edson Ney
Total de Cashback Acumulado: R$ 0.60
