/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Visao;

import br.com.ConexaoBancoDados.ConexaoSql;
import br.com.Controle.ControleFuncionario;
import br.com.Controle.ControleLancamento;
import br.com.Modelo.ModeloFuncionario;
import br.com.Modelo.ModeloLancamento;
import br.com.Modelo.ModeloTabela;
import br.com.Modelo.ModeloDatas;
import br.com.Modelo.ModeloMovimentaEstoque;
import br.com.Modelo.ModeloPreencheComboBox;
import br.com.Utilitarios.ValidaAcessos;
import java.awt.AWTKeyStroke;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Lavanderia
 */
public class TelaConsultaPorID extends javax.swing.JFrame {

    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    ModeloFuncionario objmodfunc = new ModeloFuncionario();
    ControleFuncionario controle = new ControleFuncionario();
    ConexaoSql conexao = new ConexaoSql();
    ModeloLancamento modelonovo = new ModeloLancamento();
    ControleLancamento controlelancamentos = new ControleLancamento();
    SimpleDateFormat dataformatada = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat datahora = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
    ModeloDatas diasuso = new ModeloDatas();
    ModeloPreencheComboBox modpree = new ModeloPreencheComboBox();
    ModeloMovimentaEstoque movestoque = new ModeloMovimentaEstoque();

    public TelaConsultaPorID() {
        initComponents();

        HashSet conj;
        conj = new HashSet(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);

        jLabelLetra.setVisible(false);
        jComboStatus.removeAllItems();
        jComboStatus.addItem("TODOS");
        for (Object s : modpree.preencheStatus()) {
            jComboStatus.addItem((String) s);
        }
        jComboStatus.removeItem("Selecione");
        jComboStatus.setSelectedItem("TODOS");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldApelido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxEmpresas = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxCargos = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxDepartamentos = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLancamentos = new javax.swing.JTable();
        jButtonB = new javax.swing.JButton();
        jButtonA = new javax.swing.JButton();
        jButtonC = new javax.swing.JButton();
        jButtonD = new javax.swing.JButton();
        jButtonE = new javax.swing.JButton();
        jLabelLetra = new javax.swing.JLabel();
        jButtonTodos = new javax.swing.JButton();
        jComboStatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Funcionário por ID");
        setBackground(new java.awt.Color(204, 255, 204));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setToolTipText("");

        jLabel2.setText("ID");

        jTextFieldCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldCodigoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCodigoFocusLost(evt);
            }
        });

        jLabel3.setText("Numero");

        jTextFieldNumero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldNumero.setToolTipText("Informe o número do funcionário.");
        jTextFieldNumero.setEnabled(false);

        jLabel6.setText("Nome");

        jTextFieldNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldNome.setToolTipText("Informe o nome do funcionário.");
        jTextFieldNome.setEnabled(false);

        jLabel13.setText("Apelido");

        jTextFieldApelido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldApelido.setEnabled(false);

        jLabel9.setText("Empresa");

        jComboBoxEmpresas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxEmpresas.setEnabled(false);

        jLabel8.setText("Cargo");

        jComboBoxCargos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCargos.setEnabled(false);

        jLabel10.setText("Setor");

        jComboBoxDepartamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxDepartamentos.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxCargos, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jTextFieldApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxCargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 860, 100);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jTableLancamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableLancamentos);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(12, 90, 830, 210);

        jButtonB.setBackground(new java.awt.Color(204, 255, 255));
        jButtonB.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonB.setForeground(new java.awt.Color(0, 0, 204));
        jButtonB.setText("B");
        jButtonB.setToolTipText("Filtra as roupa em uso com a letra [ B ].");
        jButtonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonB);
        jButtonB.setBounds(70, 30, 56, 52);

        jButtonA.setBackground(new java.awt.Color(204, 255, 255));
        jButtonA.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonA.setForeground(new java.awt.Color(0, 0, 204));
        jButtonA.setText("A");
        jButtonA.setToolTipText("Filtra as roupa em uso com a letra [ A ].");
        jButtonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonA);
        jButtonA.setBounds(10, 30, 56, 52);

        jButtonC.setBackground(new java.awt.Color(204, 255, 255));
        jButtonC.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonC.setForeground(new java.awt.Color(0, 0, 204));
        jButtonC.setText("C");
        jButtonC.setToolTipText("Filtra as roupa em uso com a letra [ C ].");
        jButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonC);
        jButtonC.setBounds(130, 30, 56, 52);

        jButtonD.setBackground(new java.awt.Color(204, 255, 255));
        jButtonD.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonD.setForeground(new java.awt.Color(0, 0, 204));
        jButtonD.setText("D");
        jButtonD.setToolTipText("Filtra as roupa em uso com a letra [ D ].");
        jButtonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonD);
        jButtonD.setBounds(190, 30, 56, 52);

        jButtonE.setBackground(new java.awt.Color(204, 255, 255));
        jButtonE.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonE.setForeground(new java.awt.Color(0, 0, 204));
        jButtonE.setText("E");
        jButtonE.setToolTipText("Filtra as roupa em uso com a letra [ E ].");
        jButtonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonE);
        jButtonE.setBounds(250, 30, 56, 52);

        jLabelLetra.setText("A");
        jPanel2.add(jLabelLetra);
        jLabelLetra.setBounds(330, 10, 20, 20);

        jButtonTodos.setBackground(new java.awt.Color(204, 255, 255));
        jButtonTodos.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonTodos.setForeground(new java.awt.Color(0, 0, 204));
        jButtonTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Todos 32px.png"))); // NOI18N
        jButtonTodos.setToolTipText("Todas as roupas.");
        jButtonTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTodosActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonTodos);
        jButtonTodos.setBounds(310, 30, 56, 52);

        jComboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboStatusActionPerformed(evt);
            }
        });
        jPanel2.add(jComboStatus);
        jComboStatus.setBounds(650, 30, 190, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 120, 860, 310);

        setSize(new java.awt.Dimension(893, 482));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAActionPerformed
        jButtonA.setBackground(new java.awt.Color(0, 204, 102));
        jButtonB.setBackground(new java.awt.Color(204, 255, 255));
        jButtonC.setBackground(new java.awt.Color(204, 255, 255));
        jButtonD.setBackground(new java.awt.Color(204, 255, 255));
        jButtonE.setBackground(new java.awt.Color(204, 255, 255));
        jButtonTodos.setBackground(new java.awt.Color(204, 255, 255));

        jLabelLetra.setText("A");
        String cargo = (String) jComboStatus.getSelectedItem();
        if (jComboStatus.getSelectedItem() == "TODOS") {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_cod ='" + jTextFieldCodigo.getText() + "' and (l.lan_letra = 'A') order by l.lan_fun_num, l.lan_letra asc");
        } else {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_cod ='" + jTextFieldCodigo.getText() + "' and (l.lan_sta_cod = '" + modpree.buscaCodigoStatus(cargo) + "') and (l.lan_letra = 'A') order by l.lan_fun_num, l.lan_letra asc");
        };
    }//GEN-LAST:event_jButtonAActionPerformed

    private void jButtonBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBActionPerformed
        jButtonB.setBackground(new java.awt.Color(0, 204, 102));
        jButtonA.setBackground(new java.awt.Color(204, 255, 255));
        jButtonC.setBackground(new java.awt.Color(204, 255, 255));
        jButtonD.setBackground(new java.awt.Color(204, 255, 255));
        jButtonE.setBackground(new java.awt.Color(204, 255, 255));
        jButtonTodos.setBackground(new java.awt.Color(204, 255, 255));

        jLabelLetra.setText("B");
        String cargo = (String) jComboStatus.getSelectedItem();
        if (jComboStatus.getSelectedItem() == "TODOS") {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_cod ='" + jTextFieldCodigo.getText() + "' and (l.lan_letra = 'B') order by l.lan_fun_num, l.lan_letra asc");
        } else {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_cod ='" + jTextFieldCodigo.getText() + "' and (l.lan_sta_cod = '" + modpree.buscaCodigoStatus(cargo) + "') and (l.lan_letra = 'B') order by l.lan_fun_num, l.lan_letra asc");
        };
    }//GEN-LAST:event_jButtonBActionPerformed

    private void jButtonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCActionPerformed
        jButtonC.setBackground(new java.awt.Color(0, 204, 102));
        jButtonA.setBackground(new java.awt.Color(204, 255, 255));
        jButtonB.setBackground(new java.awt.Color(204, 255, 255));
        jButtonD.setBackground(new java.awt.Color(204, 255, 255));
        jButtonE.setBackground(new java.awt.Color(204, 255, 255));
        jButtonTodos.setBackground(new java.awt.Color(204, 255, 255));

        jLabelLetra.setText("C");
        String cargo = (String) jComboStatus.getSelectedItem();
        if (jComboStatus.getSelectedItem() == "TODOS") {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_cod ='" + jTextFieldCodigo.getText() + "' and (l.lan_letra = 'C') order by l.lan_fun_num, l.lan_letra asc");
        } else {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_cod ='" + jTextFieldCodigo.getText() + "' and (l.lan_sta_cod = '" + modpree.buscaCodigoStatus(cargo) + "') and (l.lan_letra = 'C') order by l.lan_fun_num, l.lan_letra asc");
        };
    }//GEN-LAST:event_jButtonCActionPerformed

    private void jButtonDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDActionPerformed
        jButtonD.setBackground(new java.awt.Color(0, 204, 102));
        jButtonA.setBackground(new java.awt.Color(204, 255, 255));
        jButtonB.setBackground(new java.awt.Color(204, 255, 255));
        jButtonC.setBackground(new java.awt.Color(204, 255, 255));
        jButtonE.setBackground(new java.awt.Color(204, 255, 255));
        jButtonTodos.setBackground(new java.awt.Color(204, 255, 255));

        jLabelLetra.setText("D");
        String cargo = (String) jComboStatus.getSelectedItem();
        if (jComboStatus.getSelectedItem() == "TODOS") {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_cod ='" + jTextFieldCodigo.getText() + "' and (l.lan_letra = 'D') order by l.lan_fun_num, l.lan_letra asc");
        } else {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_cod ='" + jTextFieldCodigo.getText() + "' and (l.lan_sta_cod = '" + modpree.buscaCodigoStatus(cargo) + "') and (l.lan_letra = 'D') order by l.lan_fun_num, l.lan_letra asc");
        };
    }//GEN-LAST:event_jButtonDActionPerformed

    private void jButtonEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEActionPerformed
        jButtonE.setBackground(new java.awt.Color(0, 204, 102));
        jButtonA.setBackground(new java.awt.Color(204, 255, 255));
        jButtonB.setBackground(new java.awt.Color(204, 255, 255));
        jButtonC.setBackground(new java.awt.Color(204, 255, 255));
        jButtonD.setBackground(new java.awt.Color(204, 255, 255));
        jButtonTodos.setBackground(new java.awt.Color(204, 255, 255));

        jLabelLetra.setText("E");
        String cargo = (String) jComboStatus.getSelectedItem();
        if (jComboStatus.getSelectedItem() == "TODOS") {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_cod ='" + jTextFieldCodigo.getText() + "' and (l.lan_letra = 'E') order by l.lan_fun_num, l.lan_letra asc");
        } else {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_cod ='" + jTextFieldCodigo.getText() + "' and (l.lan_sta_cod = '" + modpree.buscaCodigoStatus(cargo) + "') and (l.lan_letra = 'E') order by l.lan_fun_num, l.lan_letra asc");
        };
    }//GEN-LAST:event_jButtonEActionPerformed

    private void jButtonTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTodosActionPerformed
        jButtonTodos.setBackground(new java.awt.Color(0, 204, 102));
        jButtonA.setBackground(new java.awt.Color(204, 255, 255));
        jButtonB.setBackground(new java.awt.Color(204, 255, 255));
        jButtonC.setBackground(new java.awt.Color(204, 255, 255));
        jButtonD.setBackground(new java.awt.Color(204, 255, 255));
        jButtonE.setBackground(new java.awt.Color(204, 255, 255));

        String cargo = (String) jComboStatus.getSelectedItem();
        if (jComboStatus.getSelectedItem() == "TODOS") {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_cod ='" + jTextFieldCodigo.getText() + "'order by l.lan_fun_num, l.lan_letra asc");
        } else {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_cod ='" + jTextFieldCodigo.getText() + "' and (l.lan_sta_cod = '" + modpree.buscaCodigoStatus(cargo) + "') order by l.lan_fun_num, l.lan_letra asc");
        };

    }//GEN-LAST:event_jButtonTodosActionPerformed

    private void jComboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboStatusActionPerformed
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Numero", "Letra", "Entrega", "Uniforme", "Tamanho", "Status", "Tipo", "Data Baixa", "Dias Uso", "Historico", "Ult. Mov."};
        ModeloTabela modelotab = new ModeloTabela(dados, colunas);
        jTableLancamentos.setModel(modelotab);

        jButtonA.setBackground(new java.awt.Color(204, 255, 255));
        jButtonB.setBackground(new java.awt.Color(204, 255, 255));
        jButtonC.setBackground(new java.awt.Color(204, 255, 255));
        jButtonD.setBackground(new java.awt.Color(204, 255, 255));
        jButtonE.setBackground(new java.awt.Color(204, 255, 255));
        jButtonTodos.setBackground(new java.awt.Color(204, 255, 255));
    }//GEN-LAST:event_jComboStatusActionPerformed

    private void jTextFieldCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodigoFocusLost

        if (jTextFieldCodigo.getText().equals("")) {
            return;
        }

        jButtonA.setBackground(new java.awt.Color(204, 255, 255));
        jButtonB.setBackground(new java.awt.Color(204, 255, 255));
        jButtonC.setBackground(new java.awt.Color(204, 255, 255));
        jButtonD.setBackground(new java.awt.Color(204, 255, 255));
        jButtonE.setBackground(new java.awt.Color(204, 255, 255));
        jButtonTodos.setBackground(new java.awt.Color(204, 255, 255));

        jButtonA.setEnabled(true);
        jButtonB.setEnabled(true);
        jButtonC.setEnabled(true);
        jButtonD.setEnabled(true);
        jButtonE.setEnabled(true);
        jButtonTodos.setEnabled(true);

        objmodfunc.setFuncod(Integer.parseInt(jTextFieldCodigo.getText()));
              
        
        ModeloFuncionario modelo2 = controle.buscaIDFuncionario(objmodfunc);
        if (objmodfunc.getFuncod() == -1) {
            jTextFieldCodigo.requestFocus();
            return;
        }

        jTextFieldNumero.setText(Integer.toString(modelo2.getFunnum()));
        jTextFieldNome.setText(modelo2.getFunnome());
        jTextFieldApelido.setText(modelo2.getFunapelido());

        jComboBoxEmpresas.removeAllItems();
        jComboBoxEmpresas.addItem(modelo2.getDescricao_empresa());

        jComboBoxCargos.removeAllItems();
        jComboBoxCargos.addItem(modelo2.getDescricao_cargo());

        jComboBoxDepartamentos.removeAllItems();
        jComboBoxDepartamentos.addItem(modelo2.getDescricao_departamento());

        mudacorjpanel();
        preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_cod ='" + objmodfunc.getFuncod() + "' order by l.lan_fun_num, l.lan_letra asc");
    }//GEN-LAST:event_jTextFieldCodigoFocusLost

    private void jTextFieldCodigoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodigoFocusGained
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Numero", "Letra", "Entrega", "Uniforme", "Tamanho", "Status", "Tipo", "Data Baixa", "Dias Uso", "Historico", "Ult. Mov."};
        ModeloTabela modelotab = new ModeloTabela(dados, colunas);
        jTableLancamentos.setModel(modelotab);
        jLabelLetra.setText("A");
        jButtonA.setBackground(new java.awt.Color(204, 255, 255));
        jButtonB.setBackground(new java.awt.Color(204, 255, 255));
        jButtonD.setBackground(new java.awt.Color(204, 255, 255));
        jButtonE.setBackground(new java.awt.Color(204, 255, 255));
        jButtonTodos.setBackground(new java.awt.Color(204, 255, 255));
        jButtonA.setEnabled(false);
        jButtonB.setEnabled(false);
        jButtonC.setEnabled(false);
        jButtonD.setEnabled(false);
        jButtonE.setEnabled(false);
        jButtonTodos.setEnabled(false);

        jTextFieldCodigo.setText("");
        jTextFieldNumero.setText("");
        jTextFieldApelido.setText("");
        jTextFieldNome.setText("");

        jComboBoxCargos.removeAllItems();
        jComboBoxDepartamentos.removeAllItems();
        jComboBoxEmpresas.removeAllItems();
        jComboStatus.setSelectedItem("TODOS");
    }//GEN-LAST:event_jTextFieldCodigoFocusGained

    public void preencherTabelaLancamentos(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Numero", "Letra", "Entrega", "Uniforme", "Tamanho", "Status", "Tipo", "Data Baixa", "Dias Uso", "Historico", "Ult. Mov.", "ID Func.", "Usuário"};

        long dias;
        conexao.getConexaoSql();

        try {
            conexao.executaSql(sql);
            SimpleDateFormat dataformatada = new SimpleDateFormat("dd/MM/yyyy");
            conexao.rs.first();
            int cod = conexao.rs.getInt("lan_cod"); // faz gerar o erro para o try cath ser acionado - rs vazio

            do {
                modelonovo.setLanentrega(conexao.rs.getDate("lan_data_entrega"));
                String data1 = dataformatada.format(new Date());
                String data2 = dataformatada.format(modelonovo.getLanentrega());
                dias = diasuso.CalcularTempoUso(data2, data1);

                String databaixa;

                if (conexao.rs.getDate("lan_data_baixa") != null) {
                    databaixa = df.format(conexao.rs.getDate("lan_data_baixa").getTime());
                    dias = conexao.rs.getLong("lan_dias_uso");
                } else {
                    databaixa = null;
                }

                int usuario = conexao.rs.getInt("lan_usuario_cod");

                dados.add(new Object[]{conexao.rs.getInt("lan_cod"), conexao.rs.getInt("lan_fun_num"), conexao.rs.getString("lan_letra"), df.format(conexao.rs.getDate("lan_data_entrega").getTime()), conexao.rs.getString("uni_descricao"), conexao.rs.getString("tam_sigla"), conexao.rs.getString("sta_descricao"), conexao.rs.getString("lan_tipo"), databaixa, dias, conexao.rs.getString("lan_historico"), conexao.rs.getString("lan_ult_mov"), conexao.rs.getInt("lan_fun_cod"), buscaNomeUsuario(usuario)});
            } while (conexao.rs.next());

            ModeloTabela modelotab = new ModeloTabela(dados, colunas);
            jTableLancamentos.setModel(modelotab);

            jTableLancamentos.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableLancamentos.getColumnModel().getColumn(1).setPreferredWidth(60);
            jTableLancamentos.getColumnModel().getColumn(2).setPreferredWidth(40);
            jTableLancamentos.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTableLancamentos.getColumnModel().getColumn(4).setPreferredWidth(200);
            jTableLancamentos.getColumnModel().getColumn(5).setPreferredWidth(70);
            jTableLancamentos.getColumnModel().getColumn(6).setPreferredWidth(140);
            jTableLancamentos.getColumnModel().getColumn(7).setPreferredWidth(40);
            jTableLancamentos.getColumnModel().getColumn(8).setPreferredWidth(80);
            jTableLancamentos.getColumnModel().getColumn(9).setPreferredWidth(70);
            jTableLancamentos.getColumnModel().getColumn(10).setPreferredWidth(80);
            jTableLancamentos.getColumnModel().getColumn(11).setPreferredWidth(80);

            jTableLancamentos.setAutoResizeMode(jTableLancamentos.AUTO_RESIZE_OFF);
            jTableLancamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jTableLancamentos.setAutoCreateRowSorter(true);

            conexao.FecharConexao();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nenhum lançamento encontrado.");
            limpaTabelaLamcamentos();

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

    public void limpaTabelaLamcamentos() {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Numero", "Letra", "Entrega", "Uniforme", "Tamanho", "Status", "Tipo", "Data Baixa", "Dias Uso", "Historico", "Ult. Mov.", "ID Func."};
        ModeloTabela modelotab = new ModeloTabela(dados, colunas);
        jTableLancamentos.setModel(modelotab);
    }

    public void mudacorjpanel() {
        String cargos = (String) jComboBoxCargos.getSelectedItem();
        String procurarpor = "encarregado";
        String deptos = (String) jComboBoxDepartamentos.getSelectedItem();
        String proclimpeza = "limpeza";
        String procmanut = "manute";
        String procanimais = "animais";
        String procmaquinas = "maquinas";
        String procgraxaria = "graxa";
        String proctrab = "trabalho";
        if (cargos.toLowerCase().contains(procurarpor.toLowerCase())) {                //toLowerCase - ignora maíusculas e minúsculas
            jPanel1.setBackground(new java.awt.Color(255, 255, 0));
        } else if (cargos.toLowerCase().contains(proclimpeza.toLowerCase())) {            //toLowerCase - ignora maíusculas e minúsculas
            jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        } else if (deptos.toLowerCase().contains(procmanut.toLowerCase()) || deptos.toLowerCase().contains(procanimais.toLowerCase()) || deptos.toLowerCase().contains(procmaquinas.toLowerCase()) || deptos.toLowerCase().contains(procgraxaria.toLowerCase())) {            //toLowerCase - ignora maíusculas e minúsculas
            jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        } else if (deptos.toLowerCase().contains(proctrab.toLowerCase())) {
            jPanel1.setBackground(new java.awt.Color(0, 153, 51));
        } else {
            jPanel1.setBackground(new java.awt.Color(240, 240, 240));
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
            java.util.logging.Logger.getLogger(TelaConsultaPorID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaPorID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaPorID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaPorID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsultaPorID().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonA;
    private javax.swing.JButton jButtonB;
    private javax.swing.JButton jButtonC;
    private javax.swing.JButton jButtonD;
    private javax.swing.JButton jButtonE;
    private javax.swing.JButton jButtonTodos;
    private javax.swing.JComboBox<String> jComboBoxCargos;
    private javax.swing.JComboBox<String> jComboBoxDepartamentos;
    private javax.swing.JComboBox<String> jComboBoxEmpresas;
    private javax.swing.JComboBox<String> jComboStatus;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelLetra;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLancamentos;
    private javax.swing.JTextField jTextFieldApelido;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumero;
    // End of variables declaration//GEN-END:variables
}
