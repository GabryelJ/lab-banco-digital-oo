package com.banco.domain.model;

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

    public void sacar(int valor) {
        if (saldo >= valor) {
            this.saldo -= valor;
        } else {
            throw new RuntimeException("Saldo insuficiente.");
        }
    }

    public void depositar(int valor) {
        this.saldo += valor;
    }

    public void transferir(int valor, Conta contaDestino) {

        contaDestino.saldo += valor;
    }

    protected void imprimirExtrato() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Numero: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }
}
