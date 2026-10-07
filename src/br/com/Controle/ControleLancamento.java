/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controle;

import br.com.ConexaoBancoDados.ConexaoSql;
import br.com.Modelo.ModeloDatas;
import br.com.Modelo.ModeloFuncionario;
import br.com.Modelo.ModeloLancamento;
import br.com.Modelo.ModeloPreencheComboBox;
import br.com.Visao.TelaLogin;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Lavanderia
 */
public class ControleLancamento {

    
    ConexaoSql conexao = new ConexaoSql();
    SimpleDateFormat dataformatada = new SimpleDateFormat("dd/MM/yyyy");
    ModeloDatas diasuso = new ModeloDatas();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy   HH:mm:ss");
    

    public  ControleLancamento(){
       
       
    }
    
    public void novo(ModeloLancamento modelonovo) {
        conexao.getConexaoSql();
        
        try {
            
            PreparedStatement pst = conexao.connection.prepareStatement("insert into lancamentos (lan_fun_num, lan_letra, lan_data_entrega, lan_uni_cod, lan_tam_cod, lan_sta_cod, lan_tipo, lan_historico, lan_fun_cod, lan_usuario_cod) values (?,?,?,?,?,?,?,?,?,?) ");
            pst.setInt(1, modelonovo.getLannumero());
            pst.setString(2, modelonovo.getLanletra());
            pst.setDate(3, new java.sql.Date(modelonovo.getLanentrega().getTime()));
            pst.setInt(4, modelonovo.getLanuniforme());
            pst.setInt(5, modelonovo.getLantamanho());
            pst.setInt(6, modelonovo.getLanstatus());
            pst.setString(7, modelonovo.getLantipo());
            pst.setString(8, modelonovo.getLanhistorico());
            pst.setInt(9, modelonovo.getLanfuncod());
            pst.setInt(10, TelaLogin.usuariocod); 
            pst.execute();
            
            String barrastatus = modelonovo.getBarrastatus();
            modelonovo.setBarrastatus("NOVO LANÇAMENTO" + " - " + barrastatus);
            JOptionPane.showMessageDialog(null, "Novo lançamento cadastrado com sucesso.");
            //this.recente(modelonovo);
            
            conexao.getConexaoSql();
            conexao.executaSql("select max(lan_cod) from lancamentos");
            conexao.rs.first();
            modelonovo.setLancod(conexao.rs.getInt("max(lan_cod)"));
            RegistroManutencao(modelonovo);
            
        } catch (SQLException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar novo lançamento." + ex);
        }

        conexao.FecharConexao();
    }

    public void baixar(ModeloLancamento modelonovo) {
        conexao.getConexaoSql();
        try {
            PreparedStatement pst = conexao.connection.prepareStatement("update lancamentos set lan_sta_cod=?, lan_data_baixa=?, lan_ult_mov=?, lan_dias_uso=?, lan_historico=?, lan_fun_cod=?, lan_usuario_cod=? where lan_cod=?");
            pst.setInt(1, modelonovo.getLanstatus());
            pst.setDate(2, new java.sql.Date(modelonovo.getLandatabaixa().getTime()));
            pst.setTimestamp(3, null);
            String data1 = dataformatada.format(new java.util.Date());
            String data2 = dataformatada.format(modelonovo.getLanentrega());
            
            int dias = (int) diasuso.CalcularTempoUso(data2, data1);

            pst.setInt(4, dias);
            pst.setString(5, modelonovo.getLanhistorico());
            pst.setInt(6, modelonovo.getLanfuncod());
            pst.setInt(7, TelaLogin.usuariocod); 
            pst.setInt(8, modelonovo.getLancod());
            
            pst.execute();
            
            String barrastatus = modelonovo.getBarrastatus();
            modelonovo.setBarrastatus(modelonovo.getPesquisa() + " - " + barrastatus );
            
            //JOptionPane.showMessageDialog(null, "Lançamento baixado com sucesso.");
           
            
            RegistroManutencao(modelonovo);

        } catch (SQLException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao baixar lançamento." + ex);
        }

        conexao.FecharConexao();
    }

    public void excluir(ModeloLancamento modelonovo) {
        conexao.getConexaoSql();
        try {
            PreparedStatement pst = conexao.connection.prepareStatement("delete from lancamentos where lan_cod=?");
            pst.setInt(1, modelonovo.getLancod());
            pst.execute();
            String barrastatus = modelonovo.getBarrastatus();
            modelonovo.setBarrastatus("EXCLUÍDO" + " - " + barrastatus  );
            JOptionPane.showMessageDialog(null, "Lançamento excluido com sucesso. \n \n ");
            
            RegistroManutencao(modelonovo);
            
            //this.recente(modelonovo);
        } catch (SQLException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao excluir dados. \n \n " + ex);
        }

        conexao.FecharConexao();
    }
    
    public void recente(ModeloLancamento modelonovo) {
        conexao.getConexaoSql();
        try {
            PreparedStatement pst = conexao.connection.prepareStatement("insert into recentes (rec_lancamento) values (?) ");
            pst.setString(1, modelonovo.getBarrastatus());
            pst.execute();

        } catch (SQLException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar lançamento recente." + ex);
        }

        conexao.FecharConexao();
    }

    public void transferir(ModeloLancamento modelonovo, ModeloFuncionario objmodfunc) {
        conexao.getConexaoSql();
        conexao.executaSql("select lan_cod, lan_fun_num, lan_letra, lan_sta_cod, lan_fun_cod from lancamentos where lan_fun_num='" + objmodfunc.getFunnum() + "' and lan_letra='" + modelonovo.getLanletra() + "' and lan_sta_cod=1");
        try {
            conexao.rs.first();
            do {
                try {
                    int id = conexao.rs.getInt("lan_cod");
                    PreparedStatement pst = conexao.connection.prepareStatement("update lancamentos set lan_fun_num=?, lan_fun_cod=? where lan_cod=?");
                    pst.setInt(1, modelonovo.getLannumero());
                    pst.setInt(2, modelonovo.getLanfuncod());
                    pst.setInt(3, id);
                    pst.execute();
                    

                } catch (SQLException ex) {
                    java.awt.Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Nenhum lançamento encotrado para transferir." + ex);
                    return;
                }
            } while (conexao.rs.next());
            JOptionPane.showMessageDialog(null, "Lançamentos transferidos com sucesso.");
        } catch (SQLException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao consultar lançamentos para trasnferência." + ex);
        }
        conexao.FecharConexao();
    }

    public void movimentaEstoque(ModeloPreencheComboBox modpree, ModeloLancamento modelonovo) {

        conexao.getConexaoSql();

        try {
            PreparedStatement pst = conexao.connection.prepareStatement("insert into movimenta_estoque (mov_data, mov_uni_cod, mov_tam_cod, mov_emp_cod, mov_dep_cod, mov_car_cod, mov_entrada, mov_saida, mov_historico, mov_lan_cod, mov_usuario_cod) values (?,?,?,?,?,?,?,?,?,?,?)");

            pst.setDate(1, new java.sql.Date(modelonovo.getLandatabaixa().getTime()));
            pst.setInt(2, modpree.getCoduniforme());
            pst.setInt(3, modpree.getCodtam());
            pst.setInt(4, modpree.getCodempresa());
            pst.setInt(5, modpree.getCoddepartamento());
            pst.setInt(6, modpree.getCodcargo());
            
            if (modelonovo.getLanstatus() == 1) {
                pst.setInt(7, 0);
                pst.setInt(8, 1);
            } else {
                pst.setInt(7, 1);
                pst.setInt(8, 0);
            }
            pst.setString(9, "Func. Nº " + modelonovo.getLannumero() + " - Letra: " + modelonovo.getLanletra());   //historico
            pst.setInt(10, 0); // modelonovo.getLancod());
            pst.setInt(11, TelaLogin.usuariocod); 
            pst.execute();


            PreparedStatement pst2 = conexao.connection.prepareStatement("update estoque set est_quantidade=? where est_cod=?");
            if (modelonovo.getLanstatus() == 1) {
                pst2.setInt(1, modpree.getSaldo() - 1);
            } else {
                pst2.setInt(1, modpree.getSaldo() + 1);
            }
            pst2.setInt(2, modpree.getIdestoque());
            pst2.execute();

        } catch (SQLException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar movimentação de estoque \n\n." + ex);
        }

        conexao.FecharConexao();
    }

    public ModeloPreencheComboBox BuscaEstoque(ModeloPreencheComboBox modpree) {
        conexao.getConexaoSql();
        conexao.executaSql("Select * from estoque where est_uni_cod ='" + modpree.getCoduniforme() + "' and est_tam_cod ='" + modpree.getCodtam() + "' ");
        try {
            conexao.rs.first();
            modpree.setSaldo(conexao.rs.getInt("est_quantidade"));
            modpree.setIdestoque(conexao.rs.getInt("est_cod"));  
        } catch (SQLException ex) {
            modpree.setSaldo(-1);
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao buscar saldo em estoque.");

            conexao.FecharConexao();
        }
        return modpree;

    }
    
    public void modificaLetra(ModeloLancamento modelonovo) {
        conexao.getConexaoSql();
        try {
            PreparedStatement pst = conexao.connection.prepareStatement("update lancamentos set lan_letra=?, lan_usuario_cod=?, lan_ult_mov=? where lan_cod=?");
            pst.setString(1, modelonovo.getLanletra());
            pst.setInt(2, TelaLogin.usuariocod); 
            pst.setTimestamp(3, null);
            pst.setInt(4, modelonovo.getLancod());
            pst.execute();
            
            String barrastatus = modelonovo.getBarrastatus();
            modelonovo.setBarrastatus("LETRA ALTERADA  - " + barrastatus );
            JOptionPane.showMessageDialog(null, "Letra modificada para < " + modelonovo.getLanletra() +  " > com sucesso.");
            //this.recente(modelonovo);
            
            RegistroManutencao(modelonovo);
            
        } catch (SQLException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao modificar letra." + ex);
        }

        conexao.FecharConexao();
    }

    public void cancelarBaixa(ModeloLancamento modelonovo) {
        conexao.getConexaoSql();
        try {
            PreparedStatement pst = conexao.connection.prepareStatement("update lancamentos set lan_sta_cod=?, lan_data_baixa=?, lan_dias_uso=?, lan_historico=?, lan_usuario_cod=?, lan_ult_mov=? where lan_cod=?");
            pst.setInt(1, modelonovo.getLanstatus());
            pst.setDate(2, null);
            pst.setInt(3, modelonovo.getLandias());
            pst.setString(4, modelonovo.getLanhistorico());
            pst.setInt(5, TelaLogin.usuariocod); 
            pst.setTimestamp(6, null);
            pst.setInt(7, modelonovo.getLancod());
            pst.execute();

            String barrastatus = modelonovo.getBarrastatus();
            modelonovo.setBarrastatus("BAIXA CANCELADA -  " + barrastatus );
            
            JOptionPane.showMessageDialog(null, "Baixa cancelada com sucesso.");
            //this.recente(modelonovo);
            
            RegistroManutencao(modelonovo);

        } catch (SQLException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao cancelar baixa." + ex);
        }

        conexao.FecharConexao();
    }
    
    public void alterarStatus(ModeloLancamento modelonovo) {
        conexao.getConexaoSql();
        try {
            PreparedStatement pst = conexao.connection.prepareStatement("update lancamentos set lan_sta_cod=?, lan_usuario_cod=?, lan_ult_mov=? where lan_cod=?");
            pst.setInt(1, modelonovo.getLanstatus());
            pst.setInt(2, TelaLogin.usuariocod); 
            pst.setTimestamp(3, null);
            pst.setInt(4, modelonovo.getLancod());
            pst.execute();
            
            String barrastatus = modelonovo.getBarrastatus();
            modelonovo.setBarrastatus("STATUS ALTERADO - " + barrastatus );
            
            JOptionPane.showMessageDialog(null, "Status alterado com sucesso.");
            //this.recente(modelonovo);
            
            RegistroManutencao(modelonovo);

        } catch (SQLException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao alterar status." + ex);
        }

        conexao.FecharConexao();
    }
     
    public void SalvarHistorico(ModeloLancamento modelonovo) {
        conexao.getConexaoSql();
        try {
            PreparedStatement pst = conexao.connection.prepareStatement("update lancamentos set lan_historico=?, lan_usuario_cod=?, lan_ult_mov=? where lan_cod=?");
            pst.setString(1, modelonovo.getLanhistorico());
            pst.setInt(2, TelaLogin.usuariocod);
            pst.setTimestamp(3, null);
            pst.setInt(4, modelonovo.getLancod());
            pst.execute();
            
            String barrastatus = modelonovo.getBarrastatus();
            modelonovo.setBarrastatus("HISTORICO ALTERADO - " + barrastatus );
            JOptionPane.showMessageDialog(null, "Histórico salvo com sucesso.");
            //this.recente(modelonovo);
            
            RegistroManutencao(modelonovo);
            
        } catch (SQLException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao salvar histórico." + ex);
        }

        conexao.FecharConexao();
    }

    public void AtualizaIdFunc(ModeloLancamento modelonovo) {
        conexao.getConexaoSql();
        try {
            PreparedStatement pst = conexao.connection.prepareStatement("update lancamentos set lan_fun_cod=?, lan_usuario_cod=?, lan_ult_mov=? where lan_cod=?");
            pst.setInt(1, modelonovo.getLanfuncod());
            pst.setInt(2, TelaLogin.usuariocod); 
            pst.setTimestamp(3, null);
            pst.setInt(4, modelonovo.getLancod());
            pst.execute();
            
            String barrastatus = modelonovo.getBarrastatus();
            modelonovo.setBarrastatus("ID FUNCIONARIO ALTERADO - " + barrastatus );
            JOptionPane.showMessageDialog(null, "ID do funcionário atualizado com sucesso.");
            //this.recente(modelonovo);
            
            RegistroManutencao(modelonovo);
            
        } catch (SQLException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao atualizar ID do funcionario." + ex);
        }

        conexao.FecharConexao();
    }
    
    public void RegistroManutencao(ModeloLancamento modelonovo){
        conexao.getConexaoSql();
        try {
            PreparedStatement pst = conexao.connection.prepareStatement("insert into registro_manutencao (id_lan, tipo_manut ) values (?,?) ");
            pst.setInt(1, modelonovo.getLancod());
            pst.setString(2, modelonovo.getTipomanutencao());
            pst.execute();
          
            
        } catch (SQLException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao cadastradar registro de manutenção." + ex);
        }

        conexao.FecharConexao();
    }
 
}
