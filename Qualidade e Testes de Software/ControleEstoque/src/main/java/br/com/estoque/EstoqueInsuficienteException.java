package br.com.estoque;

/**
 * Exceção customizada lançada quando uma tentativa de remoção
 * resultaria em estoque negativo.
 */
public class EstoqueInsuficienteException extends Exception {

    public EstoqueInsuficienteException(String message) {
        super(message);
    }
}