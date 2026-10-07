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

public class TelaMovimentaEstoque extends javax.swing.JFrame {

    ConexaoSql conexao = new ConexaoSql();
    ModeloPreencheComboBox modelop = new ModeloPreencheComboBox();
    ModeloPreencheComboBox modpreenche = new ModeloPreencheComboBox();
    ControleMovimentaEstoque controle = new ControleMovimentaEstoque();
    SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
    int flag = 1;

    public TelaMovimentaEstoque() {
        initComponents();
        
        HashSet conj; 
        conj = new HashSet(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0)); 
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj); 
        
        Calendar dataatual = Calendar.getInstance();
        dataatual.add(Calendar.DAY_OF_MONTH, -20);
        SimpleDateFormat data = new SimpleDateFormat("yyyy/MM/dd");
        String data2 = data.format(dataatual.getTime());
        
        
        preencherTabelaMovimentacao("select m.mov_cod, m.mov_data, u.uni_descricao, t.tam_sigla, e.emp_razao, d.dep_descricao, c.car_descricao, m.mov_entrada, m.mov_saida, m.mov_historico, m.mov_lan_cod from movimenta_estoque as m left join uniformes as u on m.mov_uni_cod = u.uni_cod left join tamanhos as t on m.mov_tam_cod = t.tam_cod left join empresas as e on m.mov_emp_cod = e.emp_cod left join departamentos as d on m.mov_dep_cod = d.dep_cod left join cargos as c on m.mov_car_cod = c.car_cod where mov_data >='"+data2+"'  order by mov_cod desc");
        jComboBoxUniformes.removeAllItems();
        jComboBoxTamanhos.removeAllItems();
        jComboBoxEmpresas.removeAllItems();
        jComboBoxDepartamentos.removeAllItems();
        jComboBoxCargos.removeAllItems();
        jDateChooserData.setDate(new Date());

        for (Object u : modelop.preencheUniformes()) {
            jComboBoxUniformes.addItem((String) u);
        }

        for (Object t : modelop.preencheTamamhos()) {
            jComboBoxTamanhos.addItem((String) t);
        }

        for (Object e : modelop.preencheEmpresas()) {
            jComboBoxEmpresas.addItem((String) e);
        }

        for (Object d : modelop.preencheDepartamentos()) {
            jComboBoxDepartamentos.addItem((String) d);
        }

        for (Object c : modelop.preencheCargos()) {
            jComboBoxCargos.addItem((String) c);
        }

        flag = 2;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxUniformes = new javax.swing.JComboBox<>();
        jComboBoxTamanhos = new javax.swing.JComboBox<>();
        jTextFieldEntradas = new javax.swing.JTextField();
        jTextFieldSaidas = new javax.swing.JTextField();
        jTextFieldEstoqueAtual = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField1Estoque = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jToggleButtonEntrada = new javax.swing.JToggleButton();
        jToggleButtonSaida = new javax.swing.JToggleButton();
        jButtonEstoque = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldHistorico = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldIdLan = new javax.swing.JTextField();
        jComboBoxEmpresas = new javax.swing.JComboBox<>();
        jComboBoxDepartamentos = new javax.swing.JComboBox<>();
        jComboBoxCargos = new javax.swing.JComboBox<>();
        jDateChooserData = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMovimentaEstoque = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimentação de Estoque");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setToolTipText("");

        jLabel4.setText("Uniforme");

        jLabel5.setText("Tamanho");

        jComboBoxUniformes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxUniformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUniformesActionPerformed(evt);
            }
        });

        jComboBoxTamanhos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTamanhos.setEnabled(false);
        jComboBoxTamanhos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTamanhosActionPerformed(evt);
            }
        });

        jTextFieldEntradas.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldEntradas.setForeground(new java.awt.Color(0, 102, 51));
        jTextFieldEntradas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldEntradas.setEnabled(false);
        jTextFieldEntradas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldEntradasFocusLost(evt);
            }
        });
        jTextFieldEntradas.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextFieldEntradasInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jTextFieldEntradas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldEntradasKeyPressed(evt);
            }
        });

        jTextFieldSaidas.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldSaidas.setForeground(new java.awt.Color(204, 51, 0));
        jTextFieldSaidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSaidas.setEnabled(false);
        jTextFieldSaidas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSaidasFocusLost(evt);
            }
        });

        jTextFieldEstoqueAtual.setEditable(false);
        jTextFieldEstoqueAtual.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldEstoqueAtual.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldEstoqueAtual.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel13.setText("Novo Estoque");

        jTextField1Estoque.setEditable(false);
        jTextField1Estoque.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1Estoque.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField1Estoque.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1Estoque.setText("0");

        jLabel14.setText("Estoque Atual");

        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Salvar 32px.png"))); // NOI18N
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jToggleButtonEntrada.setText("Entrada");
        jToggleButtonEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonEntradaActionPerformed(evt);
            }
        });

        jToggleButtonSaida.setText("Saída");
        jToggleButtonSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonSaidaActionPerformed(evt);
            }
        });

        jButtonEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Estoque 32px.png"))); // NOI18N
        jButtonEstoque.setText("Ver Estoque");
        jButtonEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstoqueActionPerformed(evt);
            }
        });

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
                        .addComponent(jComboBoxUniformes, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxTamanhos, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 138, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1Estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldEntradas, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(jToggleButtonEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldSaidas, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(jToggleButtonSaida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldEstoqueAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxUniformes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxTamanhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldEstoqueAtual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jToggleButtonEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jToggleButtonSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13))
                                        .addGap(6, 6, 6)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1Estoque)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldSaidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonEstoque)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setToolTipText("");

        jLabel3.setText("ID");

        jTextFieldCodigo.setEnabled(false);

        jLabel6.setText("Data");

        jLabel7.setText("Empresa");

        jLabel8.setText("Setor");

        jLabel9.setText("Função");

        jLabel10.setText("Historico do Lançamento");

        jLabel11.setText("ID Lan");

        jTextFieldIdLan.setEnabled(false);

        jComboBoxEmpresas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxDepartamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxCargos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jDateChooserData.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBoxDepartamentos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCargos, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooserData, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextFieldHistorico))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldIdLan, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(104, 104, 104))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooserData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldIdLan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jTextFieldHistorico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxCargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 20, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );

        setSize(new java.awt.Dimension(799, 593));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldEntradasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEntradasKeyPressed

    }//GEN-LAST:event_jTextFieldEntradasKeyPressed

    private void jTextFieldEntradasInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextFieldEntradasInputMethodTextChanged

    }//GEN-LAST:event_jTextFieldEntradasInputMethodTextChanged

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (ValidaAcessos.valida(4)==2) {return;}
        ModeloMovimentaEstoque modestoque = new ModeloMovimentaEstoque();

        if (jComboBoxUniformes.getSelectedItem().equals("Selecione.") || jComboBoxTamanhos.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Uniforme e tamanho são campos de preenchimento obrigatório.");
            return;
        } else if (jTextFieldEstoqueAtual.getText().equals("") || (jTextFieldEntradas.getText().equals("0") && jTextFieldSaidas.getText().equals("0")) ){
            JOptionPane.showMessageDialog(null, "Informe as quanitdades de entradas e ou saídas antes de salvar.");
            return;
        }

        String unif = modpreenche.buscaCodigoUniformes((String) jComboBoxUniformes.getSelectedItem());
        String tam = modpreenche.buscaCodigoTamanhos((String) jComboBoxTamanhos.getSelectedItem());

        if (jComboBoxEmpresas.getSelectedItem() != "Selecione") {
            String emp = modpreenche.buscaCodigoempreas((String) jComboBoxEmpresas.getSelectedItem());
            modestoque.setEmpcod(Integer.parseInt(emp));
        }

        if (jComboBoxDepartamentos.getSelectedItem() != "Selecione") {
            String dep = modpreenche.buscaCodigoDepartamentos((String) jComboBoxDepartamentos.getSelectedItem());
            modestoque.setDepcod(Integer.parseInt(dep));
        }

        if (jComboBoxCargos.getSelectedItem() != "Selecione") {
            String car = modpreenche.buscaCodigoCargos((String) jComboBoxCargos.getSelectedItem());
            modestoque.setCarcod(Integer.parseInt(car));
        }

        modestoque.setCodigo(modpreenche.getIdestoque());
        modestoque.setData(jDateChooserData.getDate());
        modestoque.setUnicod(Integer.parseInt(unif));
        modestoque.setTamcod(Integer.parseInt(tam));
        modestoque.setEntrada(Integer.parseInt(jTextFieldEntradas.getText()));
        modestoque.setSaida(Integer.parseInt(jTextFieldSaidas.getText()));
        modestoque.setHistorico(jTextFieldHistorico.getText());
        modestoque.setSaldo(Integer.parseInt(jTextFieldEstoqueAtual.getText()));
        controle.salvar(modestoque);
        LimpaCampos();
        
        Calendar dataatual = Calendar.getInstance();
        dataatual.add(Calendar.DAY_OF_MONTH, -20);
        SimpleDateFormat data = new SimpleDateFormat("yyyy/MM/dd");
        String data2 = data.format(dataatual.getTime());
        preencherTabelaMovimentacao("select m.mov_cod, m.mov_data, u.uni_descricao, t.tam_sigla, e.emp_razao, d.dep_descricao, c.car_descricao, m.mov_entrada, m.mov_saida, m.mov_historico, m.mov_lan_cod from movimenta_estoque as m left join uniformes as u on m.mov_uni_cod = u.uni_cod left join tamanhos as t on m.mov_tam_cod = t.tam_cod left join empresas as e on m.mov_emp_cod = e.emp_cod left join departamentos as d on m.mov_dep_cod = d.dep_cod left join cargos as c on m.mov_car_cod = c.car_cod where mov_data >='"+data2+"'  order by mov_cod desc");
        //preencherTabelaMovimentacao("select m.mov_cod, m.mov_data, u.uni_descricao, t.tam_sigla, e.emp_razao, d.dep_descricao, c.car_descricao, m.mov_entrada, m.mov_saida, m.mov_historico, m.mov_lan_cod from movimenta_estoque as m left join uniformes as u on m.mov_uni_cod = u.uni_cod left join tamanhos as t on m.mov_tam_cod = t.tam_cod left join empresas as e on m.mov_emp_cod = e.emp_cod left join departamentos as d on m.mov_dep_cod = d.dep_cod left join cargos as c on m.mov_car_cod = c.car_cod order by mov_cod desc");

    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jToggleButtonEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonEntradaActionPerformed
        if (!jToggleButtonEntrada.isSelected()) {
            jToggleButtonSaida.setSelected(false);
            jTextFieldEntradas.setEnabled(false);
        } else {
            jToggleButtonSaida.setSelected(false);
            jTextFieldEntradas.setEnabled(true);
            jTextFieldSaidas.setEnabled(false);
        }
        jTextFieldEntradas.requestFocus();
    }//GEN-LAST:event_jToggleButtonEntradaActionPerformed

    private void jToggleButtonSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonSaidaActionPerformed
        if (!jToggleButtonSaida.isSelected()) {
            jToggleButtonEntrada.setSelected(false);
            jTextFieldSaidas.setEnabled(false);
        } else {
            jToggleButtonEntrada.setSelected(false);
            jTextFieldSaidas.setEnabled(true);
            jTextFieldEntradas.setEnabled(false);
        }
        jTextFieldSaidas.requestFocus();
    }//GEN-LAST:event_jToggleButtonSaidaActionPerformed

    private void jComboBoxUniformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUniformesActionPerformed
        if (flag != 1) {
            jComboBoxTamanhos.setEnabled(true);
            jComboBoxTamanhos.setSelectedItem("Selecione");
            jTextField1Estoque.setText("0");
        }
    }//GEN-LAST:event_jComboBoxUniformesActionPerformed

    private void jComboBoxTamanhosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTamanhosActionPerformed
        LimpaCampos();
        if (jComboBoxTamanhos.getSelectedItem() != "Selecione") {
            if (flag != 1) {
                String unif = modpreenche.buscaCodigoUniformes((String) jComboBoxUniformes.getSelectedItem());
                String tam = modpreenche.buscaCodigoTamanhos((String) jComboBoxTamanhos.getSelectedItem());
                modpreenche.setCoduniforme(Integer.parseInt(unif));
                modpreenche.setCodtam(Integer.parseInt(tam));
                controle.BuscaEstoque(modpreenche);
                if (modpreenche.getSaldo() == -1) {
                    LimpaCampos();
                    jComboBoxTamanhos.setSelectedItem("Selecione");
                } else {
                    jTextField1Estoque.setText(Integer.toString(modpreenche.getSaldo()));
                    jToggleButtonEntrada.setEnabled(true);
                    jToggleButtonSaida.setEnabled(true);
                }
            }
        } else {
            LimpaCampos();

        }
    }//GEN-LAST:event_jComboBoxTamanhosActionPerformed

    private void jTextFieldEntradasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEntradasFocusLost
            int resultado = Integer.parseInt(jTextField1Estoque.getText()) + Integer.parseInt(jTextFieldEntradas.getText()) - Integer.parseInt(jTextFieldSaidas.getText());
            jTextFieldEstoqueAtual.setText(Integer.toString(resultado));
    }//GEN-LAST:event_jTextFieldEntradasFocusLost

    private void jTextFieldSaidasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSaidasFocusLost
            int resultado = Integer.parseInt(jTextField1Estoque.getText()) + Integer.parseInt(jTextFieldEntradas.getText()) - Integer.parseInt(jTextFieldSaidas.getText());
            jTextFieldEstoqueAtual.setText(Integer.toString(resultado));
    }//GEN-LAST:event_jTextFieldSaidasFocusLost

    private void jButtonEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstoqueActionPerformed
        TelaEstoque telaestoque = new TelaEstoque();
        telaestoque.setVisible(true);
    }//GEN-LAST:event_jButtonEstoqueActionPerformed

    public void preencherTabelaMovimentacao(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Data", "Uniforme", "Tamanho", "Entradas", "Saídas", "Histórico", "Empresa", "Setor", "Cargo", "ID Lançto"};

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

                dados.add(new Object[]{conexao.rs.getInt("mov_cod"), data.format(conexao.rs.getDate("mov_data").getTime()), conexao.rs.getString("uni_descricao"), conexao.rs.getString("tam_sigla"), ent, sai, conexao.rs.getString("mov_historico"), conexao.rs.getString("emp_razao"), conexao.rs.getString("dep_descricao"), conexao.rs.getString("car_descricao"), conexao.rs.getInt("mov_lan_cod")});
            } while (conexao.rs.next());

            ModeloTabela modelotab = new ModeloTabela(dados, colunas);
            jTableMovimentaEstoque.setModel(modelotab);

            jTableMovimentaEstoque.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableMovimentaEstoque.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTableMovimentaEstoque.getColumnModel().getColumn(2).setPreferredWidth(220);
            jTableMovimentaEstoque.getColumnModel().getColumn(3).setPreferredWidth(40);
            jTableMovimentaEstoque.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTableMovimentaEstoque.getColumnModel().getColumn(5).setPreferredWidth(50);
            jTableMovimentaEstoque.getColumnModel().getColumn(6).setPreferredWidth(200);
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

    public void LimpaCampos() {
        jToggleButtonEntrada.setSelected(false);
        jToggleButtonSaida.setSelected(false);
        jToggleButtonEntrada.setEnabled(false);
        jToggleButtonSaida.setEnabled(false);
        jTextFieldEntradas.setEnabled(false);
        jTextFieldSaidas.setEnabled(false);
        jTextField1Estoque.setText("0");
        jTextFieldEntradas.setText("0");
        jTextFieldSaidas.setText("0");
        jTextFieldEstoqueAtual.setText("");
        jTextFieldHistorico.setText("");
        //jComboBoxUniformes.setSelectedItem("Selecione");
        //jComboBoxTamanhos.setSelectedItem("Selecione");
        jComboBoxEmpresas.setSelectedItem("Selecione");
        jComboBoxDepartamentos.setSelectedItem("Selecione");
        jComboBoxCargos.setSelectedItem("Selecione");

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
            java.util.logging.Logger.getLogger(TelaMovimentaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMovimentaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMovimentaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMovimentaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMovimentaEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEstoque;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxCargos;
    private javax.swing.JComboBox<String> jComboBoxDepartamentos;
    private javax.swing.JComboBox<String> jComboBoxEmpresas;
    private javax.swing.JComboBox<String> jComboBoxTamanhos;
    private javax.swing.JComboBox<String> jComboBoxUniformes;
    private com.toedter.calendar.JDateChooser jDateChooserData;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMovimentaEstoque;
    private javax.swing.JTextField jTextField1Estoque;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldEntradas;
    private javax.swing.JTextField jTextFieldEstoqueAtual;
    private javax.swing.JTextField jTextFieldHistorico;
    private javax.swing.JTextField jTextFieldIdLan;
    private javax.swing.JTextField jTextFieldSaidas;
    private javax.swing.JToggleButton jToggleButtonEntrada;
    private javax.swing.JToggleButton jToggleButtonSaida;
    // End of variables declaration//GEN-END:variables
}
