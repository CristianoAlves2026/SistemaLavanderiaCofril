/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controle;

import br.com.ConexaoBancoDados.ConexaoSql;
import br.com.Modelo.ModeloMovimentaEstoque;
import br.com.Modelo.ModeloPreencheComboBox;
import br.com.Visao.TelaLogin;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Lavanderia
 */
public class ControleMovimentaEstoque {
    ConexaoSql conexao = new ConexaoSql();
    //ModeloPreencheComboBox modpree = new ModeloPreencheComboBox();
    
    public void salvar(ModeloMovimentaEstoque modestoque){
        conexao.getConexaoSql();
        
        try {
            PreparedStatement pst = conexao.connection.prepareStatement("insert into movimenta_estoque (mov_data, mov_uni_cod, mov_tam_cod, mov_emp_cod, mov_dep_cod, mov_car_cod, mov_entrada, mov_saida, mov_historico, mov_lan_cod, mov_usuario_cod) values (?,?,?,?,?,?,?,?,?,?,?)");
            
            pst.setDate(1, new java.sql.Date(modestoque.getData().getTime()));
            pst.setInt(2, modestoque.getUnicod());
            pst.setInt(3, modestoque.getTamcod());
            pst.setInt(4, modestoque.getEmpcod());
            pst.setInt(5, modestoque.getDepcod());
            pst.setInt(6, modestoque.getCarcod());
            pst.setInt(7, modestoque.getEntrada());
            pst.setInt(8, modestoque.getSaida());
            pst.setString(9, modestoque.getHistorico());
            pst.setInt(10, modestoque.getLancod());
            pst.setInt(11, TelaLogin.usuariocod);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Movimentação de estoque cadastrada com sucesso.");
            
            
            PreparedStatement pst2 = conexao.connection.prepareStatement("update estoque set est_quantidade=? where est_cod=?");
            pst2.setInt(1, modestoque.getSaldo());
            pst2.setInt(2, modestoque.getCodigo());
            pst2.execute();
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar movimentação de estoque \n\n." + ex);
        }
        
        
        conexao.FecharConexao();
    }
    
    
    public int BuscaEstoque(ModeloPreencheComboBox modpreenche){
        conexao.getConexaoSql();
        conexao.executaSql("Select * from estoque where est_uni_cod ='"+ modpreenche.getCoduniforme() +"' and est_tam_cod ='"+ modpreenche.getCodtam() +"' ");
        try {
           conexao.rs.first();
           modpreenche.setSaldo(conexao.rs.getInt("est_quantidade"));
           modpreenche.setIdestoque(conexao.rs.getInt("est_cod"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar saldo em estoque. \n\n.");
            try {
                PreparedStatement pst = conexao.connection.prepareStatement("insert into estoque (est_uni_cod, est_tam_cod, est_quantidade, est_minimo) values (?,?,?,?)");
                pst.setInt(1, modpreenche.getCoduniforme());
                pst.setInt(2, modpreenche.getCodtam());
                pst.setInt(3, 0);
                pst.setInt(4, 0);

                pst.execute();
                JOptionPane.showMessageDialog(null, "Uniforme gravado na tabela uniformes com saldo zero. \n \n Selecione tamanho novamente e cadastre unifomres no estoque.");
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, "Erro ao gravar uniforme com saldo zero.");
            }
            modpreenche.setSaldo(-1);            
        }
        
        conexao.FecharConexao();
        return modpreenche.getSaldo();
    }
    
    
    
}
