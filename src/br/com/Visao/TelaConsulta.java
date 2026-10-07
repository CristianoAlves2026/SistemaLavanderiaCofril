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
public class TelaConsulta extends javax.swing.JFrame {

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

    public TelaConsulta() {
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

        jPopupMenuModificar = new javax.swing.JPopupMenu();
        jMenuLetras = new javax.swing.JMenu();
        jMenuItemA = new javax.swing.JMenuItem();
        jMenuItemB = new javax.swing.JMenuItem();
        jMenuItemC = new javax.swing.JMenuItem();
        jMenuItemD = new javax.swing.JMenuItem();
        jMenuItemE = new javax.swing.JMenuItem();
        jMenuAlterarStatus = new javax.swing.JMenu();
        JMenuItemDescartado = new javax.swing.JMenuItem();
        jMenuItemReaproveitamento = new javax.swing.JMenuItem();
        jMenuItemExtraviado = new javax.swing.JMenuItem();
        jMenuItemCancelarBaixa = new javax.swing.JMenuItem();
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
        jPanelTransferir = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jButtonTransferir = new javax.swing.JButton();
        jButtonCapturar = new javax.swing.JButton();
        jLabelID1 = new javax.swing.JLabel();
        jLabelNumero1 = new javax.swing.JLabel();
        jLabelNome1 = new javax.swing.JLabel();
        jComboStatus = new javax.swing.JComboBox<>();

        jMenuLetras.setText("Mudar letra para ...");

        jMenuItemA.setText("A");
        jMenuItemA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAActionPerformed(evt);
            }
        });
        jMenuLetras.add(jMenuItemA);

        jMenuItemB.setText("B");
        jMenuItemB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBActionPerformed(evt);
            }
        });
        jMenuLetras.add(jMenuItemB);

        jMenuItemC.setText("C");
        jMenuItemC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCActionPerformed(evt);
            }
        });
        jMenuLetras.add(jMenuItemC);

        jMenuItemD.setText("D");
        jMenuItemD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDActionPerformed(evt);
            }
        });
        jMenuLetras.add(jMenuItemD);

        jMenuItemE.setText("E");
        jMenuItemE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEActionPerformed(evt);
            }
        });
        jMenuLetras.add(jMenuItemE);

        jPopupMenuModificar.add(jMenuLetras);

        jMenuAlterarStatus.setText("Alterar Status");
        jMenuAlterarStatus.setToolTipText("");

        JMenuItemDescartado.setText("Descartado");
        JMenuItemDescartado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemDescartadoActionPerformed(evt);
            }
        });
        jMenuAlterarStatus.add(JMenuItemDescartado);

        jMenuItemReaproveitamento.setText("Reaproveitamento");
        jMenuItemReaproveitamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReaproveitamentoActionPerformed(evt);
            }
        });
        jMenuAlterarStatus.add(jMenuItemReaproveitamento);

        jMenuItemExtraviado.setText("Extraviado");
        jMenuItemExtraviado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExtraviadoActionPerformed(evt);
            }
        });
        jMenuAlterarStatus.add(jMenuItemExtraviado);

        jPopupMenuModificar.add(jMenuAlterarStatus);

        jMenuItemCancelarBaixa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemCancelarBaixa.setText("Cancelar Baixa");
        jMenuItemCancelarBaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCancelarBaixaActionPerformed(evt);
            }
        });
        jPopupMenuModificar.add(jMenuItemCancelarBaixa);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setToolTipText("");

        jLabel2.setText("ID");

        jTextFieldCodigo.setEnabled(false);
        jTextFieldCodigo.setRequestFocusEnabled(false);

        jLabel3.setText("Numero");

        jTextFieldNumero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldNumero.setToolTipText("Informe o número do funcionário.");
        jTextFieldNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNumeroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNumeroFocusLost(evt);
            }
        });

        jLabel6.setText("Nome");

        jTextFieldNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldNome.setToolTipText("Informe o nome do funcionário.");
        jTextFieldNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNomeFocusLost(evt);
            }
        });

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
        jTableLancamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableLancamentosMouseReleased(evt);
            }
        });
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

        jPanelTransferir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelTransferir.setForeground(new java.awt.Color(0, 0, 255));
        jPanelTransferir.setLayout(null);

        jLabelNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanelTransferir.add(jLabelNome);
        jLabelNome.setBounds(110, 30, 240, 20);

        jLabelNumero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanelTransferir.add(jLabelNumero);
        jLabelNumero.setBounds(50, 30, 50, 20);

        jLabelID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanelTransferir.add(jLabelID);
        jLabelID.setBounds(10, 30, 40, 20);

        jButtonTransferir.setText("Trasnferir");
        jButtonTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransferirActionPerformed(evt);
            }
        });
        jPanelTransferir.add(jButtonTransferir);
        jButtonTransferir.setBounds(360, 40, 90, 30);

        jButtonCapturar.setText("Capturar");
        jButtonCapturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCapturarActionPerformed(evt);
            }
        });
        jPanelTransferir.add(jButtonCapturar);
        jButtonCapturar.setBounds(360, 10, 90, 30);

        jLabelID1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelID1.setText("ID");
        jPanelTransferir.add(jLabelID1);
        jLabelID1.setBounds(10, 10, 40, 20);

        jLabelNumero1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNumero1.setText("Numero");
        jPanelTransferir.add(jLabelNumero1);
        jLabelNumero1.setBounds(50, 10, 50, 20);

        jLabelNome1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNome1.setText("Nome");
        jPanelTransferir.add(jLabelNome1);
        jLabelNome1.setBounds(110, 10, 50, 20);

        jPanel2.add(jPanelTransferir);
        jPanelTransferir.setBounds(380, 10, 460, 80);

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

        setSize(new java.awt.Dimension(893, 477));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeFocusLost
        if (jTextFieldNome.getText().equals("")) {
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

        objmodfunc.setPesquisa(jTextFieldNome.getText());
        ModeloFuncionario modelo2 = controle.buscaFuncionario(objmodfunc);
        if (objmodfunc.getFuncod() == -1) {
            jTextFieldNome.setText("");
            jTextFieldNumero.setText("");
            jTextFieldNumero.requestFocus();
            return;
        }

        jTextFieldCodigo.setText(Integer.toString(modelo2.getFuncod()));
        jTextFieldNumero.setText(Integer.toString(modelo2.getFunnum()));
        jTextFieldNome.setText(modelo2.getFunnome());
        jTextFieldApelido.setText(modelo2.getFunapelido());

        jComboBoxEmpresas.removeAllItems();
        jComboBoxEmpresas.addItem(modelo2.getDescricao_empresa());

        jComboBoxCargos.removeAllItems();
        jComboBoxCargos.addItem(modelo2.getDescricao_cargo());

        jComboBoxDepartamentos.removeAllItems();
        jComboBoxDepartamentos.addItem(modelo2.getDescricao_departamento());

        //preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + modelo2.getFunnum() + "' and (l.lan_sta_cod = 1) and (l.lan_letra = '" + jLabelLetra.getText() + "') order by lan_letra, lan_uni_cod asc");

    }//GEN-LAST:event_jTextFieldNomeFocusLost

    private void jTextFieldNumeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNumeroFocusLost

        if (jTextFieldNumero.getText().equals("")) {
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

        objmodfunc.setFunnum(Integer.parseInt(jTextFieldNumero.getText()));
        ModeloFuncionario modelo2 = controle.buscaCodigoFuncionario(objmodfunc);
        if (objmodfunc.getFuncod() == -1) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + objmodfunc.getFunnum() + "' order by lan_letra, lan_uni_cod asc");
            return;
        }
        jTextFieldCodigo.setText(Integer.toString(modelo2.getFuncod()));
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
        preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + objmodfunc.getFunnum() + "' order by lan_letra, lan_uni_cod asc");
        
    }//GEN-LAST:event_jTextFieldNumeroFocusLost

    private void jTextFieldNumeroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNumeroFocusGained
        boolean titulo = getTitle().equals("Consulta de Lançamentos.");
        if (titulo == false) {
            jComboStatus.setSelectedItem("EM USO");
            jComboStatus.setEnabled(false);
            jButtonTodos.setVisible(false);
            setTitle("Manutenção de Lançamentos");
        }
        ConusltaXManut();

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


    }//GEN-LAST:event_jTextFieldNumeroFocusGained

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
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' and (l.lan_letra = 'A') order by lan_letra, lan_uni_cod asc");
        } else {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' and (l.lan_sta_cod = '" + modpree.buscaCodigoStatus(cargo) + "') and (l.lan_letra = 'A') order by lan_letra, lan_uni_cod asc");
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
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' and (l.lan_letra = 'B') order by lan_letra, lan_uni_cod asc");
        } else {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' and (l.lan_sta_cod = '" + modpree.buscaCodigoStatus(cargo) + "') and (l.lan_letra = 'B') order by lan_letra, lan_uni_cod asc");
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
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' and (l.lan_letra = 'C') order by lan_letra, lan_uni_cod asc");
        } else {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' and (l.lan_sta_cod = '" + modpree.buscaCodigoStatus(cargo) + "') and (l.lan_letra = 'C') order by lan_letra, lan_uni_cod asc");
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
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' and (l.lan_letra = 'D') order by lan_letra, lan_uni_cod asc");
        } else {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' and (l.lan_sta_cod = '" + modpree.buscaCodigoStatus(cargo) + "') and (l.lan_letra = 'D') order by lan_letra, lan_uni_cod asc");
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
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' and (l.lan_letra = 'E') order by lan_letra, lan_uni_cod asc");
        } else {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' and (l.lan_sta_cod = '" + modpree.buscaCodigoStatus(cargo) + "') and (l.lan_letra = 'E') order by lan_letra, lan_uni_cod asc");
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
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + jTextFieldNumero.getText() + "'order by lan_letra, lan_uni_cod asc");
        } else {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' and (l.lan_sta_cod = '" + modpree.buscaCodigoStatus(cargo) + "') order by lan_uni_cod asc");
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

    private void jButtonCapturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCapturarActionPerformed
        if (ValidaAcessos.valida(4)==2) {return;}
        if (jTextFieldNumero.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe um numero de funcionários para capturar.");
            return;
        }
        jLabelID.setText(jTextFieldCodigo.getText());
        jLabelNumero.setText(jTextFieldNumero.getText());
        jLabelNome.setText(jTextFieldNome.getText());
        jTextFieldNumero.requestFocus();


    }//GEN-LAST:event_jButtonCapturarActionPerformed

    private void jButtonTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransferirActionPerformed
        if (ValidaAcessos.valida(4)==2) {return;}
        if (jLabelNumero.getText().equals("") || jTextFieldNumero.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Capture um número de funcionário antes de transferir.");
            return;
        }
        if (jLabelNumero.getText().equals(jTextFieldNumero.getText())) {
            JOptionPane.showMessageDialog(null, "Impossível transferir para o mesmo número.");
            return;
        }

        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Confirma a transferência dos uniformes conforme abaixo? \n\n" + "Do Nº: " + jTextFieldNumero.getText() + " para o Nº " + jLabelNumero.getText());
        if (resposta == JOptionPane.NO_OPTION || resposta == JOptionPane.CANCEL_OPTION) {
            return;
        }
        modelonovo.setLannumero(Integer.parseInt(jLabelNumero.getText()));
        modelonovo.setLanfuncod(Integer.parseInt(jLabelID.getText()));
        modelonovo.setLanletra(jLabelLetra.getText());
        objmodfunc.setFunnum(Integer.parseInt(jTextFieldNumero.getText()));

        controlelancamentos.transferir(modelonovo, objmodfunc);
        limpaTabelaLamcamentos();

    }//GEN-LAST:event_jButtonTransferirActionPerformed

    private void jTableLancamentosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLancamentosMouseReleased
        if (jTableLancamentos.getSelectedRow() != -1) {
            int x, y, anos = 0, dias = 0, meses = 0;
            String z = "" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 9);
            x = Integer.parseInt(z);
            y = 0;
            
            anos = x / 360;
            y = x%360;
            meses = y/30;
            dias = y%30;
            
            if (anos == 0 && meses != 0){
                jTableLancamentos.setToolTipText("Em uso a " + meses + " mes(es) e " + dias + " dia(s).");
            }else if (anos == 0 && meses == 0){
                jTableLancamentos.setToolTipText("Em uso a " + dias + " dia(s).");
            }else if (dias == 0){    
                jTableLancamentos.setToolTipText("Em uso a " + anos + " ano(s) e " + meses + " mes(es). ");
            }else if (meses == 0){    
                jTableLancamentos.setToolTipText("Em uso a " + anos + " ano(s) e " + dias + " dia(s).");
            }else{    
                jTableLancamentos.setToolTipText("Em uso a " + anos + " ano(s), " + meses + " mes(es) e " + dias + " dia(s).");
            }
            z = jTableLancamentos.getToolTipText();
        }
        
        if (!jPanelTransferir.isVisible()) {
            if (jTableLancamentos.getSelectedRow() != -1) {
                if (evt.isPopupTrigger()) {
                    jPopupMenuModificar.show(jTableLancamentos, evt.getX(), evt.getY());
                }
            }
        }
        modelonovo.setBarrastatus(datahora.format(new Date()) + "  --->  " + "" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 1) + " " + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 2) + " - " + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 4) + "   [ " + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 5) + " ]  TIPO: " + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 7) + "   Dias: " + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 9) + "   ID: " + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 0) + "   Data: " + datahora.format(new Date()));
    }//GEN-LAST:event_jTableLancamentosMouseReleased

    private void jMenuItemAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAActionPerformed
        if (ValidaAcessos.valida(4)==2) {return;}
        modelonovo.setTipomanutencao("LETRA MODIFICADA PARA (A)");
        modelonovo.setLanletra("A");
        String codigo = "" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 0);
        modelonovo.setLancod(Integer.parseInt(codigo));
        controlelancamentos.modificaLetra(modelonovo);
        jButtonAActionPerformed(evt);
    }//GEN-LAST:event_jMenuItemAActionPerformed

    private void jMenuItemBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBActionPerformed
        if (ValidaAcessos.valida(4)==2) {return;}
        modelonovo.setTipomanutencao("LETRA MODIFICADA PARA (B)");
        modelonovo.setLanletra("B");
        String codigo = "" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 0);
        modelonovo.setLancod(Integer.parseInt(codigo));
        controlelancamentos.modificaLetra(modelonovo);
        jButtonBActionPerformed(evt);
    }//GEN-LAST:event_jMenuItemBActionPerformed

    private void jMenuItemCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCActionPerformed
        if (ValidaAcessos.valida(4)==2) {return;}
        modelonovo.setTipomanutencao("LETRA MODIFICADA PARA (C)");
        modelonovo.setLanletra("C");
        String codigo = "" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 0);
        modelonovo.setLancod(Integer.parseInt(codigo));
        controlelancamentos.modificaLetra(modelonovo);
        jButtonCActionPerformed(evt);
    }//GEN-LAST:event_jMenuItemCActionPerformed

    private void jMenuItemDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDActionPerformed
        if (ValidaAcessos.valida(4)==2) {return;}
        modelonovo.setTipomanutencao("LETRA MODIFICADA PARA (D)");
        modelonovo.setLanletra("D");
        String codigo = "" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 0);
        modelonovo.setLancod(Integer.parseInt(codigo));
        controlelancamentos.modificaLetra(modelonovo);
        jButtonDActionPerformed(evt);
    }//GEN-LAST:event_jMenuItemDActionPerformed

    private void jMenuItemEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEActionPerformed
        if (ValidaAcessos.valida(4)==2) {return;}
        modelonovo.setTipomanutencao("LETRA MODIFICADA PARA (E)");
        modelonovo.setLanletra("E");
        String codigo = "" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 0);
        modelonovo.setLancod(Integer.parseInt(codigo));
        controlelancamentos.modificaLetra(modelonovo);
        jButtonEActionPerformed(evt);
    }//GEN-LAST:event_jMenuItemEActionPerformed

    private void jMenuItemCancelarBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCancelarBaixaActionPerformed
        if (ValidaAcessos.valida(4)==2) {return;}
        int resposta =  JOptionPane.showConfirmDialog(rootPane, "Confirma cancelamento da baixa do uniforme selecionado");
        if (resposta == JOptionPane.YES_OPTION){
            if ( jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 6).equals("EM USO") || jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 6).equals("RETORNO ESTOQUE")){
                JOptionPane.showMessageDialog(null, "Não é possível cancelar a baixa deste tipo de Status");
                return;
            }
            modelonovo.setTipomanutencao("BAIXA CANCELADA");
            modelonovo.setLanstatus(1);
            modelonovo.setLandatabaixa(null);
            modelonovo.setLandias(0);
            modelonovo.setLanhistorico("Baixa cancelada em " + new Date());
            modelonovo.setLancod(Integer.parseInt((String) ""+jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 0)));
            controlelancamentos.cancelarBaixa(modelonovo);
            jButtonTodosActionPerformed(evt);
        }
                
    }//GEN-LAST:event_jMenuItemCancelarBaixaActionPerformed

    private void JMenuItemDescartadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemDescartadoActionPerformed
        if (ValidaAcessos.valida(4)==2) {return;}
        int resposta =  JOptionPane.showConfirmDialog(rootPane, "Deseja realmente mudar o status de baixa do uniforme?");
        if (resposta == JOptionPane.YES_OPTION){
            if ( jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 6).equals("EM USO") || jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 6).equals("RETORNO ESTOQUE")){
                JOptionPane.showMessageDialog(null, "Não é possível alterar este tipo de status.");
                return;
            }
            modelonovo.setTipomanutencao("STATUS ALTERADO PARA DESCARTADO");
            modelonovo.setLanstatus(2);
            modelonovo.setLancod(Integer.parseInt((String) ""+jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 0)));
            controlelancamentos.alterarStatus(modelonovo);
            jButtonTodosActionPerformed(evt);
        }
    }//GEN-LAST:event_JMenuItemDescartadoActionPerformed

    private void jMenuItemReaproveitamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReaproveitamentoActionPerformed
        if (ValidaAcessos.valida(4)==2) {return;}
        int resposta =  JOptionPane.showConfirmDialog(rootPane, "Deseja realmente mudar o status de baixa do uniforme?");
        if (resposta == JOptionPane.YES_OPTION){
            if ( jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 6).equals("EM USO") || jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 6).equals("RETORNO ESTOQUE")){
                JOptionPane.showMessageDialog(null, "Não é possível alterar este tipo de status.");
                return;
            }
            modelonovo.setTipomanutencao("STATUS ALTERADO PARA REAPROVEITAMENTO");
            modelonovo.setLanstatus(5);
            modelonovo.setLancod(Integer.parseInt((String) ""+jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 0)));
            controlelancamentos.alterarStatus(modelonovo);
            jButtonTodosActionPerformed(evt);
        }
    }//GEN-LAST:event_jMenuItemReaproveitamentoActionPerformed

    private void jMenuItemExtraviadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExtraviadoActionPerformed
        if (ValidaAcessos.valida(4)==2) {return;}
        int resposta =  JOptionPane.showConfirmDialog(rootPane, "Deseja realmente mudar o status de baixa do uniforme?");
        if (resposta == JOptionPane.YES_OPTION){
            if ( jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 6).equals("EM USO") || jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 6).equals("RETORNO ESTOQUE")){
                JOptionPane.showMessageDialog(null, "Não é possível alterar este tipo de status.");
                return;
            }
            modelonovo.setTipomanutencao("STATUS ALTERADO PARA EXTRAVAIDO");
            modelonovo.setLanstatus(3);
            modelonovo.setLancod(Integer.parseInt((String) ""+jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 0)));
            controlelancamentos.alterarStatus(modelonovo);
            jButtonTodosActionPerformed(evt);
        }
    }//GEN-LAST:event_jMenuItemExtraviadoActionPerformed

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

    public void ConusltaXManut() {
        boolean titulo = getTitle().equals("Consulta de Lançamentos.");
        //boolean titulo2 = getTitle().equals("Manutenção de Lançamentos.");
        if (titulo) {
            jPanel1.setBackground(new java.awt.Color(153, 153, 153));
            jPanelTransferir.setVisible(false);
            titulo = false;

        } else {
            jPanel1.setBackground(new java.awt.Color(0,255,255));
            jPanelTransferir.setVisible(true);
            titulo = false;

        }
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
            jPanel1.setBackground(new java.awt.Color(255,255,0));
        } else if (cargos.toLowerCase().contains(proclimpeza.toLowerCase())) {            //toLowerCase - ignora maíusculas e minúsculas
            jPanel1.setBackground(new java.awt.Color(255,51,51));
        } else if (deptos.toLowerCase().contains(procmanut.toLowerCase()) || deptos.toLowerCase().contains(procanimais.toLowerCase()) || deptos.toLowerCase().contains(procmaquinas.toLowerCase()) || deptos.toLowerCase().contains(procgraxaria.toLowerCase())) {            //toLowerCase - ignora maíusculas e minúsculas
            jPanel1.setBackground(new java.awt.Color(51,102,255));
        } else if (deptos.toLowerCase().contains(proctrab.toLowerCase())) {
            jPanel1.setBackground(new java.awt.Color(0,153,51));
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
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMenuItemDescartado;
    private javax.swing.JButton jButtonA;
    private javax.swing.JButton jButtonB;
    private javax.swing.JButton jButtonC;
    private javax.swing.JButton jButtonCapturar;
    private javax.swing.JButton jButtonD;
    private javax.swing.JButton jButtonE;
    private javax.swing.JButton jButtonTodos;
    private javax.swing.JButton jButtonTransferir;
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
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelID1;
    private javax.swing.JLabel jLabelLetra;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNome1;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelNumero1;
    private javax.swing.JMenu jMenuAlterarStatus;
    private javax.swing.JMenuItem jMenuItemA;
    private javax.swing.JMenuItem jMenuItemB;
    private javax.swing.JMenuItem jMenuItemC;
    private javax.swing.JMenuItem jMenuItemCancelarBaixa;
    private javax.swing.JMenuItem jMenuItemD;
    private javax.swing.JMenuItem jMenuItemE;
    private javax.swing.JMenuItem jMenuItemExtraviado;
    private javax.swing.JMenuItem jMenuItemReaproveitamento;
    private javax.swing.JMenu jMenuLetras;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelTransferir;
    private javax.swing.JPopupMenu jPopupMenuModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLancamentos;
    private javax.swing.JTextField jTextFieldApelido;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumero;
    // End of variables declaration//GEN-END:variables
}
