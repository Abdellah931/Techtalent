package ejerciciosUD20;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class ejercicio4 extends JFrame{

    private JPanel jp;

    public ejercicio4() {
        setTitle("Ejercicio 4");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // Panel
        jp = new JPanel();
        jp.setLayout(null);
        setContentPane(jp);

        // Label
        JLabel label = new JLabel("Eventos: ");
        label.setBounds(10, 50, 60, 20);
        jp.add(label);

        // TextArea
        JTextArea ta = new JTextArea();
        JScrollPane scroll = new JScrollPane(ta);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(70, 10, 300, 300);
        jp.add(scroll);


        WindowListener wl = new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                ta.append("Ventana abierta\n");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                ta.append("Cerrando ventana\n");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                ta.append("Ventana cerrada\n");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                ta.append("Ventana minimizada\n");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                ta.append("Ventana desminimizada\n");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                ta.append("Ventana activada\n");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                ta.append("Ventana desactivada\n");
            }

        };

        addWindowListener(wl);
        
    }
}