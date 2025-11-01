package br.com.estoque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstoqueProdutoTest {

    private EstoqueProduto produto;

    @BeforeEach
    void setUp() {
        // Configuração inicial para a maioria dos testes
        // Começamos com 10 itens no estoque
        produto = new EstoqueProduto("Produto Teste", 10);
    }

    // Requisito 1: Teste de Criação

    @Test
    @DisplayName("Deve criar produto com estoque inicial válido")
    void testeConstrutorEstoqueValido() {
        assertEquals(10, produto.getQuantidadeAtual());
        assertEquals("Produto Teste", produto.getNomeProduto());
    }

    @Test
    @DisplayName("Não deve criar produto com estoque inicial negativo")
    void testeConstrutorEstoqueNegativo() {
        // Verifica se a exceção IllegalArgumentException é lançada
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new EstoqueProduto("Produto Ruim", -1)
        );

        // Verifica a mensagem da exceção
        assertEquals("Quantidade inicial não pode ser negativa.", exception.getMessage());
    }

    // Requisito 2: Validação de Adição e Remoção

    @Test
    @DisplayName("Deve adicionar itens ao estoque com sucesso")
    void testeAdicionarComSucesso() {
        produto.adicionar(5);
        assertEquals(15, produto.getQuantidadeAtual());
    }

    @Test
    @DisplayName("Deve remover itens do estoque com sucesso")
    void testeRemoverComSucesso() throws EstoqueInsuficienteException {
        produto.remover(3);
        assertEquals(7, produto.getQuantidadeAtual());
    }

    @Test
    @DisplayName("Deve remover exatamente a quantidade total do estoque")
    void testeRemoverEstoqueCompleto() throws EstoqueInsuficienteException {
        produto.remover(10);
        assertEquals(0, produto.getQuantidadeAtual());
    }

    // Requisito 3: Testes de Exceção para Quantidades Inválidas

    @Test
    @DisplayName("Não deve adicionar quantidade zero")
    void testeAdicionarQuantidadeZero() {
        assertThrows(IllegalArgumentException.class, () -> produto.adicionar(0));
        assertEquals(10, produto.getQuantidadeAtual()); // Garante que o estoque não mudou
    }

    @Test
    @DisplayName("Não deve adicionar quantidade negativa")
    void testeAdicionarQuantidadeNegativa() {
        assertThrows(IllegalArgumentException.class, () -> produto.adicionar(-5));
        assertEquals(10, produto.getQuantidadeAtual()); // Garante que o estoque não mudou
    }

    @Test
    @DisplayName("Não deve remover quantidade zero")
    void testeRemoverQuantidadeZero() {
        assertThrows(IllegalArgumentException.class, () -> produto.remover(0));
        assertEquals(10, produto.getQuantidadeAtual()); // Garante que o estoque não mudou
    }

    @Test
    @DisplayName("Não deve remover quantidade negativa")
    void testeRemoverQuantidadeNegativa() {
        assertThrows(IllegalArgumentException.class, () -> produto.remover(-5));
        assertEquals(10, produto.getQuantidadeAtual()); // Garante que o estoque não mudou
    }

    // Requisito 4: Teste de Estoque Insuficiente

    @Test
    @DisplayName("Não deve remover mais itens do que o disponível")
    void testeRemoverEstoqueInsuficiente() {
        // Tenta remover 11, mas só tem 10
        EstoqueInsuficienteException exception = assertThrows(
                EstoqueInsuficienteException.class,
                () -> produto.remover(11)
        );

        // Verifica a mensagem da exceção
        assertTrue(exception.getMessage().contains("Estoque insuficiente"));

        // Garante que o estoque não foi alterado após a tentativa falha
        assertEquals(10, produto.getQuantidadeAtual());
    }
}