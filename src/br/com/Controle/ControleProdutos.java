/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controle;

import br.com.ConexaoBancoDados.ConexaoSql;
import br.com.Modelo.ModeloDatas;
import br.com.Modelo.ModeloFuncionario;

import br.com.Modelo.ModeloProdutos;
import br.com.Visao.TelaLogin;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Lavanderia
 */
public class ControleProdutos {

    ConexaoSql conexao = new ConexaoSql();
    SimpleDateFormat dataformatada = new SimpleDateFormat("dd/MM/yyyy");
    ModeloDatas diasuso = new ModeloDatas();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy   HH:mm:ss");

    public void novo(ModeloProdutos modelobaixar) {
        conexao.getConexaoSql();

        try {

            PreparedStatement pst = conexao.connection.prepareStatement("insert into produtos_lancamentos (prod_id, maquina, data_inicio, litros) values (?,?,?,?) ");
            pst.setInt(1, modelobaixar.getIdproduto());
            pst.setInt(2, modelobaixar.getMaquina());
            pst.setDate(3, new java.sql.Date(modelobaixar.getDatainicial().getTime()));
            pst.setInt(4, modelobaixar.getLitros());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Novo produto cadastrado com sucesso.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar novo produto." + ex);
        }

        conexao.FecharConexao();
    }

    public void baixar(ModeloProdutos modelobaixar) {
        conexao.getConexaoSql();

        try {

            PreparedStatement pst = conexao.connection.prepareStatement("update produtos_lancamentos set data_fim=?, dias=? where lan_id=? ");
            pst.setDate(1, new java.sql.Date(modelobaixar.getDatafinal().getTime()));
            pst.setInt(2, (modelobaixar.getDias()));
            pst.setInt(3, modelobaixar.getIdlancamento());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Produto baixado com sucesso. \n \n");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao baixar produto. \n \n" + ex);
        }

        conexao.FecharConexao();

    }
    
    public void cancelarbaixar(ModeloProdutos modelobaixar) {
        conexao.getConexaoSql();

        try {

            PreparedStatement pst = conexao.connection.prepareStatement("update produtos_lancamentos set data_fim=?, dias=? where lan_id=? ");
            pst.setDate(1, null);
            pst.setInt(2, 0);
            pst.setInt(3, modelobaixar.getIdlancamento());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Baixa do produto cancelada com sucesso. \n \n");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao cancelar produto. \n \n" + ex);
        }

        conexao.FecharConexao();

    }

    public void excluir(ModeloProdutos modelobaixar) {
        conexao.getConexaoSql();
        try {

            PreparedStatement pst = conexao.connection.prepareStatement("delete from produtos_lancamentos where lan_id=?");
            pst.setInt(1, modelobaixar.getIdlancamento());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Produto excluido com sucesso. \n \n ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir dados. \n \n " + ex);
        }

        conexao.FecharConexao();
    }

    public int buscacodigoproduto(ModeloProdutos modelobaixar) {
        conexao.getConexaoSql();
        conexao.executaSql("select * from produtos where prod_nometecnico = '"+ modelobaixar.getNometecnico() +"' order by prod_id");
        try {
            conexao.rs.first();
            modelobaixar.setIdproduto(conexao.rs.getInt("prod_id"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar codigo do produto.");
        }

        conexao.FecharConexao();
        return modelobaixar.getIdproduto();
    }
}
