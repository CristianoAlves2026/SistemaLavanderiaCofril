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
import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Lavanderia
 */
public class TelaLancamentos extends javax.swing.JFrame {

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
    String tempocasa;
    String idade;

    public TelaLancamentos() {
        initComponents();
        jComboBoxUniformes.setRenderer(new AlternatingColorRenderer());
        jTableLancamentos.setDefaultRenderer(Object.class, new AlternatingTableRenderer());

        jLabelDataAtual.setVisible(false);

        HashSet conj;
        conj = new HashSet(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);

        preencheUniformes();
        preencheTamanhos();

        String data = dataformatada.format(new Date());
        jLabelDataAtual.setText(String.valueOf(data));
        jLabelLetra.setVisible(false);
        jComboBoxLetras.setVisible(false);
        jLabelFoto.setHorizontalAlignment(SwingConstants.CENTER);
        jTextFieldNumero.requestFocus();

        if (TelaLogin.usuperfil.equals("CLARO")) {
            PerfilClaro();
        } else if (TelaLogin.usuperfil.equals("ESCURO")) {
            PerfilEscuro();
        } else if (TelaLogin.usuperfil.equals("VERDE")) {
            PerfilVerde();
        } else if (TelaLogin.usuperfil.equals("ROSA")) {
            PerfilRosa();
        } else if (TelaLogin.usuperfil.equals("AZUL")) {
            PerfilAzul();
        } else if (TelaLogin.usuperfil.equals("VERMELHO")) {
            PerfilVermelho();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuBaixas = new javax.swing.JPopupMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuDescartar = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemDescartarNovo = new javax.swing.JMenuItem();
        jMenuItemDescartarReap = new javax.swing.JMenuItem();
        jMenuReaproveitar = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemReaproveitarNovo = new javax.swing.JMenuItem();
        jMenuItemReaproveitarReap = new javax.swing.JMenuItem();
        jMenuExtravaido = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItemExtraviadoNovo = new javax.swing.JMenuItem();
        jMenuItemExtravaidoReaproveitado = new javax.swing.JMenuItem();
        jPopupMenuHist = new javax.swing.JPopupMenu();
        jMenuItemSalvarHistorico = new javax.swing.JMenuItem();
        jMenuItemAtualizaIdFunc = new javax.swing.JMenuItem();
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
        jComboBoxLetras = new javax.swing.JComboBox<>();
        jButtonNovo = new javax.swing.JButton();
        jButtonDescartar = new javax.swing.JButton();
        jButtonReaproveitar = new javax.swing.JButton();
        jButtonExtraviado = new javax.swing.JButton();
        jButtonEstoque = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jLabelLetra = new javax.swing.JLabel();
        jLabelFoto = new javax.swing.JLabel();
        jLabelFoto1 = new javax.swing.JLabel();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jCheckBoxBranco = new javax.swing.JCheckBox();
        jCheckBoxCinza = new javax.swing.JCheckBox();
        jCheckBoxAzul = new javax.swing.JCheckBox();
        jCheckBoxKitFrio = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxUniformes = new javax.swing.JComboBox<>();
        jComboBoxTamanhos = new javax.swing.JComboBox<>();
        jButtonSalvar = new javax.swing.JButton();
        jRadioButtonN = new javax.swing.JRadioButton();
        jRadioButtonR = new javax.swing.JRadioButton();
        jButtonVerEstoque = new javax.swing.JButton();
        jLabelEstoqueAtual = new javax.swing.JLabel();
        jLabelDataAtual = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTextFieldHistorico = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldBarraStatus = new javax.swing.JTextField();

        jMenuItem3.setText("Baixa Casada");
        jMenuItem3.setEnabled(false);
        jPopupMenuBaixas.add(jMenuItem3);
        jPopupMenuBaixas.add(jSeparator3);

        jMenuDescartar.setText("Baixar como Descartado");

        jMenuItem1.setText("Descartar");
        jMenuItem1.setEnabled(false);
        jMenuDescartar.add(jMenuItem1);
        jMenuDescartar.add(jSeparator1);

        jMenuItemDescartarNovo.setForeground(new java.awt.Color(0, 0, 255));
        jMenuItemDescartarNovo.setText("Substitur por Uniforme Novo");
        jMenuItemDescartarNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDescartarNovoActionPerformed(evt);
            }
        });
        jMenuDescartar.add(jMenuItemDescartarNovo);

        jMenuItemDescartarReap.setForeground(new java.awt.Color(0, 153, 0));
        jMenuItemDescartarReap.setText("Substituir por Uniforme Reaproveitado");
        jMenuItemDescartarReap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDescartarReapActionPerformed(evt);
            }
        });
        jMenuDescartar.add(jMenuItemDescartarReap);

        jPopupMenuBaixas.add(jMenuDescartar);

        jMenuReaproveitar.setText("Baixar como Reaproveitamento");

        jMenuItem2.setText("Reaproveitar");
        jMenuItem2.setEnabled(false);
        jMenuReaproveitar.add(jMenuItem2);
        jMenuReaproveitar.add(jSeparator2);

        jMenuItemReaproveitarNovo.setForeground(new java.awt.Color(0, 0, 255));
        jMenuItemReaproveitarNovo.setText("Substituir por Uniforme Novo");
        jMenuItemReaproveitarNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReaproveitarNovoActionPerformed(evt);
            }
        });
        jMenuReaproveitar.add(jMenuItemReaproveitarNovo);

        jMenuItemReaproveitarReap.setForeground(new java.awt.Color(0, 153, 0));
        jMenuItemReaproveitarReap.setText("Substituir por Uniforme Reaproveitado");
        jMenuItemReaproveitarReap.setToolTipText("");
        jMenuItemReaproveitarReap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReaproveitarReapActionPerformed(evt);
            }
        });
        jMenuReaproveitar.add(jMenuItemReaproveitarReap);

        jPopupMenuBaixas.add(jMenuReaproveitar);

        jMenuExtravaido.setText("Baixar como Extraviado");

        jMenuItem4.setText("Extraviado");
        jMenuItem4.setEnabled(false);
        jMenuExtravaido.add(jMenuItem4);
        jMenuExtravaido.add(jSeparator4);

        jMenuItemExtraviadoNovo.setForeground(new java.awt.Color(0, 0, 255));
        jMenuItemExtraviadoNovo.setText("Substituir por Uniforme Novo");
        jMenuItemExtraviadoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExtraviadoNovoActionPerformed(evt);
            }
        });
        jMenuExtravaido.add(jMenuItemExtraviadoNovo);

        jMenuItemExtravaidoReaproveitado.setForeground(new java.awt.Color(0, 153, 0));
        jMenuItemExtravaidoReaproveitado.setText("Substituir por Uniforme Reaproveitado");
        jMenuItemExtravaidoReaproveitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExtravaidoReaproveitadoActionPerformed(evt);
            }
        });
        jMenuExtravaido.add(jMenuItemExtravaidoReaproveitado);

        jPopupMenuBaixas.add(jMenuExtravaido);

        jMenuItemSalvarHistorico.setText("Salvar Histórico");
        jMenuItemSalvarHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalvarHistoricoActionPerformed(evt);
            }
        });
        jPopupMenuHist.add(jMenuItemSalvarHistorico);

        jMenuItemAtualizaIdFunc.setText("Atualiza ID Funcionário");
        jMenuItemAtualizaIdFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAtualizaIdFuncActionPerformed(evt);
            }
        });
        jPopupMenuHist.add(jMenuItemAtualizaIdFunc);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimentação de Uniformes");
        setAutoRequestFocus(false);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLancamentosMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableLancamentosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLancamentos);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(12, 100, 830, 200);

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
        jButtonB.setBounds(70, 40, 56, 52);

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
        jButtonA.setBounds(10, 40, 56, 52);

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
        jButtonC.setBounds(130, 40, 56, 52);

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
        jButtonD.setBounds(190, 40, 56, 52);

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
        jButtonE.setBounds(250, 40, 56, 52);

        jComboBoxLetras.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBoxLetras.setForeground(new java.awt.Color(0, 0, 204));
        jComboBoxLetras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F", "G", "H", "I", "J" }));
        jComboBoxLetras.setEnabled(false);
        jPanel2.add(jComboBoxLetras);
        jComboBoxLetras.setBounds(320, 10, 83, 20);

        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Adiconar 32px.png"))); // NOI18N
        jButtonNovo.setText("Novo");
        jButtonNovo.setToolTipText("Cadastra um novo lançamento de uniforme.");
        jButtonNovo.setEnabled(false);
        jButtonNovo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonNovo);
        jButtonNovo.setBounds(450, 10, 130, 40);

        jButtonDescartar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Descartar 32px.png"))); // NOI18N
        jButtonDescartar.setText("Descartar");
        jButtonDescartar.setToolTipText("Baixa o lançamento como descartado.");
        jButtonDescartar.setEnabled(false);
        jButtonDescartar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonDescartar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDescartarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonDescartar);
        jButtonDescartar.setBounds(450, 50, 130, 40);

        jButtonReaproveitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Reaproveitar 32px.png"))); // NOI18N
        jButtonReaproveitar.setText("Reaproveitar");
        jButtonReaproveitar.setToolTipText("Baixa o lançamento como reaproveitamento.");
        jButtonReaproveitar.setEnabled(false);
        jButtonReaproveitar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonReaproveitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReaproveitarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonReaproveitar);
        jButtonReaproveitar.setBounds(580, 10, 130, 40);

        jButtonExtraviado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Pergunta 32px.png"))); // NOI18N
        jButtonExtraviado.setText("Extraviado");
        jButtonExtraviado.setToolTipText("Baixa o lançamento como extraviado.");
        jButtonExtraviado.setEnabled(false);
        jButtonExtraviado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonExtraviado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExtraviadoActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonExtraviado);
        jButtonExtraviado.setBounds(580, 50, 130, 40);

        jButtonEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Estoque 32px.png"))); // NOI18N
        jButtonEstoque.setText("Estoque");
        jButtonEstoque.setToolTipText("Cancela o lançamento e retorna o item ao estoque.");
        jButtonEstoque.setEnabled(false);
        jButtonEstoque.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstoqueActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonEstoque);
        jButtonEstoque.setBounds(710, 10, 130, 40);

        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Delete 32px.png"))); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setToolTipText("Exclui o lançamento. ");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonExcluir);
        jButtonExcluir.setBounds(710, 50, 130, 40);

        jLabelLetra.setText("A");
        jLabelLetra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabelLetra);
        jLabelLetra.setBounds(400, 10, 30, 20);

        jLabelFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabelFoto);
        jLabelFoto.setBounds(320, 0, 110, 100);

        jLabelFoto1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabelFoto1);
        jLabelFoto1.setBounds(320, 0, 110, 100);

        jCheckBoxTodos.setSelected(true);
        jCheckBoxTodos.setText("Todos");
        jCheckBoxTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxTodosActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBoxTodos);
        jCheckBoxTodos.setBounds(260, 10, 70, 20);

        jCheckBoxBranco.setText("Branco");
        jCheckBoxBranco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxBrancoActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBoxBranco);
        jCheckBoxBranco.setBounds(10, 10, 70, 20);

        jCheckBoxCinza.setText("Cinza");
        jCheckBoxCinza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCinzaActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBoxCinza);
        jCheckBoxCinza.setBounds(130, 10, 60, 20);

        jCheckBoxAzul.setText("Azul");
        jCheckBoxAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAzulActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBoxAzul);
        jCheckBoxAzul.setBounds(80, 10, 52, 20);

        jCheckBoxKitFrio.setText("Kit Frio");
        jCheckBoxKitFrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxKitFrioActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBoxKitFrio);
        jCheckBoxKitFrio.setBounds(190, 10, 60, 20);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 120, 860, 310);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setToolTipText("Novo Lançamento de Uniforme");

        jLabel4.setText("Uniforme");

        jLabel5.setText("Tamanho");

        jComboBoxUniformes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxUniformes.setEnabled(false);

        jComboBoxTamanhos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTamanhos.setEnabled(false);

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jRadioButtonN.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonN.setText("N");
        jRadioButtonN.setEnabled(false);
        jRadioButtonN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonNMouseClicked(evt);
            }
        });

        jRadioButtonR.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonR.setText("R");
        jRadioButtonR.setEnabled(false);
        jRadioButtonR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonRMouseClicked(evt);
            }
        });

        jButtonVerEstoque.setText("Ver Estoque");
        jButtonVerEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerEstoqueActionPerformed(evt);
            }
        });

        jLabelEstoqueAtual.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelEstoqueAtual.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxUniformes, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelEstoqueAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxTamanhos, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonR, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonVerEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxUniformes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstoqueAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxTamanhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonN)
                    .addComponent(jRadioButtonR)
                    .addComponent(jButtonVerEstoque))
                .addGap(15, 15, 15))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(390, 440, 480, 70);

        jLabelDataAtual.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDataAtual.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelDataAtual.setBorder(javax.swing.BorderFactory.createTitledBorder("Data"));
        getContentPane().add(jLabelDataAtual);
        jLabelDataAtual.setBounds(750, 0, 120, 50);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextFieldHistorico.setToolTipText("Histórico do lançamento.");
        jTextFieldHistorico.setEnabled(false);
        jTextFieldHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextFieldHistoricoMouseReleased(evt);
            }
        });

        jLabel7.setText("Histórico");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(10, 440, 370, 50);

        jTextFieldBarraStatus.setEditable(false);
        jTextFieldBarraStatus.setFont(new java.awt.Font("Verdana", 1, 9)); // NOI18N
        jTextFieldBarraStatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jTextFieldBarraStatus);
        jTextFieldBarraStatus.setBounds(10, 520, 860, 20);

        setSize(new java.awt.Dimension(893, 582));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeFocusLost
        if (jTextFieldNome.getText().equals("") || !jTextFieldNumero.getText().equals("")) {
            return;
        }
        jButtonA.setBackground(new java.awt.Color(204, 255, 255));
        jButtonB.setBackground(new java.awt.Color(204, 255, 255));
        jButtonC.setBackground(new java.awt.Color(204, 255, 255));
        jButtonD.setBackground(new java.awt.Color(204, 255, 255));
        jButtonE.setBackground(new java.awt.Color(204, 255, 255));

        jButtonA.setEnabled(true);
        jButtonB.setEnabled(true);
        jButtonC.setEnabled(true);
        jButtonD.setEnabled(true);
        jButtonE.setEnabled(true);

        objmodfunc.setPesquisa(jTextFieldNome.getText());
        ModeloFuncionario modelo2 = controle.buscaFuncionario(objmodfunc);
        if (objmodfunc.getFuncod() == -1) {
            jTextFieldNome.setText("");
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

        jButtonNovo.setEnabled(false);
        preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + modelo2.getFunnum() + "' and (l.lan_sta_cod = 1) order by lan_uni_cod asc");


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

        jButtonA.setEnabled(true);
        jButtonB.setEnabled(true);
        jButtonC.setEnabled(true);
        jButtonD.setEnabled(true);
        jButtonE.setEnabled(true);

        objmodfunc.setFunnum(Integer.parseInt(jTextFieldNumero.getText()));
        ModeloFuncionario modelo2 = controle.buscaCodigoFuncionario(objmodfunc);
        if (objmodfunc.getFuncod() == -1) {
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

        if (TelaLogin.usuperfil.equals("CLARO") || TelaLogin.usuperfil.equals("PADRAO")) {
            mudacorjpanel();
        }
        jButtonNovo.setEnabled(false);
        preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + modelo2.getFunnum() + "' and (l.lan_sta_cod = 1) order by lan_uni_cod asc");

        TempoCasa();
        jTextFieldBarraStatus.setText(" " + jTextFieldNome.getText() + " tem " + idade + "foi admitido em " + dataformatada.format(objmodfunc.getFunadmissao()) + " " + tempocasa);


    }//GEN-LAST:event_jTextFieldNumeroFocusLost

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed

        if (ValidaAcessos.valida(3) == 2) {
            return;
        }

        jLabelEstoqueAtual.setText("");
        if (jButtonNovo.getText().equals("Novo")) {
            jComboBoxUniformes.setEnabled(true);
            jComboBoxTamanhos.setEnabled(true);
            jButtonSalvar.setEnabled(true);
            jButtonNovo.setText("Cancelar");
            jButtonNovo.setBackground(new java.awt.Color(255, 102, 102));
            jButtonDescartar.setEnabled(false);
            jButtonExcluir.setEnabled(false);
            jButtonReaproveitar.setEnabled(false);
            jButtonEstoque.setEnabled(false);
            jButtonExtraviado.setEnabled(false);
            jRadioButtonN.setEnabled(true);
            jRadioButtonR.setEnabled(true);
            jTextFieldHistorico.setEnabled(true);
        } else {
            //jTableLancamentos.setSelectedRow(-1,0);
            jComboBoxUniformes.setEnabled(false);
            jComboBoxTamanhos.setEnabled(false);
            jButtonSalvar.setEnabled(false);
            jButtonNovo.setText("Novo");
            jButtonNovo.setBackground(new java.awt.Color(240, 240, 240));
            jButtonDescartar.setEnabled(true);
            jButtonExcluir.setEnabled(true);
            jButtonReaproveitar.setEnabled(true);
            jButtonEstoque.setEnabled(true);
            jButtonExtraviado.setEnabled(true);
            jRadioButtonN.setEnabled(false);
            jRadioButtonR.setEnabled(false);
            //jTextFieldHistorico.setEnabled(false);
        }

    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jTableLancamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLancamentosMouseClicked

        if (jTableLancamentos.getSelectedRow() != -1) {
            int x, y, anos = 0, dias = 0, meses = 0;
            String z = "" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 9);
            x = Integer.parseInt(z);
            y = 0;

            anos = x / 360;
            y = x % 360;
            meses = y / 30;
            dias = y % 30;

            if (anos == 0 && meses != 0) {
                jTableLancamentos.setToolTipText("Em uso a " + meses + " mes(es) e " + dias + " dia(s).");
            } else if (anos == 0 && meses == 0) {
                jTableLancamentos.setToolTipText("Em uso a " + dias + " dia(s).");
            } else if (dias == 0) {
                jTableLancamentos.setToolTipText("Em uso a " + anos + " ano(s) e " + meses + " mes(es). ");
            } else if (meses == 0) {
                jTableLancamentos.setToolTipText("Em uso a " + anos + " ano(s) e " + dias + " dia(s).");
            } else {
                jTableLancamentos.setToolTipText("Em uso a " + anos + " ano(s), " + meses + " mes(es) e " + dias + " dia(s).");
            }
            z = jTableLancamentos.getToolTipText();
        }

        if (!jButtonNovo.getText().equals("Cancelar")) {
            jButtonDescartar.setEnabled(true);
            jButtonEstoque.setEnabled(true);
            jButtonExcluir.setEnabled(true);
            jButtonExtraviado.setEnabled(true);
            jButtonReaproveitar.setEnabled(true);

        }
        if (jTableLancamentos.getSelectedRow() != -1) {
            jTextFieldHistorico.setText("" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 10));
            jComboBoxUniformes.setSelectedItem((String) jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 4));
            jComboBoxTamanhos.setSelectedItem((String) jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 5));
            buscaCodigoUniformes();
            buscaCodigoTamanho();
            modpree.setCoduniforme(modelonovo.getLanuniforme());
            modpree.setCodtam(modelonovo.getLantamanho());
            controlelancamentos.BuscaEstoque(modpree);
            jLabelEstoqueAtual.setText(String.valueOf(modpree.getSaldo()));
            if (modpree.getSaldo() < modelonovo.getSaldo()) {  //verificando estoque minimo  getSaldo emprestado.
                jTextFieldBarraStatus.setText((String) jComboBoxUniformes.getSelectedItem() + " TAMANHO " + jComboBoxTamanhos.getSelectedItem() + " COM ESTOQUE BAIXO. VERIFIQUE!!!");
                jTextFieldBarraStatus.setForeground(Color.RED);
            } else {
                jTextFieldBarraStatus.setForeground(Color.BLACK);
                jTextFieldBarraStatus.setText("" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 1) + " " + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 2) + " - " + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 4) + "   [ " + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 5) + " ]  TIPO: " + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 7) + "   Dias: " + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 9) + "   ID: " + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 0));

            }

            modelonovo.setBarrastatus(datahora.format(new Date()) + "  --->  " + "" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 1) + " " + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 2) + " - " + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 4) + "   [ " + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 5) + " ]  TIPO: " + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 7) + "   Dias: " + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 9) + "   ID: " + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 0));
            modelonovo.setLanfuncod(Integer.parseInt(jTextFieldCodigo.getText()));
            fotouniforme();

        }


    }//GEN-LAST:event_jTableLancamentosMouseClicked

    private void jTextFieldNumeroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNumeroFocusGained
        if (TelaLogin.usuperfil.equals("CLARO") || TelaLogin.usuperfil.equals("PADRAO")) {
            jPanel1.setBackground(new java.awt.Color(240, 240, 240));
        }

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Numero", "Letra", "Entrega", "Uniforme", "Tamanho", "Status", "Tipo", "Data Baixa", "Dias Uso", "Historico", "Ult. Mov."};
        ModeloTabela modelotab = new ModeloTabela(dados, colunas);
        jTableLancamentos.setModel(modelotab);

        jCheckBoxTodos.setSelected(true);
        jCheckBoxBranco.setSelected(false);
        jCheckBoxAzul.setSelected(false);
        jCheckBoxCinza.setSelected(false);
        jCheckBoxKitFrio.setSelected(false);

        jLabelFoto.setIcon(null);
        jComboBoxUniformes.setEnabled(false);
        jComboBoxTamanhos.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        jButtonNovo.setText("Novo");
        jButtonNovo.setBackground(new java.awt.Color(240, 240, 240));
        jButtonNovo.setEnabled(false);
        jButtonA.setBackground(new java.awt.Color(204, 255, 255));
        jButtonB.setBackground(new java.awt.Color(204, 255, 255));
        jButtonD.setBackground(new java.awt.Color(204, 255, 255));
        jButtonE.setBackground(new java.awt.Color(204, 255, 255));
        jButtonA.setEnabled(false);
        jButtonB.setEnabled(false);
        jButtonC.setEnabled(false);
        jButtonD.setEnabled(false);
        jButtonE.setEnabled(false);
        jRadioButtonN.setEnabled(false);
        jRadioButtonR.setEnabled(false);
        jTextFieldHistorico.setEnabled(false);
        jTextFieldCodigo.setText("");
        jTextFieldNumero.setText("");
        jTextFieldApelido.setText("");
        jTextFieldNome.setText("");
        jTextFieldHistorico.setText("");
        jComboBoxCargos.removeAllItems();
        jComboBoxDepartamentos.removeAllItems();
        jComboBoxEmpresas.removeAllItems();
        jButtonDescartar.setEnabled(false);
        jButtonEstoque.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonExtraviado.setEnabled(false);
        jButtonReaproveitar.setEnabled(false);


    }//GEN-LAST:event_jTextFieldNumeroFocusGained

    private void jRadioButtonNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonNMouseClicked
        jRadioButtonR.setSelected(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonNMouseClicked

    private void jRadioButtonRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonRMouseClicked
        jRadioButtonN.setSelected(false);      // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonRMouseClicked

    private void jButtonAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAActionPerformed
        jButtonA.setBackground(new java.awt.Color(0, 204, 102));
        jButtonB.setBackground(new java.awt.Color(204, 255, 255));
        jButtonC.setBackground(new java.awt.Color(204, 255, 255));
        jButtonD.setBackground(new java.awt.Color(204, 255, 255));
        jButtonE.setBackground(new java.awt.Color(204, 255, 255));
        jButtonNovo.setEnabled(true);
        jLabelLetra.setText("A");

        if (jCheckBoxTodos.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'A') order by lan_uni_cod asc");
        } else if (jCheckBoxBranco.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (u.uni_cod = 2 or u.uni_cod = 3 or u.uni_cod = 14 or u.uni_cod = 17 or u.uni_cod = 19 )"
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'A') order by lan_uni_cod asc");
        } else if (jCheckBoxAzul.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (u.uni_cod = 5 or u.uni_cod = 11 or u.uni_cod = 22 or u.uni_cod = 24 )"
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'A') order by lan_uni_cod asc");
        } else if (jCheckBoxCinza.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (u.uni_cod = 9 or u.uni_cod = 10 or u.uni_cod = 12 )"
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'A') order by lan_uni_cod asc");
        } else if (jCheckBoxKitFrio.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (u.uni_cod = 4 or u.uni_cod = 15 or u.uni_cod = 17 or u.uni_cod = 21 or u.uni_cod = 31)"
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'A') order by lan_uni_cod asc");
        } else {
            jCheckBoxTodos.setSelected(true);
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'A') order by lan_uni_cod asc");
        }

        if (jTableLancamentos.getRowCount() > 0) {
            jTableLancamentos.setRowSelectionInterval(0, 0);
        }
        jButtonDescartar.setEnabled(false);
        jButtonEstoque.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonExtraviado.setEnabled(false);
        jButtonReaproveitar.setEnabled(false);

    }//GEN-LAST:event_jButtonAActionPerformed

    private void jButtonBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBActionPerformed
        jButtonB.setBackground(new java.awt.Color(0, 204, 102));
        jButtonA.setBackground(new java.awt.Color(204, 255, 255));
        jButtonC.setBackground(new java.awt.Color(204, 255, 255));
        jButtonD.setBackground(new java.awt.Color(204, 255, 255));
        jButtonE.setBackground(new java.awt.Color(204, 255, 255));
        jButtonNovo.setEnabled(true);
        jLabelLetra.setText("B");

        if (jCheckBoxTodos.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'B') order by lan_uni_cod asc");
        } else if (jCheckBoxBranco.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (u.uni_cod = 2 or u.uni_cod = 3 or u.uni_cod = 14 or u.uni_cod = 17 or u.uni_cod = 19 )"
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'B') order by lan_uni_cod asc");
        } else if (jCheckBoxAzul.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (u.uni_cod = 5 or u.uni_cod = 11 or u.uni_cod = 22 or u.uni_cod = 24 )"
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'B') order by lan_uni_cod asc");
        } else if (jCheckBoxCinza.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (u.uni_cod = 9 or u.uni_cod = 10 or u.uni_cod = 12 )"
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'B') order by lan_uni_cod asc");
        } else if (jCheckBoxKitFrio.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (u.uni_cod = 4 or u.uni_cod = 15 or u.uni_cod = 17 or u.uni_cod = 21)"
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'B') order by lan_uni_cod asc");
        } else {
            jCheckBoxTodos.setSelected(true);
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'B') order by lan_uni_cod asc");
        }

        if (jTableLancamentos.getRowCount() > 0) {
            jTableLancamentos.setRowSelectionInterval(0, 0);
        }
        jButtonDescartar.setEnabled(false);
        jButtonEstoque.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonExtraviado.setEnabled(false);
        jButtonReaproveitar.setEnabled(false);

    }//GEN-LAST:event_jButtonBActionPerformed

    private void jButtonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCActionPerformed
        jButtonC.setBackground(new java.awt.Color(0, 204, 102));
        jButtonA.setBackground(new java.awt.Color(204, 255, 255));
        jButtonB.setBackground(new java.awt.Color(204, 255, 255));
        jButtonD.setBackground(new java.awt.Color(204, 255, 255));
        jButtonE.setBackground(new java.awt.Color(204, 255, 255));
        jButtonNovo.setEnabled(true);
        jLabelLetra.setText("C");

        if (jCheckBoxTodos.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'C') order by lan_uni_cod asc");
        } else if (jCheckBoxBranco.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (u.uni_cod = 2 or u.uni_cod = 3 or u.uni_cod = 14 or u.uni_cod = 17 or u.uni_cod = 19 )"
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'C') order by lan_uni_cod asc");
        } else if (jCheckBoxAzul.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (u.uni_cod = 5 or u.uni_cod = 11 or u.uni_cod = 22 or u.uni_cod = 24 )"
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'C') order by lan_uni_cod asc");
        } else if (jCheckBoxCinza.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (u.uni_cod = 9 or u.uni_cod = 10 or u.uni_cod = 12 )"
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'C') order by lan_uni_cod asc");
        } else if (jCheckBoxKitFrio.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (u.uni_cod = 4 or u.uni_cod = 15 or u.uni_cod = 17 or u.uni_cod = 21)"
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'C') order by lan_uni_cod asc");
        } else {
            jCheckBoxTodos.setSelected(true);
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'C') order by lan_uni_cod asc");
        }

        if (jTableLancamentos.getRowCount() > 0) {
            jTableLancamentos.setRowSelectionInterval(0, 0);
        }
        jButtonDescartar.setEnabled(false);
        jButtonEstoque.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonExtraviado.setEnabled(false);
        jButtonReaproveitar.setEnabled(false);
    }//GEN-LAST:event_jButtonCActionPerformed

    private void jButtonDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDActionPerformed
        jButtonD.setBackground(new java.awt.Color(0, 204, 102));
        jButtonA.setBackground(new java.awt.Color(204, 255, 255));
        jButtonB.setBackground(new java.awt.Color(204, 255, 255));
        jButtonC.setBackground(new java.awt.Color(204, 255, 255));
        jButtonE.setBackground(new java.awt.Color(204, 255, 255));
        jButtonNovo.setEnabled(true);
        jLabelLetra.setText("D");

        if (jCheckBoxTodos.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'D') order by lan_uni_cod asc");
        } else if (jCheckBoxBranco.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (u.uni_cod = 2 or u.uni_cod = 3 or u.uni_cod = 14 or u.uni_cod = 17 or u.uni_cod = 19 )"
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'D') order by lan_uni_cod asc");
        } else if (jCheckBoxAzul.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (u.uni_cod = 5 or u.uni_cod = 11 or u.uni_cod = 22 or u.uni_cod = 24 )"
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'D') order by lan_uni_cod asc");
        } else if (jCheckBoxCinza.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (u.uni_cod = 9 or u.uni_cod = 10 or u.uni_cod = 12 )"
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'D') order by lan_uni_cod asc");
        } else if (jCheckBoxKitFrio.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (u.uni_cod = 4 or u.uni_cod = 15 or u.uni_cod = 17 or u.uni_cod = 21)"
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'D') order by lan_uni_cod asc");
        } else {
            jCheckBoxTodos.setSelected(true);
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'D') order by lan_uni_cod asc");
        }

        if (jTableLancamentos.getRowCount() > 0) {
            jTableLancamentos.setRowSelectionInterval(0, 0);
        }
        jButtonDescartar.setEnabled(false);
        jButtonEstoque.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonExtraviado.setEnabled(false);
        jButtonReaproveitar.setEnabled(false);
    }//GEN-LAST:event_jButtonDActionPerformed

    private void jButtonEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEActionPerformed
        jButtonE.setBackground(new java.awt.Color(0, 204, 102));
        jButtonA.setBackground(new java.awt.Color(204, 255, 255));
        jButtonB.setBackground(new java.awt.Color(204, 255, 255));
        jButtonC.setBackground(new java.awt.Color(204, 255, 255));
        jButtonD.setBackground(new java.awt.Color(204, 255, 255));
        jButtonNovo.setEnabled(true);
        jLabelLetra.setText("E");

        if (jCheckBoxTodos.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'E') order by lan_uni_cod asc");
        } else if (jCheckBoxBranco.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (u.uni_cod = 2 or u.uni_cod = 3 or u.uni_cod = 14 or u.uni_cod = 17 or u.uni_cod = 19 )"
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'E') order by lan_uni_cod asc");
        } else if (jCheckBoxAzul.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (u.uni_cod = 5 or u.uni_cod = 11 or u.uni_cod = 22 or u.uni_cod = 24)"
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'E') order by lan_uni_cod asc");
        } else if (jCheckBoxCinza.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (u.uni_cod = 9 or u.uni_cod = 10 or u.uni_cod = 12 )"
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'E') order by lan_uni_cod asc");
        } else if (jCheckBoxKitFrio.isSelected()) {
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (u.uni_cod = 4 or u.uni_cod = 15 or u.uni_cod = 17 or u.uni_cod = 21)"
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'E') order by lan_uni_cod asc");
        } else {
            jCheckBoxTodos.setSelected(true);
            preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod "
                    + "where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' "
                    + "and (l.lan_sta_cod = 1) "
                    + "and (l.lan_letra = 'E') order by lan_uni_cod asc");
        }

        if (jTableLancamentos.getRowCount() > 0) {
            jTableLancamentos.setRowSelectionInterval(0, 0);
        }
        jButtonDescartar.setEnabled(false);
        jButtonEstoque.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonExtraviado.setEnabled(false);
        jButtonReaproveitar.setEnabled(false);
    }//GEN-LAST:event_jButtonEActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (ValidaAcessos.valida(3) == 2) {
            return;
        }
        if (!jRadioButtonN.isSelected() && !jRadioButtonR.isSelected()) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Informe se a roupa é N-nova ou R-reaproveitada.");
            return;
        }
        modelonovo.setTipomanutencao("NOVO LANÇAMENTO");
        modelonovo.setLannumero(Integer.parseInt(jTextFieldNumero.getText()));
        modelonovo.setLanletra(jLabelLetra.getText());
        modelonovo.setLanentrega(new Date());
        modelonovo.setLandatabaixa(new Date());
        buscaCodigoUniformes();
        buscaCodigoTamanho();

        modelonovo.setLanstatus(1);
        if (jRadioButtonN.isSelected()) {
            modelonovo.setLantipo((String) "N");
        } else if (jRadioButtonR.isSelected()) {
            modelonovo.setLantipo((String) "R");
        }

        modelonovo.setLanhistorico(jTextFieldHistorico.getText());
        modelonovo.setLanfuncod(Integer.parseInt(jTextFieldCodigo.getText()));
        modpree.setCoduniforme(modelonovo.getLanuniforme());
        modpree.setCodtam(modelonovo.getLantamanho());
        String emp = modpree.buscaCodigoempreas((String) jComboBoxEmpresas.getSelectedItem());
        modpree.setCodempresa(Integer.parseInt(emp));
        String dep = modpree.buscaCodigoDepartamentos((String) jComboBoxDepartamentos.getSelectedItem());
        modpree.setCoddepartamento(Integer.parseInt(dep));
        String car = modpree.buscaCodigoCargos((String) jComboBoxCargos.getSelectedItem());
        modpree.setCodcargo(Integer.parseInt(car));

        String tipo = "R";
        if (jRadioButtonN.isSelected()) {
            tipo = "N";
            controlelancamentos.BuscaEstoque(modpree);
            if (modpree.getSaldo() == -1) {
                java.awt.Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Lançamento não pode ser efetuado.\nUniforme não cadastrado na tabela estoque. Verifique...");
                return;
            } else if (modpree.getSaldo() == 0) {
                java.awt.Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Uniforme com saldo 0 (zero) em estoque. Lançamento não efetuado.");
                return;
            }
        }

        modelonovo.setBarrastatus(datahora.format(new Date()) + "  --->  " + jTextFieldNumero.getText() + " " + jLabelLetra.getText() + " - " + jComboBoxUniformes.getSelectedItem() + "   [ " + jComboBoxTamanhos.getSelectedItem() + " ]   TIPO: " + tipo);
        controlelancamentos.novo(modelonovo);

        if (jRadioButtonN.isSelected()) {
            controlelancamentos.movimentaEstoque(modpree, modelonovo);
        }

        jRadioButtonN.setSelected(false);
        jRadioButtonR.setSelected(false);

        preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' and (l.lan_sta_cod = 1) and (l.lan_letra = '" + "" + jLabelLetra.getText() + "') order by lan_letra, lan_uni_cod asc");
        jTableLancamentos.setRowSelectionInterval(0, 0);
        jCheckBoxTodos.setSelected(true);
        jCheckBoxTodosActionPerformed(evt);
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonDescartarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDescartarActionPerformed
        if (ValidaAcessos.valida(3) == 2) {
            return;
        }
        if (jTableLancamentos.getSelectedRow() == -1) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Selecione um lançamento.");
            return;
        }

        Date date = null;
        try {
            date = df.parse((String) jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 3));
            modelonovo.setLanentrega(date);
        } catch (ParseException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao trasnformar data.");
        }

        modelonovo.setTipomanutencao("DESCARTADO");
        modelonovo.setPesquisa(jButtonDescartar.getText());
        modelonovo.setLandatabaixa(new Date());
        modelonovo.setLancod(Integer.parseInt("" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 0)));

        buscaCodigoStatus();

        modelonovo.setLanhistorico(jTextFieldHistorico.getText());

        controlelancamentos.baixar(modelonovo);

        preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' and (l.lan_sta_cod = 1) and (l.lan_letra = '" + "" + jLabelLetra.getText() + "') order by lan_letra, lan_uni_cod asc");

    }//GEN-LAST:event_jButtonDescartarActionPerformed

    private void jButtonReaproveitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReaproveitarActionPerformed
        if (ValidaAcessos.valida(3) == 2) {
            return;
        }
        if (jTableLancamentos.getSelectedRow() == -1) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Selecione um lançamento.");
            return;
        }

        Date date = null;
        try {
            date = df.parse((String) jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 3));
            modelonovo.setLanentrega(date);
        } catch (ParseException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao trasnformar data.");
        }

        modelonovo.setTipomanutencao("REAPROVEITADO");
        modelonovo.setPesquisa(jButtonReaproveitar.getText());
        modelonovo.setLandatabaixa(new Date());
        modelonovo.setLancod(Integer.parseInt("" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 0)));
        buscaCodigoStatus();
        modelonovo.setLanhistorico(jTextFieldHistorico.getText());
        controlelancamentos.baixar(modelonovo);

        preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' and (l.lan_sta_cod = 1) and (l.lan_letra = '" + "" + jLabelLetra.getText() + "') order by lan_letra, lan_uni_cod asc");
    }//GEN-LAST:event_jButtonReaproveitarActionPerformed

    private void jButtonExtraviadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExtraviadoActionPerformed
        if (ValidaAcessos.valida(3) == 2) {
            return;
        }
        if (jTableLancamentos.getSelectedRow() == -1) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Selecione um lançamento.");
            return;
        }

        Date date;
        try {
            date = df.parse((String) jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 3));
            modelonovo.setLanentrega(date);
        } catch (ParseException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao trasnformar data.");
        }

        modelonovo.setTipomanutencao("EXTRAVIADO");
        modelonovo.setPesquisa(jButtonExtraviado.getText());
        modelonovo.setLandatabaixa(new Date());
        modelonovo.setLancod(Integer.parseInt("" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 0)));
        buscaCodigoStatus();
        modelonovo.setLanhistorico(jTextFieldHistorico.getText());
        controlelancamentos.baixar(modelonovo);

        preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' and (l.lan_sta_cod = 1) and (l.lan_letra = '" + "" + jLabelLetra.getText() + "') order by lan_letra, lan_uni_cod asc");
    }//GEN-LAST:event_jButtonExtraviadoActionPerformed

    private void jButtonEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstoqueActionPerformed
        if (ValidaAcessos.valida(3) == 2) {
            return;
        }
        if (jTableLancamentos.getSelectedRow() == -1) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Selecione um lançamento.");
            return;
        }

        if (jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 7).equals("R")) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Opção válida somente para uniformes N-novos.");
            return;
        }

        Date date;
        try {
            date = df.parse((String) jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 3));
            modelonovo.setLanentrega(date);
        } catch (ParseException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao trasnformar data.");
        }

        modelonovo.setTipomanutencao("RETORNADO AO ESTOQUE");
        modelonovo.setPesquisa(jButtonEstoque.getText());
        modelonovo.setLandatabaixa(new Date());
        modelonovo.setLancod(Integer.parseInt("" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 0)));
        buscaCodigoStatus();
        modelonovo.setLanhistorico(jTextFieldHistorico.getText());
        modelonovo.setLannumero(Integer.parseInt("" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 1)));
        modelonovo.setLanletra("" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 2));

        modpree.setCoduniforme(Integer.parseInt(modpree.buscaCodigoUniformes((String) "" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 4))));
        modpree.setCodtam(Integer.parseInt(modpree.buscaCodigoTamanhos((String) "" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 5))));
        modpree.setCodempresa(Integer.parseInt(modpree.buscaCodigoempreas((String) jComboBoxEmpresas.getSelectedItem())));
        modpree.setCoddepartamento(Integer.parseInt(modpree.buscaCodigoDepartamentos((String) jComboBoxDepartamentos.getSelectedItem())));
        modpree.setCodcargo(Integer.parseInt(modpree.buscaCodigoCargos((String) jComboBoxCargos.getSelectedItem())));
        controlelancamentos.BuscaEstoque(modpree);

        if (modpree.getSaldo() == -1) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Lançamento não pode ser efetuado.\nUniforme não cadastrado na tabela estoque. Verifique...");
            return;
        }

        controlelancamentos.movimentaEstoque(modpree, modelonovo);
        controlelancamentos.baixar(modelonovo);

        preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' and (l.lan_sta_cod = 1) and (l.lan_letra = '" + "" + jLabelLetra.getText() + "') order by lan_letra, lan_uni_cod asc");
    }//GEN-LAST:event_jButtonEstoqueActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        if (ValidaAcessos.valida(3) == 2) {
            return;
        }
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Confirma exclusão do lançamento selecionado?");
        if (resposta == JOptionPane.NO_OPTION || resposta == JOptionPane.CANCEL_OPTION) {
            return;
        }
        if (jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 7).equals("N")) {
            resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja repor o lançamento ao estoque antes de exluí-lo?");
            if (resposta == JOptionPane.NO_OPTION) {
                excluirLançamento();
                return;
            } else if (resposta == JOptionPane.CANCEL_OPTION) {
                return;
            }

            if (jTableLancamentos.getSelectedRow() == -1) {
                java.awt.Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Selecione um lançamento.");
                return;
            }

            Date date;
            try {
                date = df.parse((String) jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 3));
                modelonovo.setLanentrega(date);
            } catch (ParseException ex) {
                java.awt.Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Erro ao trasnformar data.");
            }

            modelonovo.setPesquisa(jButtonEstoque.getText());
            modelonovo.setLandatabaixa(new Date());
            modelonovo.setLancod(Integer.parseInt("" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 0)));
            buscaCodigoStatus();
            SimpleDateFormat dataformatada = new SimpleDateFormat("HH:mm:ss a");
            String hora = dataformatada.format(new Date());
            modelonovo.setLanultmov(hora);
            modelonovo.setLanhistorico(jTextFieldHistorico.getText());
            modelonovo.setLannumero(Integer.parseInt("" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 1)));
            modelonovo.setLanletra("" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 2));

            modpree.setCoduniforme(Integer.parseInt(modpree.buscaCodigoUniformes((String) "" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 4))));
            modpree.setCodtam(Integer.parseInt(modpree.buscaCodigoTamanhos((String) "" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 5))));
            modpree.setCodempresa(Integer.parseInt(modpree.buscaCodigoempreas((String) jComboBoxEmpresas.getSelectedItem())));
            modpree.setCoddepartamento(Integer.parseInt(modpree.buscaCodigoDepartamentos((String) jComboBoxDepartamentos.getSelectedItem())));
            modpree.setCodcargo(Integer.parseInt(modpree.buscaCodigoCargos((String) jComboBoxCargos.getSelectedItem())));
            controlelancamentos.BuscaEstoque(modpree);

            if (modpree.getSaldo() == -1) {
                java.awt.Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Lançamento não pode ser efetuado.\nUniforme não cadastrado na tabela estoque. Verifique...");
                return;
            }

            controlelancamentos.movimentaEstoque(modpree, modelonovo);
            modelonovo.setTipomanutencao("RETORNO ESTOQUE");
            controlelancamentos.baixar(modelonovo);

        } else {

        }
        excluirLançamento();

    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonVerEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerEstoqueActionPerformed
        TelaEstoque telaestoque = new TelaEstoque();
        telaestoque.setVisible(true);
    }//GEN-LAST:event_jButtonVerEstoqueActionPerformed

    private void jTableLancamentosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLancamentosMouseReleased
        if (jButtonDescartar.isEnabled() == false) {
            return;
        }

        if (jButtonNovo.isEnabled()) {
            if (jTableLancamentos.getSelectedRow() != -1) {
                if (evt.isPopupTrigger()) {
                    jPopupMenuBaixas.show(jTableLancamentos, evt.getX(), evt.getY());
                }
            }
        }
    }//GEN-LAST:event_jTableLancamentosMouseReleased

    private void jMenuItemDescartarNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDescartarNovoActionPerformed
        String unif = (String) jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 4);
        String tam = (String) jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 5);
        jComboBoxUniformes.setSelectedItem(unif);
        jComboBoxTamanhos.setSelectedItem(tam);
        jRadioButtonN.setSelected(true);
        jRadioButtonR.setSelected(false);
        jButtonDescartarActionPerformed(evt);
        jButtonSalvarActionPerformed(evt);

    }//GEN-LAST:event_jMenuItemDescartarNovoActionPerformed

    private void jMenuItemDescartarReapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDescartarReapActionPerformed
        String unif = (String) jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 4);
        String tam = (String) jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 5);
        jComboBoxUniformes.setSelectedItem(unif);
        jComboBoxTamanhos.setSelectedItem(tam);
        jRadioButtonN.setSelected(false);
        jRadioButtonR.setSelected(true);
        jButtonDescartarActionPerformed(evt);
        jButtonSalvarActionPerformed(evt);
    }//GEN-LAST:event_jMenuItemDescartarReapActionPerformed

    private void jMenuItemReaproveitarNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReaproveitarNovoActionPerformed
        String unif = (String) jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 4);
        String tam = (String) jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 5);
        jComboBoxUniformes.setSelectedItem(unif);
        jComboBoxTamanhos.setSelectedItem(tam);
        jRadioButtonN.setSelected(true);
        jRadioButtonR.setSelected(false);
        jButtonReaproveitarActionPerformed(evt);
        jButtonSalvarActionPerformed(evt);
    }//GEN-LAST:event_jMenuItemReaproveitarNovoActionPerformed

    private void jMenuItemReaproveitarReapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReaproveitarReapActionPerformed
        String unif = (String) jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 4);
        String tam = (String) jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 5);
        jComboBoxUniformes.setSelectedItem(unif);
        jComboBoxTamanhos.setSelectedItem(tam);
        jRadioButtonN.setSelected(false);
        jRadioButtonR.setSelected(true);
        jButtonReaproveitarActionPerformed(evt);
        jButtonSalvarActionPerformed(evt);
    }//GEN-LAST:event_jMenuItemReaproveitarReapActionPerformed

    private void jMenuItemExtraviadoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExtraviadoNovoActionPerformed
        String unif = (String) jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 4);
        String tam = (String) jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 5);
        jComboBoxUniformes.setSelectedItem(unif);
        jComboBoxTamanhos.setSelectedItem(tam);
        jRadioButtonN.setSelected(true);
        jRadioButtonR.setSelected(false);
        jButtonExtraviadoActionPerformed(evt);
        jButtonSalvarActionPerformed(evt);
    }//GEN-LAST:event_jMenuItemExtraviadoNovoActionPerformed

    private void jMenuItemExtravaidoReaproveitadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExtravaidoReaproveitadoActionPerformed
        String unif = (String) jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 4);
        String tam = (String) jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 5);
        jComboBoxUniformes.setSelectedItem(unif);
        jComboBoxTamanhos.setSelectedItem(tam);
        jRadioButtonN.setSelected(false);
        jRadioButtonR.setSelected(true);
        jButtonExtraviadoActionPerformed(evt);
        jButtonSalvarActionPerformed(evt);
    }//GEN-LAST:event_jMenuItemExtravaidoReaproveitadoActionPerformed

    private void jTextFieldHistoricoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldHistoricoMouseReleased
        if (jButtonNovo.isEnabled()) {
            if (jTableLancamentos.getSelectedRow() != -1) {
                if (evt.isPopupTrigger()) {
                    jPopupMenuHist.show(jTextFieldHistorico, evt.getX(), evt.getY());
                }
            }
        }
    }//GEN-LAST:event_jTextFieldHistoricoMouseReleased

    private void jMenuItemSalvarHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalvarHistoricoActionPerformed
        if (ValidaAcessos.valida(3) == 2) {
            return;
        }
        modelonovo.setTipomanutencao("HISTORICO ALTERADO");
        modelonovo.setLanhistorico(jTextFieldHistorico.getText());
        modelonovo.setLancod(Integer.parseInt("" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 0)));

        controlelancamentos.SalvarHistorico(modelonovo);
        preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' and (l.lan_sta_cod = 1) and (l.lan_letra = '" + jLabelLetra.getText() + "') order by lan_letra, lan_uni_cod asc");
    }//GEN-LAST:event_jMenuItemSalvarHistoricoActionPerformed

    private void jMenuItemAtualizaIdFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAtualizaIdFuncActionPerformed
        if (ValidaAcessos.valida(4) == 2) {
            return;
        }
        modelonovo.setTipomanutencao("ID DO FUNCIONARIO ALTERADO");
        modelonovo.setLancod(Integer.parseInt("" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 0)));
        modelonovo.setLanfuncod(Integer.parseInt(jTextFieldCodigo.getText()));
        controlelancamentos.AtualizaIdFunc(modelonovo);
        preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' and (l.lan_sta_cod = 1) and (l.lan_letra = '" + jLabelLetra.getText() + "') order by lan_letra, lan_uni_cod asc");
    }//GEN-LAST:event_jMenuItemAtualizaIdFuncActionPerformed

    private void jCheckBoxBrancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxBrancoActionPerformed
        jCheckBoxCinza.setSelected(false);
        jCheckBoxAzul.setSelected(false);
        jCheckBoxTodos.setSelected(false);
        jCheckBoxKitFrio.setSelected(false);

    }//GEN-LAST:event_jCheckBoxBrancoActionPerformed

    private void jCheckBoxAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAzulActionPerformed
        jCheckBoxBranco.setSelected(false);
        jCheckBoxCinza.setSelected(false);
        jCheckBoxTodos.setSelected(false);
        jCheckBoxKitFrio.setSelected(false);
    }//GEN-LAST:event_jCheckBoxAzulActionPerformed

    private void jCheckBoxCinzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCinzaActionPerformed
        jCheckBoxBranco.setSelected(false);
        jCheckBoxAzul.setSelected(false);
        jCheckBoxTodos.setSelected(false);
        jCheckBoxKitFrio.setSelected(false);
    }//GEN-LAST:event_jCheckBoxCinzaActionPerformed

    private void jCheckBoxTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxTodosActionPerformed
        jCheckBoxBranco.setSelected(false);
        jCheckBoxAzul.setSelected(false);
        jCheckBoxCinza.setSelected(false);
        jCheckBoxKitFrio.setSelected(false);
    }//GEN-LAST:event_jCheckBoxTodosActionPerformed

    private void jCheckBoxKitFrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxKitFrioActionPerformed
        jCheckBoxBranco.setSelected(false);
        jCheckBoxAzul.setSelected(false);
        jCheckBoxCinza.setSelected(false);
        jCheckBoxTodos.setSelected(false);
    }//GEN-LAST:event_jCheckBoxKitFrioActionPerformed

    public void TempoCasa() {
        //calculo de idade
        String data11 = dataformatada.format(new Date());
        String data22 = dataformatada.format(objmodfunc.getNascimento());
        int dias2 = (int) diasuso.CalcularTempoUso(data22, data11);

        int xx, anos1 = 0;
        xx = dias2;
        anos1 = xx / 365;
        jTextFieldCodigo.setToolTipText(anos1 + " anos ");
        idade = jTextFieldCodigo.getToolTipText();

        //calculo de tempo de casa
        String data1 = dataformatada.format(new Date());
        String data2 = dataformatada.format(objmodfunc.getFunadmissao());
        int diass = (int) diasuso.CalcularTempoUso(data2, data1);

        int x, y, anos = 0, dias = 0, meses = 0;
        x = diass;
        y = 0;

        anos = x / 360;
        y = x % 360;
        meses = y / 30;
        dias = y % 30;

        if (anos == 0 && meses != 0) {
            jTextFieldNome.setToolTipText("tempo de casa " + meses + " mes(es) e " + dias + " dia(s)");
        } else if (anos == 0 && meses == 0) {
            jTextFieldNome.setToolTipText("tempo de casa " + dias + " dia(s)");
        } else if (dias == 0) {
            jTextFieldNome.setToolTipText("tempo de casa " + anos + " ano(s) e " + meses + " mes(es) ");
        } else if (meses == 0) {
            jTextFieldNome.setToolTipText("tempo de casa " + anos + " ano(s) e " + dias + " dia(s)");
        } else {
            jTextFieldNome.setToolTipText("tempo de casa " + anos + " ano(s), " + meses + " mes(es) e " + dias + " dia(s)");
        }

        tempocasa = jTextFieldNome.getToolTipText();
    }

    public void PerfilEscuro() {
        this.getContentPane().setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jTableLancamentos.setBackground(Color.WHITE);
        jTableLancamentos.setForeground(new java.awt.Color(0, 0, 0));

        //JLabel Jpainel 1
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEstoqueAtual.setForeground(new java.awt.Color(255, 255, 255));

        //JLabel Jpainel 3
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));

        //JLabel Jpainel 4
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        //jTextField Jpainel 1
        jTextFieldCodigo.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldNumero.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldNome.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldApelido.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNumero.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNome.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldApelido.setForeground(new java.awt.Color(255, 255, 255));

        //jTextField Jpainel 3
        jTextFieldHistorico.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldHistorico.setForeground(new java.awt.Color(255, 255, 255));

        //jTextField Jpainel 3
        jRadioButtonN.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonR.setForeground(new java.awt.Color(255, 255, 255));

    }

    public void PerfilAzul() {
        this.getContentPane().setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel2.setBackground(new java.awt.Color(0, 153, 255));
        jPanel3.setBackground(new java.awt.Color(0, 153, 255));
        jPanel4.setBackground(new java.awt.Color(0, 153, 255));
        jTableLancamentos.setBackground(Color.WHITE);
        jTableLancamentos.setForeground(new java.awt.Color(0, 0, 0));

        //JLabel Jpainel 1
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEstoqueAtual.setForeground(new java.awt.Color(255, 255, 255));

        //JLabel Jpainel 3
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));

        //JLabel Jpainel 4
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        //jTextField Jpainel 1
        jTextFieldCodigo.setBackground(new java.awt.Color(0, 153, 255));
        jTextFieldNumero.setBackground(new java.awt.Color(0, 153, 255));
        jTextFieldNome.setBackground(new java.awt.Color(0, 153, 255));
        jTextFieldApelido.setBackground(new java.awt.Color(0, 153, 255));
        jTextFieldCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNumero.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNome.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldApelido.setForeground(new java.awt.Color(255, 255, 255));

        //jTextField Jpainel 3
        jTextFieldHistorico.setBackground(new java.awt.Color(0, 153, 255));
        jTextFieldHistorico.setForeground(new java.awt.Color(255, 255, 255));

        //jTextField Jpainel 3
        jRadioButtonN.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonR.setForeground(new java.awt.Color(255, 255, 255));

    }

    public void PerfilVermelho() {
        this.getContentPane().setBackground(new java.awt.Color(204, 0, 0));
        jPanel1.setBackground(new java.awt.Color(204, 0, 0));
        jPanel2.setBackground(new java.awt.Color(204, 0, 0));
        jPanel3.setBackground(new java.awt.Color(204, 0, 0));
        jPanel4.setBackground(new java.awt.Color(204, 0, 0));
        jTableLancamentos.setBackground(Color.WHITE);
        jTableLancamentos.setForeground(new java.awt.Color(0, 0, 0));

        //JLabel Jpainel 1
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEstoqueAtual.setForeground(new java.awt.Color(255, 255, 255));

        //JLabel Jpainel 3
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));

        //JLabel Jpainel 4
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        //jTextField Jpainel 1
        jTextFieldCodigo.setBackground(new java.awt.Color(204, 0, 0));
        jTextFieldNumero.setBackground(new java.awt.Color(204, 0, 0));
        jTextFieldNome.setBackground(new java.awt.Color(204, 0, 0));
        jTextFieldApelido.setBackground(new java.awt.Color(204, 0, 0));
        jTextFieldCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNumero.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNome.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldApelido.setForeground(new java.awt.Color(255, 255, 255));

        //jTextField Jpainel 3
        jTextFieldHistorico.setBackground(new java.awt.Color(204, 0, 0));
        jTextFieldHistorico.setForeground(new java.awt.Color(255, 255, 255));

        //jTextField Jpainel 3
        jRadioButtonN.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonR.setForeground(new java.awt.Color(255, 255, 255));

    }

    public void PerfilClaro() {
        this.getContentPane().setBackground(new java.awt.Color(240, 240, 240));
        jPanel1.setBackground(new java.awt.Color(240, 240, 240));
        jPanel2.setBackground(new java.awt.Color(240, 240, 240));
        jPanel3.setBackground(new java.awt.Color(240, 240, 240));
        jPanel4.setBackground(new java.awt.Color(240, 240, 240));
        jTableLancamentos.setBackground(new java.awt.Color(240, 240, 240));
        jTableLancamentos.setForeground(new java.awt.Color(0, 0, 0));

        //JLabel Jpainel 1
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEstoqueAtual.setForeground(new java.awt.Color(0, 0, 0));

        //JLabel Jpainel 3
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));

        //JLabel Jpainel 4
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));

        //jTextField Jpainel 1
        jTextFieldCodigo.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldNumero.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldNome.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldApelido.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCodigo.setForeground(Color.BLACK);
        jTextFieldNumero.setForeground(Color.BLACK);
        jTextFieldNome.setForeground(Color.BLACK);
        jTextFieldApelido.setForeground(Color.BLACK);

        //jTextField Jpainel 3
        jTextFieldHistorico.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldHistorico.setForeground(Color.BLACK);

        //jTextField Jpainel 4
        jRadioButtonN.setForeground(Color.BLACK);
        jRadioButtonR.setForeground(Color.BLACK);

    }

    public void PerfilVerde() {
        this.getContentPane().setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jTableLancamentos.setBackground(new java.awt.Color(255, 255, 255));
        jTableLancamentos.setForeground(new java.awt.Color(0, 102, 102));

        //JLabel Jpainel 1
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));

        //JLabel Jpainel 3
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));

        //JLabel Jpainel 4
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEstoqueAtual.setForeground(new java.awt.Color(255, 255, 255));

        //jTextField Jpainel 1
        jTextFieldCodigo.setBackground(new java.awt.Color(0, 102, 102));
        jTextFieldNumero.setBackground(new java.awt.Color(0, 102, 102));
        jTextFieldNome.setBackground(new java.awt.Color(0, 102, 102));
        jTextFieldApelido.setBackground(new java.awt.Color(0, 102, 102));
        jTextFieldCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNumero.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNome.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldApelido.setForeground(new java.awt.Color(255, 255, 255));

        //jTextField Jpainel 3
        jTextFieldHistorico.setBackground(new java.awt.Color(0, 102, 102));
        jTextFieldHistorico.setForeground(new java.awt.Color(255, 255, 255));

        //jTextField Jpainel 3
        jRadioButtonN.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonR.setForeground(new java.awt.Color(255, 255, 255));

    }

    public void PerfilRosa() {
        this.getContentPane().setBackground(new java.awt.Color(153, 0, 153));
        jPanel1.setBackground(new java.awt.Color(153, 0, 153));
        jPanel2.setBackground(new java.awt.Color(153, 0, 153));
        jPanel3.setBackground(new java.awt.Color(153, 0, 153));
        jPanel4.setBackground(new java.awt.Color(153, 0, 153));
        jTableLancamentos.setBackground(new java.awt.Color(255, 255, 255));
        jTableLancamentos.setForeground(new java.awt.Color(153, 0, 153));

        //JLabel Jpainel 1
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));

        //JLabel Jpainel 3
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));

        //JLabel Jpainel 4
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEstoqueAtual.setForeground(new java.awt.Color(255, 255, 255));

        //jTextField Jpainel 1
        jTextFieldCodigo.setBackground(new java.awt.Color(153, 0, 153));
        jTextFieldNumero.setBackground(new java.awt.Color(153, 0, 153));
        jTextFieldNome.setBackground(new java.awt.Color(153, 0, 153));
        jTextFieldApelido.setBackground(new java.awt.Color(153, 0, 153));
        jTextFieldCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNumero.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNome.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldApelido.setForeground(new java.awt.Color(255, 255, 255));

        //jTextField Jpainel 3
        jTextFieldHistorico.setBackground(new java.awt.Color(153, 0, 153));
        jTextFieldHistorico.setForeground(new java.awt.Color(255, 255, 255));

        //jTextField Jpainel 3
        jRadioButtonN.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonR.setForeground(new java.awt.Color(255, 255, 255));

    }

    public void preencherTabelaLancamentos(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Numero", "Letra", "Entrega", "Uniforme", "Tamanho", "Status", "Tipo", "Data Baixa", "Dias Uso", "Historico", "Ult. Mov.", "ID Func.", "Usuário"};

        jTextFieldBarraStatus.setText(modelonovo.getBarrastatus());

        long dias;
        conexao.getConexaoSql();
        conexao.executaSql(sql);
        try {
            SimpleDateFormat dataformatada = new SimpleDateFormat("dd/MM/yyyy");
            conexao.rs.first();

            int cod = conexao.rs.getInt("lan_cod"); // faz gerar o erro para o try cath ser acionado - rs vazio
            do {
                modelonovo.setLanentrega(conexao.rs.getDate("lan_data_entrega"));
                String data1 = dataformatada.format(new Date());
                String data2 = dataformatada.format(modelonovo.getLanentrega());
                dias = diasuso.CalcularTempoUso(data2, data1);
                int usuario = conexao.rs.getInt("lan_usuario_cod");

                if (conexao.rs.getTimestamp("lan_ult_mov") == null) {
                    dados.add(new Object[]{conexao.rs.getInt("lan_cod"), conexao.rs.getInt("lan_fun_num"), conexao.rs.getString("lan_letra"), df.format(conexao.rs.getDate("lan_data_entrega").getTime()), conexao.rs.getString("uni_descricao"), conexao.rs.getString("tam_sigla"), conexao.rs.getString("sta_descricao"), conexao.rs.getString("lan_tipo"), conexao.rs.getDate("lan_data_baixa"), dias, conexao.rs.getString("lan_historico"), null, conexao.rs.getInt("lan_fun_cod"), buscaNomeUsuario(usuario)});
                } else {
                    String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(conexao.rs.getTimestamp("lan_ult_mov").getTime());
                    dados.add(new Object[]{conexao.rs.getInt("lan_cod"), conexao.rs.getInt("lan_fun_num"), conexao.rs.getString("lan_letra"), df.format(conexao.rs.getDate("lan_data_entrega").getTime()), conexao.rs.getString("uni_descricao"), conexao.rs.getString("tam_sigla"), conexao.rs.getString("sta_descricao"), conexao.rs.getString("lan_tipo"), conexao.rs.getDate("lan_data_baixa"), dias, conexao.rs.getString("lan_historico"), date, conexao.rs.getInt("lan_fun_cod"), buscaNomeUsuario(usuario)});
                }

            } while (conexao.rs.next());

            ModeloTabela modelotab = new ModeloTabela(dados, colunas);
            jTableLancamentos.setModel(modelotab);

            jTableLancamentos.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableLancamentos.getColumnModel().getColumn(1).setPreferredWidth(60);
            jTableLancamentos.getColumnModel().getColumn(2).setPreferredWidth(40);
            jTableLancamentos.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTableLancamentos.getColumnModel().getColumn(4).setPreferredWidth(200);
            jTableLancamentos.getColumnModel().getColumn(5).setPreferredWidth(70);
            jTableLancamentos.getColumnModel().getColumn(6).setPreferredWidth(100);
            jTableLancamentos.getColumnModel().getColumn(7).setPreferredWidth(40);
            jTableLancamentos.getColumnModel().getColumn(8).setPreferredWidth(0);
            jTableLancamentos.getColumnModel().getColumn(9).setPreferredWidth(70);
            jTableLancamentos.getColumnModel().getColumn(10).setPreferredWidth(80);
            jTableLancamentos.getColumnModel().getColumn(11).setPreferredWidth(80);

            jTableLancamentos.setAutoResizeMode(jTableLancamentos.AUTO_RESIZE_OFF);
            jTableLancamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jTableLancamentos.setAutoCreateRowSorter(true);

            conexao.FecharConexao();
            jTextFieldHistorico.setText("");
            jTextFieldHistorico.setEnabled(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nenhum lançamentos encontrado.");
            limpaTabelaLamcamentos();
            jTextFieldHistorico.setEnabled(false);

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

    public void preencheUniformes() {
        conexao.getConexaoSql();
        conexao.executaSql("select * from uniformes order by uni_descricao");
        try {
            conexao.rs.first();
            jComboBoxUniformes.removeAllItems();

            do {
                jComboBoxUniformes.addItem(conexao.rs.getString("uni_descricao"));
            } while (conexao.rs.next());

        } catch (SQLException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao preencher jComboBox uniformes");
        }

        conexao.FecharConexao();

    }

    public void buscaCodigoUniformes() {
        conexao.getConexaoSql();

        conexao.executaSql("select * from uniformes where uni_descricao= '" + jComboBoxUniformes.getSelectedItem() + "'");
        try {
            conexao.rs.first();
            modelonovo.setLanuniforme(conexao.rs.getInt("uni_cod"));
            modelonovo.setPath(conexao.rs.getString("path"));
            modelonovo.setSaldo(conexao.rs.getInt("uni_est_minimo"));
        } catch (SQLException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao capturar codigo do uniforme.");
        }
        conexao.FecharConexao();

    }

    public void buscaCodigoTamanho() {
        conexao.getConexaoSql();

        conexao.executaSql("select * from tamanhos where tam_sigla= '" + jComboBoxTamanhos.getSelectedItem() + "' ");
        try {
            conexao.rs.first();
            modelonovo.setLantamanho(conexao.rs.getInt("tam_cod"));

        } catch (SQLException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao capturar codigo do tamanho.");
        }
        conexao.FecharConexao();
    }

    public void buscaCodigoStatus() {
        conexao.getConexaoSql();

        conexao.executaSql("select * from status where sta_vinculo_jbtn= '" + modelonovo.getPesquisa() + "' ");
        try {
            conexao.rs.first();
            modelonovo.setLanstatus(conexao.rs.getInt("sta_cod"));

        } catch (SQLException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao capturar codigo do status.");
        }
        conexao.FecharConexao();
    }

    public void preencheTamanhos() {
        conexao.getConexaoSql();
        conexao.executaSql("select * from tamanhos");
        try {
            conexao.rs.first();
            jComboBoxTamanhos.removeAllItems();
            do {
                jComboBoxTamanhos.addItem(conexao.rs.getString("tam_sigla"));
            } while (conexao.rs.next());

        } catch (SQLException ex) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao preencher jCobomBox tamanhos");
        }

        conexao.FecharConexao();
    }

    public void limpaTabelaLamcamentos() {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Numero", "Letra", "Entrega", "Uniforme", "Tamanho", "Status", "Tipo", "Data Baixa", "Dias Uso", "Historico", "Ult. Mov."};
        ModeloTabela modelotab = new ModeloTabela(dados, colunas);
        jTableLancamentos.setModel(modelotab);
    }

    public void excluirLançamento() {

        modelonovo.setLancod(Integer.parseInt("" + jTableLancamentos.getValueAt(jTableLancamentos.getSelectedRow(), 0)));
        modelonovo.setTipomanutencao("LANÇAMENTO EXCLUIDO");
        controlelancamentos.excluir(modelonovo);

        preencherTabelaLancamentos("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + jTextFieldNumero.getText() + "' and (l.lan_sta_cod = 1) and (l.lan_letra = '" + "" + jLabelLetra.getText() + "') order by lan_letra, lan_uni_cod asc");
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

    public void fotouniforme() {

        //ImageIcon img = (new ImageIcon("C:/Users/Lavanderia/Documents/NetBeansProjects/ProjetoLavanderia/src/br/com/Imagens/BlusaBranca96px.png"));
        ImageIcon img = (new ImageIcon(modelonovo.getPath()));
        jLabelFoto.setIcon(img);

    }

    private class AlternatingTableRenderer extends javax.swing.table.DefaultTableCellRenderer {

        @Override
        public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
                boolean isSelected, boolean cellHasFocus, int row, int column) {

            // Obtém o componente padrão
            java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, cellHasFocus, row, column);

            if (!isSelected) {
                // Lógica de cores alternadas para linhas não selecionadas
                if (row % 2 == 0) {
                    c.setBackground(new java.awt.Color(200, 230, 255)); // Azul Escuro
                    c.setForeground(java.awt.Color.BLACK);          // Letra Branca
                } else {
                    c.setBackground(java.awt.Color.WHITE);          // Fundo Branco
                    c.setForeground(java.awt.Color.BLACK);          // Letra Preta
                }
                // Garante que a fonte não seja negrito nas linhas normais
                c.setFont(c.getFont().deriveFont(java.awt.Font.PLAIN));
            } else {
                // --- LINHA SELECIONADA ---
                c.setBackground(new java.awt.Color(0, 102, 204));
                c.setForeground(java.awt.Color.WHITE);
                c.setFont(c.getFont().deriveFont(java.awt.Font.BOLD));
            }

            // Centraliza o texto (opcional, remova se preferir alinhado à esquerda)
            // setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            return c;
        }
    }

    private class AlternatingColorRenderer extends javax.swing.DefaultListCellRenderer {

        @Override
        public java.awt.Component getListCellRendererComponent(javax.swing.JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            // Renderização padrão
            java.awt.Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            // Se a linha não estiver selecionada pelo mouse/teclado
            if (!isSelected) {
                if (index % 2 == 0) {
                    // Fundo Azul Escuro e Letra Branca
                    c.setBackground(new java.awt.Color(200, 230, 255));
                    c.setForeground(java.awt.Color.BLACK);
                    ;
                } else {
                    // Fundo Branco e Letra Preta (Linhas ímpares)
                    c.setBackground(java.awt.Color.WHITE);
                    c.setForeground(java.awt.Color.BLACK);
                }
                // Remove o negrito das linhas não selecionadas (opcional)
                c.setFont(c.getFont().deriveFont(java.awt.Font.PLAIN));

            } else {
                // --- ITEM SELECIONADO (MOUSE OU TECLADO) ---
                // Fundo azul médio, letra branca e em NEGRITO
                c.setBackground(new java.awt.Color(0, 102, 204));
                c.setForeground(java.awt.Color.WHITE);
                c.setFont(c.getFont().deriveFont(java.awt.Font.BOLD));
            }

            return c;
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
            java.util.logging.Logger.getLogger(TelaLancamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLancamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLancamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLancamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLancamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonA;
    private javax.swing.JButton jButtonB;
    private javax.swing.JButton jButtonC;
    private javax.swing.JButton jButtonD;
    private javax.swing.JButton jButtonDescartar;
    private javax.swing.JButton jButtonE;
    private javax.swing.JButton jButtonEstoque;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonExtraviado;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonReaproveitar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVerEstoque;
    private javax.swing.JCheckBox jCheckBoxAzul;
    private javax.swing.JCheckBox jCheckBoxBranco;
    private javax.swing.JCheckBox jCheckBoxCinza;
    private javax.swing.JCheckBox jCheckBoxKitFrio;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JComboBox<String> jComboBoxCargos;
    private javax.swing.JComboBox<String> jComboBoxDepartamentos;
    private javax.swing.JComboBox<String> jComboBoxEmpresas;
    private javax.swing.JComboBox<String> jComboBoxLetras;
    private javax.swing.JComboBox<String> jComboBoxTamanhos;
    private javax.swing.JComboBox<String> jComboBoxUniformes;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDataAtual;
    private javax.swing.JLabel jLabelEstoqueAtual;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelFoto1;
    private javax.swing.JLabel jLabelLetra;
    private javax.swing.JMenu jMenuDescartar;
    private javax.swing.JMenu jMenuExtravaido;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItemAtualizaIdFunc;
    private javax.swing.JMenuItem jMenuItemDescartarNovo;
    private javax.swing.JMenuItem jMenuItemDescartarReap;
    private javax.swing.JMenuItem jMenuItemExtravaidoReaproveitado;
    private javax.swing.JMenuItem jMenuItemExtraviadoNovo;
    private javax.swing.JMenuItem jMenuItemReaproveitarNovo;
    private javax.swing.JMenuItem jMenuItemReaproveitarReap;
    private javax.swing.JMenuItem jMenuItemSalvarHistorico;
    private javax.swing.JMenu jMenuReaproveitar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenuBaixas;
    private javax.swing.JPopupMenu jPopupMenuHist;
    private javax.swing.JRadioButton jRadioButtonN;
    private javax.swing.JRadioButton jRadioButtonR;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JTable jTableLancamentos;
    private javax.swing.JTextField jTextFieldApelido;
    private javax.swing.JTextField jTextFieldBarraStatus;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldHistorico;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumero;
    // End of variables declaration//GEN-END:variables
}
