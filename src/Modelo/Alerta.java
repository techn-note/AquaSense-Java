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

    public String alertaPH() {
        Float ultimoValorPH = analise.obterUltimoValorSenPH();
        String mensagemAlerta = "";

        if (ultimoValorPH != null && ultimoValorPH < 6.5) {
            mensagemAlerta = "Atenção: O nível de acidez (pH) está elevado. Considere realizar correções.\n";
        }
        return mensagemAlerta;
    }

    public String alertaOD() {
        Float ultimoValorOD = analise.obterUltimoValorSenOD();
        String mensagemAlerta = "";
        
        if (ultimoValorOD != null && ultimoValorOD <= 4) {
            mensagemAlerta = "Alerta: Baixa oxigenação na água, abaixo de 5. Verifique e melhore a circulação de oxigênio.\n";
        }
        return mensagemAlerta;
    }

    public String alertaTemp() {
        Float ultimoValorTemp = analise.obterUltimoValorSenTemp();
        String mensagemAlerta = "";

        if (ultimoValorTemp != null && ultimoValorTemp > 25) {
            mensagemAlerta= "Atenção: Temperatura acima de 25°. Verifique se há condições adequadas para os organismos.\n";
        }
        return mensagemAlerta;
    }

    public String alertaAmonia() {
        Float obterDadoAmonia = analise.obterDadoAmonia();
        String mensagemAlerta = "";

        if (obterDadoAmonia != null && obterDadoAmonia > 1) {
            mensagemAlerta = "Alerta de concentração elevada de amônia. Tome medidas para garantir a saúde dos organismos.\n";
        }
        return mensagemAlerta;
    }

}
