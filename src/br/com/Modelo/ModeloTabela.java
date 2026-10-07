/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lavanderia
 */
public class ModeloTabela extends AbstractTableModel {
    private ArrayList linhas = null;
    private String [] colunas = null;
    
    
     //CONSTRUTOR
    public ModeloTabela(ArrayList lin, String[] col) {
        setLinhas(lin);
        setColunas(col);
    }
    /**
     * @return the linhas
     */
    public ArrayList getLinhas() {
        return linhas;
    }

    /**
     * @param linhas the linhas to set
     */
    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    /**
     * @return the colunas
     */
    public String[] getColunas() {
        return colunas;
    }

    /**
     * @param colunas the colunas to set
     */
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
    
    //METODOS OBRIGATORIOS DA CLASSE ABSTRACTTABLEMODEL
    public int getColumnCount(){
        return colunas.length;
    } 
    
    public int getRowCount(){
        return linhas.size();
    }

    public String getColumnName(int numcol){
        return colunas[numcol];
        
    }
    
    public Object getValueAt(int numlin, int numcol){
        Object[] linha = (Object[]) getLinhas().get(numlin);
        return linha[numcol];
        
    }
}

