/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Modelo;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Lavanderia
 */
public class TableRenderer extends DefaultTableCellRenderer {

    Color defaultBackground, defaultForeground;

    public TableRenderer() {
        this.defaultBackground = getBackground();
        this.defaultForeground = getForeground();
        setHorizontalAlignment(javax.swing.JLabel.RIGHT);

    }

    /**
     *
     * @param table
     * @param value
     * @param isSelected
     * @param hasFocus
     * @param row
     * @param column
     * @return
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        //String status = table.getModel().getValueAt(row, 6).toString();
        //int dias = Integer.parseInt(table.getModel().getValueAt(row, 9).toString());
        
           
        if (row % 2 == 0){  // coluna par
            comp.setBackground(Color.lightGray);
        }else{
           comp.setBackground(Color.WHITE);
        }
        
        return comp;

    }

}
