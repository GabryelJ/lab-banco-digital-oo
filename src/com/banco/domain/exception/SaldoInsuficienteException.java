package com.banco.domain.exception;

public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(){
        super("Erro: saldo insuficiente");
    }
}
