package calculadora;
import javax.swing.JOptionPane;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;

public class Calculadora extends JFrame {

	private JTextField textField;

//	FORMATO VENTANA
	public Calculadora() {
		setTitle("Calculadora");
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//      CREAR PANEL
		JPanel panel = new JPanel();
		panel.setLayout(null);
		Font font = new Font("Arial", Font.BOLD, 14);
		panel.setFont(font);
		add(panel);

//      OPERANDO 1
		JLabel etiquetaop1 = new JLabel("Operando 1:");
		etiquetaop1.setBounds(10, 20, 200, 20);
		panel.add(etiquetaop1);

		JTextField textOP1 = new JTextField(20);
		textOP1.setBounds(100, 20, 100, 25); // Posicionamos el campo de texto
		panel.add(textOP1);

//      OPERANDO 2
		JLabel etiquetaop2 = new JLabel("Operando 2:");
		etiquetaop2.setBounds(10, 50, 200, 20);
		panel.add(etiquetaop2);

		JTextField textOP2 = new JTextField(20);
		textOP2.setBounds(100, 50, 100, 25);
		panel.add(textOP2);

//      BOTON CALCULAR
		JButton botonAñadir = new JButton("Calcular");
		botonAñadir.setBounds(125, 110, 150, 25);
		panel.add(botonAñadir);

		// Agregar ActionListener a CALCULAR
	
//		BOTONES OPERACIONES
		JToggleButton toggleSuma = new JToggleButton("+", false);
		toggleSuma.setBounds(310, 55, 50, 30);
		panel.add(toggleSuma);
		
		JToggleButton toggleResta = new JToggleButton("-", false);
		toggleResta.setBounds(250, 55, 50, 30);
		panel.add(toggleResta);
		
		JToggleButton toggleProd = new JToggleButton("*", false);
		toggleProd.setBounds(310, 20, 50, 30);
		panel.add(toggleProd);
		
		JToggleButton toggleDiv = new JToggleButton("/", false);
		toggleDiv.setBounds(250, 20, 50, 30);
		panel.add(toggleDiv);
		
		// Agregar ActionListener a CALCULAR
				botonAñadir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						
						String textoOP1 = textOP1.getText();
						String textoOP2 = textOP2.getText();
						
						double op1 = Double.parseDouble(textoOP1);
						
						double op2 = Double.parseDouble(textoOP2);
						
						double resultado =0;
						
						
						if(toggleSuma.isSelected()) {
							resultado = op1 + op2;
							
						}else if(toggleResta.isSelected()) {
							resultado = op1 - op2;
							
						}else if(toggleProd.isSelected()) {
							resultado = op1 * op2;
							
						}else if(toggleDiv.isSelected()) {
							resultado = op1 / op2;
						}
						
						
						JOptionPane.showMessageDialog(Calculadora.this, "El resultado es: " + resultado);
					}
				});

	}

	public static void main(String[] args) {
		// Crear una instancia de la ventana
		Calculadora ventana = new Calculadora();
		// Hacer visible la ventana
		ventana.setVisible(true);
	}
}