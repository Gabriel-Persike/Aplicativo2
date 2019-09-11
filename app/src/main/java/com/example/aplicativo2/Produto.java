package com.example.aplicativo2;

public class Produto {
    private String nome;
    private String quantidade;
    private boolean prioridade;

    public Produto(String nome, String quantidade, boolean prioridade){
        this.nome = nome;
        this.quantidade = quantidade;
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isPrioridade() {
        return prioridade;
    }

    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
    }
}
