package com.uninassau.bilu_bilu.activity;

import java.io.Serializable;

public class Jogar implements Serializable {

    private String nome;
    private int pontuacaoTotal = 0;
    private String nivel = "Facil";
    private int fase = 0;
    private int idade;

    public Jogar() {

    }

    public Jogar(String nome) {
        this.nome = nome;
    }

    public Jogar(String nome, int pontos) {
        this.nome = nome;
        this.pontuacaoTotal = pontos;
    }

    // Metodos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacaoTotal() {
        return pontuacaoTotal;
    }

    public void setPontuacaoTotal(int pontuacaoTotal) {
        this.pontuacaoTotal = pontuacaoTotal;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}


