package UD20.Ejercicio01;
import javax.swing.*;
import java.awt.*;

public class main
{
	public static void main(String[] args) {
        // Configuración de la ventana principal
        JFrame frame = new JFrame("Mi Aplicación GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300); // Tamaño inicial de la ventana
        
        // Configuración de una etiqueta
        JLabel label = new JLabel("¡Hola, Mundo!", SwingConstants.CENTER);
        frame.getContentPane().add(label, BorderLayout.CENTER);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}