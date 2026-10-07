/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Visao;

import br.com.ConexaoBancoDados.ConexaoSql;
import br.com.Modelo.ModeloFuncionario;
import br.com.Controle.ControleFuncionario;
import br.com.Modelo.ModeloTabela;
import br.com.Utilitarios.ValidaAcessos;
import java.awt.AWTKeyStroke;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Lavanderia
 */
public final class TelaCadFuncionarios extends javax.swing.JFrame {

    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    ModeloFuncionario modelo = new ModeloFuncionario();
    ModeloFuncionario modeloeditar = new ModeloFuncionario();
    ModeloFuncionario modeloexcluir = new ModeloFuncionario();
    ModeloFuncionario objmodfunc = new ModeloFuncionario();
    ControleFuncionario controle = new ControleFuncionario();
    ConexaoSql conecta = new ConexaoSql();
    public int carcod;
    public String informacao;
    int flag = 0;
    int flag2 = 0;

    public TelaCadFuncionarios() {
        initComponents();
        preencherTabela("select func.fun_cod, func.fun_num, func.fun_nome, func.fun_sexo,empre.emp_razao, depar.dep_descricao, carg.car_descricao, tamah.tam_sigla, func.fun_qtd_mudas, func.fun_data_cadastro, func.fun_admissao, func.fun_demissao, func.fun_telefone, func.fun_cpf, func.fun_apelido, func.fun_status, func.fun_obs, func.fun_nascimento from funcionarios as func inner join empresas as empre on func.fun_emp_cod = empre.emp_cod inner join departamentos as depar on func.fun_dep_cod = depar.dep_cod inner join cargos as carg on func.fun_car_cod = carg.car_cod inner join tamanhos as tamah on func.fun_tam_cod = tamah.tam_cod where func.fun_num > 100 order by func.fun_dep_cod, func.fun_nome ");
        preencherCargos();
        preencheEmpresas();
        preencheTamanhos();
        preencheDepartamentos();
        buscanumeroinativo();

        HashSet conj;
        conj = new HashSet(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonPesquisar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldQtdMudas = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldCpf = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldApelido = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldTelefone = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldObs = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFuncionarios = new javax.swing.JTable();
        jButtonCancelar = new javax.swing.JButton();
        jDateChooserCadastro = new com.toedter.calendar.JDateChooser();
        jDateChooserAdmissao = new com.toedter.calendar.JDateChooser();
        jDateChooserDemissao = new com.toedter.calendar.JDateChooser();
        jComboBoxCargos = new javax.swing.JComboBox<>();
        jComboBoxStatus = new javax.swing.JComboBox<>();
        jComboBoxSexo = new javax.swing.JComboBox<>();
        jComboBoxEmpresas = new javax.swing.JComboBox<>();
        jComboBoxTamanhos = new javax.swing.JComboBox<>();
        jComboBoxDepartamentos = new javax.swing.JComboBox<>();
        jLabelNumInativo = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jDateChooserNascimento = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Funcionários");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Salvar 32px.png"))); // NOI18N
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Novo Func 32 px.png"))); // NOI18N
        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Editar 32px.png"))); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonPesquisar.setBackground(new java.awt.Color(153, 255, 255));
        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Pesquisar 32 px.png"))); // NOI18N
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Excluir Func 32px.png"))); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jLabel2.setText("ID");

        jTextFieldCodigo.setEnabled(false);
        jTextFieldCodigo.setRequestFocusEnabled(false);

        jLabel3.setText("Numero");

        jTextFieldNumero.setBackground(new java.awt.Color(255, 255, 153));
        jTextFieldNumero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNumeroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNumeroFocusLost(evt);
            }
        });

        jLabel4.setText("Sexo");

        jLabel5.setText("Admissão");

        jLabel6.setText("Nome");

        jTextFieldNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel7.setText("Tamanho Padrão");

        jLabel8.setText("Cargo");

        jLabel9.setText("Empresa");

        jLabel10.setText("Setor");

        jLabel11.setText("Qtd Mudas");

        jLabel12.setText("CPF");

        jLabel13.setText("Apelido");

        jTextFieldApelido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel14.setText("Telefone");

        jLabel15.setText("Cadastro");

        jLabel16.setText("Status");

        jLabel17.setText("Demissão");

        jLabel18.setText("Obs");

        jTableFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFuncionarios);

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Cancelar 32px.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jDateChooserCadastro.setDateFormatString("dd'/'MM'/'yyyy");

        jDateChooserAdmissao.setDateFormatString("dd'/'MM'/'yyyy");

        jDateChooserDemissao.setEnabled(false);

        jComboBoxCargos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "ATIVO", "DEMITIDO", "INSS", "AFASTADO", "APOSENTADO", "INATIVO" }));

        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "FEMININO", "MASCULINO" }));

        jComboBoxEmpresas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxTamanhos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxDepartamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelNumInativo.setEnabled(false);

        jLabel19.setText("Nascimento");

        jDateChooserNascimento.setDateFormatString("dd'/'MM'/'yyyy");

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel1.setText("PTM");
        jLabel1.setToolTipText("Primeira Truma");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel20.setText("OBS");
        jLabel20.setToolTipText("Observação");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                                .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(180, 180, 180))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jComboBoxEmpresas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jTextFieldCpf)
                                                    .addComponent(jComboBoxDepartamentos, javax.swing.GroupLayout.Alignment.LEADING, 0, 205, Short.MAX_VALUE))
                                                .addGap(30, 30, 30)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel14)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jDateChooserNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel7)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jComboBoxTamanhos, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextFieldObs, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxCargos, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jDateChooserDemissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jDateChooserCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jDateChooserAdmissao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldApelido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldQtdMudas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(7, 7, 7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabelNumInativo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonPesquisar)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jDateChooserAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jComboBoxEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jComboBoxCargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel10)
                                            .addComponent(jComboBoxDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7)
                                            .addComponent(jComboBoxTamanhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel11)
                                            .addComponent(jTextFieldQtdMudas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jButtonSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(jButtonEditar)
                                .addGap(4, 4, 4)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonExcluir)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel16)
                                            .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19))
                                        .addComponent(jDateChooserNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jDateChooserCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCancelar)
                            .addComponent(jLabel18)
                            .addComponent(jTextFieldObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel1)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jDateChooserDemissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabelNumInativo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(954, 607));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (ValidaAcessos.valida(3) == 2) {
            return;
        }
        validaCampos();
        if (flag2 == 9) {
            flag2 = 0;
            return;
        }

        if (flag == 1) {
            modelo.setFunnum(Integer.parseInt(jTextFieldNumero.getText()));
            modelo.setFunnome(jTextFieldNome.getText());
            modelo.setFunsexo((String) jComboBoxSexo.getSelectedItem());
            modelo.setFunempcod(buscaCodigoEmpresas());
            modelo.setFundepcod(buscaCodigoDepartamentos());
            modelo.setFuntamcod(buscaCodigoTamanhos());
            modelo.setFunobs(jTextFieldObs.getText());
            modelo.setFunqtdmudas(Integer.parseInt(jTextFieldQtdMudas.getText()));
            modelo.setFundatacadastro(jDateChooserCadastro.getDate());
            modelo.setFunadmissao(jDateChooserAdmissao.getDate());
            modelo.setFuncarcod(buscaCodigoCargos());
            modelo.setFuntelefone(jTextFieldTelefone.getText());
            modelo.setFuncpf(jTextFieldCpf.getText());
            modelo.setFunapelido(jTextFieldApelido.getText());
            modelo.setFunstatus((String) jComboBoxStatus.getSelectedItem());
            modelo.setNascimento(jDateChooserNascimento.getDate());
            controle.salvar(modelo);

        } else if (flag == 2) {
            modeloeditar.setFuncod(Integer.parseInt(jTextFieldCodigo.getText()));
            modeloeditar.setFunnum(Integer.parseInt(jTextFieldNumero.getText()));
            modeloeditar.setFunnome(jTextFieldNome.getText());
            modeloeditar.setFunsexo((String) jComboBoxSexo.getSelectedItem());
            modeloeditar.setFunempcod(buscaCodigoEmpresas());
            modeloeditar.setFundepcod(buscaCodigoDepartamentos());
            modeloeditar.setFuntamcod(buscaCodigoTamanhos());
            modeloeditar.setFunobs(jTextFieldObs.getText());
            modeloeditar.setFunqtdmudas(Integer.parseInt(jTextFieldQtdMudas.getText()));
            modeloeditar.setFundatacadastro(jDateChooserCadastro.getDate());
            modeloeditar.setFunadmissao(jDateChooserAdmissao.getDate());
            modeloeditar.setFuncarcod(buscaCodigoCargos());
            modeloeditar.setFuntelefone(jTextFieldTelefone.getText());
            modeloeditar.setFuncpf(jTextFieldCpf.getText());
            modeloeditar.setFunapelido(jTextFieldApelido.getText());
            modeloeditar.setFunstatus((String) jComboBoxStatus.getSelectedItem());
            modeloeditar.setNascimento(jDateChooserNascimento.getDate());
            controle.editar(modeloeditar);

        }
        preencherTabela("select func.fun_cod, func.fun_num, func.fun_nome, func.fun_sexo,empre.emp_razao, depar.dep_descricao, carg.car_descricao, tamah.tam_sigla, func.fun_qtd_mudas, func.fun_data_cadastro, func.fun_admissao, func.fun_demissao, func.fun_telefone, func.fun_cpf, func.fun_apelido, func.fun_status, func.fun_obs, func.fun_nascimento from funcionarios as func inner join empresas as empre on func.fun_emp_cod = empre.emp_cod inner join departamentos as depar on func.fun_dep_cod = depar.dep_cod inner join cargos as carg on func.fun_car_cod = carg.car_cod inner join tamanhos as tamah on func.fun_tam_cod = tamah.tam_cod where func.fun_num > 100 order by func.fun_dep_cod, func.fun_nome ");

        jButtonPesquisar.setEnabled(true);
        jButtonNovo.setEnabled(true);
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        buscanumeroinativo();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        if (jTextFieldNome.getText().equals("")) {
            return;
        }
        
        jButtonPesquisar.setEnabled(false);
        jButtonNovo.setEnabled(false);
        jButtonEditar.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jTextFieldNome.setEnabled(true);

        objmodfunc.setPesquisa(jTextFieldNome.getText());
        preencherTabela("select func.fun_cod, func.fun_num, func.fun_nome, func.fun_sexo,empre.emp_razao, depar.dep_descricao, carg.car_descricao, tamah.tam_sigla, func.fun_qtd_mudas, func.fun_data_cadastro, func.fun_admissao, func.fun_demissao, func.fun_telefone, func.fun_cpf, func.fun_apelido, func.fun_status, func.fun_obs, func.fun_nascimento from funcionarios as func inner join empresas as empre on func.fun_emp_cod = empre.emp_cod inner join departamentos as depar on func.fun_dep_cod = depar.dep_cod inner join cargos as carg on func.fun_car_cod = carg.car_cod inner join tamanhos as tamah on func.fun_tam_cod = tamah.tam_cod where func.fun_nome like '%" + objmodfunc.getPesquisa() + "%' order by func.fun_nome");


    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        limpaCampos();
        jButtonPesquisar.setEnabled(true);
        jButtonNovo.setEnabled(true);
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        flag = 0;
        preencherTabela("select func.fun_cod, func.fun_num, func.fun_nome, func.fun_sexo,empre.emp_razao, depar.dep_descricao, carg.car_descricao, tamah.tam_sigla, func.fun_qtd_mudas, func.fun_data_cadastro, func.fun_admissao, func.fun_demissao, func.fun_telefone, func.fun_cpf, func.fun_apelido, func.fun_status, func.fun_obs, func.fun_nascimento from funcionarios as func inner join empresas as empre on func.fun_emp_cod = empre.emp_cod inner join departamentos as depar on func.fun_dep_cod = depar.dep_cod inner join cargos as carg on func.fun_car_cod = carg.car_cod inner join tamanhos as tamah on func.fun_tam_cod = tamah.tam_cod where func.fun_num > 100 order by func.fun_dep_cod, func.fun_nome ");

    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTableFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFuncionariosMouseClicked
        //String codigofuncionario = ""+jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 0);

        conecta.getConexaoSql();
        conecta.executaSql("select func.fun_cod, func.fun_num, func.fun_nome, func.fun_sexo,empre.emp_razao, depar.dep_descricao, carg.car_descricao, tamah.tam_sigla,  func.fun_qtd_mudas, func.fun_data_cadastro, func.fun_admissao, func.fun_demissao, func.fun_telefone, func.fun_cpf, func.fun_apelido, func.fun_status, func.fun_obs, func.fun_nascimento from funcionarios as func inner join empresas as empre on func.fun_emp_cod = empre.emp_cod inner join departamentos as depar on func.fun_dep_cod = depar.dep_cod inner join cargos as carg on func.fun_car_cod = carg.car_cod inner join tamanhos as tamah on func.fun_tam_cod = tamah.tam_cod where func.fun_cod < 100");

        try {
            conecta.rs.first();
            jTextFieldCodigo.setText("" + jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 0));
            jTextFieldNumero.setText("" + jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 1));
            jTextFieldNome.setText("" + jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 2));
            jComboBoxSexo.setSelectedItem("" + jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 3));
            jComboBoxEmpresas.setSelectedItem("" + jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 4));
            jComboBoxDepartamentos.setSelectedItem("" + jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 5));
            jComboBoxCargos.setSelectedItem("" + jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 6));
            jComboBoxTamanhos.setSelectedItem("" + jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 7));
            jTextFieldQtdMudas.setText("" + jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 8));

            try {
                if (jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 9) != null) {
                    jDateChooserCadastro.setDate(df.parse((String) jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 9)));
                }

                if (jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 10) != null) {
                    jDateChooserAdmissao.setDate(df.parse((String) jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 10)));
                }

                if (jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 11) != null) {
                    jDateChooserDemissao.setDate(df.parse((String) jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 11)));
                }
                if (jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 17) != null) {
                    jDateChooserNascimento.setDate(df.parse((String) jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 17)));
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao mostrar data no DataChooser");
            }

            jTextFieldTelefone.setText("" + jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 12));
            jTextFieldCpf.setText("" + jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 13));
            jTextFieldApelido.setText("" + jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 14));
            jComboBoxStatus.setSelectedItem("" + jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 15));
            jTextFieldObs.setText("" + jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 16));

            jButtonPesquisar.setEnabled(false);
            jButtonNovo.setEnabled(false);
            jButtonEditar.setEnabled(true);
            jButtonExcluir.setEnabled(true);
            jButtonCancelar.setEnabled(true);
            jButtonSalvar.setEnabled(false);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar os dados" + ex);
        }

        conecta.FecharConexao();
    }//GEN-LAST:event_jTableFuncionariosMouseClicked

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        if (ValidaAcessos.valida(3) == 2) {
            return;
        }
        flag = 2;
        jButtonPesquisar.setEnabled(false);
        jButtonNovo.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonCancelar.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jTextFieldNumero.requestFocus();
        //habilitaCampos(true);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        if (ValidaAcessos.valida(3) == 2) {
            return;
        }
        flag = 1;
        limpaCampos();
        jDateChooserCadastro.setDate(new Date());
        jButtonPesquisar.setEnabled(false);
        jButtonNovo.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonCancelar.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        
        TelaNovoCadastro tela = new TelaNovoCadastro(this);
        tela.setVisible(true);
        
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        if (ValidaAcessos.valida(4) == 2) {
            return;
        }
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Confirma exclusão dos dados?");
        if (resposta == JOptionPane.YES_OPTION) {
            modeloexcluir.setFuncod(Integer.parseInt(jTextFieldCodigo.getText()));
            controle.excluir(modeloexcluir);
            limpaCampos();
            jButtonPesquisar.setEnabled(true);
            jButtonNovo.setEnabled(true);
            jButtonEditar.setEnabled(false);
            jButtonExcluir.setEnabled(false);
            jButtonCancelar.setEnabled(false);
            jButtonSalvar.setEnabled(false);
            preencherTabela("select func.fun_cod, func.fun_num, func.fun_nome, func.fun_sexo,empre.emp_razao, depar.dep_descricao, carg.car_descricao, tamah.tam_sigla, func.fun_qtd_mudas, func.fun_data_cadastro, func.fun_admissao, func.fun_demissao, func.fun_telefone, func.fun_cpf, func.fun_apelido, func.fun_status, func.fun_obs, func.fun_nascimento from funcionarios as func inner join empresas as empre on func.fun_emp_cod = empre.emp_cod inner join departamentos as depar on func.fun_dep_cod = depar.dep_cod inner join cargos as carg on func.fun_car_cod = carg.car_cod inner join tamanhos as tamah on func.fun_tam_cod = tamah.tam_cod where func.fun_dep_cod = 1 order by func.fun_emp_cod, func.fun_nome ");
        }

    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTextFieldNumeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNumeroFocusLost
        if (jTextFieldNumero.getText().equals("")) {
            return;
        }
        jButtonPesquisar.setEnabled(false);
        jButtonNovo.setEnabled(false);
        //jButtonEditar.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jTextFieldNome.setEnabled(true);

        if (flag != 2) {
            objmodfunc.setFunnum(Integer.parseInt(jTextFieldNumero.getText()));
            controle.buscaCodigoFuncionario(objmodfunc);
            if (objmodfunc.getFuncod() == -1) {
                return;
            }
            //limpaCampos();
        }
        preencherTabela("select func.fun_cod, func.fun_num, func.fun_nome, func.fun_sexo,empre.emp_razao, depar.dep_descricao, carg.car_descricao, tamah.tam_sigla, func.fun_qtd_mudas, func.fun_data_cadastro, func.fun_admissao, func.fun_demissao, func.fun_telefone, func.fun_cpf, func.fun_apelido, func.fun_status, func.fun_obs, func.fun_nascimento from funcionarios as func inner join empresas as empre on func.fun_emp_cod = empre.emp_cod inner join departamentos as depar on func.fun_dep_cod = depar.dep_cod inner join cargos as carg on func.fun_car_cod = carg.car_cod inner join tamanhos as tamah on func.fun_tam_cod = tamah.tam_cod where func.fun_num ='" + jTextFieldNumero.getText() + "'  order by func.fun_emp_cod, func.fun_nome ");

    }//GEN-LAST:event_jTextFieldNumeroFocusLost

    private void jTextFieldNumeroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNumeroFocusGained
       /* if (flag != 2) {
            limpaCampos();
            jButtonPesquisar.setEnabled(true);
            jButtonNovo.setEnabled(true);
            jButtonEditar.setEnabled(false);
            jButtonExcluir.setEnabled(false);
            jButtonCancelar.setEnabled(false);
            jButtonSalvar.setEnabled(false);
            flag = 0;
            preencherTabela("select func.fun_cod, func.fun_num, func.fun_nome, func.fun_sexo,empre.emp_razao, depar.dep_descricao, carg.car_descricao, tamah.tam_sigla, func.fun_qtd_mudas, func.fun_data_cadastro, func.fun_admissao, func.fun_demissao, func.fun_telefone, func.fun_cpf, func.fun_apelido, func.fun_status, func.fun_obs, func.fun_nascimento from funcionarios as func inner join empresas as empre on func.fun_emp_cod = empre.emp_cod inner join departamentos as depar on func.fun_dep_cod = depar.dep_cod inner join cargos as carg on func.fun_car_cod = carg.car_cod inner join tamanhos as tamah on func.fun_tam_cod = tamah.tam_cod where func.fun_num > 100 order by func.fun_dep_cod, func.fun_nome ");
        }*/
    }//GEN-LAST:event_jTextFieldNumeroFocusGained

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        jTextFieldObs.setText("PTM");
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        jTextFieldObs.setText("OBS");
    }//GEN-LAST:event_jLabel20MouseClicked

    /*public void preencherCampos(String nome, String setor, String cargo,
                            String cpf, String telefone,
                            String sexo, String status) {

    jTextFieldNome.setText(nome);
    jComboBoxDepartamentos.setSelectedItem(setor);
    jComboBoxCargos.setSelectedItem(cargo);
    jTextFieldCpf.setText(cpf);
    jTextFieldTelefone.setText(telefone);

    // STATUS
    jComboBoxStatus.setSelectedItem(status);

    // SEXO
    if (sexo != null) {
        if (sexo.equalsIgnoreCase("M")) {
            jComboBoxSexo.setSelectedItem("MASCULINO");
        } else if (sexo.equalsIgnoreCase("F")) {
            jComboBoxSexo.setSelectedItem("FEMININO");
        }
    }
}*/

public void preencherCampos(String nome, String setor, String funcao, String cpf,
                            String celular, String sexo, String status,
                            java.util.Date dataAdmissao, java.util.Date dataNascimento) {

    jTextFieldNome.setText(nome != null ? nome : "");
    jComboBoxDepartamentos.setSelectedItem(setor != null ? setor : "");
    jComboBoxCargos.setSelectedItem(funcao != null ? funcao : "");
    jTextFieldCpf.setText(cpf != null ? cpf : "");
    jTextFieldTelefone.setText(celular != null ? celular : "");

    // ComboBox com proteção contra null e espaços
    jComboBoxSexo.setSelectedItem(sexo != null ? sexo.trim() : null);
    jComboBoxStatus.setSelectedItem(status != null ? status.trim() : null);

    // Datas seguras
    jDateChooserAdmissao.setDate(dataAdmissao);
    jDateChooserNascimento.setDate(dataNascimento);

    // Foco depois da atualização da UI
    javax.swing.SwingUtilities.invokeLater(() -> jTextFieldNome.requestFocus());
}

    
    
    public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Numero", "Nome", "Sexo", "Empresa", "Setor", "Função", "Tamanho", "Mudas", "Cadastro", "Admissao", "Demissao", "Telefone", "CPF", "Apelido", "Status", "Observação", "Nascimento"};

        conecta.getConexaoSql();
        conecta.executaSql(sql);
        try {
            conecta.rs.first();
            do {
                String data;
                String dataadm;
                String datademi;
                String datanasc;

                if (conecta.rs.getDate("fun_data_cadastro") != null) {
                    data = df.format(conecta.rs.getDate("fun_data_cadastro").getTime());
                } else {
                    data = null;
                }

                if (conecta.rs.getDate("fun_admissao") != null) {
                    dataadm = df.format(conecta.rs.getDate("fun_admissao").getTime());
                } else {
                    dataadm = null;
                }

                if (conecta.rs.getDate("fun_demissao") != null) {
                    datademi = df.format(conecta.rs.getDate("fun_demissao").getTime());
                } else {
                    datademi = null;
                }

                if (conecta.rs.getDate("fun_nascimento") != null) {
                    datanasc = df.format(conecta.rs.getDate("fun_nascimento").getTime());
                } else {
                    datanasc = null;
                }
                dados.add(new Object[]{conecta.rs.getInt("fun_cod"), conecta.rs.getInt("fun_num"), conecta.rs.getString("fun_nome"), conecta.rs.getString("fun_sexo"), conecta.rs.getString("emp_razao"), conecta.rs.getString("dep_descricao"), conecta.rs.getString("car_descricao"), conecta.rs.getString("tam_sigla"), conecta.rs.getString("fun_qtd_mudas"), data, dataadm, datademi, conecta.rs.getString("fun_telefone"), conecta.rs.getString("fun_cpf"), conecta.rs.getString("fun_apelido"), conecta.rs.getString("fun_status"), conecta.rs.getString("fun_obs"), datanasc});
            } while (conecta.rs.next());

            ModeloTabela modelotab = new ModeloTabela(dados, colunas);
            jTableFuncionarios.setModel(modelotab);

            jTableFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTableFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(250);
            jTableFuncionarios.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTableFuncionarios.getColumnModel().getColumn(4).setPreferredWidth(180);
            jTableFuncionarios.getColumnModel().getColumn(5).setPreferredWidth(180);
            jTableFuncionarios.getColumnModel().getColumn(6).setPreferredWidth(150);

            jTableFuncionarios.setAutoResizeMode(jTableFuncionarios.AUTO_RESIZE_OFF);
            jTableFuncionarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jTableFuncionarios.setAutoCreateRowSorter(true);

            conecta.FecharConexao();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Preencher ArrayList (JTABLE) \n \n" + e);

        }

    }

    public void preencherCargos() {
        conecta.getConexaoSql();

        conecta.executaSql("select * from cargos order by car_descricao");
        try {
            conecta.rs.first();
            jComboBoxCargos.removeAllItems();
            jComboBoxCargos.addItem("Selecione");
            do {
                jComboBoxCargos.addItem(conecta.rs.getString("car_descricao"));
            } while (conecta.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher cargos.");
        }

        conecta.FecharConexao();

    }

    public int buscaCodigoCargos() {
        conecta.getConexaoSql();

        conecta.executaSql("select * from cargos where car_descricao= '" + jComboBoxCargos.getSelectedItem() + "' ");
        try {
            conecta.rs.first();
            carcod = conecta.rs.getInt("car_cod");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao capturar codigo do cargo \n \n" + ex);
        }

        conecta.FecharConexao();
        return carcod;
    }

    public void preencheEmpresas() {
        conecta.getConexaoSql();
        conecta.executaSql("select * from empresas order by emp_razao");

        try {
            conecta.rs.first();
            jComboBoxEmpresas.removeAllItems();
            jComboBoxEmpresas.addItem("Selecione");
            do {
                jComboBoxEmpresas.addItem(conecta.rs.getString("emp_razao"));
            } while (conecta.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher empresa. \n\n" + ex);
        }

        conecta.FecharConexao();
    }

    public int buscaCodigoEmpresas() {
        conecta.getConexaoSql();

        conecta.executaSql("select * from empresas where emp_razao= '" + jComboBoxEmpresas.getSelectedItem() + "' ");
        try {
            conecta.rs.first();
            carcod = conecta.rs.getInt("emp_cod");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao capturar codigo da empresa \n \n" + ex);
        }
        conecta.FecharConexao();
        return carcod;
    }

    public void preencheTamanhos() {
        conecta.getConexaoSql();
        conecta.executaSql("select * from tamanhos order by tam_cod");

        try {
            conecta.rs.first();
            jComboBoxTamanhos.removeAllItems();
            jComboBoxTamanhos.addItem("Selecione");
            do {
                jComboBoxTamanhos.addItem(conecta.rs.getString("tam_sigla"));
            } while (conecta.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher tamanhos. \n\n" + ex);
        }

        conecta.FecharConexao();
    }

    public int buscaCodigoTamanhos() {
        conecta.getConexaoSql();

        conecta.executaSql("select * from tamanhos where tam_sigla= '" + jComboBoxTamanhos.getSelectedItem() + "' ");
        try {
            conecta.rs.first();
            carcod = conecta.rs.getInt("tam_cod");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao capturar codigo do tamamho \n \n" + ex);
        }

        conecta.FecharConexao();
        return carcod;
    }

    public void preencheDepartamentos() {
        conecta.getConexaoSql();
        conecta.executaSql("select * from departamentos order by dep_descricao");

        try {
            conecta.rs.first();
            jComboBoxDepartamentos.removeAllItems();
            jComboBoxDepartamentos.addItem("Selecione");
            do {
                jComboBoxDepartamentos.addItem(conecta.rs.getString("dep_descricao"));
            } while (conecta.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher departamentos. \n\n" + ex);
        }

        conecta.FecharConexao();
    }

    public int buscaCodigoDepartamentos() {
        conecta.getConexaoSql();

        conecta.executaSql("select * from departamentos where dep_descricao= '" + jComboBoxDepartamentos.getSelectedItem() + "' ");
        try {
            conecta.rs.first();
            carcod = conecta.rs.getInt("dep_cod");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao capturar codigo do departamento \n \n" + ex);
        }

        conecta.FecharConexao();
        return carcod;
    }

    public void limpaCampos() {
        jTextFieldCodigo.setText("");
        jTextFieldNome.setText("");
        jTextFieldNumero.setText("");
        jComboBoxSexo.setSelectedItem("Selecione");

        jComboBoxEmpresas.setSelectedItem("Selecione");
        jComboBoxDepartamentos.setSelectedItem("Selecione");
        jComboBoxTamanhos.setSelectedItem("Selecione");
        jTextFieldObs.setText("");
        jTextFieldQtdMudas.setText("");
        jDateChooserCadastro.setDate(null);
        jDateChooserAdmissao.setDate(null);
        jDateChooserDemissao.setDate(null);
        jDateChooserNascimento.setDate(null);

        jComboBoxCargos.setSelectedItem("Selecione");
        jTextFieldTelefone.setText("");
        jTextFieldCpf.setText("");
        jTextFieldApelido.setText("");
        jComboBoxStatus.setSelectedItem("Selecione");

    }

    public void validaCampos() {

        if (jComboBoxSexo.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Informe o sexo do funcionário.");
            flag2 = 9;

        } else if (jComboBoxCargos.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Informe o cargo do funcionário.");
            flag2 = 9;

        } else if (jComboBoxEmpresas.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Informe a empresa do funcionário.");
            flag2 = 9;

        } else if (jComboBoxDepartamentos.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Informe o setor do funcionário.");
            flag2 = 9;

        } else if (jComboBoxTamanhos.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Informe o tamanho do uniforme do funcionário.");
            flag2 = 9;

        } else if (jComboBoxStatus.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Informe o Status do funcionário.");
            flag2 = 9;

        } else if (jTextFieldNumero.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe o numero do funcionário.");
            flag2 = 9;
        } else if (jTextFieldNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe o nome do funcionário.");
            flag2 = 9;
        } else if (jTextFieldQtdMudas.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe o quantidade de mudas de uniformes que o funcionário pode ter.");
            flag2 = 9;
        } else if (Integer.parseInt(jTextFieldQtdMudas.getText()) > 5) {
            JOptionPane.showMessageDialog(null, "Permitido máximo 5 uniformes.");
            flag2 = 9;
        } else if (jDateChooserNascimento.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Informe a data de nascimento.");
            flag2 = 9;
        } else if (jDateChooserCadastro.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Informe a data do cadastro.");
            flag2 = 9;
        } else if (jDateChooserAdmissao.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Informe a data de admissao.");
            flag2 = 9;
        }
    }

    public Boolean habilitaCampos(boolean tf) {
        jTextFieldNumero.setEnabled(tf);
        jTextFieldNome.setEnabled(tf);
        jComboBoxSexo.setEnabled(tf);
        jComboBoxEmpresas.setEnabled(tf);
        jComboBoxDepartamentos.setEnabled(tf);
        jComboBoxTamanhos.setEnabled(tf);
        jTextFieldObs.setEnabled(tf);
        jTextFieldQtdMudas.setEnabled(tf);
        jDateChooserCadastro.setEnabled(tf);
        jDateChooserAdmissao.setEnabled(tf);
        //jDateChooserDemissao.setEnabled(tf);
        jComboBoxCargos.setEnabled(tf);
        jTextFieldTelefone.setEnabled(tf);
        jTextFieldCpf.setEnabled(tf);
        jTextFieldApelido.setEnabled(tf);
        jComboBoxStatus.setEnabled(tf);

        return tf;
    }

    public void buscanumeroinativo() {
    conecta.getConexaoSql();
    conecta.executaSql("select fun_num from funcionarios where fun_num > 9000 order by fun_num");

    try {
        if (conecta.rs.next()) { // verifica se existe pelo menos um registro
            int funnum = conecta.rs.getInt("fun_num");

            while (conecta.rs.next()) {
                int proximo = conecta.rs.getInt("fun_num");

                if (proximo != funnum + 1) {
                    break;
                }
                funnum = proximo;
            }

            jLabelNumInativo.setText(String.valueOf(funnum + 1));
        } else {
            // caso não exista nenhum número acima de 9000
            jLabelNumInativo.setText("9001");
        }

    } catch (SQLException ex) {
        Logger.getLogger(TelaCadFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
    }

    conecta.FecharConexao();
}


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
            java.util.logging.Logger.getLogger(TelaCadFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadFuncionarios().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxCargos;
    private javax.swing.JComboBox<String> jComboBoxDepartamentos;
    private javax.swing.JComboBox<String> jComboBoxEmpresas;
    public javax.swing.JComboBox<String> jComboBoxSexo;
    public javax.swing.JComboBox<String> jComboBoxStatus;
    private javax.swing.JComboBox<String> jComboBoxTamanhos;
    public com.toedter.calendar.JDateChooser jDateChooserAdmissao;
    private com.toedter.calendar.JDateChooser jDateChooserCadastro;
    private com.toedter.calendar.JDateChooser jDateChooserDemissao;
    public com.toedter.calendar.JDateChooser jDateChooserNascimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNumInativo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFuncionarios;
    private javax.swing.JTextField jTextFieldApelido;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldObs;
    private javax.swing.JTextField jTextFieldQtdMudas;
    private javax.swing.JTextField jTextFieldTelefone;
    // End of variables declaration//GEN-END:variables

    void preencherCampos(String nome, String setor, String cargo, String cpf, String telefone) {
        
    }

    
}
