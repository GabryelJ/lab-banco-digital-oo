package com.banco.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Cliente {
    private String nome;
    public Cliente(String nome) {
        this.nome = nome;
    }
}