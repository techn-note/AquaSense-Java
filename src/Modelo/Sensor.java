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

public class Sensor {
    private List<Float> registrosVolume = new ArrayList<>();
    private List<Float> registrosTemperatura = new ArrayList<>();
    private List<Float> registrosPH = new ArrayList<>();
    private List<Float> registrosOxigenacao = new ArrayList<>();
    private List<Peixe> historicoPeixes = new ArrayList<>();

    Conexao C = new Conexao();
    
    public List<Float> getRegistrosVolume() {
        return registrosVolume;
    }

    public void setRegistrosVolume(List<Float> registrosVolume) {
        this.registrosVolume = registrosVolume;
    }

    public List<Float> getRegistrosTemperatura() {
        return registrosTemperatura;
    }

    public void setRegistrosTemperatura(List<Float> registrosTemperatura) {
        this.registrosTemperatura = registrosTemperatura;
    }

    public List<Float> getRegistrosPH() {
        return registrosPH;
    }

    public void setRegistrosPH(List<Float> registrosPH) {
        this.registrosPH = registrosPH;
    }

    public List<Float> getRegistrosOxigenacao() {
        return registrosOxigenacao;
    }

    public void setRegistrosOxigenacao(List<Float> registrosOxigenacao) {
        this.registrosOxigenacao = registrosOxigenacao;
    }

    public List<Peixe> getHistoricoPeixes() {
        return historicoPeixes;
    }

    public void setHistoricoPeixes(List<Peixe> historicoPeixes) {
        this.historicoPeixes = historicoPeixes;
    }
    
    
}
