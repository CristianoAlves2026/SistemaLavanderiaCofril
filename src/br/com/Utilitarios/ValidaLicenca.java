/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Utilitarios;

import br.com.ConexaoBancoDados.ConexaoSql;
import br.com.Modelo.ModeloSenha;
/*import br.com.Visao.TelaLogin;
import static br.com.Visao.TelaLogin.codusu;
import static br.com.Visao.TelaLogin.nivelusu;
import static br.com.Visao.TelaLogin.nomeusu;
import static br.com.Visao.TelaLogin.numnivelusu;
import static br.com.Visao.TelaLogin.usuariocod;
import static br.com.Visao.TelaLogin.usuperfil;
import br.com.Visao.TelaPrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.Visao.TelaSerial;
import java.awt.Color;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;*/

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;



/**
 *
 * @author Lavanderia
 */
public class ValidaLicenca {

    SimpleDateFormat dataformatada = new SimpleDateFormat("dd/MM/yyyy");
    ConexaoSql conexao = new ConexaoSql();
    ModeloSenha modelosenha = new ModeloSenha();
    

    public boolean valida(boolean vf) {
        Calendar dataAtual = new GregorianCalendar();
        Calendar datalimite = new GregorianCalendar();
        
        String data = dataformatada.format(new Date().getTime());
        String data2 = "31/10/2026";
        
        try {
            dataAtual.setTime(dataformatada.parse(data));
            datalimite.setTime(dataformatada.parse(data2));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar data da licença de uso.");
        }
        
       
        if((dataAtual.getTimeInMillis() > datalimite.getTimeInMillis())){
            vf = true;
        }else{
            vf= false;
        }
        
        return vf;
    }
        

    
    
    }
