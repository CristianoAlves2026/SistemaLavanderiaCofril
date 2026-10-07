/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controle;

import br.com.ConexaoBancoDados.ConexaoSql;
import br.com.Modelo.ModeloConferencia;
import br.com.Modelo.ModeloFuncionario;
import br.com.Visao.TelaLogin;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lavanderia
 */
public class ControleConferenciaDetalhada {
    ConexaoSql conexao = new ConexaoSql();
    
    public ModeloConferencia buscaObsFuncionario(ModeloConferencia confere) {
        conexao.getConexaoSql();
        conexao.executaSql("select fun_num, fun_obs from funcionarios where fun_num = '" + confere.getConfnum() +"' ");
        
        try {
            conexao.rs.first();
            confere.setConfnum(conexao.rs.getInt("fun_num"));
            confere.setConfobs(conexao.rs.getString("fun_obs"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Número de funcionário não encontrado na tabela de funcionários.");
            confere.setConfobs("not"); // se não encontrar o número do funcionario retorna not para encerrar.
        }

        conexao.FecharConexao();
        return confere;
    }
    
    public void novo(ModeloConferencia confere){
        conexao.getConexaoSql();
        try {
            PreparedStatement pst = conexao.connection.prepareStatement("insert into cadastro_conferencia_detail (cadconf_empresa, cadconf_data) values (?,?) ");
            pst.setInt(1, confere.getCadconfemp());
            pst.setDate(2, new java.sql.Date(confere.getCadconfdata().getTime()));
            pst.execute();
            
            //JOptionPane.showMessageDialog(null, "Nova conferência cadastrada com sucesso.");
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar nova conferência." + ex);
        }

        conexao.FecharConexao();
        
    }
    
    public ModeloConferencia AtualizaQtd(ModeloConferencia confere) {
        conexao.getConexaoSql();
        conexao.executaSql("select count(conf_id_cadastro) from conferencia_detail where conf_status = 'OK' and conf_id_cadastro = '"+ confere.getConfidcadastro()+ "'");
        
        try {
            conexao.rs.first();
            confere.setConftotal(conexao.rs.getInt("count(conf_id_cadastro)"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na totalização. \n \n");
        }

        conexao.FecharConexao();
        return confere;
    }
    
    public ModeloConferencia buscaNumFuncionario(ModeloConferencia confere) {
        conexao.getConexaoSql();
        conexao.executaSql("select conf_cod, conf_numero, conf_status from conferencia_detail where conf_numero = '" + confere.getConfnum() +"' and conf_id_cadastro = '"+confere.getCadconfcod()+"' ");
        
        try {
            conexao.rs.first();
            confere.setConfnum(conexao.rs.getInt("conf_numero"));
            confere.setConfcod(conexao.rs.getInt("conf_cod"));
            confere.setConfstatus(conexao.rs.getString("conf_status"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Número de funcionário não encontrado \n \n");
            confere.setConfnum(-1);
        }

        conexao.FecharConexao();
        return confere;
    }
    
    public void marcapeca(ModeloConferencia confere) {
        conexao.getConexaoSql();

        try {

            PreparedStatement pst = conexao.connection.prepareStatement("update conferencia_detail set conf_status=?, touca=?, blusa=?, calça=?, conf_obs=? where conf_cod=?");
            pst.setString(1, confere.getConfstatus());
            pst.setString(2, confere.getTouca());
            pst.setString(3, confere.getBlusa());
            pst.setString(4, confere.getCalça());
             pst.setString(5, confere.getConfobs());
            pst.setInt(6, confere.getConfcod());
            pst.execute();
            
            //JOptionPane.showMessageDialog(null, "Roupa marcada com sucessos. \n \n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na marcação da roupa. \n \n" + ex);
        }

        conexao.FecharConexao();

    }
    
}
