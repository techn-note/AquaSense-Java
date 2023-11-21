/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class BancoDDL {

    final private String driver = "com.mysql.jdbc.Driver";
    final private String url = "jdbc:mysql://127.0.0.1/";
    final private String usuario = "root";
    final private String senha = "";

    final private String Usuarios = "CREATE TABLE IF NOT EXISTS Usuarios ("
            + "Id_Usuario INTEGER PRIMARY KEY AUTO_INCREMENT,"
            + "Nome VARCHAR(250),"
            + "Email VARCHAR(250) UNIQUE,"
            + "Senha VARCHAR(250),"
            + "Telefone VARCHAR(20) UNIQUE,"
            + "UNIQUE (Email, Telefone));";
    final private String Dimensao = "CREATE TABLE IF NOT EXISTS Dimensao ("
            + "Id_Dimensao INT PRIMARY KEY AUTO_INCREMENT,"
            + "Comprimento DOUBLE,"
            + "Largura DOUBLE,"
            + "Profundidade DOUBLE);";
    final private String Tanque = "CREATE TABLE IF NOT EXISTS Tanque ( "
            + "Id_Tanque INT PRIMARY KEY AUTO_INCREMENT, "
            + "Nome VARCHAR(250), "
            + "Capacidade DOUBLE, "
            + "Data_hora_Instalacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
            + "fk_Dimensao_Id_Dimensao INT, "
            + "fk_Usuario_Id_Usuario INT, "
            + "CONSTRAINT fk_TanqueDimensao FOREIGN KEY (fk_Dimensao_Id_Dimensao) REFERENCES Dimensao (Id_Dimensao), "
            + "CONSTRAINT fk_TanqueUsuario FOREIGN KEY (fk_Usuario_Id_Usuario) REFERENCES Usuarios (Id_Usuario));";
    final private String Sensores = "CREATE TABLE IF NOT EXISTS Sensores ("
            + "Id_Sensores INT PRIMARY KEY AUTO_INCREMENT,"
            + "fk_Tanque_Id_Tanque INT,"
            + "CONSTRAINT fk_SensoresTanque FOREIGN KEY (fk_Tanque_Id_Tanque) REFERENCES Tanque (Id_Tanque))";
    final private String SenPH = "CREATE TABLE IF NOT EXISTS SenPH ("
            + "Id_pH INT PRIMARY KEY AUTO_INCREMENT,"
            + "Data_hora_leitura DATETIME,"
            + "Valor DOUBLE,"
            + "fk_Sensores_Id_Sensores INT,"
            + "CONSTRAINT fk_SenPHSensores FOREIGN KEY (fk_Sensores_Id_Sensores) REFERENCES Sensores (Id_Sensores))";
    final private String SenOD = "CREATE TABLE IF NOT EXISTS SenOD ("
            + "Id_SenOD INT PRIMARY KEY AUTO_INCREMENT,"
            + "Data_hora_leitura DATETIME,"
            + "Valor DOUBLE,"
            + "fk_Sensores_Id_Sensores INTEGER,"
            + "CONSTRAINT fk_SenODSensores FOREIGN KEY (fk_Sensores_Id_Sensores) REFERENCES Sensores (Id_Sensores))";
    final private String SenTemp = "CREATE TABLE IF NOT EXISTS SenTemp ("
            + "Id_SenTemp INTEGER PRIMARY KEY AUTO_INCREMENT,"
            + "Data_hora_leitura DATETIME,"
            + "Valor DOUBLE,"
            + "fk_Sensores_Id_Sensores INTEGER,"
            + "CONSTRAINT fk_SenTempSensores FOREIGN KEY (fk_Sensores_Id_Sensores) REFERENCES Sensores (Id_Sensores))";
    final private String Peixe = "CREATE TABLE IF NOT EXISTS Peixe ("
            + "Id_Peixe INT PRIMARY KEY AUTO_INCREMENT,"
            + "Idade INT,"
            + "Peso DOUBLE,"
            + "Comprimento DOUBLE,"
            + "Ciclo INT,"
            + "fk_Tanque_Id_Tanque INT,"
            + "CONSTRAINT fk_PeixeTanque FOREIGN KEY (fk_Tanque_Id_Tanque) REFERENCES Tanque (Id_Tanque))";

    public void criandoBanco() {
        Connection conexao = null;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null, "Driver nao localizado: " + Driver);
        } catch (SQLException Fonte) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com a fonte de dados: " + Fonte);
        }

        String insert = "CREATE DATABASE IF NOT EXISTS ";
        String banco = "aquasense";

        try {
            if (conexao != null) {
                java.sql.Statement statement = conexao.createStatement();
                statement.execute(insert + banco);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao criar banco de dados: " + sqle.getMessage());
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException fecha) {
                    JOptionPane.showMessageDialog(null, "Não foi possível fechar o banco de dados: " + fecha);
                }
            }
        }

        criandoTabela("Usuarios", Usuarios);
        criandoTabela("Dimensão", Dimensao);
        criandoTabela("Tanque", Tanque);
        criandoTabela("Sensores", Sensores);
        criandoTabela("Sensor de Ph", SenPH);
        criandoTabela("Sensor de Oxigenio Dissolvido", SenOD);
        criandoTabela("Sensor de Temperatura", SenTemp);
        criandoTabela("Peixe", Peixe);
    }

    public void criandoTabela(String Nome, String table) {

        try (Connection conexao = DriverManager.getConnection(url + "aquasense", usuario, senha)) {
            if (conexao != null) {
                java.sql.Statement statement = conexao.createStatement();
                statement.execute(table);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao criar tabela " + Nome + ":" + sqle.getMessage());
        }

    }
}
