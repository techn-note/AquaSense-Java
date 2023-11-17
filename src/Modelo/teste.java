/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Modelo;

/**
 *
 * @author Rodrigo
 */
public class teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Analise teste = new Analise();
        Float ultimoValorPH = teste.obterUltimoValorSenPH();

        if (ultimoValorPH != null) {
            System.out.println("Último valor de SenPH: " + ultimoValorPH);
        } else {
            System.out.println("Nenhum valor encontrado em SenPH.\n");
        }

        Float ultimoValorOD = teste.obterUltimoValorSenOD();

        if (ultimoValorPH != null) {
            System.out.println("Último valor de SenOD: " + ultimoValorOD);
        } else {
            System.out.println("Nenhum valor encontrado em SenPH.\n");
        }

        Float ultimoValorTemp = teste.obterUltimoValorSenTemp();

        if (ultimoValorPH != null) {
            System.out.println("Último valor de SenTemp: " + ultimoValorTemp);
        } else {
            System.out.println("Nenhum valor encontrado em SenPH.\n");
        }

        Float dadoAmonia = teste.obterDadoAmonia();
        if (ultimoValorPH != null) {
            System.out.println("Último valor do dado Amonia: " + dadoAmonia);
        } else {
            System.out.println("Nenhum valor encontrado em SenPH.\n");
        }

        Alerta ale = new Alerta();

        ale.alertaPH();
        ale.alertaOD();
        ale.alertaTemp();
        ale.alertaAmonia();
    }

}
