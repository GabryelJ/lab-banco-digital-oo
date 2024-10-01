package com.banco.domain.model;

import lombok.Getter;

import java.util.ArrayList;
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

}