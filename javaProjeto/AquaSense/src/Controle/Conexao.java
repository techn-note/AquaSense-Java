/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author dsm2
 */
public class Conexao {
        
    final private String driver = "com.mysql.jdbc.Driver";
   
    final private String url= "jdbc:mysql://127.0.0.1/aquasense";
    
    final private String usuario="root";
    final private String senha="";
    private Connection conexao;// objeto que faz conexao com o banco
    public Statement statement;// objeto que abre caminho até o banco
    public ResultSet resultset;// objeto que armazena os comandos sql   
    
    public boolean conecta() {  
        boolean result = true;  
  
        try {  
            Class.forName(driver);  
            conexao = DriverManager.getConnection(url,usuario,senha);
            //JOptionPane.showMessageDialog(null,"Conectou com o Banco de Dados");
            
        } catch(ClassNotFoundException Driver){
               JOptionPane.showMessageDialog(null,"Driver nao localizado: "+Driver);
               result = false;
        }catch(SQLException Fonte) {
                JOptionPane.showMessageDialog(null,"Erro na conexão com a fonte de dados: "+Fonte);
                result = false;
            }
        return result;  
    }
    
     public void desconecta (){
        boolean result = true;
        try
        {
            conexao.close();
            //JOptionPane.showMessageDialog(null,"Banco fechado");
        }
        catch(SQLException fecha)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel fechar o banco de dados"+ fecha);
            result = false;
        }
    }
     
     public void executeSQL(String sql){
//chamada do metodo conecta para abrir a conexão com o db
        conecta();
        try{
    
        statement = conexao.createStatement();

        statement.execute(sql);
        //desconecta();
        }catch(SQLException sqle){
           JOptionPane.showMessageDialog(null, "Driver não encontrado1" + sqle.getMessage());
        }
}
    
    public ResultSet RetornarResultset(String sql){
         ResultSet resultSet = null;
         conecta();
         try{
         statement = conexao.createStatement();
         resultSet = statement.executeQuery(sql);
         resultSet.next();
         }catch (Exception e){
         JOptionPane.showMessageDialog(null, "Erro ao retornar resultset"+e.getMessage());
         }
         return resultSet;
 }
    public void cadastrar(String nome, String email, String senha) { // Corrigido para "senha"
    try {
        // Substitua 'sua_tabela' pelo nome da tabela em seu banco de dados
        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";
        
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, nome);
        statement.setString(2, email);
        statement.setString(3, senha); // Usando a variável "senha"

        // Executar a inserção
        statement.executeUpdate();
        System.out.println("Cadastro realizado com sucesso!");
    } catch (SQLException e) {
        System.err.println("Erro ao cadastrar: " + e.getMessage());
    }
}
    
    public boolean fazerLogin(String email, String senha) {
    boolean sucesso = false;
    try {
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
        
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, senha);

        ResultSet resultSet = statement.executeQuery();

        sucesso = resultSet.next();

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        System.err.println("Erro ao fazer login: " + e.getMessage());
    }
    return sucesso;
}


}
