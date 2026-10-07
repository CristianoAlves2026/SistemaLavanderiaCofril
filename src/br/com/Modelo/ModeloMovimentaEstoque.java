/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Modelo;

import java.util.Date;

/**
 *
 * @author Lavanderia
 */
public class ModeloMovimentaEstoque {

   
    private int codigo;
    private Date data;
    private int unicod;
    private int tamcod;
    private int empcod;
    private int depcod;
    private int carcod;
    private int entrada;
    private int saida;
    private String historico;
    private int lancod;
    private int saldo;
    
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the unicod
     */
    public int getUnicod() {
        return unicod;
    }

    /**
     * @param unicod the unicod to set
     */
    public void setUnicod(int unicod) {
        this.unicod = unicod;
    }

    /**
     * @return the tamcod
     */
    public int getTamcod() {
        return tamcod;
    }

    /**
     * @param tamcod the tamcod to set
     */
    public void setTamcod(int tamcod) {
        this.tamcod = tamcod;
    }

    /**
     * @return the empcod
     */
    public int getEmpcod() {
        return empcod;
    }

    /**
     * @param empcod the empcod to set
     */
    public void setEmpcod(int empcod) {
        this.empcod = empcod;
    }

    /**
     * @return the depcod
     */
    public int getDepcod() {
        return depcod;
    }

    /**
     * @param depcod the depcod to set
     */
    public void setDepcod(int depcod) {
        this.depcod = depcod;
    }

    /**
     * @return the carcod
     */
    public int getCarcod() {
        return carcod;
    }

    /**
     * @param carcod the carcod to set
     */
    public void setCarcod(int carcod) {
        this.carcod = carcod;
    }

    /**
     * @return the entrada
     */
    public int getEntrada() {
        return entrada;
    }

    /**
     * @param entrada the entrada to set
     */
    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    /**
     * @return the saida
     */
    public int getSaida() {
        return saida;
    }

    /**
     * @param saida the saida to set
     */
    public void setSaida(int saida) {
        this.saida = saida;
    }

    /**
     * @return the historico
     */
    public String getHistorico() {
        return historico;
    }

    /**
     * @param historico the historico to set
     */
    public void setHistorico(String historico) {
        this.historico = historico;
    }

    /**
     * @return the lancod
     */
    public int getLancod() {
        return lancod;
    }

    /**
     * @param lancod the lancod to set
     */
    public void setLancod(int lancod) {
        this.lancod = lancod;
    }
    
     /**
     * @return the saldo
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
}
