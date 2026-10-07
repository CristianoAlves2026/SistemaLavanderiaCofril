package br.com.Modelo;

import java.awt.*;
import javax.swing.*;

public class BalaoAnimado extends JPanel {

    private JLabel label;
    private float alpha = 0f;
    // private int posY;
    // private Timer timer;
    private Point mouseClick;
    //private String texto;
    private Point ultimaPosicao;

    public BalaoAnimado(String texto) {
        setOpaque(false);
        setLayout(new BorderLayout());

        label = new JLabel(texto, SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 14));

        add(label, BorderLayout.CENTER);

        setSize(250, 60);

        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                mouseClick = e.getPoint();
            }
        });

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {

        int x = getLocation().x + e.getX() - mouseClick.x;
        int y = getLocation().y + e.getY() - mouseClick.y;

        setLocation(x, y);
    }
});

    }

    public void mostrar(JFrame frame, int x, int y) {

    if (getParent() == null) {
        if (getWidth() == 0 || getHeight() == 0) {
            setSize(400, 80);
        }

        setBounds(x, y, getWidth(), getHeight());
        frame.getLayeredPane().add(this, JLayeredPane.POPUP_LAYER);
    }

    alpha = 1f;
    repaint();
}
    
    public void setTexto(String texto) {

        String textoLimpo = (texto == null ? "" : texto).replace("PD:", "").trim();

        java.util.LinkedHashSet<String> numerosUnicos = new java.util.LinkedHashSet<>();

        if (!textoLimpo.isEmpty()) {
            String[] partes = textoLimpo.split("\\|");

            for (String parte : partes) {
                String numero = parte.trim();
                if (!numero.isEmpty()) {
                    numerosUnicos.add(numero);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<html><body style='text-align:center;'>");

        // ✔ título só aqui (único lugar permitido)
        sb.append("<div style='font-weight:bold;'>PENDÊNCIAS</div>");
        sb.append("<br>");

        int contador = 0;
        int total = numerosUnicos.size();
        int i = 0;

        for (String numero : numerosUnicos) {

            sb.append(numero);

            i++;
            contador++;

            if (i < total) {
                sb.append(" | ");
            }

            if (contador == 10) {
                sb.append("<br>");
                contador = 0;
            }
        }

        sb.append("</body></html>");

        label.setText(sb.toString());

        int linhas = (total / 10) + 1;
        setSize(400, 80 + (linhas * 25));

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        float safeAlpha = Math.max(0f, Math.min(1f, alpha));

        g2.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, safeAlpha));

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // fundo do balão
        //g2.setColor(new Color(30, 30, 30, 220));
        g2.setColor(new Color(55, 65, 75));
        g2.fillRoundRect(0, 0, getWidth(), getHeight() - 15, 20, 20);

        g2.dispose();
    }

}
