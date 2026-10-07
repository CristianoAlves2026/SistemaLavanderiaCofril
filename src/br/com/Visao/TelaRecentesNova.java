/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Visao;

import br.com.ConexaoBancoDados.ConexaoSql;
import br.com.Modelo.ModeloDatas;
import br.com.Modelo.ModeloTabela;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Lavanderia
 */
public final class TelaRecentesNova extends javax.swing.JFrame {

    ConexaoSql conexao = new ConexaoSql();
    ModeloDatas diasuso = new ModeloDatas();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    int max = 0;
    /**
     * Creates new form TelaRecentesNova
     */
    public TelaRecentesNova() {
        initComponents();
        
        
        maximo(); // buscao o numero de registro da tabela lancamentos para limitar os reg. exibidos.
        preencherTabelaRecentes("select rm.id, l.lan_cod, l.lan_ult_mov, rm.tipo_manut, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_fun_cod, l.lan_usuario_cod from registro_manutencao as rm left join lancamentos as l on rm.id_lan = l.lan_cod left join uniformes as u on l.lan_uni_cod = u.uni_cod left join tamanhos as t on l.lan_tam_cod = t.tam_cod left join status as s on l.lan_sta_cod = s.sta_cod where rm.id > '"+ max + "' order by rm.id desc");
    }
    
    public void maximo(){
        conexao.getConexaoSql();   
        conexao.executaSql("select max(id) from registro_manutencao");
        try {
            conexao.rs.first();
            max = conexao.rs.getInt("max(id)");
            max = max -100;
        } catch (SQLException ex) {
            Logger.getLogger(TelaRecentesNova.class.getName()).log(Level.SEVERE, null, ex);
        } 
        conexao.FecharConexao();
    }
    
    public void preencherTabelaRecentes(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Ord", "ID", "Data Alteração", "Operação", "Numero", "Letra", "Entrega", "Uniforme", "Tamanho", "Status", "Tipo", "Data Baixa", "Dias Uso", "Historico", "ID Func.", "Usuário"};

        long dias = 0;
        String datae =  null;

        conexao.getConexaoSql();
        conexao.executaSql(sql);
        try {
            SimpleDateFormat dataformatada = new SimpleDateFormat("dd/MM/yyyy");
            conexao.rs.first();
            
            
            do {
                if (conexao.rs.getDate("l.lan_data_entrega") != null) {
                    String data1 = dataformatada.format(new Date());
                    String data2 = dataformatada.format(conexao.rs.getDate("l.lan_data_entrega"));
                    dias = diasuso.CalcularTempoUso(data2, data1);
                    
                    datae = df.format(conexao.rs.getDate("l.lan_data_entrega").getTime());
                }else{
                    dias = 0;
                }

                int usuario = conexao.rs.getInt("l.lan_usuario_cod");

                if (conexao.rs.getTimestamp("l.lan_ult_mov") == null) {
                    dados.add(new Object[]{conexao.rs.getInt("rm.id"), conexao.rs.getInt("l.lan_cod"), conexao.rs.getTimestamp("l.lan_ult_mov"), conexao.rs.getString("rm.tipo_manut"), conexao.rs.getInt("lan_fun_num"), conexao.rs.getString("lan_letra"), datae, conexao.rs.getString("uni_descricao"), conexao.rs.getString("tam_sigla"), conexao.rs.getString("sta_descricao"), conexao.rs.getString("lan_tipo"), conexao.rs.getDate("lan_data_baixa"), dias, conexao.rs.getString("lan_historico"), conexao.rs.getInt("lan_fun_cod"), buscaNomeUsuario(usuario)});
                } else {
                    String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(conexao.rs.getTimestamp("l.lan_ult_mov").getTime());
                    dados.add(new Object[]{conexao.rs.getInt("rm.id"), conexao.rs.getInt("l.lan_cod"), date, conexao.rs.getString("rm.tipo_manut"), conexao.rs.getInt("lan_fun_num"), conexao.rs.getString("lan_letra"), datae, conexao.rs.getString("uni_descricao"), conexao.rs.getString("tam_sigla"), conexao.rs.getString("sta_descricao"), conexao.rs.getString("lan_tipo"), conexao.rs.getDate("lan_data_baixa"), dias, conexao.rs.getString("lan_historico"), conexao.rs.getInt("lan_fun_cod"), buscaNomeUsuario(usuario)});
                }

            } while (conexao.rs.next());

            ModeloTabela modelotab = new ModeloTabela(dados, colunas);
            jTableRecentes.setModel(modelotab);

            jTableRecentes.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableRecentes.getColumnModel().getColumn(1).setPreferredWidth(60);
            jTableRecentes.getColumnModel().getColumn(2).setPreferredWidth(130);
            jTableRecentes.getColumnModel().getColumn(3).setPreferredWidth(180);
            jTableRecentes.getColumnModel().getColumn(4).setPreferredWidth(60);
            jTableRecentes.getColumnModel().getColumn(5).setPreferredWidth(50);
            jTableRecentes.getColumnModel().getColumn(6).setPreferredWidth(80);
            jTableRecentes.getColumnModel().getColumn(7).setPreferredWidth(180);
            jTableRecentes.getColumnModel().getColumn(8).setPreferredWidth(70);
            jTableRecentes.getColumnModel().getColumn(9).setPreferredWidth(110);
            jTableRecentes.getColumnModel().getColumn(10).setPreferredWidth(50);
            jTableRecentes.getColumnModel().getColumn(11).setPreferredWidth(80);
            jTableRecentes.getColumnModel().getColumn(12).setPreferredWidth(80);
            jTableRecentes.getColumnModel().getColumn(13).setPreferredWidth(250);
            jTableRecentes.getColumnModel().getColumn(14).setPreferredWidth(50);
            jTableRecentes.getColumnModel().getColumn(15).setPreferredWidth(100);

            jTableRecentes.setAutoResizeMode(jTableRecentes.AUTO_RESIZE_OFF);
            jTableRecentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jTableRecentes.setAutoCreateRowSorter(true);

            conexao.FecharConexao();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nenhum lançamentos encontrado."+ e);

        }

    }

    public String buscaNomeUsuario(int usu) {
        conexao.getConexaoSql();
        String nomeusuario = "";
        conexao.executaSqlu("select * from usuarios where usu_cod= '" + usu + "' ");
        //System.out.println(usu);
        try {
            conexao.rs_u.first();
            nomeusuario = conexao.rs_u.getString("usu_usuario");

        } catch (SQLException ex) {
            nomeusuario = " - ";
        }
        conexao.FecharConexao();

        //System.out.println("nomeusuario" + nomeusuario);
        return nomeusuario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRecentes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lançamentos Recentes");
        setResizable(false);

        jTableRecentes.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTableRecentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableRecentes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1071, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1087, 371));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaRecentesNova.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRecentesNova.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRecentesNova.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRecentesNova.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRecentesNova().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRecentes;
    // End of variables declaration//GEN-END:variables
}
