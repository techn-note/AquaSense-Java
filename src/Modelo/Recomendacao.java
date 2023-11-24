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
    Analise analise = new Analise();

    public Recomendacao() {
        this(0, "", "");
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
/*
    public void recomendaPH() {

        Float ultimoValorPH = analise.obterUltimoValorSenPH();

        if (ultimoValorPH != null && ultimoValorPH > 7) {

            System.out.println("Alerta: O valor de pH é maior que 7!\n");
        }
    }

    public void recomendaOD() {

        Float ultimoValorOD = analise.obterUltimoValorSenOD();

        if (ultimoValorOD != null && ultimoValorOD < 5) {

            System.out.println("Os níveis de Oxigenação estão menores que 5\n");
        }
    }

    public void recomendaTemp() {

        Float ultimoValorTemp = analise.obterUltimoValorSenTemp();

        if (ultimoValorTemp != null && ultimoValorTemp > 25) {

            System.out.println("As medições de temperatura estão maiores que 25!\n");
        }
    }
*/
}
