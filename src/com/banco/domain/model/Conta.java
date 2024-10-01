package com.banco.domain.model;

public abstract class Conta {
    private static final int AGENCIA_PADRAO = 1;
    private static int IDCONTASEQUENCIAL= 1;

    private int agencia;
    private int numero;
    private double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = IDCONTASEQUENCIAL;
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

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirExtrato() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
