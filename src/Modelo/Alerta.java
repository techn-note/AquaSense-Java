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

    public Alerta() {
        this(0,"","");
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
    
    
}
