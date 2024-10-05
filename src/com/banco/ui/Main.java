package com.banco.ui;

import com.banco.domain.exception.ContaNaoCriadaException;
import com.banco.domain.model.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Boolean rodando = true;
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco("CASH! & MONEY!") ;
        System.out.println("Bem-Vindo!");
        while (rodando) {
            System.out.printf("Escolha:" +
                    "\n1 - Criar Conta" +
                    "\n2 - Imprimir Extrato" +
                    "\n3 - Sacar" +
                    "\n4 - Depositar" +
                    "\n5 - Transferir" +
                    "\n6 - Sair" +
                    "\n Escolha: ");
            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1 -> {
                    try {
                        String nome = "";
                        System.out.println("Criação de conta: ");
                        System.out.printf("Insira seu nome: ");
                        scanner.nextLine();
                        nome = scanner.nextLine();
                        Conta conta = null;
                        Cliente cliente = new Cliente(nome);
                        System.out.printf("\nDigite 1 para criar uma conta Corrente. \n" +
                                "Digite 2 para criar uma conta Poupanca." +
                                "\nEscolha: ");
                        escolha = scanner.nextInt();
                        if (escolha == 1) {
                            conta = new ContaCorrente(cliente);
                        } else if (escolha == 2){
                            conta = new ContaPoupanca(cliente);
                        } else{
                            throw new ContaNaoCriadaException();
                        }
                        banco.persistirConta(conta);
                        System.out.println("Conta criada!");
                    }catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        System.out.println("Insira o número da sua conta");
                        int numero = scanner.nextInt();
                        System.out.println("Qual o tipo da conta?\n" +
                                "1 - Corrente\n" +
                                "2 - Poupança");
                        int tipo = scanner.nextInt();
                        Conta conta = banco.buscaPorNumeroDaConta(numero, tipo);
                        if (conta != null){
                            conta.imprimirExtrato();
                        }
                    }catch (Exception e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                }

                case 3 -> {
                    try {
                        System.out.println("Insira o número da sua conta");
                        int numero = scanner.nextInt();
                        System.out.println("Qual o tipo da conta?\n" +
                                "1 - Corrente\n" +
                                "2 - Poupança");
                        int tipo = scanner.nextInt();
                        Conta conta = banco.buscaPorNumeroDaConta(numero, tipo);
                        if (conta != null) {
                            System.out.println("Insira o valor do saque: ");
                            float valorSaque = scanner.nextFloat();
                            conta.sacar(valorSaque);
                            System.out.println("Saldo atual: " + conta.getSaldo());
                            System.out.println("Saque concluido!");
                        }
                    }catch (Exception e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                }

                case 4 -> {
                    try {
                        System.out.println("Insira o número da sua conta");
                        int numero = scanner.nextInt();
                        System.out.println("Qual o tipo da conta?\n" +
                                "1 - Corrente\n" +
                                "2 - Poupança");
                        int tipo = scanner.nextInt();
                        Conta conta = banco.buscaPorNumeroDaConta(numero, tipo);
                        if (conta != null) {
                            System.out.println("Insira o valor do depósito: ");
                            float valorDeposito = scanner.nextFloat();
                            conta.depositar(valorDeposito);
                            System.out.println("Saldo atual: " + conta.getSaldo());
                            System.out.println("Deposito concluido!");
                        }
                    }catch (Exception e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                }

                case 5 -> {
                    try {
                        System.out.println("Insira o número da sua conta: ");
                        int numero = scanner.nextInt();
                        System.out.println("Qual o tipo da conta?\n" +
                                "1 - Corrente\n" +
                                "2 - Poupança");
                        int tipo = scanner.nextInt();
                        Conta contaEnvio = banco.buscaPorNumeroDaConta(numero, tipo);
                        if (contaEnvio != null){
                            System.out.println("Insira o número da conta que receberá a transferência: ");
                            numero = scanner.nextInt();
                            System.out.println("Qual o tipo da conta?\n" +
                                    "1 - Corrente\n" +
                                    "2 - Poupança");
                            tipo = scanner.nextInt();
                            Conta contaDestino = banco.buscaPorNumeroDaConta(numero, tipo);
                            if (contaDestino != null){
                                System.out.println("Quanto deseja transferir? ");
                                float valorTransferencia = scanner.nextFloat();
                                contaEnvio.transferir(valorTransferencia, contaEnvio, contaDestino);
                                System.out.println("Saldo atual: " + contaEnvio.getSaldo());
                            }
                        }

                    }catch (Exception e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                }

                case 6 -> rodando = false;

                default -> System.out.println("Tente novamente.");
            }
        }
    }
}