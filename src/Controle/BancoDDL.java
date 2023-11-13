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
            + "Data_hora_Instalacao DATETIME, "
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

    final private String usuarioSQL = "INSERT INTO Usuarios (Nome, Email, Senha, Telefone) VALUES"
            + "    ('Usuario1', 'usuario1@email.com', 'senha1', '1234567890'),"
            + "    ('Usuario2', 'usuario2@email.com', 'senha2', '9876543210'),"
            + "    ('Usuario3', 'usuario3@email.com', 'senha3', '1112223333'),"
            + "    ('Usuario4', 'usuario4@email.com', 'senha4', '4445556666'),"
            + "    ('Usuario5', 'usuario5@email.com', 'senha5', '7778889999')"
            + " ON DUPLICATE KEY UPDATE Email=VALUES(Email)";

    final private String dimensaoSQL = 
        "INSERT INTO Dimensao (Comprimento, Largura, Profundidade) VALUES\n" +
        "(5.0, 3.0, 2.0),\n" +
        "(4.0, 2.5, 1.8),\n" +
        "(6.0, 3.5, 2.2),\n" +
        "(4.5, 2.8, 2.0),\n" +
        "(5.5, 3.2, 2.5);";

    final private String tanqueSQL = 
        "INSERT INTO Tanque (Nome, Capacidade, Data_hora_Instalacao, fk_Dimensao_Id_Dimensao, fk_Usuario_Id_Usuario) VALUES\n" +
        "('Tanque1', 1000.0, '2023-01-01 10:00:00', 1, 1),\n" +
        "('Tanque2', 800.0, '2023-01-02 12:30:00', 2, 2),\n" +
        "('Tanque3', 1200.0, '2023-01-03 14:15:00', 3, 3),\n" +
        "('Tanque4', 950.0, '2023-01-04 16:45:00', 4, 4),\n" +
        "('Tanque5', 1100.0, '2023-01-05 18:30:00', 5, 5);";

    final private String sensoresSQL = 
        "INSERT INTO Sensores (fk_Tanque_Id_Tanque) VALUES\n" +
        "(1),\n" +
        "(2),\n" +
        "(3),\n" +
        "(4),\n" +
        "(5);";

    final private String senPHSQL = 
        "INSERT INTO SenPH (Data_hora_leitura, Valor, fk_Sensores_Id_Sensores) VALUES\n" +
        "('2023-01-01 10:15:00', 7.2, 1),\n" +
        "('2023-01-02 12:45:00', 7.5, 2),\n" +
        "('2023-01-03 14:30:00', 7.0, 3),\n" +
        "('2023-01-04 16:55:00', 6.8, 4),\n" +
        "('2023-01-05 18:45:00', 7.3, 5);";

    final private String senODSQL = 
        "INSERT INTO SenOD (Data_hora_leitura, Valor, fk_Sensores_Id_Sensores) VALUES\n" +
        "('2023-01-01 10:20:00', 5.0, 1),\n" +
        "('2023-01-02 13:00:00', 4.8, 2),\n" +
        "('2023-01-03 14:45:00', 5.2, 3),\n" +
        "('2023-01-04 17:00:00', 5.5, 4),\n" +
        "('2023-01-05 19:00:00', 4.9, 5);";

    final private String senTempSQL = 
        "INSERT INTO SenTemp (Data_hora_leitura, Valor, fk_Sensores_Id_Sensores) VALUES\n" +
        "('2023-01-01 10:25:00', 28.0, 1),\n" +
        "('2023-01-02 13:15:00', 27.5, 2),\n" +
        "('2023-01-03 15:00:00', 28.2, 3),\n" +
        "('2023-01-04 17:15:00', 26.8, 4),\n" +
        "('2023-01-05 19:15:00', 27.9, 5);";

    final private String peixeSQL = 
        "INSERT INTO Peixe (Idade, Peso, Comprimento, Ciclo, fk_Tanque_Id_Tanque) VALUES\n" +
        "(1, 0.3, 10.0, 1, 1),\n" +
        "(2, 0.5, 12.0, 2, 2),\n" +
        "(3, 0.6, 13.0, 3, 3),\n" +
        "(4, 0.7, 14.0, 4, 4),\n" +
        "(5, 0.8, 15.0, 5, 5);";

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

    public void inserindoDados() {
        try (Connection conexao = DriverManager.getConnection(url + "aquasense", usuario, senha)) {
            if (conexao != null) {
                try (Statement statement = conexao.createStatement()) {
                    statement.executeUpdate(usuarioSQL);
                    statement.executeUpdate(dimensaoSQL);
                    statement.executeUpdate(tanqueSQL);
                    statement.executeUpdate(sensoresSQL);
                    statement.executeUpdate(senPHSQL);
                    statement.executeUpdate(senTempSQL);
                    statement.executeUpdate(peixeSQL);
                }
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados na tabela Usuarios: " + sqle.getMessage());
        }
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
