/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Visao;

import br.com.ConexaoBancoDados.ConexaoSql;
import br.com.Controle.ControleProdutos;
import br.com.Modelo.ModeloDatas;
import br.com.Modelo.ModeloProdutos;
import br.com.Modelo.ModeloTabela;
import br.com.Utilitarios.ValidaAcessos;
import com.toedter.calendar.JDateChooser;
import java.util.Date;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.ListSelectionModel;

/**
 *
 * @author Lavanderia
 */
public class TelaProdutos extends javax.swing.JFrame {

    ModeloProdutos modelobaixar = new ModeloProdutos();
    ControleProdutos controle = new ControleProdutos();
    ConexaoSql conecta = new ConexaoSql();
    SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat dataformat = new SimpleDateFormat("yyyy/MM/dd");
    int flag; //filtra ou não os produtos quando seleciona o jcombobox
    int maq = 1;
    ModeloDatas calcdias = new ModeloDatas();

    /**
     * Creates new form TelaProdutos
     */
    public TelaProdutos() {
        initComponents();
        preencherProdutos();
        jRadioButtonLavadora01Velha.setSelected(true);
        preencherTabelaProdutos("select lan.lan_id, lan.prod_id, prod.prod_nometecnico, lan.litros, lan.data_inicio, lan.data_fim, lan.dias, lan.maquina from produtos_lancamentos as lan inner join produtos as prod on lan.prod_id = prod.prod_id where lan.maquina = '" + maq + "' order by lan.lan_id desc");
        jLabelIdProduto.setVisible(false);
        
    }

    public void preencherProdutos() {
        conecta.getConexaoSql();

        flag = 1;
        conecta.executaSql("select * from produtos order by prod_nometecnico");
        try {
            conecta.rs.first();
            jComboBoxProdutos.removeAllItems();
            jComboBoxProdutos.addItem("Selecione");
            do {
                jComboBoxProdutos.addItem(conecta.rs.getString("prod_nometecnico"));
            } while (conecta.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher Produtos.");
        }

        conecta.FecharConexao();
        flag = 0;

    }

    public void preencherTabelaProdutos(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "ID Produto", "Produto", "Litros", "Data Inicio", "Data Final", "Dias", "Maquina"};
        String datanull = null;
        int qtddias;

        conecta.getConexaoSql();
        conecta.executaSql(sql);
        try {
            conecta.rs.first();
            int idcod = conecta.rs.getInt("lan_id");// faz gerar o erro para o try cath ser acionado - rs vazio

            do {
                if (conecta.rs.getDate("data_fim") != null) {
                    datanull = data.format(conecta.rs.getDate("data_fim").getTime());
                    qtddias = conecta.rs.getInt("dias");

                } else {
                    datanull = null;
                    String data1 = data.format(conecta.rs.getDate("data_inicio"));
                    String data2 = data.format(new Date());
                    qtddias = (int) calcdias.CalcularTempoUso(data1, data2);

                }

                dados.add(new Object[]{conecta.rs.getInt("lan_id"), conecta.rs.getInt("prod_id"), conecta.rs.getString("prod_nometecnico"), conecta.rs.getInt("litros"), data.format(conecta.rs.getDate("data_inicio").getTime()), datanull, qtddias, conecta.rs.getInt("maquina")});
            } while (conecta.rs.next());

            ModeloTabela modelotab = new ModeloTabela(dados, colunas);
            jTableProdutos.setModel(modelotab);

            jTableProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableProdutos.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTableProdutos.getColumnModel().getColumn(2).setPreferredWidth(280);
            jTableProdutos.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTableProdutos.getColumnModel().getColumn(4).setPreferredWidth(90);
            jTableProdutos.getColumnModel().getColumn(5).setPreferredWidth(90);
            jTableProdutos.getColumnModel().getColumn(6).setPreferredWidth(50);

            jTableProdutos.setAutoResizeMode(jTableProdutos.AUTO_RESIZE_OFF);
            jTableProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jTableProdutos.setAutoCreateRowSorter(true);

            conecta.FecharConexao();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nenhuma lançamento de produto encontrado.");

            int resposta = 0;
            resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja iniciar o uso de um novo produto?");
            if (resposta == JOptionPane.YES_OPTION) {
                IncluirSemBaixar();
            } else {
                jComboBoxProdutos.setSelectedItem("Selecione");
                preencherTabelaProdutos("select lan.lan_id, lan.prod_id, prod.prod_nometecnico, lan.litros, lan.data_inicio, lan.data_fim, lan.dias, lan.maquina from produtos_lancamentos as lan inner join produtos as prod on lan.prod_id = prod.prod_id order by lan.lan_id desc");
            }

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuOpçoes = new javax.swing.JPopupMenu();
        jMenuItemIncluirSemBaixar = new javax.swing.JMenuItem();
        jMenuItemCancelarBaixa = new javax.swing.JMenuItem();
        jMenuItemExcluirProduto = new javax.swing.JMenuItem();
        jComboBoxProdutos = new javax.swing.JComboBox<>();
        jDateChooserDataInicial = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooserDataFinal = new com.toedter.calendar.JDateChooser();
        jButtonGerar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxLitros = new javax.swing.JComboBox<>();
        jCheckBoxNovoAutomatico = new javax.swing.JCheckBox();
        jLabelIdProduto = new javax.swing.JLabel();
        jRadioButtonLavadora01Velha = new javax.swing.JRadioButton();
        jRadioButtonLavadora02Nova = new javax.swing.JRadioButton();

        jMenuItemIncluirSemBaixar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemIncluirSemBaixar.setForeground(new java.awt.Color(0, 0, 204));
        jMenuItemIncluirSemBaixar.setText("Iniciar uso de novo produto");
        jMenuItemIncluirSemBaixar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemIncluirSemBaixarActionPerformed(evt);
            }
        });
        jPopupMenuOpçoes.add(jMenuItemIncluirSemBaixar);

        jMenuItemCancelarBaixa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemCancelarBaixa.setForeground(new java.awt.Color(0, 0, 204));
        jMenuItemCancelarBaixa.setText("Cancelar Baixa");
        jMenuItemCancelarBaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCancelarBaixaActionPerformed(evt);
            }
        });
        jPopupMenuOpçoes.add(jMenuItemCancelarBaixa);

        jMenuItemExcluirProduto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemExcluirProduto.setForeground(new java.awt.Color(255, 0, 0));
        jMenuItemExcluirProduto.setText("Excluir");
        jMenuItemExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExcluirProdutoActionPerformed(evt);
            }
        });
        jPopupMenuOpçoes.add(jMenuItemExcluirProduto);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de Produtos");
        setResizable(false);

        jComboBoxProdutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProdutosActionPerformed(evt);
            }
        });

        jDateChooserDataInicial.setDateFormatString("dd'/'MM'/'yyyy");
        jDateChooserDataInicial.setEnabled(false);

        jLabel1.setText("Produto");

        jLabel2.setText("Data Final");

        jDateChooserDataFinal.setDateFormatString("dd'/'MM'/'yyyy");

        jButtonGerar.setText("Baixar");
        jButtonGerar.setEnabled(false);
        jButtonGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarActionPerformed(evt);
            }
        });

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProdutosMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableProdutosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProdutos);

        jLabel3.setText("Data Inicial");

        jLabel4.setText("Litros");

        jComboBoxLitros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "20", "50" }));

        jCheckBoxNovoAutomatico.setSelected(true);
        jCheckBoxNovoAutomatico.setText("Após baixar um produto iniciar automaticamente o uso de um novo.");
        jCheckBoxNovoAutomatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxNovoAutomaticoActionPerformed(evt);
            }
        });

        jLabelIdProduto.setText("vazio");

        jRadioButtonLavadora01Velha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButtonLavadora01Velha.setText("Lavadora 01 - Antiga");
        jRadioButtonLavadora01Velha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonLavadora01VelhaActionPerformed(evt);
            }
        });

        jRadioButtonLavadora02Nova.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButtonLavadora02Nova.setText("Lavadora 02 - Nova");
        jRadioButtonLavadora02Nova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonLavadora02NovaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jCheckBoxNovoAutomatico, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jComboBoxProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jDateChooserDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jDateChooserDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxLitros, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonLavadora01Velha)
                        .addGap(30, 30, 30)
                        .addComponent(jRadioButtonLavadora02Nova, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonLavadora01Velha)
                    .addComponent(jRadioButtonLavadora02Nova))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelIdProduto))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooserDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxLitros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooserDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonGerar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxNovoAutomatico, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18))
        );

        setSize(new java.awt.Dimension(723, 495));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarActionPerformed
        if (ValidaAcessos.valida(3) == 2) {
            return;
        }

        if (jTableProdutos.getSelectedRow() == -1) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Selecione um produto para baixar.");
            return;
        }
        if (jTableProdutos.getValueAt(jTableProdutos.getSelectedRow(), 5) != null) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Produto já baixado. Selecione o produto correto");
            return;
        }

        if (jComboBoxLitros.getSelectedItem().equals("00") && jCheckBoxNovoAutomatico.isSelected()) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Informe a quantidade de litros do galão para ao novo produto que será cadasrado.");
            return;
        }
        if (jDateChooserDataInicial.getDate() == null || jDateChooserDataFinal.getDate() == null) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Informe data inicial e data final.");
            return;
        } else {

            modelobaixar.setIdlancamento(Integer.parseInt("" + jTableProdutos.getValueAt(jTableProdutos.getSelectedRow(), 0)));
            modelobaixar.setIdproduto(Integer.parseInt("" + jTableProdutos.getValueAt(jTableProdutos.getSelectedRow(), 1)));
            modelobaixar.setNometecnico((String) jComboBoxProdutos.getSelectedItem());
            modelobaixar.setLitros(Integer.parseInt("" + jTableProdutos.getValueAt(jTableProdutos.getSelectedRow(), 3)));
            modelobaixar.setMaquina(maq);
            
            String data1 = data.format(jDateChooserDataInicial.getDate());
            String data2 = data.format(jDateChooserDataFinal.getDate());
            int qtddias = (int) calcdias.CalcularTempoUso(data1, data2);
            modelobaixar.setDias(qtddias);

            modelobaixar.setDatafinal(jDateChooserDataFinal.getDate());

            controle.baixar(modelobaixar);

            if (jCheckBoxNovoAutomatico.isSelected()) {

                modelobaixar.setDatainicial(jDateChooserDataFinal.getDate());
                controle.novo(modelobaixar);

            }

            preencherTabelaProdutos("select lan.lan_id, lan.prod_id, prod.prod_nometecnico, lan.litros, lan.data_inicio, lan.data_fim, lan.dias, lan.maquina from produtos_lancamentos as lan inner join produtos as prod on lan.prod_id = prod.prod_id where prod.prod_nometecnico = '" + jComboBoxProdutos.getSelectedItem() + "' and lan.maquina = '" + maq + "' order by lan.lan_id desc");
            jComboBoxLitros.setSelectedItem("00");
            jDateChooserDataInicial.setDate(null);
            jDateChooserDataFinal.setDate(null);
        }


    }//GEN-LAST:event_jButtonGerarActionPerformed

    private void jTableProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdutosMouseClicked

        if (jTableProdutos.getSelectedRow() != -1) {
            flag = 1; //não filtra
            jComboBoxProdutos.setSelectedItem("" + jTableProdutos.getValueAt(jTableProdutos.getSelectedRow(), 2));
            try {
                jDateChooserDataInicial.setDate(data.parse("" + jTableProdutos.getValueAt(jTableProdutos.getSelectedRow(), 4)));
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao retornar data para JDataChooser.");
            }
            flag = 0;
        }


    }//GEN-LAST:event_jTableProdutosMouseClicked

    private void jComboBoxProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProdutosActionPerformed
        
        if (flag != 1 && jComboBoxProdutos.getSelectedItem() != "Selecione") {

            modelobaixar.setNometecnico((String) jComboBoxProdutos.getSelectedItem());
            controle.buscacodigoproduto(modelobaixar);
            jLabelIdProduto.setText(String.valueOf(modelobaixar.getIdproduto()));

            preencherTabelaProdutos("select lan.lan_id, lan.prod_id, prod.prod_nometecnico, lan.litros, lan.data_inicio, lan.data_fim, lan.dias, lan.maquina from produtos_lancamentos as lan inner join produtos as prod on lan.prod_id = prod.prod_id where prod.prod_nometecnico = '" + jComboBoxProdutos.getSelectedItem() + " ' and lan.maquina = '" + maq + "' order by lan.lan_id desc");
            jButtonGerar.setEnabled(true);
            jComboBoxLitros.setSelectedItem("00");
        } else if (flag != 1 && jComboBoxProdutos.getSelectedItem() == "Selecione") {
            
            //jRadioButtonLavadora01Velha.setSelected(true);
            //jRadioButtonLavadora02Nova.setSelected(false);
            
            preencherTabelaProdutos("select lan.lan_id, lan.prod_id, prod.prod_nometecnico, lan.litros, lan.data_inicio, lan.data_fim, lan.dias, lan.maquina from produtos_lancamentos as lan inner join produtos as prod on lan.prod_id = prod.prod_id where lan.maquina = '" + maq + "' order by lan.lan_id desc");
            jButtonGerar.setEnabled(false);
            jLabelIdProduto.setText("vazio");
            jComboBoxLitros.setSelectedItem("00");
        }
        
        jDateChooserDataFinal.setDate(null);

    }//GEN-LAST:event_jComboBoxProdutosActionPerformed

    private void jCheckBoxNovoAutomaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxNovoAutomaticoActionPerformed
        jComboBoxLitros.setSelectedItem("00");
        if (jCheckBoxNovoAutomatico.isSelected()) {
            jComboBoxLitros.setEnabled(true);
        } else {
            jComboBoxLitros.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxNovoAutomaticoActionPerformed

    private void jTableProdutosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdutosMouseReleased

        if (jTableProdutos.getSelectedRow() != -1 && !jLabelIdProduto.getText().equals("vazio")) {
            if (evt.isPopupTrigger()) {
                if (ValidaAcessos.valida(3) == 2) {
                    return;
                }
                jPopupMenuOpçoes.show(jTableProdutos, evt.getX(), evt.getY());
            }
        }

    }//GEN-LAST:event_jTableProdutosMouseReleased

    private void jMenuItemIncluirSemBaixarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemIncluirSemBaixarActionPerformed
        IncluirSemBaixar();

    }//GEN-LAST:event_jMenuItemIncluirSemBaixarActionPerformed

    public void IncluirSemBaixar() {

        modelobaixar.setIdproduto(Integer.parseInt(jLabelIdProduto.getText()));
        modelobaixar.setMaquina(maq);

        
        jDateChooserDataInicial.setDate(new Date());
        modelobaixar.setDatainicial(jDateChooserDataInicial.getDate());
        modelobaixar.setLitros(Integer.parseInt((String) jComboBoxLitros.getSelectedItem()));

        if (jComboBoxLitros.getSelectedItem().equals("00")) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Informe a quantidade de litros do galão.");
            return;
        }
        controle.novo(modelobaixar);
        preencherTabelaProdutos("select lan.lan_id, lan.prod_id, prod.prod_nometecnico, lan.litros, lan.data_inicio, lan.data_fim, lan.dias, lan.maquina from produtos_lancamentos as lan inner join produtos as prod on lan.prod_id = prod.prod_id where prod.prod_nometecnico = '" + jComboBoxProdutos.getSelectedItem() + " ' and lan.maquina = '" + maq + "' order by lan.lan_id desc");

    }

    private void jMenuItemExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExcluirProdutoActionPerformed
        modelobaixar.setIdlancamento(Integer.parseInt("" + jTableProdutos.getValueAt(jTableProdutos.getSelectedRow(), 0)));
        controle.excluir(modelobaixar);
        preencherTabelaProdutos("select lan.lan_id, lan.prod_id, prod.prod_nometecnico, lan.litros, lan.data_inicio, lan.data_fim, lan.dias, lan.maquina from produtos_lancamentos as lan inner join produtos as prod on lan.prod_id = prod.prod_id where prod.prod_nometecnico = '" + jComboBoxProdutos.getSelectedItem() + " ' and lan.maquina = '" + maq + "' order by lan.lan_id desc");
    }//GEN-LAST:event_jMenuItemExcluirProdutoActionPerformed

    private void jMenuItemCancelarBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCancelarBaixaActionPerformed
        modelobaixar.setIdlancamento(Integer.parseInt("" + jTableProdutos.getValueAt(jTableProdutos.getSelectedRow(), 0)));
        controle.cancelarbaixar(modelobaixar);
        preencherTabelaProdutos("select lan.lan_id, lan.prod_id, prod.prod_nometecnico, lan.litros, lan.data_inicio, lan.data_fim, lan.dias, lan.maquina from produtos_lancamentos as lan inner join produtos as prod on lan.prod_id = prod.prod_id where prod.prod_nometecnico = '" + jComboBoxProdutos.getSelectedItem() + " ' and lan.maquina = '" + maq + "' order by lan.lan_id desc");
    }//GEN-LAST:event_jMenuItemCancelarBaixaActionPerformed

    private void jRadioButtonLavadora01VelhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonLavadora01VelhaActionPerformed
         jRadioButtonLavadora02Nova.setSelected(false);
         maq = 1;
        jComboBoxProdutos.setSelectedItem("Selecione");
        //preencherTabelaProdutos("select lan.lan_id, lan.prod_id, prod.prod_nometecnico, lan.litros, lan.data_inicio, lan.data_fim, lan.dias, lan.maquina from produtos_lancamentos as lan inner join produtos as prod on lan.prod_id = prod.prod_id where lan.maquina = '" + maq + "'order by lan.lan_id desc");
    }//GEN-LAST:event_jRadioButtonLavadora01VelhaActionPerformed

    private void jRadioButtonLavadora02NovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonLavadora02NovaActionPerformed
        jRadioButtonLavadora01Velha.setSelected(false);
        maq = 2;
        jComboBoxProdutos.setSelectedItem("Selecione");
        //preencherTabelaProdutos("select lan.lan_id, lan.prod_id, prod.prod_nometecnico, lan.litros, lan.data_inicio, lan.data_fim, lan.dias, lan.maquina from produtos_lancamentos as lan inner join produtos as prod on lan.prod_id = prod.prod_id where lan.maquina = '" + maq + "'order by lan.lan_id desc");
    }//GEN-LAST:event_jRadioButtonLavadora02NovaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGerar;
    private javax.swing.JCheckBox jCheckBoxNovoAutomatico;
    private javax.swing.JComboBox<String> jComboBoxLitros;
    private javax.swing.JComboBox<String> jComboBoxProdutos;
    private com.toedter.calendar.JDateChooser jDateChooserDataFinal;
    private com.toedter.calendar.JDateChooser jDateChooserDataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelIdProduto;
    private javax.swing.JMenuItem jMenuItemCancelarBaixa;
    private javax.swing.JMenuItem jMenuItemExcluirProduto;
    private javax.swing.JMenuItem jMenuItemIncluirSemBaixar;
    private javax.swing.JPopupMenu jPopupMenuOpçoes;
    private javax.swing.JRadioButton jRadioButtonLavadora01Velha;
    private javax.swing.JRadioButton jRadioButtonLavadora02Nova;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProdutos;
    // End of variables declaration//GEN-END:variables
}
