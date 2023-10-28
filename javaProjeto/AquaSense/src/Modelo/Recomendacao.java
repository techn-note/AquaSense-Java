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
public class Recomendacao {
    private int codRecomendacao;
    private String mensagemR;
    private String dtHora;
    
    Conexao C = new Conexao();

    public Recomendacao() {
        this(0,"","");
    }

    public Recomendacao(int codRecomendacao, String mensagemR, String dtHora) {
        this.codRecomendacao = codRecomendacao;
        this.mensagemR = mensagemR;
        this.dtHora = dtHora;
    }

    public int getCodRecomendacao() {
        return codRecomendacao;
    }

    public void setCodRecomendacao(int codRecomendacao) {
        this.codRecomendacao = codRecomendacao;
    }

    public String getMensagemR() {
        return mensagemR;
    }

    public void setMensagemR(String mensagemR) {
        this.mensagemR = mensagemR;
    }

    public String getDtHora() {
        return dtHora;
    }

    public void setDtHora(String dtHora) {
        this.dtHora = dtHora;
    }
    
    
}
