/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controle.Conexao;

/**
 *
 * @author dsm2
 */
class Peixe {
    private String nome;
    private String especie;
    private int idade;
    private float peso;
    private int quantidade;
    
    Conexao C = new Conexao();

    public Peixe() {
        this("","",0,0.0f,0);
    }

    public Peixe(String nome, String especie, int idade, float peso, int quantidade) {
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.peso = peso;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
