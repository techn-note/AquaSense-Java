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
public class Alerta {

    private int codAlerta;
    private String mensageAlerta;
    private String dtHora;

    Conexao C = new Conexao();
    Analise analise = new Analise();

    public Alerta() {
        this(0, "", "");
    }

    public Alerta(int codAlerta, String mensageAlerta, String dtHora) {
        this.codAlerta = codAlerta;
        this.mensageAlerta = mensageAlerta;
        this.dtHora = dtHora;
    }

    public int getCodAlerta() {
        return codAlerta;
    }

    public void setCodAlerta(int codAlerta) {
        this.codAlerta = codAlerta;
    }

    public String getMensageAlerta() {
        return mensageAlerta;
    }

    public void setMensageAlerta(String mensageAlerta) {
        this.mensageAlerta = mensageAlerta;
    }

    public String getDtHora() {
        return dtHora;
    }

    public void setDtHora(String dtHora) {
        this.dtHora = dtHora;
    }

    public void alertaPH() {

        Float ultimoValorPH = analise.obterUltimoValorSenPH();

        if (ultimoValorPH != null && ultimoValorPH > 7) {

            System.out.println("Alerta: O valor de pH é maior que 7!\n");
        }
    }

    public void alertaOD() {

        Float ultimoValorOD = analise.obterUltimoValorSenOD();

        if (ultimoValorOD != null && ultimoValorOD < 5) {

            System.out.println("Os níveis de Oxigenação estão menores que 5\n");
        }
    }

    public void alertaTemp() {

        Float ultimoValorTemp = analise.obterUltimoValorSenTemp();

        if (ultimoValorTemp != null && ultimoValorTemp > 25) {

            System.out.println("As medições de temperatura estão maiores que 25!\n");
        }
    }

    public void alertaAmonia() {

        Float obterDadoAmonia = analise.obterDadoAmonia();

        if (obterDadoAmonia != null && obterDadoAmonia < 1) {

            System.out.println("Amonia muito baixa!\n");
        }
    }

}
