/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


/**
 *
 * @author dsm2
 */

public class DadosSensor {
     private int ciclo;
    private String nomeTanque;
    private double valorPH;
    private double valorOD;
    private double valorTemp;
    private Timestamp dataHoraLeitura;



    public DadosSensor(int ciclo, String nomeTanque, double valorPH, double valorOD, double valorTemp, Timestamp dataHoraLeitura) {
        this.ciclo = ciclo;
        this.nomeTanque = nomeTanque;
        this.valorPH = valorPH;
        this.valorOD = valorOD;
        this.valorTemp = valorTemp;
        this.dataHoraLeitura = dataHoraLeitura;
    }

    
    

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public String getNomeTanque() {
        return nomeTanque;
    }

    public void setNomeTanque(String nomeTanque) {
        this.nomeTanque = nomeTanque;
    }

    public double getValorPH() {
        return valorPH;
    }

    public void setValorPH(double valorPH) {
        this.valorPH = valorPH;
    }

    public double getValorOD() {
        return valorOD;
    }

    public void setValorOD(double valorOD) {
        this.valorOD = valorOD;
    }

    public double getValorTemp() {
        return valorTemp;
    }

    public void setValorTemp(double valorTemp) {
        this.valorTemp = valorTemp;
    }

    public Timestamp getDataHoraLeitura() {
        return dataHoraLeitura;
    }

    public void setDataHoraLeitura(Timestamp dataHoraLeitura) {
        this.dataHoraLeitura = dataHoraLeitura;
    }
        public String getDataFormatada() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dataHoraLeitura);
    }

    public String getHoraFormatada() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(dataHoraLeitura);
    }
    
}
