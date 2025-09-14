package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UtilsTest {
    // ePrimo
    @Test
    public void testEPrimo() {
        assertTrue(Utils.ePrimo(2));
        assertTrue(Utils.ePrimo(13));
        assertTrue(Utils.ePrimo(29));
        assertFalse(Utils.ePrimo(1));
        assertFalse(Utils.ePrimo(0));
        assertFalse(Utils.ePrimo(12));
        assertFalse(Utils.ePrimo(100));
    }

    // isValidEmail
    @Test
    public void testIsValidEmail() {
        assertTrue(Utils.isValidEmail("aluno@fatec.com"));
        assertTrue(Utils.isValidEmail("nome.sobrenome@dominio.com.br"));
        assertFalse(Utils.isValidEmail("alunofatec.com")); // sem @
        assertFalse(Utils.isValidEmail("aluno@.com"));     // dominio invalido
        assertFalse(Utils.isValidEmail(null));            // null -> false
    }

    // contemPalavra
    @Test
    public void testContemPalavra() {
        assertTrue(Utils.contemPalavra("Fazendo codigo de Java", "java"));
        assertTrue(Utils.contemPalavra("O sistema esta online", "esta"));
        assertFalse(Utils.contemPalavra("Teste simples", "complexo"));
        assertFalse(Utils.contemPalavra(null, "algo"));
        assertFalse(Utils.contemPalavra("texto valido", null));
    }

    // calcularIMC
    @Test
    public void testCalcularIMC() {
        assertTrue(Utils.calcularIMC(70.0, 1.75));      // IMC ~22.86 -> dentro da faixa
        assertFalse(Utils.calcularIMC(50.0, 1.80));    // IMC ~15.43 -> abaixo
        assertFalse(Utils.calcularIMC(100.0, 1.70));  // IMC ~34.6 -> acima
        assertFalse(Utils.calcularIMC(-5, 1.70));    // entrada invalida
        assertFalse(Utils.calcularIMC(70, 0));      // entrada invalida
    }
}