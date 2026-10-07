/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Visao;

import br.com.ConexaoBancoDados.ConexaoSql;
import br.com.Controle.ControleFuncionario;
import br.com.Modelo.ModeloDatas;
import br.com.Modelo.ModeloFuncionario;
import br.com.Modelo.ModeloLancamento;
import br.com.Modelo.ModeloTabela;

import br.com.Relatorios.Descarte_de_Uniformes_Peso;
import br.com.Relatorios.Funcionarios_Por_Empresa;
import br.com.Relatorios.Funcionarios_Por_Setor;
import br.com.Relatorios.Funcionarios_Por_Tamanho;
import br.com.Relatorios.Letras_Por_Funcionarios;
import br.com.Relatorios.Ocorrencias_Por_Periodo;
import br.com.Relatorios.Relatorio_Produtos;
import br.com.Relatorios.Uniformes_Por_Tamanho;
import br.com.Relatorios.Uniformes_Tamanho_Setor;
import br.com.Utilitarios.Aniversariantes;
import br.com.Utilitarios.AtualizadorHorario;
import br.com.Utilitarios.BackUpSistema;
import br.com.Utilitarios.ValidaAcessos;
import br.com.Utilitarios.ValidaLicenca;
import java.awt.AWTKeyStroke;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import java.util.Date;
import java.util.HashSet;
import javax.swing.ListSelectionModel;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Lavanderia
 */
public class TelaPrincipal extends javax.swing.JFrame {
    
    ModeloFuncionario objmodfunc = new ModeloFuncionario();
    ControleFuncionario controlfunc = new ControleFuncionario();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    ModeloLancamento modelonovo = new ModeloLancamento();
    SimpleDateFormat dataformatada = new SimpleDateFormat("dd/MM/yyyy");
    ModeloDatas diasuso = new ModeloDatas();
    
    public static int recebefoco = 0;
    TelaEspera espera = new TelaEspera(this, rootPaneCheckingEnabled);
    ConexaoSql conexao = new ConexaoSql();
    TelaSerial serial = new TelaSerial(this, rootPaneCheckingEnabled);
    SimpleDateFormat fhora = new SimpleDateFormat("HH");
    
    
    

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        mostrarHora();
        
        HashSet conj;
        conj = new HashSet(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
        
        ConexaoSql conecta = new ConexaoSql();
        
        jLabelBancoDados.setText("Base de Dados Ativa : " + conecta.nomebanco);
        jLabelUsuario.setText("Usuário : " + TelaLogin.codusu + " - " + TelaLogin.nomeusu);
        jLabelNivel.setText("Nível de Acesso : " + TelaLogin.numnivelusu + " - " + TelaLogin.nivelusu);

        getRootPane().setGlassPane(new JComponent() {
            public void paintComponent(Graphics g) {
                g.setColor(new Color(0, 0, 0, 100));
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        });
        
        conexao.getConexaoSql();
        conexao.executaSql("select  count(fun_cod)  from funcionarios where fun_status = 'ATIVO'");
        conexao.executaSqlt("select  count(lan_cod)  from lancamentos where lan_sta_cod = 1");
        conexao.executaSqlu("select sum(est_quantidade) from estoque");
        
        try {
            conexao.rs.first();
            conexao.rs_t.first();
            conexao.rs_u.first();
            
            int totfunc = conexao.rs.getInt("count(fun_cod)");
            int totlan = conexao.rs_t.getInt("count(lan_cod)");
            int totest = conexao.rs_u.getInt("sum(est_quantidade)");
            
            jLabel2.setText("Funcionários (" + totfunc + ")");
            jLabel3.setText("Lançamentos (" + totlan + ")");
            jLabel7.setText("Estoque (" + totest + ")");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na totalização de funcionários. \n \n");
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

        jInternalFrameConsultaRapida = new javax.swing.JInternalFrame();
        jTextFieldNumero = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDados = new javax.swing.JTable();
        jButtonFecharBemVindo1 = new javax.swing.JButton();
        jInternalFrameBemVindo = new javax.swing.JInternalFrame();
        jPanelFundo = new javax.swing.JPanel();
        jButtonCadFuncionarios = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonMovimentaUniformes = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButtonConsulta = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButtonEstoque = new javax.swing.JButton();
        jButtonRecentes = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButtonTempoMedio = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButtonEspera = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButtonProdutos = new javax.swing.JButton();
        jLabelAlerta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelBancoDados = new javax.swing.JLabel();
        jLabelNivel = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelHorario = new javax.swing.JLabel();
        jLabelTempo = new javax.swing.JLabel();
        jButtonFecharBemVindo = new javax.swing.JButton();
        jLabelImagemFundojFrame = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuItemFuncionarios = new javax.swing.JMenuItem();
        jMenuItemUsuarios = new javax.swing.JMenuItem();
        jMenuUniformes = new javax.swing.JMenu();
        jMenuItemEstoque = new javax.swing.JMenuItem();
        jMenuItemMovimentacao = new javax.swing.JMenuItem();
        jMenuItemMovimentaEstoque = new javax.swing.JMenuItem();
        jMenumManutenção = new javax.swing.JMenu();
        jMenuItemConsulta = new javax.swing.JMenuItem();
        jMenuItemConsultaHistorico = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemPadrao = new javax.swing.JMenuItem();
        jMenuItemClaro = new javax.swing.JMenuItem();
        jMenuItemEscuro = new javax.swing.JMenuItem();
        jMenuItemPerfilAzul = new javax.swing.JMenuItem();
        jMenuItemVerde = new javax.swing.JMenuItem();
        jMenuItemRosa = new javax.swing.JMenuItem();
        jMenuItemPerfilVermelho = new javax.swing.JMenuItem();
        jMenuItemBemVindo = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuUtilitarios = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItemProdutos = new javax.swing.JMenuItem();
        jMenuItemNumerosLivres = new javax.swing.JMenuItem();
        jMenuItemOcorrencias = new javax.swing.JMenuItem();
        jMenuItemTrocaNumero = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItemAgendarTarefas = new javax.swing.JMenuItem();
        jMenuItemBack = new javax.swing.JMenuItem();
        jMenuRelatorios = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemFuncSetor = new javax.swing.JMenuItem();
        jMenuItemFuncEmpresa = new javax.swing.JMenuItem();
        jMenuItemTotalFuncionarios = new javax.swing.JMenuItem();
        jMenuArca = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemExtrato = new javax.swing.JMenuItem();
        jMenuItemDemonstrativo = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItemTempoMedio = new javax.swing.JMenuItem();
        jMenuItemRelatorioEstoque = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItemLetras = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuSegurança = new javax.swing.JMenu();
        jMenuItemBackup = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();
        jMenuItemSairDoSistema = new javax.swing.JMenuItem();
        jMenuItemEspera = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Controle de Uniformes - Cofril");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jInternalFrameConsultaRapida.setTitle("Consulta Rápida");
        jInternalFrameConsultaRapida.setVisible(true);
        jInternalFrameConsultaRapida.getContentPane().setLayout(null);

        jTextFieldNumero.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jTextFieldNumero.setForeground(new java.awt.Color(0, 0, 255));
        jTextFieldNumero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNumeroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNumeroFocusLost(evt);
            }
        });
        jTextFieldNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldNumeroKeyReleased(evt);
            }
        });
        jInternalFrameConsultaRapida.getContentPane().add(jTextFieldNumero);
        jTextFieldNumero.setBounds(10, 10, 50, 22);

        jLabelNome.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(0, 0, 255));
        jInternalFrameConsultaRapida.getContentPane().add(jLabelNome);
        jLabelNome.setBounds(70, 10, 650, 20);

        jTableDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableDados);

        jInternalFrameConsultaRapida.getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 740, 200);

        jButtonFecharBemVindo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Fechar - 32p.png"))); // NOI18N
        jButtonFecharBemVindo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharBemVindo1ActionPerformed(evt);
            }
        });
        jInternalFrameConsultaRapida.getContentPane().add(jButtonFecharBemVindo1);
        jButtonFecharBemVindo1.setBounds(730, 10, 20, 20);

        getContentPane().add(jInternalFrameConsultaRapida);
        jInternalFrameConsultaRapida.setBounds(240, 40, 770, 280);

        jInternalFrameBemVindo.setTitle("Bem-Vindo");
        jInternalFrameBemVindo.setVisible(true);
        jInternalFrameBemVindo.getContentPane().setLayout(null);

        jPanelFundo.setBackground(new java.awt.Color(204, 255, 255));
        jPanelFundo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelFundo.setLayout(null);

        jButtonCadFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/pessoa 96px.png"))); // NOI18N
        jButtonCadFuncionarios.setToolTipText("Cadastro de Funcionários");
        jButtonCadFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadFuncionariosActionPerformed(evt);
            }
        });
        jPanelFundo.add(jButtonCadFuncionarios);
        jButtonCadFuncionarios.setBounds(140, 30, 110, 110);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText(" Funcionários");
        jPanelFundo.add(jLabel2);
        jLabel2.setBounds(140, 10, 110, 14);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText(" Uniformes");
        jPanelFundo.add(jLabel3);
        jLabel3.setBounds(10, 10, 120, 14);

        jButtonMovimentaUniformes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Blusa Azul 92px.png"))); // NOI18N
        jButtonMovimentaUniformes.setToolTipText("Cadastro de Funcionários");
        jButtonMovimentaUniformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMovimentaUniformesActionPerformed(evt);
            }
        });
        jPanelFundo.add(jButtonMovimentaUniformes);
        jButtonMovimentaUniformes.setBounds(10, 30, 110, 110);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Consultar");
        jPanelFundo.add(jLabel4);
        jLabel4.setBounds(270, 10, 110, 14);

        jButtonConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Lupa 92px.png"))); // NOI18N
        jButtonConsulta.setToolTipText("Cadastro de Funcionários");
        jButtonConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultaActionPerformed(evt);
            }
        });
        jPanelFundo.add(jButtonConsulta);
        jButtonConsulta.setBounds(270, 30, 110, 110);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Tempo Médio");
        jPanelFundo.add(jLabel5);
        jLabel5.setBounds(660, 10, 90, 14);

        jButtonEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Empilhadeira 96px.png"))); // NOI18N
        jButtonEstoque.setToolTipText("Cadastro de Funcionários");
        jButtonEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstoqueActionPerformed(evt);
            }
        });
        jPanelFundo.add(jButtonEstoque);
        jButtonEstoque.setBounds(400, 30, 110, 110);

        jButtonRecentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Recente96px.png"))); // NOI18N
        jButtonRecentes.setToolTipText("Cadastro de Funcionários");
        jButtonRecentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRecentesActionPerformed(evt);
            }
        });
        jPanelFundo.add(jButtonRecentes);
        jButtonRecentes.setBounds(530, 30, 110, 110);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText(" Estoque");
        jPanelFundo.add(jLabel7);
        jLabel7.setBounds(400, 10, 110, 14);

        jButtonTempoMedio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Tempo96px.png"))); // NOI18N
        jButtonTempoMedio.setToolTipText("Cadastro de Funcionários");
        jButtonTempoMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTempoMedioActionPerformed(evt);
            }
        });
        jPanelFundo.add(jButtonTempoMedio);
        jButtonTempoMedio.setBounds(660, 30, 110, 110);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Recentes");
        jPanelFundo.add(jLabel8);
        jLabel8.setBounds(530, 10, 110, 14);

        jButtonEspera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Tomada 48px.png"))); // NOI18N
        jButtonEspera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEsperaActionPerformed(evt);
            }
        });
        jPanelFundo.add(jButtonEspera);
        jButtonEspera.setBounds(1070, 90, 50, 50);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Produtos");
        jPanelFundo.add(jLabel9);
        jLabel9.setBounds(790, 10, 90, 14);

        jButtonProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Produtos.png"))); // NOI18N
        jButtonProdutos.setToolTipText("Cadastro de Funcionários");
        jButtonProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProdutosActionPerformed(evt);
            }
        });
        jPanelFundo.add(jButtonProdutos);
        jButtonProdutos.setBounds(790, 30, 110, 110);
        jPanelFundo.add(jLabelAlerta);
        jLabelAlerta.setBounds(1060, 30, 0, 0);

        jInternalFrameBemVindo.getContentPane().add(jPanelFundo);
        jPanelFundo.setBounds(0, 100, 1130, 150);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("SISTEMA CONTROLE DE UNIFORMES");
        jInternalFrameBemVindo.getContentPane().add(jLabel1);
        jLabel1.setBounds(340, 10, 450, 30);

        jLabelBancoDados.setText("jLabel6");
        jLabelBancoDados.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jInternalFrameBemVindo.getContentPane().add(jLabelBancoDados);
        jLabelBancoDados.setBounds(10, 80, 240, 16);

        jLabelNivel.setText("jLabel6");
        jLabelNivel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jInternalFrameBemVindo.getContentPane().add(jLabelNivel);
        jLabelNivel.setBounds(10, 60, 240, 16);

        jLabelUsuario.setText("jLabel6");
        jLabelUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jInternalFrameBemVindo.getContentPane().add(jLabelUsuario);
        jLabelUsuario.setBounds(10, 40, 240, 16);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Versão 1.0 - 01/07/2020");
        jInternalFrameBemVindo.getContentPane().add(jLabel6);
        jLabel6.setBounds(980, 40, 140, 16);

        jLabelHorario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelHorario.setText("Data Hora");
        jInternalFrameBemVindo.getContentPane().add(jLabelHorario);
        jLabelHorario.setBounds(790, 60, 330, 20);

        jLabelTempo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jInternalFrameBemVindo.getContentPane().add(jLabelTempo);
        jLabelTempo.setBounds(830, 80, 290, 20);

        jButtonFecharBemVindo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/Fechar - 32p.png"))); // NOI18N
        jButtonFecharBemVindo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharBemVindoActionPerformed(evt);
            }
        });
        jInternalFrameBemVindo.getContentPane().add(jButtonFecharBemVindo);
        jButtonFecharBemVindo.setBounds(1100, 10, 20, 20);

        getContentPane().add(jInternalFrameBemVindo);
        jInternalFrameBemVindo.setBounds(0, 331, 1140, 280);

        jLabelImagemFundojFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Imagens/cofril.png"))); // NOI18N
        jLabelImagemFundojFrame.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabelImagemFundojFrameMouseMoved(evt);
            }
        });
        getContentPane().add(jLabelImagemFundojFrame);
        jLabelImagemFundojFrame.setBounds(0, 0, 1160, 620);

        jMenuCadastro.setText("Cadastro");

        jMenuItemFuncionarios.setText("Funcionários");
        jMenuItemFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFuncionariosActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemFuncionarios);

        jMenuItemUsuarios.setText("Usuários");
        jMenuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuariosActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemUsuarios);

        jMenuBar1.add(jMenuCadastro);

        jMenuUniformes.setText("Uniformes");

        jMenuItemEstoque.setText("Estoque");
        jMenuItemEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEstoqueActionPerformed(evt);
            }
        });
        jMenuUniformes.add(jMenuItemEstoque);

        jMenuItemMovimentacao.setText("Movimentação de Uniformes");
        jMenuItemMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMovimentacaoActionPerformed(evt);
            }
        });
        jMenuUniformes.add(jMenuItemMovimentacao);

        jMenuItemMovimentaEstoque.setText("Movimentação de  Estoque");
        jMenuItemMovimentaEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMovimentaEstoqueActionPerformed(evt);
            }
        });
        jMenuUniformes.add(jMenuItemMovimentaEstoque);

        jMenuBar1.add(jMenuUniformes);

        jMenumManutenção.setText("Consultas");

        jMenuItemConsulta.setText("Consulta Lançamentos");
        jMenuItemConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaActionPerformed(evt);
            }
        });
        jMenumManutenção.add(jMenuItemConsulta);

        jMenuItemConsultaHistorico.setText("Consulta Histórico");
        jMenuItemConsultaHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaHistoricoActionPerformed(evt);
            }
        });
        jMenumManutenção.add(jMenuItemConsultaHistorico);

        jMenuItem3.setText("Consulta Funcionário por ID");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenumManutenção.add(jMenuItem3);

        jMenuItem4.setText("Consulta Movimentação de Estoque");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenumManutenção.add(jMenuItem4);

        jMenuBar1.add(jMenumManutenção);

        jMenu1.setText("Exibir");

        jMenu2.setText("Movimentação de Uniformes");

        jMenuItemPadrao.setText("Perfil Padrão");
        jMenuItemPadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPadraoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemPadrao);

        jMenuItemClaro.setText("Perfil Claro");
        jMenuItemClaro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClaroActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemClaro);

        jMenuItemEscuro.setText("Perfil Escuro");
        jMenuItemEscuro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEscuroActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemEscuro);

        jMenuItemPerfilAzul.setText("Perfil Azul");
        jMenuItemPerfilAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPerfilAzulActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemPerfilAzul);

        jMenuItemVerde.setText("Perfil Verde");
        jMenuItemVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerdeActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemVerde);

        jMenuItemRosa.setText("Perfil Rosa");
        jMenuItemRosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRosaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemRosa);

        jMenuItemPerfilVermelho.setText("Perfil Vermelho");
        jMenuItemPerfilVermelho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPerfilVermelhoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemPerfilVermelho);

        jMenu1.add(jMenu2);

        jMenuItemBemVindo.setText("Tela Bem-Vindo");
        jMenuItemBemVindo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBemVindoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemBemVindo);

        jMenuItem10.setText("Consulta Rápida");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuBar1.add(jMenu1);

        jMenuUtilitarios.setText("Utilitários");

        jMenuItem1.setText("Conferência Matriz - CM");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuUtilitarios.add(jMenuItem1);

        jMenuItemProdutos.setText("Controle de Produtos");
        jMenuItemProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProdutosActionPerformed(evt);
            }
        });
        jMenuUtilitarios.add(jMenuItemProdutos);

        jMenuItemNumerosLivres.setText("Números Disponíveis");
        jMenuItemNumerosLivres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNumerosLivresActionPerformed(evt);
            }
        });
        jMenuUtilitarios.add(jMenuItemNumerosLivres);

        jMenuItemOcorrencias.setText("Ocorrências de Funcionários");
        jMenuItemOcorrencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOcorrenciasActionPerformed(evt);
            }
        });
        jMenuUtilitarios.add(jMenuItemOcorrencias);

        jMenuItemTrocaNumero.setText("Transferência de Uniformes");
        jMenuItemTrocaNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTrocaNumeroActionPerformed(evt);
            }
        });
        jMenuUtilitarios.add(jMenuItemTrocaNumero);

        jMenuItem7.setText("Conferência Detalhada");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenuUtilitarios.add(jMenuItem7);

        jMenuItem8.setText("Aniversariantes do Dia");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenuUtilitarios.add(jMenuItem8);

        jMenuItemAgendarTarefas.setText("Agendamento de Tarefas");
        jMenuItemAgendarTarefas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgendarTarefasActionPerformed(evt);
            }
        });
        jMenuUtilitarios.add(jMenuItemAgendarTarefas);

        jMenuItemBack.setText("Backup Base de Dados");
        jMenuItemBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBackActionPerformed(evt);
            }
        });
        jMenuUtilitarios.add(jMenuItemBack);

        jMenuBar1.add(jMenuUtilitarios);

        jMenuRelatorios.setText("Relatórios");

        jMenu3.setText("Funcionários");

        jMenuItemFuncSetor.setText("Funcionários por Setor");
        jMenuItemFuncSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFuncSetorActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemFuncSetor);

        jMenuItemFuncEmpresa.setText("Funcionários por Empresa");
        jMenuItemFuncEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFuncEmpresaActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemFuncEmpresa);

        jMenuItemTotalFuncionarios.setText("Total de Funcionários por Setor");
        jMenuItemTotalFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTotalFuncionariosActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemTotalFuncionarios);

        jMenuArca.setText("Relat. Func. por Tamanhos (Arca)");
        jMenuArca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArcaActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuArca);

        jMenuRelatorios.add(jMenu3);

        jMenu4.setText("Uniformes");

        jMenuItemExtrato.setText("Extrato de Uniformes");
        jMenuItemExtrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExtratoActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemExtrato);

        jMenuItemDemonstrativo.setText("Demonstrativo de Uniformes por Data");
        jMenuItemDemonstrativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDemonstrativoActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemDemonstrativo);

        jMenuItem6.setText("Descarte de Uniformes (Qtd e Peso)");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem5.setText("Relat. Uniformes [Tamanhos por Setor]");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuRelatorios.add(jMenu4);

        jMenuItemTempoMedio.setText("Tempo Médio de Uso");
        jMenuItemTempoMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTempoMedioActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jMenuItemTempoMedio);

        jMenuItemRelatorioEstoque.setText("Relatório de Estoque");
        jMenuItemRelatorioEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatorioEstoqueActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jMenuItemRelatorioEstoque);

        jMenuItem2.setText("Relat. Ocorrência Func. por Período");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jMenuItem2);

        jMenuItemLetras.setText("Letras por Funcionários");
        jMenuItemLetras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLetrasActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jMenuItemLetras);

        jMenuItem9.setText("Relatório de Produtos");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jMenuItem9);

        jMenuItem11.setText("Relatório Demitidos RH");
        jMenuItem11.setToolTipText("Gere antes Relatório de Funcionários no Sistema de RH.");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jMenuItem11);

        jMenuBar1.add(jMenuRelatorios);

        jMenuSegurança.setText("Segurança");

        jMenuItemBackup.setText("Backup Banco de Dados do Sistema");
        jMenuItemBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBackupActionPerformed(evt);
            }
        });
        jMenuSegurança.add(jMenuItemBackup);

        jMenuBar1.add(jMenuSegurança);

        jMenuSair.setText("Sair");

        jMenuItemSairDoSistema.setText("Sair do Sistema");
        jMenuItemSairDoSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairDoSistemaActionPerformed(evt);
            }
        });
        jMenuSair.add(jMenuItemSairDoSistema);

        jMenuItemEspera.setText("Modo Espera");
        jMenuItemEspera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEsperaActionPerformed(evt);
            }
        });
        jMenuSair.add(jMenuItemEspera);

        jMenuBar1.add(jMenuSair);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1157, 671));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemSairDoSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairDoSistemaActionPerformed
        System.exit(0);

    }//GEN-LAST:event_jMenuItemSairDoSistemaActionPerformed

    private void jMenuItemBemVindoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBemVindoActionPerformed

        jInternalFrameBemVindo.setVisible(true);
    }//GEN-LAST:event_jMenuItemBemVindoActionPerformed

    private void jButtonFecharBemVindoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharBemVindoActionPerformed

        jInternalFrameBemVindo.dispose();

    }//GEN-LAST:event_jButtonFecharBemVindoActionPerformed

    private void jButtonCadFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadFuncionariosActionPerformed
        TelaCadFuncionarios telacad = new TelaCadFuncionarios();
        telacad.setVisible(true);

    }//GEN-LAST:event_jButtonCadFuncionariosActionPerformed

    private void jMenuItemMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMovimentacaoActionPerformed
        TelaLancamentos telalan = new TelaLancamentos();
        telalan.setVisible(true);
    }//GEN-LAST:event_jMenuItemMovimentacaoActionPerformed

    private void jMenuItemFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFuncionariosActionPerformed
        TelaCadFuncionarios telacad = new TelaCadFuncionarios();
        telacad.setVisible(true);
    }//GEN-LAST:event_jMenuItemFuncionariosActionPerformed

    private void jMenuItemEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEstoqueActionPerformed
        TelaEstoque telaestoque = new TelaEstoque();
        telaestoque.setVisible(true);
    }//GEN-LAST:event_jMenuItemEstoqueActionPerformed

    private void jMenuItemMovimentaEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMovimentaEstoqueActionPerformed
        TelaMovimentaEstoque telamov = new TelaMovimentaEstoque();
        telamov.setVisible(true);
    }//GEN-LAST:event_jMenuItemMovimentaEstoqueActionPerformed

    private void jMenuItemNumerosLivresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNumerosLivresActionPerformed
        TelaNumeroDisponivel telanovo = new TelaNumeroDisponivel();
        telanovo.setVisible(true);
    }//GEN-LAST:event_jMenuItemNumerosLivresActionPerformed

    private void jMenuItemConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaActionPerformed
        TelaConsulta telaconsulta = new TelaConsulta();
        telaconsulta.setVisible(true);
        telaconsulta.setTitle("Consulta de Lançamentos.");
        telaconsulta.ConusltaXManut();

    }//GEN-LAST:event_jMenuItemConsultaActionPerformed

    private void jMenuItemTrocaNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTrocaNumeroActionPerformed
        TelaConsulta telaconsulta = new TelaConsulta();
        telaconsulta.setVisible(true);
        telaconsulta.setTitle("Manutenção de Lançamentos.");


    }//GEN-LAST:event_jMenuItemTrocaNumeroActionPerformed

    private void jButtonMovimentaUniformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMovimentaUniformesActionPerformed
        TelaLancamentos lanca = new TelaLancamentos();
        lanca.setVisible(true);
    }//GEN-LAST:event_jButtonMovimentaUniformesActionPerformed

    private void jButtonConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultaActionPerformed
        jMenuItemConsultaActionPerformed(evt);
    }//GEN-LAST:event_jButtonConsultaActionPerformed

    private void jButtonEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstoqueActionPerformed
        TelaEstoque estoque = new TelaEstoque();
        estoque.setVisible(true);
    }//GEN-LAST:event_jButtonEstoqueActionPerformed

    private void jButtonRecentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRecentesActionPerformed
        TelaRecentesNova rec = new TelaRecentesNova();
        rec.setVisible(true);
    }//GEN-LAST:event_jButtonRecentesActionPerformed

    private void jMenuItemTempoMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTempoMedioActionPerformed
        TelaTempoMedio tmedio = new TelaTempoMedio();
        tmedio.setVisible(true);
    }//GEN-LAST:event_jMenuItemTempoMedioActionPerformed

    private void jButtonTempoMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTempoMedioActionPerformed
        TelaTempoMedio tmedio = new TelaTempoMedio();
        tmedio.setVisible(true);
    }//GEN-LAST:event_jButtonTempoMedioActionPerformed

    private void jMenuItemDemonstrativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDemonstrativoActionPerformed
        Uniformes_Por_Tamanho relat_uniformes = new Uniformes_Por_Tamanho();
        relat_uniformes.setVisible(true);
    }//GEN-LAST:event_jMenuItemDemonstrativoActionPerformed

    private void jMenuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuariosActionPerformed
        if (ValidaAcessos.valida(4) == 2) {
            return;
        }
        TelaSenha cadusuarios = new TelaSenha();
        cadusuarios.setVisible(true);
    }//GEN-LAST:event_jMenuItemUsuariosActionPerformed

    private void jMenuItemEsperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEsperaActionPerformed
        getRootPane().getGlassPane().setVisible(true);
        espera.setVisible(true);
    }//GEN-LAST:event_jMenuItemEsperaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if (recebefoco == 1) {
            recebefoco = 0;
            jLabelUsuario.setText("Usuário : " + TelaLogin.codusu + " - " + TelaLogin.nomeusu);
            jLabelNivel.setText("Nível de Acesso : " + TelaLogin.numnivelusu + " - " + TelaLogin.nivelusu);
            getRootPane().getGlassPane().setVisible(false);
            
        }
        
    }//GEN-LAST:event_formWindowGainedFocus

    private void jButtonEsperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEsperaActionPerformed
        getRootPane().getGlassPane().setVisible(true);
        TelaLogin.usuflag = 1;  // flag para evitar que tempo corre quando uma tela de espera já estiver aberta e não abrir outra
        espera.setVisible(true);
    }//GEN-LAST:event_jButtonEsperaActionPerformed

    private void jMenuItemFuncSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFuncSetorActionPerformed
        Funcionarios_Por_Setor funcsetor = new Funcionarios_Por_Setor();
        funcsetor.setVisible(true);
    }//GEN-LAST:event_jMenuItemFuncSetorActionPerformed

    private void jMenuItemFuncEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFuncEmpresaActionPerformed
        Funcionarios_Por_Empresa funcemp = new Funcionarios_Por_Empresa();
        funcemp.setVisible(true);
    }//GEN-LAST:event_jMenuItemFuncEmpresaActionPerformed

    private void jMenuItemExtratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExtratoActionPerformed
        try {
            int numero;
            int id_func;
            String number;

            number = JOptionPane.showInputDialog("Informe o Número do Funcionário");
            numero = Integer.parseInt(number);

            conexao.getConexaoSql();
            conexao.executaSql("select func.fun_cod, func.fun_nome, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, func.fun_admissao from lancamentos as l  inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod  inner join funcionarios as func on l.lan_fun_num = func.fun_num where l.lan_fun_num = '" + numero + "'  and l.lan_data_entrega >= func.fun_admissao order by lan_letra, lan_uni_cod, lan_data_entrega");
            
            conexao.rs.first();
            id_func = conexao.rs.getInt("func.fun_cod");
            System.out.println(id_func);
            
            conexao.executaSqlu("select func.fun_cod, func.fun_nome, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, func.fun_admissao from lancamentos as l  inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod  inner join funcionarios as func on l.lan_fun_num = func.fun_num where l.lan_fun_cod = '" + id_func + "'  order by lan_letra, lan_uni_cod, lan_data_entrega");
            
            JRResultSetDataSource relatresult = new JRResultSetDataSource(conexao.rs_u);
            

            String reportPath = "C:/Users/Lavanderia/Documents/MyReports/Extrato_do_Funcionario.jasper";
            //'JasperReport jr = JasperCompileManager.compileReport(reportPath);
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reportPath);
            
            HashMap map = new HashMap();
            map.put("numero", numero);

            JasperPrint jp = JasperFillManager.fillReport(jr, map, relatresult);

            JasperViewer.viewReport(jp, false);
            conexao.FecharConexao();

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }//GEN-LAST:event_jMenuItemExtratoActionPerformed

    private void jMenuItemOcorrenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOcorrenciasActionPerformed
        TelaOcorrencias ocorre = new TelaOcorrencias();
        ocorre.setVisible(true);
    }//GEN-LAST:event_jMenuItemOcorrenciasActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        TelaConferênciaMatriz conf = new TelaConferênciaMatriz();
        conf.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItemClaroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClaroActionPerformed
        conexao.getConexaoSql();
        try {

            PreparedStatement pst = conexao.connection.prepareStatement("update usuarios set usu_perfil=? where usu_cod=?");
            pst.setString(1, "CLARO");
            pst.setInt(2, TelaLogin.usuariocod);
            pst.execute();
            TelaLogin.usuperfil = "CLARO";

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na gravação do perfil de cores \n \n" + ex);
        }
        conexao.FecharConexao();
        TelaLancamentos telalan = new TelaLancamentos();
        telalan.setVisible(true);
    }//GEN-LAST:event_jMenuItemClaroActionPerformed

    private void jMenuItemEscuroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEscuroActionPerformed
        conexao.getConexaoSql();
        try {

            PreparedStatement pst = conexao.connection.prepareStatement("update usuarios set usu_perfil=? where usu_cod=?");
            pst.setString(1, "ESCURO");
            pst.setInt(2, TelaLogin.usuariocod);
            pst.execute();
            TelaLogin.usuperfil = "ESCURO";

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na gravação do perfil de cores \n \n" + ex);
        }
        conexao.FecharConexao();
        TelaLancamentos telalan = new TelaLancamentos();
        telalan.setVisible(true);
    }//GEN-LAST:event_jMenuItemEscuroActionPerformed

    private void jMenuItemVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerdeActionPerformed
        conexao.getConexaoSql();
        try {

            PreparedStatement pst = conexao.connection.prepareStatement("update usuarios set usu_perfil=? where usu_cod=?");
            pst.setString(1, "VERDE");
            pst.setInt(2, TelaLogin.usuariocod);
            pst.execute();
            TelaLogin.usuperfil = "VERDE";

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na gravação do perfil de cores \n \n" + ex);
        }
        conexao.FecharConexao();
        TelaLancamentos telalan = new TelaLancamentos();
        telalan.setVisible(true);
    }//GEN-LAST:event_jMenuItemVerdeActionPerformed

    private void jMenuItemRosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRosaActionPerformed
        conexao.getConexaoSql();
        try {

            PreparedStatement pst = conexao.connection.prepareStatement("update usuarios set usu_perfil=? where usu_cod=?");
            pst.setString(1, "ROSA");
            pst.setInt(2, TelaLogin.usuariocod);
            pst.execute();
            TelaLogin.usuperfil = "ROSA";

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na gravação do perfil de cores \n \n" + ex);
        }
        conexao.FecharConexao();
        TelaLancamentos telalan = new TelaLancamentos();
        telalan.setVisible(true);
    }//GEN-LAST:event_jMenuItemRosaActionPerformed

    private void jMenuItemRelatorioEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatorioEstoqueActionPerformed
        try {
            conexao.getConexaoSql();
            conexao.executaSql("select u.uni_descricao, t.tam_sigla, e.est_quantidade from estoque as e inner join uniformes as u on e.est_uni_cod = u.uni_cod inner join tamanhos as t on e.est_tam_cod = t.tam_cod order by u.uni_descricao, tam_ordem");

            JRResultSetDataSource relatresult = new JRResultSetDataSource(conexao.rs);

            String reportPath = "C:/Users/Lavanderia/Documents/MyReports/Relatorio_Estoque.jasper";
            //JasperReport jr = JasperCompileManager.compileReport(reportPath);
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reportPath);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, null, relatresult);

            JasperViewer.viewReport(jp, false);
            conexao.FecharConexao();

        } catch (Exception ex) {
            //ex.printStackTrace()
            JOptionPane.showMessageDialog(null, "Erro na impressão do relatório" + ex);

        }
    }//GEN-LAST:event_jMenuItemRelatorioEstoqueActionPerformed

    private void jMenuItemPadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPadraoActionPerformed
        conexao.getConexaoSql();
        try {

            PreparedStatement pst = conexao.connection.prepareStatement("update usuarios set usu_perfil=? where usu_cod=?");
            pst.setString(1, "PADRAO");
            pst.setInt(2, TelaLogin.usuariocod);
            pst.execute();
            TelaLogin.usuperfil = "PADRAO";

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na gravação do perfil de cores \n \n" + ex);
        }
        conexao.FecharConexao();
        TelaLancamentos telalan = new TelaLancamentos();
        telalan.setVisible(true);
    }//GEN-LAST:event_jMenuItemPadraoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Ocorrencias_Por_Periodo ocorrencia = new Ocorrencias_Por_Periodo();
        ocorrencia.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jLabelImagemFundojFrameMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImagemFundojFrameMouseMoved

        if (TelaLogin.nomeusu.equals("COFRIL")) {
            return;
        }

        ValidaLicenca licença = new ValidaLicenca();
        Boolean vf = false;

        if (licença.valida(vf)) {
            serial.setVisible(true);

        };
    }//GEN-LAST:event_jLabelImagemFundojFrameMouseMoved

    private void jMenuItemConsultaHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaHistoricoActionPerformed
        TelaConsultaHistorico chist = new TelaConsultaHistorico();
        chist.setVisible(true);
    }//GEN-LAST:event_jMenuItemConsultaHistoricoActionPerformed

    private void jMenuItemPerfilAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPerfilAzulActionPerformed
        conexao.getConexaoSql();
        try {

            PreparedStatement pst = conexao.connection.prepareStatement("update usuarios set usu_perfil=? where usu_cod=?");
            pst.setString(1, "AZUL");
            pst.setInt(2, TelaLogin.usuariocod);
            pst.execute();
            TelaLogin.usuperfil = "AZUL";

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na gravação do perfil de cores \n \n" + ex);
        }
        conexao.FecharConexao();
        TelaLancamentos telalan = new TelaLancamentos();
        telalan.setVisible(true);
    }//GEN-LAST:event_jMenuItemPerfilAzulActionPerformed

    private void jMenuItemPerfilVermelhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPerfilVermelhoActionPerformed
        conexao.getConexaoSql();
        try {

            PreparedStatement pst = conexao.connection.prepareStatement("update usuarios set usu_perfil=? where usu_cod=?");
            pst.setString(1, "VERMELHO");
            pst.setInt(2, TelaLogin.usuariocod);
            pst.execute();
            TelaLogin.usuperfil = "VERMELHO";

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na gravação do perfil de cores \n \n" + ex);
        }
        conexao.FecharConexao();
        TelaLancamentos telalan = new TelaLancamentos();
        telalan.setVisible(true);
    }//GEN-LAST:event_jMenuItemPerfilVermelhoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        TelaConsultaPorID telaid = new TelaConsultaPorID();
        telaid.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        TelaConsultaMovEstoque conmov = new TelaConsultaMovEstoque();
        conmov.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItemProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProdutosActionPerformed
        TelaProdutos tp = new TelaProdutos();
        tp.setVisible(true);
    }//GEN-LAST:event_jMenuItemProdutosActionPerformed

    private void jMenuArcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArcaActionPerformed
        Funcionarios_Por_Tamanho arca = new Funcionarios_Por_Tamanho();
        arca.setVisible(true);
    }//GEN-LAST:event_jMenuArcaActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Uniformes_Tamanho_Setor ts = new Uniformes_Tamanho_Setor();
        ts.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Descarte_de_Uniformes_Peso des = new Descarte_de_Uniformes_Peso();
        des.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItemTotalFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTotalFuncionariosActionPerformed
        try {

            conexao.getConexaoSql();
            conexao.executaSql("select e.emp_razao, d.dep_descricao, count(f.fun_cod) from funcionarios as f\n"
                    + "inner join empresas as e on e.emp_cod = f.fun_emp_cod\n"
                    + "inner join departamentos as d on d.dep_cod = f.fun_dep_cod\n"
                    + "where f.fun_status = \"ATIVO\"\n"
                    + "group by f.fun_emp_cod, f.fun_dep_cod");

            JRResultSetDataSource relatresult = new JRResultSetDataSource(conexao.rs);

            String reportPath = "C:/Users/Lavanderia/Documents/MyReports/Total_Fucionarios.jasper";
            //JasperReport jr = JasperCompileManager.compileReport(reportPath);
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reportPath);

            HashMap map = new HashMap();
            //map.put("datainicial", dataformat.format(jDateChooserInicial.getDate()));
            //map.put("datafinal", dataformat.format(jDateChooserFinal.getDate()));

            JasperPrint jp = JasperFillManager.fillReport(jr, map, relatresult);

            JasperViewer.viewReport(jp, false);
            conexao.FecharConexao();

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }//GEN-LAST:event_jMenuItemTotalFuncionariosActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if (ValidaAcessos.valida(3) == 2) {
            return;
        }

        TelaConferênciaDetalhada tcd = new TelaConferênciaDetalhada();
        tcd.setVisible(true);

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItemLetrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLetrasActionPerformed
        Letras_Por_Funcionarios le = new Letras_Por_Funcionarios();
        le.setVisible(true);
    }//GEN-LAST:event_jMenuItemLetrasActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Aniversariantes niver = new Aniversariantes();
        niver.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItemBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBackupActionPerformed
        BackUpSistema bs = new BackUpSistema();
        bs.setVisible(true);
    }//GEN-LAST:event_jMenuItemBackupActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        
        String hora = fhora.format(new Date());
        if (Integer.parseInt(hora) >= 15) {
            JOptionPane.showMessageDialog(null, "Backup automático do sistema.");
            try {
                Runtime.getRuntime().exec("cmd /c start C:/Users/Lavanderia/Documents/BackupSistemaLavanderia/BackUp.bat");
                
            } catch (IOException e) {
                System.out.println("Erro ao fazer o backup." + e);
            }
        }

    }//GEN-LAST:event_formWindowClosing

    private void jButtonProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProdutosActionPerformed
        TelaProdutos tp = new TelaProdutos();
        tp.setVisible(true);
    }//GEN-LAST:event_jButtonProdutosActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        Relatorio_Produtos rp = new Relatorio_Produtos();
        rp.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItemAgendarTarefasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAgendarTarefasActionPerformed
        TelaLogin.tarefas = 0;
        
        TelaAgendaTarefas agtar = new TelaAgendaTarefas();
        agtar.setTitle("Agendamento de Tarefas");
        
        agtar.setVisible(true);
        
    }//GEN-LAST:event_jMenuItemAgendarTarefasActionPerformed

    private void jTextFieldNumeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNumeroFocusLost
        if (jTextFieldNumero.getText().equals("")) {
            limpaTabelaDados();
            return;
        }
        
        objmodfunc.setFunnum(Integer.parseInt(jTextFieldNumero.getText()));
        ModeloFuncionario modelo09 = controlfunc.buscaCodigoFuncionarioSemErro(objmodfunc);
        jTextFieldNumero.setText(Integer.toString(modelo09.getFunnum()));
        jLabelNome.setText(modelo09.getFunnome() + " - " + modelo09.getDescricao_departamento() + " - " + modelo09.getDescricao_empresa());
        
        if (objmodfunc.getFuncod() != -1){
            preencherTabelaDados("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + modelo09.getFunnum() + "' and (l.lan_sta_cod = 1) order by lan_uni_cod asc");
           
        }else{
            limpaTabelaDados();
        }
        
    }//GEN-LAST:event_jTextFieldNumeroFocusLost

    private void jTextFieldNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNumeroKeyReleased
         if (jTextFieldNumero.getText().equals("")) {
             limpaTabelaDados();
             return;
        }
        
               
        objmodfunc.setFunnum(Integer.parseInt(jTextFieldNumero.getText()));
        ModeloFuncionario modelo09 = controlfunc.buscaCodigoFuncionarioSemErro(objmodfunc);
        jTextFieldNumero.setText(Integer.toString(modelo09.getFunnum()));
        jLabelNome.setText(modelo09.getFunnome() + " - " + modelo09.getDescricao_departamento() + " - " + modelo09.getDescricao_empresa());
        if (objmodfunc.getFuncod() != -1){
            preencherTabelaDados("select l.lan_cod, l.lan_fun_num, l.lan_letra, l.lan_data_entrega, u.uni_descricao, t.tam_sigla, s.sta_descricao, l.lan_tipo, l.lan_data_baixa, l.lan_dias_uso, l.lan_historico, l.lan_ult_mov, l.lan_fun_cod, l.lan_usuario_cod from lancamentos as l inner join uniformes as u on l.lan_uni_cod = u.uni_cod inner join tamanhos as t on l.lan_tam_cod = t.tam_cod inner join status as s on l.lan_sta_cod = s.sta_cod where l.lan_fun_num ='" + modelo09.getFunnum() + "' and (l.lan_sta_cod = 1) order by lan_uni_cod asc");
           
        }else{
            limpaTabelaDados();
        }
        
        
    }//GEN-LAST:event_jTextFieldNumeroKeyReleased

    private void jTextFieldNumeroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNumeroFocusGained
        limpaTabelaDados();
        jTextFieldNumero.setText("");
    }//GEN-LAST:event_jTextFieldNumeroFocusGained

    private void jButtonFecharBemVindo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharBemVindo1ActionPerformed
        jInternalFrameConsultaRapida.dispose();
    }//GEN-LAST:event_jButtonFecharBemVindo1ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        jInternalFrameConsultaRapida.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItemBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBackActionPerformed
        BackUpSistema backup = new BackUpSistema();
        backup.setVisible(true);
    }//GEN-LAST:event_jMenuItemBackActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
      

    String caminhoEntrada =
            "F:\\Lavanderia\\Backup\\Relatorios\\import.csv";

    String caminhoSaida =
            "F:\\Lavanderia\\Backup\\Relatorios\\import_numerado.csv";

    br.com.ConexaoBancoDados.ConexaoSql conexao =
            new br.com.ConexaoBancoDados.ConexaoSql();

    try {

        conexao.getConexaoSql();

        // CARREGA FUNCIONÁRIOS ATIVOS EM MEMÓRIA
        java.util.HashMap<String, String[]> mapaFuncionarios =
                new java.util.HashMap<>();

        String sql =
                "SELECT fun_cod, fun_num, fun_nome, fun_status "
                + "FROM funcionarios "
                + "WHERE fun_status = 'ATIVO'";

        java.sql.Statement stm =
                conexao.connection.createStatement();

        java.sql.ResultSet rs =
                stm.executeQuery(sql);

        while (rs.next()) {

            mapaFuncionarios.put(
                    rs.getString("fun_nome").trim().toUpperCase(),
                    new String[]{
                        rs.getString("fun_cod"),
                        rs.getString("fun_num"),
                        rs.getString("fun_nome"),
                        rs.getString("fun_status")
                    }
            );

        }

        rs.close();
        stm.close();


        java.io.BufferedReader reader =
                new java.io.BufferedReader(
                        new java.io.InputStreamReader(
                                new java.io.FileInputStream(
                                        caminhoEntrada
                                ),
                                java.nio.charset.StandardCharsets.UTF_8
                        )
                );

        java.io.BufferedWriter writer =
                new java.io.BufferedWriter(
                        new java.io.OutputStreamWriter(
                                new java.io.FileOutputStream(
                                        caminhoSaida
                                ),
                                java.nio.charset.StandardCharsets.UTF_8
                        )
                );

        writer.write("fun_cod;fun_num;fun_nome;fun_status");
        writer.newLine();

        String linha;

        boolean primeiraLinha = true;

        while ((linha = reader.readLine()) != null) {

            if (primeiraLinha) {

                primeiraLinha = false;
                continue;

            }

            String[] partes = linha.split(";");

            if (partes.length < 2) {
                continue;
            }

            String nome =
                    partes[1].trim().toUpperCase();

            if (mapaFuncionarios.containsKey(nome)) {

                String[] dados =
                        mapaFuncionarios.get(nome);

                writer.write(
                        dados[0] + ";"
                        + dados[1] + ";"
                        + dados[2] + ";"
                        + dados[3]
                );

                writer.newLine();

            }

        }

        reader.close();
        writer.close();

        conexao.FecharConexao();

        javax.swing.JOptionPane.showMessageDialog(
                null,
                "IMPORT_NUMERADO.csv gerado com sucesso!"
        );

    } catch (Exception e) {

        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Erro ao gerar IMPORT_NUMERADO.csv:\n"
                + e.getMessage()
        );

        e.printStackTrace();

    }


    }//GEN-LAST:event_jMenuItem11ActionPerformed

    public void limpaTabelaDados() {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Numero", "Letra", "Entrega", "Uniforme", "Tamanho", "Status", "Tipo", "Data Baixa", "Dias Uso", "Historico", "Ult. Mov."};
        ModeloTabela modelotab = new ModeloTabela(dados, colunas);
        jTableDados.setModel(modelotab);
        jLabelNome.setText("");
        
    }
    
    public void preencherTabelaDados(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Numero", "Letra", "Entrega", "Uniforme", "Tamanho", "Status", "Tipo", "Data Baixa", "Dias Uso", "Historico", "Ult. Mov.", "ID Func.", "Usuário"};

        

        long dias;
        conexao.getConexaoSql();
        conexao.executaSql(sql);
        try {
            //SimpleDateFormat dataformatada = new SimpleDateFormat("dd/MM/yyyy");
            conexao.rs.first();

            int cod = conexao.rs.getInt("lan_cod"); // faz gerar o erro para o try cath ser acionado - rs vazio
            do {
                modelonovo.setLanentrega(conexao.rs.getDate("lan_data_entrega"));
                String data101 = dataformatada.format(new Date());
                String data202 = dataformatada.format(modelonovo.getLanentrega());
                dias = diasuso.CalcularTempoUso(data202, data101);
                int usuario = conexao.rs.getInt("lan_usuario_cod");
                
                
                if (conexao.rs.getTimestamp("lan_ult_mov") == null) {
                    dados.add(new Object[]{conexao.rs.getInt("lan_cod"), conexao.rs.getInt("lan_fun_num"), conexao.rs.getString("lan_letra"), df.format(conexao.rs.getDate("lan_data_entrega").getTime()), conexao.rs.getString("uni_descricao"), conexao.rs.getString("tam_sigla"), conexao.rs.getString("sta_descricao"), conexao.rs.getString("lan_tipo"), conexao.rs.getDate("lan_data_baixa"), dias, conexao.rs.getString("lan_historico"), null, conexao.rs.getInt("lan_fun_cod"), usuario});
                } else {
                    String datemod = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(conexao.rs.getTimestamp("lan_ult_mov").getTime());
                    dados.add(new Object[]{conexao.rs.getInt("lan_cod"), conexao.rs.getInt("lan_fun_num"), conexao.rs.getString("lan_letra"), df.format(conexao.rs.getDate("lan_data_entrega").getTime()), conexao.rs.getString("uni_descricao"), conexao.rs.getString("tam_sigla"), conexao.rs.getString("sta_descricao"), conexao.rs.getString("lan_tipo"), conexao.rs.getDate("lan_data_baixa"), dias, conexao.rs.getString("lan_historico"), datemod, conexao.rs.getInt("lan_fun_cod"), usuario});
                }
                
                
                

            } while (conexao.rs.next());

            ModeloTabela modelotab = new ModeloTabela(dados, colunas);
            jTableDados.setModel(modelotab);

            jTableDados.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableDados.getColumnModel().getColumn(1).setPreferredWidth(60);
            jTableDados.getColumnModel().getColumn(2).setPreferredWidth(40);
            jTableDados.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTableDados.getColumnModel().getColumn(4).setPreferredWidth(200);
            jTableDados.getColumnModel().getColumn(5).setPreferredWidth(70);
            jTableDados.getColumnModel().getColumn(6).setPreferredWidth(100);
            jTableDados.getColumnModel().getColumn(7).setPreferredWidth(40);
            jTableDados.getColumnModel().getColumn(8).setPreferredWidth(0);
            jTableDados.getColumnModel().getColumn(9).setPreferredWidth(70);
            jTableDados.getColumnModel().getColumn(10).setPreferredWidth(80);
            jTableDados.getColumnModel().getColumn(11).setPreferredWidth(80);

            jTableDados.setAutoResizeMode(jTableDados.AUTO_RESIZE_OFF);
            jTableDados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jTableDados.setAutoCreateRowSorter(true);

            conexao.FecharConexao();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nenhum lançamentos encontrado.");

        }

    }
    
    public void mostrarHora() {
        AtualizadorHorario ah = new AtualizadorHorario(jLabelHorario, jLabelTempo);
        ah.mostrarData(true);
        Thread thHora = ah;
        thHora.start();
              
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadFuncionarios;
    private javax.swing.JButton jButtonConsulta;
    private javax.swing.JButton jButtonEspera;
    private javax.swing.JButton jButtonEstoque;
    private javax.swing.JButton jButtonFecharBemVindo;
    private javax.swing.JButton jButtonFecharBemVindo1;
    private javax.swing.JButton jButtonMovimentaUniformes;
    private javax.swing.JButton jButtonProdutos;
    private javax.swing.JButton jButtonRecentes;
    private javax.swing.JButton jButtonTempoMedio;
    private javax.swing.JInternalFrame jInternalFrameBemVindo;
    private javax.swing.JInternalFrame jInternalFrameConsultaRapida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAlerta;
    private javax.swing.JLabel jLabelBancoDados;
    private javax.swing.JLabel jLabelHorario;
    private javax.swing.JLabel jLabelImagemFundojFrame;
    private javax.swing.JLabel jLabelNivel;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTempo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuArca;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemAgendarTarefas;
    private javax.swing.JMenuItem jMenuItemBack;
    private javax.swing.JMenuItem jMenuItemBackup;
    private javax.swing.JMenuItem jMenuItemBemVindo;
    private javax.swing.JMenuItem jMenuItemClaro;
    private javax.swing.JMenuItem jMenuItemConsulta;
    private javax.swing.JMenuItem jMenuItemConsultaHistorico;
    private javax.swing.JMenuItem jMenuItemDemonstrativo;
    private javax.swing.JMenuItem jMenuItemEscuro;
    private javax.swing.JMenuItem jMenuItemEspera;
    private javax.swing.JMenuItem jMenuItemEstoque;
    private javax.swing.JMenuItem jMenuItemExtrato;
    private javax.swing.JMenuItem jMenuItemFuncEmpresa;
    private javax.swing.JMenuItem jMenuItemFuncSetor;
    private javax.swing.JMenuItem jMenuItemFuncionarios;
    private javax.swing.JMenuItem jMenuItemLetras;
    private javax.swing.JMenuItem jMenuItemMovimentaEstoque;
    private javax.swing.JMenuItem jMenuItemMovimentacao;
    private javax.swing.JMenuItem jMenuItemNumerosLivres;
    private javax.swing.JMenuItem jMenuItemOcorrencias;
    private javax.swing.JMenuItem jMenuItemPadrao;
    private javax.swing.JMenuItem jMenuItemPerfilAzul;
    private javax.swing.JMenuItem jMenuItemPerfilVermelho;
    private javax.swing.JMenuItem jMenuItemProdutos;
    private javax.swing.JMenuItem jMenuItemRelatorioEstoque;
    private javax.swing.JMenuItem jMenuItemRosa;
    private javax.swing.JMenuItem jMenuItemSairDoSistema;
    private javax.swing.JMenuItem jMenuItemTempoMedio;
    private javax.swing.JMenuItem jMenuItemTotalFuncionarios;
    private javax.swing.JMenuItem jMenuItemTrocaNumero;
    private javax.swing.JMenuItem jMenuItemUsuarios;
    private javax.swing.JMenuItem jMenuItemVerde;
    private javax.swing.JMenu jMenuRelatorios;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JMenu jMenuSegurança;
    private javax.swing.JMenu jMenuUniformes;
    private javax.swing.JMenu jMenuUtilitarios;
    private javax.swing.JMenu jMenumManutenção;
    private javax.swing.JPanel jPanelFundo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDados;
    private javax.swing.JTextField jTextFieldNumero;
    // End of variables declaration//GEN-END:variables
}
