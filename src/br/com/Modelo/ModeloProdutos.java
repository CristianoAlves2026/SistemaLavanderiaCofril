/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import br.com.ConexaoBancoDados.ConexaoSql;
/**
 *
 * @author Lavanderia
 */
public class ModeloProdutos {
    
    private int idproduto;
    private String nometecnico;
    private String descricao;
    private int idlancamento;
    private Date datainicial;
    private Date datafinal;
    private int litros;
    private int dias;
    private int maquina;
            
    ConexaoSql conexao = new ConexaoSql();
    ArrayList listaprodutos = new ArrayList();
   
    
    public ArrayList preencheProdutos() {
        conexao.getConexaoSql();
        conexao.executaSql("select * from produtos order by prod_descricao");
        listaprodutos.add("Selecione");
        try {
            conexao.rs.first();

            do {
                listaprodutos.add(conexao.rs.getString("prod_descricao"));
            } while (conexao.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jComboBox uniformes");
        }
        return listaprodutos;

    }

    /**
     * @return the idproduto
     */
    public int getIdproduto() {
        return idproduto;
    }

    /**
     * @param idproduto the idproduto to set
     */
    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    /**
     * @return the nometecnico
     */
    public String getNometecnico() {
        return nometecnico;
    }

    /**
     * @param nometecnico the nometecnico to set
     */
    public void setNometecnico(String nometecnico) {
        this.nometecnico = nometecnico;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the idlancamento
     */
    public int getIdlancamento() {
        return idlancamento;
    }

    /**
     * @param idlancamento the idlancamento to set
     */
    public void setIdlancamento(int idlancamento) {
        this.idlancamento = idlancamento;
    }

    /**
     * @return the datainicial
     */
    public Date getDatainicial() {
        return datainicial;
    }

    /**
     * @param datainicial the datainicial to set
     */
    public void setDatainicial(Date datainicial) {
        this.datainicial = datainicial;
    }

    /**
     * @return the datafinal
     */
    public Date getDatafinal() {
        return datafinal;
    }

    /**
     * @param datafinal the datafinal to set
     */
    public void setDatafinal(Date datafinal) {
        this.datafinal = datafinal;
    }

    /**
     * @return the litros
     */
    public int getLitros() {
        return litros;
    }

    /**
     * @param litros the litros to set
     */
    public void setLitros(int litros) {
        this.litros = litros;
    }

    /**
     * @return the dias
     */
    public int getDias() {
        return dias;
    }

    /**
     * @param dias the dias to set
     */
    public void setDias(int dias) {
        this.dias = dias;
    }

    public void getDatafinal(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public int getMaquina() {
        return maquina;
    }

    /**
     * @param maquina the litros to set
     */
    public void setMaquina(int maquina) {
        this.maquina = maquina;
    }
    
    
}
