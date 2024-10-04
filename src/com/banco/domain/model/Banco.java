package com.banco.domain.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Banco {
    private String nome;

    @Getter
    private List<Conta> contas = new ArrayList<>();

    public Banco(String nome){
        this.nome = nome;
    }

    public void persistirConta(Conta conta){
        contas.add(conta);
    }



    public Conta buscaPorNumeroDaConta(int numero, int tipo){
        Conta contaIndice = tipo == 1 ?  new ContaPoupanca(numero) :  new ContaCorrente(numero);
        Integer contaBuscada = Collections.binarySearch(
                contas,
                contaIndice,
                (conta1, conta2) -> Integer.compare(conta1.getNumero(), conta2.getNumero()));
       return contas.get(contaBuscada);
    }


}