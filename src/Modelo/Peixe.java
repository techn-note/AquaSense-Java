/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dsm2
 */
class Peixe {

    private double comprimento;
    private double peso;
    private String peixe;
    private int idade;
    private int ciclo;

    public Peixe() {
        this(0.0, 0.0, "", 0, 0);
    }

    public Peixe(double comprimento, double peso, String peixe, int idade, int ciclo) {
        this.comprimento = comprimento;
        this.peso = peso;
        this.peixe = peixe;
        this.idade = idade;
        this.ciclo = ciclo;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getPeixe() {
        return peixe;
    }

    public void setPeixe(String peixe) {
        this.peixe = peixe;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public List<Peixe> obterDadosSensor(ResultSet resultSet) {

        List<Peixe> Peixe = new ArrayList<>();

        try {
            while (resultSet.next()) {
                Peixe.add(new Peixe(resultSet.getDouble("Comprimento"),
                        resultSet.getDouble("Peso"),
                        resultSet.getString("Peixe"),
                        resultSet.getInt("Idade"),
                        resultSet.getInt("Ciclo")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Peixe;
    }
}
