/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.Visao;


import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
// Use EXCLUSIVAMENTE estes para o Excel:
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;


/**
 *
 * @author Lavanderia
 */
public class TelaNovoCadastro extends javax.swing.JFrame {

    // Adicione esta variável manualmente
    private TableRowSorter<DefaultTableModel> sorter;
    private TelaCadFuncionarios telaCadastro;

        
    public TelaNovoCadastro() {
    initComponents();
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    configurarTabela();
}
    
    public TelaNovoCadastro(TelaCadFuncionarios tela) {
        this();
        this.telaCadastro = tela;

        jTablePlanilha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    enviarDadosParaCadastro();
                }
            }
        });

        jTablePlanilha.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        String caminhoFixo = "C:\\Users\\Lavanderia\\Documents\\Planilha de Funcionários RH2.xlsx";
        importarExcel(caminhoFixo);
    }

    private void configurarTabela() {
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Número", "Nome", "Setor", "Cargo"} // Cabeçalhos
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jTablePlanilha.setModel(modelo);
        sorter = new TableRowSorter<>(modelo);
        jTablePlanilha.setRowSorter(sorter);
    }

    private String getCell(Row row, Row header, String colunaNome, DataFormatter formatter) {

    for (Cell cell : header) {
        String nome = formatter.formatCellValue(cell).trim();

        if (nome.equalsIgnoreCase(colunaNome)) {
            Cell valueCell = row.getCell(cell.getColumnIndex());
            return formatter.formatCellValue(valueCell);
        }
    }

    return "";
}

    private void ajustarColunasManual() {

        // IMPORTANTE: desativar o resize automático
        jTablePlanilha.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        // Exemplo de ajustes (adicione conforme sua planilha)
        jTablePlanilha.getColumnModel().getColumn(0).setPreferredWidth(50);  // Nº
        jTablePlanilha.getColumnModel().getColumn(1).setPreferredWidth(80);  // Número
        jTablePlanilha.getColumnModel().getColumn(2).setPreferredWidth(250); // Nome
        jTablePlanilha.getColumnModel().getColumn(3).setPreferredWidth(150); // Setor
        jTablePlanilha.getColumnModel().getColumn(4).setPreferredWidth(180); // Cargo

        // Datas (exemplo)
        // ajuste conforme o índice real da sua planilha
        jTablePlanilha.getColumnModel().getColumn(7).setPreferredWidth(100);  // D. ADM.
        jTablePlanilha.getColumnModel().getColumn(8).setPreferredWidth(100);  // D.NASC.
    }

    public void importarExcel(String caminho) {
    File arquivo = new File(caminho);
    FileInputStream fis = null;
    Workbook workbook = null;

    try {
        fis = new FileInputStream(arquivo);
        workbook = WorkbookFactory.create(fis);
        Sheet aba = workbook.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();
        Row header = aba.getRow(0);

        if (header == null) return;

        // Criando o modelo SEM a coluna "Nº"
        DefaultTableModel modeloNovo = new DefaultTableModel(new Object[][]{}, new Object[]{
            "ID", "EMPRESA", "NOME", "SETOR", "FUNCAO",
            "ADMISSAO", "AQUISITIVO", "NASCIMENTO", "MOTIVO",
            "DEMISSAO", "SEXO", "ESTADO CIVIL", "MAE",
            "CTPS", "CPF", "PIS", "RG", "ENDERECO",
            "DDD", "CELULAR", "STATUS", "FOTO", "USUARIO"
        }) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };

        for (Row row : aba) {
            if (row.getRowNum() == 0) continue; 
            Object[] linhaDados = new Object[23]; 

            // Mapeando colunas do Excel para a Tabela
            for (int i = 0; i < 23; i++) {
                // Aqui usamos o seu método getCell para buscar pelo nome do cabeçalho
                String[] nomes = {"ID", "EMPRESA", "NOME", "SETOR", "FUNCAO", "ADMISSAO", 
                                  "AQUISITIVO", "NASCIMENTO", "MOTIVO", "DEMISSAO", "SEXO", 
                                  "ESTADO CIVIL", "MAE", "CTPS", "CPF", "PIS", "RG", 
                                  "ENDERECO", "DDD", "CELULAR", "STATUS", "FOTO", "USUARIO"};
                linhaDados[i] = getCell(row, header, nomes[i], formatter);
            }
            modeloNovo.addRow(linhaDados);
        }

        jTablePlanilha.setModel(modeloNovo);
        sorter = new TableRowSorter<>(modeloNovo);
        jTablePlanilha.setRowSorter(sorter);
        ajustarColunasManual();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
    } finally {
        try { if (fis != null) fis.close(); } catch (Exception ex) {}
    }
}
    
    private java.util.Date converterStringParaData(String data) {
    if (data == null || data.trim().isEmpty()) return null;

    String[] formatos = {
        "dd/MM/yyyy",
        "yyyy-MM-dd",
        "dd-MM-yyyy",
        "yyyy/MM/dd"
    };

    for (String formato : formatos) {
        try {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(formato);
            sdf.setLenient(false);
            return sdf.parse(data.trim());
        } catch (Exception ignored) {}
    }

    return null; // se nenhum formato bater
}

private void enviarDadosParaCadastro() {

    int row = jTablePlanilha.getSelectedRow();

    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Selecione uma linha primeiro!");
        return;
    }

    int modelRow = jTablePlanilha.convertRowIndexToModel(row);
    DefaultTableModel modelo = (DefaultTableModel) jTablePlanilha.getModel();

    try {

        // ===== COLUNAS (mais seguro manter assim) =====
        final int COL_NOME = 2;
        final int COL_SETOR = 3;
        final int COL_FUNCAO = 4;
        final int COL_ADMISSAO = 5;
        final int COL_NASCIMENTO = 7;
        final int COL_SEXO = 10;
        final int COL_CPF = 14;
        final int COL_CELULAR = 19;
        final int COL_STATUS = 20;

        // ===== STRING SEGURAS =====
        String nome    = getString(modelo, modelRow, COL_NOME);
        String setor   = getString(modelo, modelRow, COL_SETOR);
        String funcao  = getString(modelo, modelRow, COL_FUNCAO);
        String cpf     = getString(modelo, modelRow, COL_CPF);
        String celular = getString(modelo, modelRow, COL_CELULAR);
        String sexo    = getString(modelo, modelRow, COL_SEXO);
        String status  = getString(modelo, modelRow, COL_STATUS);

        // ===== DATAS SEGURAS =====
        java.util.Date dAdm = converterDataSeguro(modelo.getValueAt(modelRow, COL_ADMISSAO));
        java.util.Date dNas = converterDataSeguro(modelo.getValueAt(modelRow, COL_NASCIMENTO));

        // ===== ENVIO =====
        if (this.telaCadastro != null) {

            this.telaCadastro.preencherCampos(
                nome,
                setor,
                funcao,
                cpf,
                celular,
                sexo,
                status,
                dAdm,
                dNas
            );

            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this, "Erro: Tela de cadastro não referenciada!");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao processar linha: " + e.getMessage());
        e.printStackTrace();
    }
}
 
private String getString(DefaultTableModel modelo, int row, int col) {
    Object value = modelo.getValueAt(row, col);
    return value != null ? value.toString().trim() : "";
}

private java.util.Date converterDataSeguro(Object value) {
    try {
        if (value == null) return null;
        return converterStringParaData(value.toString());
    } catch (Exception e) {
        return null;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePlanilha = new javax.swing.JTable();
        jTextFieldBusca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Planilha RH");

        jTablePlanilha.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablePlanilha);

        jTextFieldBusca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscaKeyReleased
        // Pegamos o sorter que está atualmente na tabela
        javax.swing.table.TableRowSorter<javax.swing.table.TableModel> sorterAtual
                = (javax.swing.table.TableRowSorter<javax.swing.table.TableModel>) jTablePlanilha.getRowSorter();

        if (sorterAtual != null) {
            String texto = jTextFieldBusca.getText();
            // Filtra pela coluna 2 (Nome). (?i) para ignorar maiúsculas/minúsculas
            sorterAtual.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + texto, 2));
        }
    }//GEN-LAST:event_jTextFieldBuscaKeyReleased

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
            java.util.logging.Logger.getLogger(TelaNovoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNovoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNovoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNovoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaNovoCadastro(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePlanilha;
    private javax.swing.JTextField jTextFieldBusca;
    // End of variables declaration//GEN-END:variables
}
