/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controle.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    Sensor S = new Sensor();

    final private String url = "jdbc:mysql://127.0.0.1/aquasense";
    final private String usuario = "root";
    final private String senha = "";

    public Analise() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
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

    public Float obterUltimoValorSenPH() {
        String consultaSQL = "SELECT Valor FROM SenPH ORDER BY Id_pH DESC LIMIT 1";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha); PreparedStatement preparedStatement = conexao.prepareStatement(consultaSQL); ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                dadoPH = resultSet.getFloat("Valor");
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return dadoPH;
    }

    public Float obterUltimoValorSenOD() {
        String consultaSQL = "SELECT Valor FROM SenOD ORDER BY Id_SenOD DESC LIMIT 1";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha); PreparedStatement preparedStatement = conexao.prepareStatement(consultaSQL); ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                dadoOxigenacao = resultSet.getFloat("Valor");
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return dadoOxigenacao;
    }

    public Float obterUltimoValorSenTemp() {
        String consultaSQL = "SELECT Valor FROM SenTemp ORDER BY Id_SenTemp DESC LIMIT 1";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha); PreparedStatement preparedStatement = conexao.prepareStatement(consultaSQL); ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                dadoTemp = resultSet.getFloat("Valor");
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return dadoTemp;
    }
    
    public Float obterDadoAmonia(){

        double pKaAmonia = 9.26;
        
        dadoAmonia = (float) (Math.pow(10, (dadoPH - pKaAmonia)) * Math.pow(2.71828, (-0.08 * (dadoTemp - 25))));
        
        dadoAmonia *= 100;

        return dadoAmonia;
    }
    
        public Float obterDadoVolume() {
        String consultaSQL = "SELECT Valor FROM SenTemp ORDER BY Id_SenTemp DESC LIMIT 1";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha); PreparedStatement preparedStatement = conexao.prepareStatement(consultaSQL); ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                dadoVolume = 150;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return dadoVolume;
    }
}
