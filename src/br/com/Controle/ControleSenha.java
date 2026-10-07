/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controle;

import br.com.ConexaoBancoDados.ConexaoSql;
import br.com.Modelo.ModeloSenha;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Lavanderia
 */
public class ControleSenha {
    ConexaoSql conexao = new ConexaoSql();
    public static final int MYSQL_DUPLICATE_PK = 1062;

public void novo(ModeloSenha modelosenha){
    conexao.getConexaoSql();
        try {
            PreparedStatement pst = conexao.connection.prepareStatement("insert into usuarios (usu_usuario, usu_senha, usu_nome, usu_nivel, usu_num_nivel, usu_status, usu_perfil) values (?,?,?,?,?,?,?) ");
            pst.setString(1, modelosenha.getUsuario());
            pst.setString(2, modelosenha.getSenha());
            pst.setString(3, modelosenha.getNome());
            pst.setString(4, modelosenha.getNivel());
            pst.setInt(5, modelosenha.getNumnivel());
            pst.setString(6, modelosenha.getStatus());
            pst.setString(7, "CLARO");
            
            pst.execute();
           
        } catch (SQLException ex) {
            if (ex.getErrorCode() == MYSQL_DUPLICATE_PK){
                JOptionPane.showMessageDialog(null, "Usuário já cadastrado. ");
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar novo usuário. " + ex);
            }
        }
        
        
        conexao.FecharConexao();
}

public void AlterarSenha(ModeloSenha modelosenha){
        conexao.getConexaoSql();
        
        try {
                   
            PreparedStatement pst = conexao.connection.prepareStatement("update usuarios set usu_senha=? where usu_cod=?");
            pst.setString(1, modelosenha.getSenha());
            pst.setInt(2, modelosenha.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Senha alterada com sucessos. \n \n" );
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Erro na alteração da senha. \n \n" + ex);
        }
        
       conexao.FecharConexao();
        
    }
 
public void editar(ModeloSenha modelosenha){
        conexao.getConexaoSql();
        
        try {
                   
            
            PreparedStatement pst = conexao.connection.prepareStatement("update usuarios set usu_usuario=?, usu_nome=?, usu_nivel=?, usu_status=?, usu_num_nivel=? where usu_cod=?");
            pst.setString(1, modelosenha.getUsuario());
            pst.setString(2, modelosenha.getNome());
            pst.setString(3, modelosenha.getNivel());
            pst.setString(4, modelosenha.getStatus());
            pst.setInt(5, modelosenha.getNumnivel());
            pst.setInt(6, modelosenha.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucessos. \n \n" );
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Erro na alteração do dados. \n \n" + ex);
        }
        
       conexao.FecharConexao();
        
    }

}
