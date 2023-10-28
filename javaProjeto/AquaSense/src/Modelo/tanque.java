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
    private float capacidade;
    private float nivelVolume;
    private float temperaturaAgua;
    private float pHAgua;
    private Float oxigenacao;
    private List<Peixe> peixes;
    
    Conexao C = new Conexao();

    public tanque() {
        this(0.0f,0.0f,0.0f,0.0f,0.0f, new ArrayList<>());
    }

    public tanque(float capacidade, float nivelVolume, float temperaturaAgua, float pHAgua, Float oxigenacao, List<Peixe> peixes) {
        this.capacidade = capacidade;
        this.nivelVolume = nivelVolume;
        this.temperaturaAgua = temperaturaAgua;
        this.pHAgua = pHAgua;
        this.oxigenacao = oxigenacao;
        this.peixes = peixes;
    }
    
    
}
