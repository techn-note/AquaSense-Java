/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controle.Conexao;
import java.sql.ResultSet;
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

    public ResultSet consultar() {
        ResultSet tabela;
        tabela = null;

        String sql = "SELECT p.Ciclo, t.Nome, sph.valor, sod.valor, stemp.valor, sph.data_hora_leitura, sod.data_hora_leitura, stemp.data_hora_leitura \n"
                + "FROM sensores s"
                + "JOIN Tanque t ON t.Id_Tanque = s.fk_Tanque_Id_Tanque"
                + "JOIN peixe p ON p.id_peixe = t.Id_tanque"
                + "JOIN SenPH sph ON sph.fk_Sensores_Id_Sensores = s.Id_sensores"
                + "JOIN SenOD sod ON sod.fk_Sensores_Id_Sensores = s.Id_sensores"
                + "JOIN SenTemp stemp ON stemp.fk_Sensores_Id_Sensores = s.Id_sensores";
        tabela = C.RetornarResultset(sql);
        return tabela;
    }

}
