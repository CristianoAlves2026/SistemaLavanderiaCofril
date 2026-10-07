/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Modelo;

import br.com.ConexaoBancoDados.ConexaoSql;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lavanderia
 */
public class ModeloPreencheComboBox {

    /**
     * @return the encarregado
     */
    public String getEncarregado() {
        return encarregado;
    }

    /**
     * @param encarregado the encarregado to set
     */
    public void setEncarregado(String encarregado) {
        this.encarregado = encarregado;
    }

   

    private int idestoque;
    private int coduniforme;
    private int codtam;
    private int codempresa;
    private int coddepartamento;
    private int codcargo;
    private int status;
    private int saldo;
    private int numinicial;
    private int numfinal;
    private int numinicial2;
    private int numfinal2;
    private String encarregado;

    ArrayList listau = new ArrayList();
    ArrayList listat = new ArrayList();
    ArrayList listae = new ArrayList();
    ArrayList listad = new ArrayList();
    ArrayList listac = new ArrayList();
    ArrayList listas = new ArrayList();
    ConexaoSql conexao = new ConexaoSql();

    
    public ArrayList preencheUniformes() {
        conexao.getConexaoSql();
        conexao.executaSql("select * from uniformes order by uni_descricao");
        listau.add("Selecione");
        try {
            conexao.rs.first();

            do {
                listau.add(conexao.rs.getString("uni_descricao"));
            } while (conexao.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jComboBox uniformes");
        }
        return listau;

    }

    public String buscaCodigoUniformes(String uniforme) {
        conexao.getConexaoSql();

        conexao.executaSql("select * from uniformes where uni_descricao= '" + uniforme + "' ");
        try {
            conexao.rs.first();
            this.coduniforme = conexao.rs.getInt("uni_cod");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao capturar codigo do uniforme.");
        }
        int coduni = this.coduniforme;
        conexao.FecharConexao();
        return Integer.toString(coduni);

    }

    public ArrayList preencheTamamhos() {
        conexao.getConexaoSql();
        conexao.executaSql("select * from tamanhos order by tam_ordem");
        listat.add("Selecione");
        try {
            conexao.rs.first();

            do {
                listat.add(conexao.rs.getString("tam_sigla"));
            } while (conexao.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jComboBox tamanhos.");
        }
        return listat;

    }

    public String buscaCodigoTamanhos(String tamanhos) {
        conexao.getConexaoSql();

        conexao.executaSql("select * from tamanhos where tam_sigla= '" + tamanhos + "' ");
        try {
            conexao.rs.first();
            this.codtam = conexao.rs.getInt("tam_cod");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao capturar codigo do tamanho.");
        }
        int codtam = this.codtam;
        conexao.FecharConexao();
        return Integer.toString(codtam);

    }

    public ArrayList preencheEmpresas() {
        conexao.getConexaoSql();
        conexao.executaSql("select * from empresas order by emp_razao");
        listae.add("Selecione");
        try {
            conexao.rs.first();

            do {
                listae.add(conexao.rs.getString("emp_razao"));
            } while (conexao.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jComboBox empresas.");
        }
        return listae;
    }

    public String buscaCodigoempreas(String empresa) {
        conexao.getConexaoSql();

        conexao.executaSql("select * from empresas where emp_razao= '" + empresa + "' ");
        try {
            conexao.rs.first();
            this.setCodempresa(conexao.rs.getInt("emp_cod"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao capturar codigo da empresa.");
        }
        int codemp = this.getCodempresa();
        conexao.FecharConexao();
        return Integer.toString(codemp);

    }

    public ArrayList preencheDepartamentos() {
        conexao.getConexaoSql();
        conexao.executaSql("select * from departamentos order by dep_descricao");
        listad.add("Selecione");
        try {
            conexao.rs.first();

            do {
                listad.add(conexao.rs.getString("dep_descricao"));
            } while (conexao.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jComboBox departamentos.");
        }
        return listad;
    }

    public String buscaCodigoDepartamentos(String departamento) {
        conexao.getConexaoSql();

        conexao.executaSql("select * from departamentos where dep_descricao= '" + departamento + "' ");
        try {
            conexao.rs.first();
            this.setCoddepartamento(conexao.rs.getInt("dep_cod"));
            this.setEncarregado(conexao.rs.getString("dep_encarregado"));
            this.setNuminicial(conexao.rs.getInt("num_inicial"));
            this.setNumFinal(conexao.rs.getInt("num_final"));
            this.setNuminicial2(conexao.rs.getInt("num_inicial2"));
            this.setNumFinal2(conexao.rs.getInt("num_final2"));
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao capturar codigo do departamento.");
        }
        int coddep = this.getCoddepartamento();
        conexao.FecharConexao();
        return Integer.toString(coddep);

    }

    public ArrayList preencheCargos() {
        conexao.getConexaoSql();
        conexao.executaSql("select * from cargos order by car_descricao");
        listac.add("Selecione");
        try {
            conexao.rs.first();

            do {
                listac.add(conexao.rs.getString("car_descricao"));
            } while (conexao.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jComboBox cargos.");
        }
        return listac;
    }

    public String buscaCodigoCargos(String cargo) {
        conexao.getConexaoSql();

        conexao.executaSql("select * from cargos where car_descricao= '" + cargo + "' ");
        try {
            conexao.rs.first();
            this.setCodcargo(conexao.rs.getInt("car_cod"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao capturar codigo do cargo.");
        }
        int codcar = this.getCodcargo();
        conexao.FecharConexao();
        return Integer.toString(codcar);

    }
    
    public ArrayList preencheStatus() {
        conexao.getConexaoSql();
        conexao.executaSql("select * from status order by sta_descricao");
        listas.add("Selecione");
        try {
            conexao.rs.first();

            do {
                listas.add(conexao.rs.getString("sta_descricao"));
            } while (conexao.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jComboBox status.");
        }
        return listas;
    }
    
    public String buscaCodigoStatus(String cargo) {
        conexao.getConexaoSql();

        conexao.executaSql("select * from status where sta_descricao= '" + cargo + "' ");
        try {
            conexao.rs.first();
            this.setStatus(conexao.rs.getInt("sta_cod"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao capturar codigo do status.");
        }
        int codsta = this.getStatus();
        conexao.FecharConexao();
        return Integer.toString(codsta);

    }

    /**
     * @return the coduniforme
     */
    public int getCoduniforme() {
        return coduniforme;
    }

    /**
     * @param coduniforme the coduniforme to set
     */
    public void setCoduniforme(int coduniforme) {
        this.coduniforme = coduniforme;
    }

    public int getCodtam() {
        return codtam;
    }

    /**
     * @param codtam the codtam to set
     */
    public void setCodtam(int codtam) {
        this.codtam = codtam;
    }

    /**
     * @return the codempresa
     */
    public int getCodempresa() {
        return codempresa;
    }

    /**
     * @param codempresa the codempresa to set
     */
    public void setCodempresa(int codempresa) {
        this.codempresa = codempresa;
    }

    /**
     * @return the coddepartamento
     */
    public int getCoddepartamento() {
        return coddepartamento;
    }
    
    public int getNuminicial() {
        return numinicial;
    }
    
    public int getNuminicial2() {
        return numinicial2;
    }
    
    public int getNumfinal() {
        return numfinal;
    }
    
    public int getNumfinal2() {
        return numfinal2;
    }

    /**
     * @param coddepartamento the coddepartamento to set
     */
    public void setCoddepartamento(int coddepartamento) {
        this.coddepartamento = coddepartamento;
    }
    
    public void setNuminicial(int numinicial) {
        this.numinicial = numinicial;
    }
    
    public void setNuminicial2(int numinicial2) {
        this.numinicial2 = numinicial2;
    }
    
    public void setNumFinal(int numfinal) {
        this.numfinal = numfinal;
    }
    
    public void setNumFinal2(int numfinal2) {
        this.numfinal2 = numfinal2;
    }

    /**
     * @return the codcargo
     */
    public int getCodcargo() {
        return codcargo;
    }

    /**
     * @param codcargo the codcargo to set
     */
    public void setCodcargo(int codcargo) {
        this.codcargo = codcargo;
    }

    /**
     * @return the saldo
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the idestoque
     */
    public int getIdestoque() {
        return idestoque;
    }

    /**
     * @param idestoque the idestoque to set
     */
    public void setIdestoque(int idestoque) {
        this.idestoque = idestoque;
    }
    
     /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    
}
