package br.com.Modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabela01 extends AbstractTableModel {

    private ArrayList<Object[]> linhas;
    private String[] colunas;

    public ModeloTabela01(ArrayList linhas, String[] colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
    }

    public void removeRow(int row) {
    if (row >= 0 && row < linhas.size()) {
        this.linhas.remove(row); // O nome correto da sua variável é 'linhas'
        fireTableRowsDeleted(row, row); // Notifica a JTable para atualizar o visual
    }
}
    
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        return linhas.get(row)[column];
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        linhas.get(row)[column] = value;
        fireTableCellUpdated(row, column);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 0; // SOMENTE checkbox
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Boolean.class; // JCheckBox
        }
        return Object.class;
    }
}
