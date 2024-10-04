package com.banco.domain.model;

import com.banco.domain.exception.SaldoInsuficienteException;
import lombok.*;


@Getter
public abstract class Conta {
    private static final int AGENCIA_PADRAO = 1;
    private static int idContaSequencial= 1;

    private int agencia;
    private int numero;
    private double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = idContaSequencial++;
        this.saldo = 0;
        this.cliente = cliente;
    }

    public Conta(int numero){
        this.numero = numero;
    }


    public void sacar(int valor) throws SaldoInsuficienteException {
        if (saldo >= valor) {
            this.saldo -= valor;
        } else {
            throw new SaldoInsuficienteException();
        }
    }

    public void depositar(int valor) {
        this.saldo += valor;
    }

    public void transferir(int valor, Conta contaEnvio, Conta contaDestino) throws SaldoInsuficienteException {
        contaEnvio.sacar(valor);
        contaDestino.depositar(valor);
    }

    public void imprimirExtrato() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Numero: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }
}
