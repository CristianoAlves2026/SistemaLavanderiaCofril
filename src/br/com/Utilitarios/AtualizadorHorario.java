/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Utilitarios;

import br.com.Visao.TelaAgendaTarefas;
import br.com.Visao.TelaConferênciaMatriz;
import br.com.Visao.TelaEspera;
import br.com.Visao.TelaLogin;
import br.com.Visao.TelaPrincipal;
import java.awt.MouseInfo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RootPaneContainer;

/**
 *
 * @author Lavanderia
 */
public class AtualizadorHorario extends Thread {

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    SimpleDateFormat seg = new SimpleDateFormat("ss");
    SimpleDateFormat minuto = new SimpleDateFormat("mm");
    Calendar tpinicial = new GregorianCalendar();
    Calendar tpfinal = new GregorianCalendar();
    private JLabel hr;
    private JLabel tp;
    private JInternalFrame pi;
    private boolean mostrarData;

    int y; //posição do mouse em qualquer lugar da tela.
    int x; //posição do mouse em qualquer lugar da tela.
    int bloq = 0;

    public AtualizadorHorario(JLabel hora, JLabel tempo) {
        this.hr = hora;
        this.tp = tempo;

    }

    public void mostrarData(boolean mostrar) {
        if (mostrar) {
            this.mostrarData = true;
        } else {
            this.mostrarData = false;
        }
    }

    @Override
    public void run() {
        //SimpleDateFormat dataformat = new SimpleDateFormat("HH:mm:ss");
        try {
            while (true) {
                Date d = new Date();

                ////////////////////////////////////////////////////////////////////////////////////
                tpfinal.setTime(d);  // data final

                if (tp.getText().equals("")) {
                    Date ti = new Date();
                    bloq = 180;
                    tp.setText("Bloqueio por inatividade em " + String.valueOf(bloq) + " segundos");
                    ti.setTime(ti.getTime() + (180000));
                    tpinicial.setTime(ti);  // data incial
                    y = MouseInfo.getPointerInfo().getLocation().y;
                    x = MouseInfo.getPointerInfo().getLocation().x;

                } else if ((tpfinal.getTimeInMillis() > tpinicial.getTimeInMillis()) && !tp.getText().equals("Sistema Bloqueado por Inatividade")) {
                    tp.setText("Sistema Bloqueado por Inatividade");
                    TelaEspera dialog = new TelaEspera(new javax.swing.JFrame(), true);
                    dialog.setVisible(true);
                    tp.setText("");
                    y = 0;
                }

                ////////////////////////////////////////////////////////////////////////////////////
                StringBuffer data = new StringBuffer();

                if (mostrarData) {
                    SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy - EEEE");
                    data.append(sdfData.format(d));
                    data.append(" - ");
                }

                this.hr.setText(data.toString() + sdf.format(d));

                Thread.sleep(1000);
                this.hr.revalidate();

                ////////////ALERTA DE TAREFAS
                if (TelaLogin.alerta == Integer.parseInt(minuto.format(new Date()))) {

                    TelaLogin.tarefas = 1; // exibe somente tarefas do dia
                    TelaAgendaTarefas agtar = new TelaAgendaTarefas();

                    TelaLogin.alerta = Integer.parseInt(minuto.format(new Date()));
                    if (TelaLogin.alerta <= 49) {
                        TelaLogin.alerta = Integer.parseInt(minuto.format(new Date())) + 10;
                        //JOptionPane.showMessageDialog(null, "MINUTO ("+ TelaLogin.alerta + ") AtHorario menor q 49");
                    } else {
                        int calc;
                        TelaLogin.alerta = Integer.parseInt(minuto.format(new Date())) + 10;
                        calc = TelaLogin.alerta - 59;
                        TelaLogin.alerta = calc;
                        //JOptionPane.showMessageDialog(null, "MINUTO ("+ TelaLogin.alerta + ")AtHorario maior q 49");
                    }

                    if (TelaLogin.visivel.equals("não")) {
                        TelaLogin.visivel = "sim";//exibe o forumlario de tarefas
                        agtar.setVisible(true);
                    }
                }
                /////////////////////////////

                if (x != MouseInfo.getPointerInfo().getLocation().x || y != MouseInfo.getPointerInfo().getLocation().y) {
                    tp.setText("");

                } else if (TelaLogin.usuflag == 1) {  // flag para evitar que tempo corre quando uma tela espera já estiver aberta e não abrir outra) {
                    tp.setText("");
                } else {
                    bloq--;
                    tp.setText("Bloqueio por inatividade em " + String.valueOf(bloq) + " segundos");

                }

                if (TelaConferênciaMatriz.key01 != TelaConferênciaMatriz.key02) {
                    TelaConferênciaMatriz.key01 = 0;
                    TelaConferênciaMatriz.key02 = 0;
                    tp.setText("");
                }

            }
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Problema na atualização da data/hora");
            ex.printStackTrace();
        }
    }

}
