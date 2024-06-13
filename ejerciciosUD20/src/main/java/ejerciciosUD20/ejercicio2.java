package ejerciciosUD20;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ejercicio2 extends JFrame{

    private JPanel jp;
    private String texto;
    private String textoLabel;
    private String textoBoton;

    public ejercicio2() {
        setTitle("Ejercicio 2");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        textoLabel = "Has pulsado el botón: ";
        textoBoton = "";
        texto = textoLabel;

        // Panel
        jp = new JPanel();
        jp.setLayout(null);
        setContentPane(jp);

        // Label
        JLabel label = new JLabel(textoLabel);
        label.setBounds(20, 10, 200, 20);
        jp.add(label);

        // Botón
        JButton boton1 = new JButton("Botón 1");
        boton1.setBounds(60, 40, 80, 30);
        jp.add(boton1);

        // Botón
        JButton boton2 = new JButton("Botón 2");
        boton2.setBounds(150, 40, 80, 30);
        jp.add(boton2);

        // Action Listener
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == boton1) {
                    textoBoton = boton1.getText();
                } else if (e.getSource() == boton2) {
                    textoBoton = boton2.getText();
                }

                texto = textoLabel + textoBoton;
                label.setText(texto);
            }

        };

        boton1.addActionListener(al);
        boton2.addActionListener(al);
    }
}