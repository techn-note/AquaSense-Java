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
public class DadosSensorDAO {
    
    public List<DadosSensor> obterDadosSensor(ResultSet resultSet) {
        List<DadosSensor> dadosSensores = new ArrayList<>();

        try {
            while (resultSet.next()) {
               
                dadosSensores.add(new DadosSensor(resultSet.getInt("Ciclo"),
                        resultSet.getString("Nome"),
                        resultSet.getDouble("valor"), 
                        resultSet.getDouble("valor"),
                        resultSet.getDouble("valor"),
                        resultSet.getTimestamp("data_hora_leitura")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dadosSensores;
    }
}
    