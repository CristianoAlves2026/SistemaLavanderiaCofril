/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ConexaoBancoDados;

import java.sql.*;
import javax.swing.JOptionPane;


public class ConexaoSql {
    //ATRIBUTOS
    public String status; 
    public Connection connection = null;    
    public Statement stm;
    public ResultSet rs;
    public ResultSet rs_u;
    public ResultSet rs_t;
    public String nomebanco = "bdlavanderia";
    
    
    
//METODO CONSTRUTOR
    public ConexaoSql() {
    }
    
    public void executaSql(String sql){
        try {
            stm = connection.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Executar SQL \n" + ex.getMessage());
        }
        
    }
    
    
    public void executaSqlu(String sql){
        try {
            stm = connection.createStatement(rs_u.TYPE_SCROLL_INSENSITIVE, rs_u.CONCUR_READ_ONLY);
            rs_u = stm.executeQuery(sql);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Executar SQL-Uniformes \n" + ex.getMessage());
        }
        
    }

      public void executaSqlt(String sql){
        try {
            stm = connection.createStatement(rs_t.TYPE_SCROLL_INSENSITIVE, rs_t.CONCUR_READ_ONLY);
            rs_t = stm.executeQuery(sql);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Executar SQL \n" + ex.getMessage());
        }
    }
    
    
    
    //METODO DE CONEXAO
    public void getConexaoSql(){
      
        try {
            //CARREGANDO O JDBC PADRAO  
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);  // REGISTRA O DRIVER https://www.guj.com.br/t/jdbc-class-forname-pq/40408/2
            
                              
            //CONFIGURANDO CONEXAO COM O BANCO DE DADOS
            String nomeservidor = "localhost";   //CAMINHO DO SERVIDOR DE BANCO DE DADOS
            //nomebanco = "TESTE"; // bdlavanderia";
            String url = "jdbc:mysql://" + nomeservidor + "/" + nomebanco + "?zeroDateTimeBehavior=convertToNull";
            //?zeroDateTimeBehavior=convertToNull -> trata erro de data 000/00/00 que sql.date não aceita. ou é uma data ou é null
            
            String nomeusuario = "root";
             // String nomeusuario = "cristiano";            
            String senha = "";
              //String senha = "1979";  
            
            connection = DriverManager.getConnection(url, nomeusuario, senha);
            
             if (connection != null) {
                status = "Conectado com sucesso!"; 
            }else{
                status = "Não Conectado!";
            }
                    
            
        } catch (ClassNotFoundException e) {  //Driver não encontrado {
            //NAO LOCALIZOU O DRIVER
            JOptionPane.showMessageDialog(null, "O Driver especificado não foi encontrado.");
            
            
        } catch (SQLException e) {
            //NAO CONSEGUIU CONECTAR AO BANCO    
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.");
            
            
        }
    }
    
    //METODO QUE RETORNA O STATUS DA CONEXAO
        public String statusConnection(){
          
            return status;
        }
        
    //METODO QUE FECHA SUA CONEXAO
        public Boolean FecharConexao(){
            
            try{
                connection.close();
                //JOptionPane.showMessageDialog(null, "Conexão encerrada.");
                return true;
                    
            }catch (SQLException e) {
                return false;
        }
    }
     //Método que reinicia sua conexão//
 
    public Connection ReiniciarConexao() {
            
        FecharConexao();
        getConexaoSql();
        
   
        return connection;
    
    } 
    
 
    
            
}
