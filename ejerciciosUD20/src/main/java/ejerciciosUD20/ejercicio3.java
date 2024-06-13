package ejerciciosUD20;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ejercicio3 extends JFrame {

    private JPanel jp;
    private int count1;
    private int count2;
    private String texto1;
    private String texto2;

    public ejercicio3() {
        count1 = 0;
        count2 = 0;
        texto1 = "Botón 1: ";
        texto2 = "Botón 2: ";

        setTitle("Ejercicio 3");
        setSize(300, 170);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // Panel
        jp = new JPanel();
        jp.setLayout(null);
        setContentPane(jp);

        // Label
        JLabel label = new JLabel("Botones Pulsados:");
        label.setBounds(90, 10, 200, 20);
        jp.add(label);

        // Label
        JLabel label1 = new JLabel(texto1);
        label1.setBounds(100, 30, 200, 20);
        jp.add(label1);

        // Label
        JLabel label2 = new JLabel(texto2);
        label2.setBounds(100, 50, 200, 20);
        jp.add(label2);

        // Botón
        JButton boton1 = new JButton("Botón 1");
        boton1.setBounds(60, 80, 80, 30);
        jp.add(boton1);

        // Botón
        JButton boton2 = new JButton("Botón 2");
        boton2.setBounds(150, 80, 80, 30);
        jp.add(boton2);

        // Action Listener
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == boton1) {
                    count1++;
                    texto1 = "Botón 1: " + count1;
                    label1.setText(texto1);
                } else if (e.getSource() == boton2) {
                    count2++;
                    texto2 = "Botón 2: " + count2;
                    label2.setText(texto2);
                }

            }

        };

        boton1.addActionListener(al);
        boton2.addActionListener(al);
    }
}