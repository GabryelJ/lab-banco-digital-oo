package com.banco.domain.exception;

public class ContaNaoExisteException extends Exception{
    public ContaNaoExisteException(){
        super("Conta não existe ou não foi encontrada.");
    }
}
