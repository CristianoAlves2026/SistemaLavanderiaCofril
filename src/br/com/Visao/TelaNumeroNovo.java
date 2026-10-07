/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Visao;

import br.com.ConexaoBancoDados.ConexaoSql;
import br.com.Modelo.ModeloPreencheComboBox;
import br.com.Modelo.ModeloTabela;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Lavanderia
 */
public class TelaNumeroNovo extends javax.swing.JFrame {

    ConexaoSql conexao = new ConexaoSql();
    ModeloPreencheComboBox preenche = new ModeloPreencheComboBox();
    int flag;

    /**
     * Creates new form TelaNumeroNovo
     */
    public TelaNumeroNovo() {
        initComponents();
        preenchetabela();
        jButtonEncarregado.setVisible(false);
        flag = 1;
        jComboBoxSetor.removeAllItems();
        for (Object u : preenche.preencheDepartamentos()) {
            jComboBoxSetor.addItem((String) u);
        }

        jComboBoxEmpresa.removeAllItems();
        for (Object e : preenche.preencheEmpresas()) {
            jComboBoxEmpresa.addItem((String) e);
        }

        jComboBoxEmpresa.setSelectedItem("ABAV - ABATEDOURO ATÍLIO VIVÁCQUA");
    }

    public void preenchetabela() {
        conexao.getConexaoSql();
        ArrayList dados = new ArrayList<String>();
        String[] colunas = new String[]{"Disponíveis"};

        conexao.executaSql("Select fun_num from funcionarios where fun_num > 1 and fun_num < 2100 order by fun_num");
        try {
            conexao.rs.first();

            int num1 = 0;
            int cont = 0;
            num1 = conexao.rs.getInt("fun_num");
            do {
                if (cont == 0) {
                    cont = 1;
                } else {
                    if (num1 + 1 != conexao.rs.getInt("fun_num")) {

                        while (++num1 < conexao.rs.getInt("fun_num")) {
                            if (jRadioButtonMasculino.isSelected()) {
                                int i = (num1 % 2);
                                    if (i == 0){
                                        dados.add(new Object[]{num1});                                         
                                    }                                                         
                            } else if (jRadioButtonFeminino.isSelected()) {
                                int i = (num1 % 2);
                                    if (i != 0){
                                        dados.add(new Object[]{num1});                                         
                                    }
                            } else {
                                dados.add(new Object[]{num1});
                            }

                        };

                    }
                    num1 = conexao.rs.getInt("fun_num");

                }

            } while (conexao.rs.next());

            ModeloTabela tabnumeros = new ModeloTabela(dados, colunas);
            jTableNumeroNovo.setModel(tabnumeros);
            jTableNumeroNovo.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTableNumeroNovo.setAutoResizeMode(jTableNumeroNovo.AUTO_RESIZE_OFF);
            jTableNumeroNovo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher tabela de números livres.");
        }

        conexao.FecharConexao();

    }

    public void preenchetabelasetor(String coddep, String codemp) {
        conexao.getConexaoSql();
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Número", "Nome"};

        if (jRadioButtonMasculino.isSelected()) {
            conexao.executaSql("Select fun_num, fun_nome from funcionarios where fun_dep_cod = '" + coddep + "' and fun_emp_cod = '" + codemp + "' and fun_status = 'ATIVO' and fun_sexo = 'MASCULINO' order by fun_num");
        } else if (jRadioButtonFeminino.isSelected()) {
            conexao.executaSql("Select fun_num, fun_nome from funcionarios where fun_dep_cod = '" + coddep + "' and fun_emp_cod = '" + codemp + "' and fun_status = 'ATIVO' and fun_sexo = 'FEMININO' order by fun_num");
        } else {
            conexao.executaSql("Select fun_num, fun_nome from funcionarios where fun_dep_cod = '" + coddep + "' and fun_emp_cod = '" + codemp + "' and fun_status = 'ATIVO' order by fun_num");
        }

        try {
            conexao.rs.first();
            do {
                dados.add(new Object[]{conexao.rs.getInt("fun_num"), conexao.rs.getString("fun_nome")});
            } while (conexao.rs.next());

            ModeloTabela tabelasetor = new ModeloTabela(dados, colunas);
            jTableSetor.setModel(tabelasetor);
            jTableSetor.getColumnModel().getColumn(0).setPreferredWidth(90);
            jTableSetor.getColumnModel().getColumn(1).setPreferredWidth(350);
            jTableSetor.setAutoResizeMode(jTableNumeroNovo.AUTO_RESIZE_OFF);
            jTableSetor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum funcionário encontrado.");
        }

        conexao.FecharConexao();

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
        jTableNumeroNovo = new javax.swing.JTable();
        jComboBoxSetor = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSetor = new javax.swing.JTable();
        jComboBoxEmpresa = new javax.swing.JComboBox<>();
        jButtonEncarregado = new javax.swing.JButton();
        jRadioButtonMasculino = new javax.swing.JRadioButton();
        jRadioButtonFeminino = new javax.swing.JRadioButton();
        jRadioButtonTodos = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Números Disponíveis");

        jTableNumeroNovo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableNumeroNovo.setForeground(new java.awt.Color(0, 0, 204));
        jTableNumeroNovo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableNumeroNovo);

        jComboBoxSetor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSetorActionPerformed(evt);
            }
        });

        jTableSetor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableSetor);

        jComboBoxEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEmpresaActionPerformed(evt);
            }
        });

        jButtonEncarregado.setBackground(new java.awt.Color(255, 255, 0));
        jButtonEncarregado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jRadioButtonMasculino.setText("Masculino");
        jRadioButtonMasculino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonMasculinoMouseClicked(evt);
            }
        });

        jRadioButtonFeminino.setText("Feminino");
        jRadioButtonFeminino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonFemininoMouseClicked(evt);
            }
        });

        jRadioButtonTodos.setSelected(true);
        jRadioButtonTodos.setText("Todos");
        jRadioButtonTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonTodosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jRadioButtonMasculino)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonFeminino)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonTodos)
                        .addGap(237, 237, 237))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jComboBoxSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonEncarregado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEncarregado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonMasculino)
                            .addComponent(jRadioButtonFeminino)
                            .addComponent(jRadioButtonTodos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(280, 280, 280))
        );

        setSize(new java.awt.Dimension(638, 434));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSetorActionPerformed
        if (flag <= 2) {
            ++flag;
        } else if (flag > 2) {
            String coddep = preenche.buscaCodigoDepartamentos((String) jComboBoxSetor.getSelectedItem());
            preenchetabelasetor(coddep, preenche.buscaCodigoempreas((String) jComboBoxEmpresa.getSelectedItem()));

            int codemp = Integer.parseInt(preenche.buscaCodigoempreas((String) jComboBoxEmpresa.getSelectedItem()));
            if (codemp == 1) {
                jButtonEncarregado.setVisible(true);
                jButtonEncarregado.setText(preenche.getEncarregado());
            } else {
                jButtonEncarregado.setVisible(false);
            }
        }
    }//GEN-LAST:event_jComboBoxSetorActionPerformed

    private void jComboBoxEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEmpresaActionPerformed
        jButtonEncarregado.setVisible(false);
    }//GEN-LAST:event_jComboBoxEmpresaActionPerformed

    private void jRadioButtonMasculinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonMasculinoMouseClicked
        jRadioButtonFeminino.setSelected(false);
        jRadioButtonTodos.setSelected(false);
        String setor = (String) jComboBoxSetor.getSelectedItem();
        jComboBoxSetor.setSelectedItem(setor);
        preenchetabela();
    }//GEN-LAST:event_jRadioButtonMasculinoMouseClicked

    private void jRadioButtonFemininoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonFemininoMouseClicked
        jRadioButtonMasculino.setSelected(false);
        jRadioButtonTodos.setSelected(false);
        String setor = (String) jComboBoxSetor.getSelectedItem();
        jComboBoxSetor.setSelectedItem(setor);
        preenchetabela();
    }//GEN-LAST:event_jRadioButtonFemininoMouseClicked

    private void jRadioButtonTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonTodosMouseClicked
        jRadioButtonFeminino.setSelected(false);
        jRadioButtonMasculino.setSelected(false);
        String setor = (String) jComboBoxSetor.getSelectedItem();
        jComboBoxSetor.setSelectedItem(setor);
        preenchetabela();
    }//GEN-LAST:event_jRadioButtonTodosMouseClicked

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
            java.util.logging.Logger.getLogger(TelaNumeroNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNumeroNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNumeroNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNumeroNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaNumeroNovo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEncarregado;
    private javax.swing.JComboBox<String> jComboBoxEmpresa;
    private javax.swing.JComboBox<String> jComboBoxSetor;
    private javax.swing.JRadioButton jRadioButtonFeminino;
    private javax.swing.JRadioButton jRadioButtonMasculino;
    private javax.swing.JRadioButton jRadioButtonTodos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableNumeroNovo;
    private javax.swing.JTable jTableSetor;
    // End of variables declaration//GEN-END:variables
}
