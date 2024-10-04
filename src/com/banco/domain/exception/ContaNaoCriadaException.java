package com.banco.domain.exception;

public class ContaNaoCriadaException extends Exception{
    public ContaNaoCriadaException() {
        super("Não foi possível criar a conta."); // Define a mensagem da exceção
    }
}
