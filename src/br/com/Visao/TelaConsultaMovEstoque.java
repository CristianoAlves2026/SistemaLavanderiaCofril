/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Visao;

import br.com.ConexaoBancoDados.ConexaoSql;
import br.com.Controle.ControleMovimentaEstoque;
import br.com.Modelo.ModeloMovimentaEstoque;
import br.com.Modelo.ModeloPreencheComboBox;
import br.com.Modelo.ModeloTabela;
import br.com.Utilitarios.ValidaAcessos;
import java.awt.AWTKeyStroke;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class TelaConsultaMovEstoque extends javax.swing.JFrame {

    ConexaoSql conexao = new ConexaoSql();
    ControleMovimentaEstoque controle = new ControleMovimentaEstoque();
    SimpleDateFormat dataformat = new SimpleDateFormat("yyyy/MM/dd");
    SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

    public TelaConsultaMovEstoque() {
        initComponents();

        HashSet conj;
        conj = new HashSet(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
        
        jDateChooserDataInicial.setDate(new Date());
        jDateChooserDataFinal.setDate(new Date());
        
        preencherTabelaMovimentacao("select m.mov_cod, m.mov_data, u.uni_descricao, t.tam_sigla, e.emp_razao, d.dep_descricao, c.car_descricao, m.mov_entrada, m.mov_saida, m.mov_historico, m.mov_lan_cod from movimenta_estoque as m left join uniformes as u on m.mov_uni_cod = u.uni_cod left join tamanhos as t on m.mov_tam_cod = t.tam_cod left join empresas as e on m.mov_emp_cod = e.emp_cod left join departamentos as d on m.mov_dep_cod = d.dep_cod left join cargos as c on m.mov_car_cod = c.car_cod where mov_data >='" + dataformat.format(jDateChooserDataInicial.getDate()) + "' and mov_data <= '"+ dataformat.format(jDateChooserDataFinal.getDate()) +"' order by mov_cod desc");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jDateChooserDataInicial = new com.toedter.calendar.JDateChooser();
        jDateChooserDataFinal = new com.toedter.calendar.JDateChooser();
        jButtonGerar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelTexto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMovimentaEstoque = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Movimentação de Estoque");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setToolTipText("");

        jDateChooserDataInicial.setDateFormatString("dd'/'MM'/'yyyy");

        jDateChooserDataFinal.setDateFormatString("dd'/'MM'/'yyyy");

        jButtonGerar.setText("Gerar");
        jButtonGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarActionPerformed(evt);
            }
        });

        jLabel1.setText("Data Inicial");

        jLabel2.setText("Data Final");

        jLabelTexto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTexto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jDateChooserDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonGerar)
                            .addComponent(jLabelTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTableMovimentaEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableMovimentaEstoque);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1101, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        setSize(new java.awt.Dimension(1137, 593));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarActionPerformed

        if (jDateChooserDataInicial.getDate()==null  || jDateChooserDataFinal.getDate() == null){
            JOptionPane.showMessageDialog(null, "Informe data inicial e data final.");
            return;
        }
        preencherTabelaMovimentacao("select m.mov_cod, m.mov_data, u.uni_descricao, t.tam_sigla, e.emp_razao, d.dep_descricao, c.car_descricao, m.mov_entrada, m.mov_saida, m.mov_historico, m.mov_lan_cod from movimenta_estoque as m left join uniformes as u on m.mov_uni_cod = u.uni_cod left join tamanhos as t on m.mov_tam_cod = t.tam_cod left join empresas as e on m.mov_emp_cod = e.emp_cod left join departamentos as d on m.mov_dep_cod = d.dep_cod left join cargos as c on m.mov_car_cod = c.car_cod where mov_data >='" + dataformat.format(jDateChooserDataInicial.getDate()) + "' and mov_data <= '"+ dataformat.format(jDateChooserDataFinal.getDate()) +"' order by mov_cod desc");


    }//GEN-LAST:event_jButtonGerarActionPerformed

    public void preencherTabelaMovimentacao(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Data", "Uniforme", "Tamanho", "Entradas", "Saídas", "Histórico", "Empresa", "Setor", "Cargo", "ID Lançto"};
        int cont = 0;
        
        conexao.getConexaoSql();
        conexao.executaSql(sql);
        try {
            conexao.rs.first();
            do {
                String ent, sai;
                if (conexao.rs.getInt("mov_entrada") == 0) {
                    ent = ("-");
                } else {
                    ent = String.valueOf(conexao.rs.getInt("mov_entrada"));
                }

                if (conexao.rs.getInt("mov_saida") == 0) {
                    sai = ("-");
                } else {
                    sai = String.valueOf(conexao.rs.getInt("mov_saida"));
                }
                cont++;
                dados.add(new Object[]{conexao.rs.getInt("mov_cod"), data.format(conexao.rs.getDate("mov_data").getTime()), conexao.rs.getString("uni_descricao"), conexao.rs.getString("tam_sigla"), ent, sai, conexao.rs.getString("mov_historico"), conexao.rs.getString("emp_razao"), conexao.rs.getString("dep_descricao"), conexao.rs.getString("car_descricao"), conexao.rs.getInt("mov_lan_cod")});
            } while (conexao.rs.next());
            
            jLabelTexto.setText(cont + " Registro(s) encontrado(s).");
            ModeloTabela modelotab = new ModeloTabela(dados, colunas);
            jTableMovimentaEstoque.setModel(modelotab);

            jTableMovimentaEstoque.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableMovimentaEstoque.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTableMovimentaEstoque.getColumnModel().getColumn(2).setPreferredWidth(220);
            jTableMovimentaEstoque.getColumnModel().getColumn(3).setPreferredWidth(40);
            jTableMovimentaEstoque.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTableMovimentaEstoque.getColumnModel().getColumn(5).setPreferredWidth(50);
            jTableMovimentaEstoque.getColumnModel().getColumn(6).setPreferredWidth(380);
            jTableMovimentaEstoque.getColumnModel().getColumn(7).setPreferredWidth(200);
            jTableMovimentaEstoque.getColumnModel().getColumn(8).setPreferredWidth(150);
            jTableMovimentaEstoque.getColumnModel().getColumn(9).setPreferredWidth(150);
            jTableMovimentaEstoque.getColumnModel().getColumn(10).setPreferredWidth(150);
            jTableMovimentaEstoque.getColumnModel().getColumn(10).setPreferredWidth(80);

            jTableMovimentaEstoque.setAutoResizeMode(jTableMovimentaEstoque.AUTO_RESIZE_OFF);
            jTableMovimentaEstoque.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jTableMovimentaEstoque.setAutoCreateRowSorter(true);

            conexao.FecharConexao();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nenhuma movimentação de estoque encontrado.");

        }

    }

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
            java.util.logging.Logger.getLogger(TelaConsultaMovEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaMovEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaMovEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaMovEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsultaMovEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGerar;
    private com.toedter.calendar.JDateChooser jDateChooserDataFinal;
    private com.toedter.calendar.JDateChooser jDateChooserDataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTexto;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMovimentaEstoque;
    // End of variables declaration//GEN-END:variables
}
