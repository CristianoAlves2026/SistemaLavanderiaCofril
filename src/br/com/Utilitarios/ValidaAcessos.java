/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Utilitarios;

import br.com.Visao.TelaLogin;
import javax.swing.JOptionPane;

/**
 *
 * @author Lavanderia
 */
public class ValidaAcessos {
    
    public static int valida(int nivelpermitido){
        int acesso = 0;
        if (TelaLogin.numnivelusu < nivelpermitido ){
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Acesso não permitido para seu nível de usuário.");
            acesso = 2;  //acesso negado
        }
        return acesso;
    }
    
}
