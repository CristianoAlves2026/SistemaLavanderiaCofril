/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Visao;

import br.com.ConexaoBancoDados.ConexaoSql;
import br.com.Controle.ControleNumPreSelecionado;
import br.com.Modelo.ModeloNumPreSelecionado;
import br.com.Modelo.ModeloPreencheComboBox;
import br.com.Modelo.ModeloTabela;
import br.com.Modelo.ModeloTabela01;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lavanderia
 */
public class TelaNumeroDisponivel extends javax.swing.JFrame {

    ModeloNumPreSelecionado modelnumpre = new ModeloNumPreSelecionado();
    ControleNumPreSelecionado controlnumpre = new ControleNumPreSelecionado();
    ConexaoSql conexao = new ConexaoSql();
    ConexaoSql conexao02 = new ConexaoSql();
    ModeloPreencheComboBox preenche = new ModeloPreencheComboBox();
    int flag;
    private boolean isAjustandoTabela = false;

    /**
     * Creates new form TelaNumeroNovo
     */
    public TelaNumeroDisponivel() {
        initComponents();
        //preenchetabela();
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

        ArrayList<Object[]> dados = new ArrayList<>();
        String[] colunas = new String[]{"", "Disponíveis"};

        int ninicial = preenche.getNuminicial();
        int nfinal = preenche.getNumfinal();
        int ninicial2 = preenche.getNuminicial2();
        int nfinal2 = preenche.getNumfinal2();

        conexao.executaSql(
                "Select fun_num from funcionarios "
                + "where fun_num > 0 and fun_num < 2100 order by fun_num"
        );

        try {
            conexao.rs.first();

            int num1 = conexao.rs.getInt("fun_num");
            int cont = 0;

            do {
                if (cont == 0) {
                    cont = 1;
                } else {
                    if (num1 + 1 != conexao.rs.getInt("fun_num")) {

                        while (++num1 < conexao.rs.getInt("fun_num")) {

                            //int atual = conexao.rs.getInt("fun_num");
                            if ((num1 >= ninicial && num1 <= nfinal) || (num1 >= ninicial2 && num1 <= nfinal2)) {

                            } else {
                                continue;
                            }

                            if (jRadioButtonMasculino.isSelected()) {
                                if (num1 % 2 == 0) {
                                    dados.add(new Object[]{false, num1});
                                }
                            } else if (jRadioButtonFeminino.isSelected()) {
                                if (num1 % 2 != 0) {
                                    dados.add(new Object[]{false, num1});
                                }
                            } else {
                                dados.add(new Object[]{false, num1});
                            }
                        }
                    }
                    num1 = conexao.rs.getInt("fun_num");

                }
            } while (conexao.rs.next());

            ModeloTabela01 tabnumeros = new ModeloTabela01(dados, colunas) {

                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnIndex == 0 ? Boolean.class : Integer.class;
                }

                @Override
                public boolean isCellEditable(int row, int column) {
                    return column == 0;
                }
            };

            jTableNumeroNovo.setModel(tabnumeros);
            

            verificapreselecionados(); // <--- Adicione esta linha aqui
//************
            tabnumeros.addTableModelListener(e -> {
                if (isAjustandoTabela) {
                    return; // Se o sistema estiver ajustando, não faz nada
                }
                if (e.getType() == javax.swing.event.TableModelEvent.UPDATE) {
                    int linha = e.getFirstRow();
                    int coluna = e.getColumn();

                    if (coluna == 0) {
                        Boolean marcado = (Boolean) tabnumeros.getValueAt(linha, 0);
                        Integer numero = (Integer) tabnumeros.getValueAt(linha, 1);

                        modelnumpre.setNumeroPre(numero);
                        if (marcado) {
                            controlnumpre.marcaNumPre(modelnumpre);
                        } else {
                            controlnumpre.desmarcaNumPre(modelnumpre);
                        }
                    }
                }
            });

//**************
            jTableNumeroNovo.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableNumeroNovo.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTableNumeroNovo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            jTableNumeroNovo.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

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
            jTableSetor.setModel(new DefaultTableModel());
            JOptionPane.showMessageDialog(null, "Nenhum funcionário encontrado.");
        }

        conexao.FecharConexao();

    }

    public void verificapreselecionados() {
    
    
    // 1. Buscamos TODOS os números que estão reservados no banco de reservas
    ArrayList<Integer> reservados = new ArrayList<>();
    conexao.getConexaoSql();
    try {
        conexao.executaSql("SELECT numero_pre FROM numero_pre_selecionado");
        while (conexao.rs.next()) {
            reservados.add(conexao.rs.getInt("numero_pre"));
        }
    } catch (SQLException e) {
        System.err.println("Erro ao buscar reservas: " + e.getMessage());
    } finally {
        conexao.FecharConexao();
    }

    // 2. Para cada número reservado, verificamos se ele já virou um funcionário
    for (Integer numReservado : reservados) {
        if (estaEmUsoNoCadastroGeral(numReservado)) {
            
            
            // Deleta do banco de reservas
            ModeloNumPreSelecionado m = new ModeloNumPreSelecionado();
            m.setNumeroPre(numReservado);
            controlnumpre.desmarcaNumPre(m);
        }
    }

    // 3. AGORA SIM: Atualizamos o visual da JTable para refletir o banco limpo
    // (Apenas marca o Checkbox para quem ainda é apenas reserva)
    isAjustandoTabela = true;
    ModeloTabela01 modelo = (ModeloTabela01) jTableNumeroNovo.getModel();
    for (int i = 0; i < modelo.getRowCount(); i++) {
        int numNaTela = (int) modelo.getValueAt(i, 1);
        if (controlnumpre.isStatusOk(numNaTela)) {
            modelo.setValueAt(true, i, 0);
        }
    }
    isAjustandoTabela = false;
}
    
    

private boolean estaEmUsoNoCadastroGeral(int numero) {
    boolean emUso = false;
    // Use uma nova conexão ou garanta que o rs não seja sobrescrito
    ConexaoSql conexaoBusca = new ConexaoSql(); 
    conexaoBusca.getConexaoSql();
    try {
        // Usar PreparedStatement é mais seguro e rápido
        String sql = "SELECT fun_num FROM funcionarios WHERE fun_num = ?";
        PreparedStatement pst = conexaoBusca.connection.prepareStatement(sql);
        pst.setInt(1, numero);
        ResultSet rsBusca = pst.executeQuery();
        
        if (rsBusca.next()) {
            emUso = true;
        }
        rsBusca.close();
        pst.close();
    } catch (SQLException e) {
        System.err.println("Erro na busca: " + e.getMessage());
    } finally {
        conexaoBusca.FecharConexao();
    }
    return emUso;
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
        jLabelSequencia = new javax.swing.JLabel();
        jLabelSequencia2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Números Disponíveis");

        jTableNumeroNovo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableNumeroNovo.setForeground(new java.awt.Color(0, 0, 204));
        jTableNumeroNovo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

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

        jLabelSequencia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSequencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelSequencia2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSequencia2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jComboBoxSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonEncarregado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(162, 162, 162))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonMasculino)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonFeminino)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonTodos)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSequencia2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSequencia, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRadioButtonMasculino)
                                .addComponent(jRadioButtonFeminino)
                                .addComponent(jRadioButtonTodos))
                            .addComponent(jLabelSequencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSequencia2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
            int ninicial = preenche.getNuminicial();
            int nfinal = preenche.getNumfinal();
            int ninicial02 = preenche.getNuminicial2();
            int nfinal02 = preenche.getNumfinal2();
            preenchetabelasetor(coddep, preenche.buscaCodigoempreas((String) jComboBoxEmpresa.getSelectedItem()));
            jLabelSequencia.setText("De: " + ninicial + " até: " + nfinal);
            if (ninicial02 != 0) {
                jLabelSequencia2.setText("De: " + ninicial02 + " até: " + nfinal02);
            } else {
                jLabelSequencia2.setText("");
            }

            int codemp = Integer.parseInt(preenche.buscaCodigoempreas((String) jComboBoxEmpresa.getSelectedItem()));
            if (codemp == 1) {
                jButtonEncarregado.setVisible(true);
                jButtonEncarregado.setText(preenche.getEncarregado());
            } else {
                jButtonEncarregado.setVisible(false);
            }

            preenchetabela();
            //verificapreselecionados();

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
            java.util.logging.Logger.getLogger(TelaNumeroDisponivel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNumeroDisponivel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNumeroDisponivel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNumeroDisponivel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaNumeroDisponivel().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEncarregado;
    private javax.swing.JComboBox<String> jComboBoxEmpresa;
    private javax.swing.JComboBox<String> jComboBoxSetor;
    private javax.swing.JLabel jLabelSequencia;
    private javax.swing.JLabel jLabelSequencia2;
    private javax.swing.JRadioButton jRadioButtonFeminino;
    private javax.swing.JRadioButton jRadioButtonMasculino;
    private javax.swing.JRadioButton jRadioButtonTodos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableNumeroNovo;
    private javax.swing.JTable jTableSetor;
    // End of variables declaration//GEN-END:variables
}
