package com.banco.domain.exception;

public class ValorDeTransacaoNegativoException extends Exception{
    public ValorDeTransacaoNegativoException(){
        super("Não é possivel passar um valor negativo.");
    }
}
