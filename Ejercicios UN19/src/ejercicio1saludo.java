

import javax.swing.*;
import java.awt.event.*;

public class ejercicio1saludo extends JFrame {
    
    private JTextField textField;
    
    public ejercicio1saludo() {
        setTitle("Saludador Personalizable");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear un panel
        JPanel panel = new JPanel();
        
        // Crear un campo de texto
        textField = new JTextField(20);
        panel.add(textField);
        
        // Crear un botón
        JButton botonSaludar = new JButton("Saludar");
        // Agregar ActionListener al botón
        botonSaludar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto del campo de texto
                String nombre = textField.getText();
                // Mostrar un mensaje en un JOptionPane
                JOptionPane.showMessageDialog(ejercicio1saludo
                		.this, "¡Hola " + nombre + "!");
            }
        });
        panel.add(botonSaludar);
        
        // Agregar el panel a la ventana
        add(panel);
    }
    
    public static void main(String[] args) {
        // Crear una instancia de la ventana
    	ejercicio1saludo ventana = new ejercicio1saludo();
        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}