/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controle.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dsm2
 */
public class tanque {
    private double capacidade;
    private double nivelVolume;
    private double temperaturaAgua;
    private double pHAgua;
    private double oxigenacao;
    private double peixes;

    public tanque() {
        this(0.0,0.0,0.0,0.0,0.0,0.0);
    }

    public tanque(double capacidade, double nivelVolume, double temperaturaAgua, double pHAgua, double oxigenacao, double peixes) {
        this.capacidade = capacidade;
        this.nivelVolume = nivelVolume;
        this.temperaturaAgua = temperaturaAgua;
        this.pHAgua = pHAgua;
        this.oxigenacao = oxigenacao;
        this.peixes = peixes;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public double getNivelVolume() {
        return nivelVolume;
    }

    public void setNivelVolume(double nivelVolume) {
        this.nivelVolume = nivelVolume;
    }

    public double getTemperaturaAgua() {
        return temperaturaAgua;
    }

    public void setTemperaturaAgua(double temperaturaAgua) {
        this.temperaturaAgua = temperaturaAgua;
    }

    public double getpHAgua() {
        return pHAgua;
    }

    public void setpHAgua(double pHAgua) {
        this.pHAgua = pHAgua;
    }

    public double getOxigenacao() {
        return oxigenacao;
    }

    public void setOxigenacao(double oxigenacao) {
        this.oxigenacao = oxigenacao;
    }

    public double getPeixes() {
        return peixes;
    }

    public void setPeixes(double peixes) {
        this.peixes = peixes;
    }
    
    
}
