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
public class Analise {
    private float dadoAmonia;
    private float dadoTemp;
    private float dadoVolume;
    private float dadoPH;
    private float dadoOxigenacao;

    Conexao C = new Conexao();
    
    public Analise() {
        this(0.0f,0.0f,0.0f,0.0f,0.0f);
    }

    public Analise(float dadoAmonia, float dadoTemp, float dadoVolume, float dadoPH, float dadoOxigenacao) {
        this.dadoAmonia = dadoAmonia;
        this.dadoTemp = dadoTemp;
        this.dadoVolume = dadoVolume;
        this.dadoPH = dadoPH;
        this.dadoOxigenacao = dadoOxigenacao;
    }

    public float getDadoAmonia() {
        return dadoAmonia;
    }

    public void setDadoAmonia(float dadoAmonia) {
        this.dadoAmonia = dadoAmonia;
    }

    public float getDadoTemp() {
        return dadoTemp;
    }

    public void setDadoTemp(float dadoTemp) {
        this.dadoTemp = dadoTemp;
    }

    public float getDadoVolume() {
        return dadoVolume;
    }

    public void setDadoVolume(float dadoVolume) {
        this.dadoVolume = dadoVolume;
    }

    public float getDadoPH() {
        return dadoPH;
    }

    public void setDadoPH(float dadoPH) {
        this.dadoPH = dadoPH;
    }

    public float getDadoOxigenacao() {
        return dadoOxigenacao;
    }

    public void setDadoOxigenacao(float dadoOxigenacao) {
        this.dadoOxigenacao = dadoOxigenacao;
    }
    
    
        
}
