/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.event.PrintJobEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Lavanderia
 */
public class ModeloDatas {
    
    private Date database;
    private Date vencimento;
    private int qtddias;
    
    public long CalcularTempoUso(String base, String venc){
      
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
        try {
            this.database = sdf.parse(base);  
            this.vencimento= sdf.parse(venc); 
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao calcular dias de uso" + ex);
        }
      
      
      long diferencaMS = this.vencimento.getTime() - this.database.getTime();
      long diferencaSegundos = diferencaMS / 1000;
      long diferencaMinutos = diferencaSegundos / 60;
      long diferencaHoras = diferencaMinutos / 60;
      long diferencaDias = diferencaHoras / 24;

      return diferencaDias;
    
      
    }
    
    
    /**
     * @return the database
     */
    public Date getDatabase() {
        return database;
    }

    /**
     * @param database the database to set
     */
    public void setDatabase(Date database) {
        this.database = database;
    }

    /**
     * @return the vencimento
     */
    public Date getVencimento() {
        return vencimento;
    }

    /**
     * @param vencimento the vencimento to set
     */
    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }
    
     /**
     * @return the qtddias
     */
    public int getQtddias() {
        return qtddias;
    }

    /**
     * @param qtddias the qtddias to set
     */
    public void setQtddias(int qtddias) {
        this.qtddias = qtddias;
    }

}
