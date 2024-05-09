package calculadora;
import javax.swing.JOptionPane;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.JButton;
public class Calculadora2 extends JFrame {

	private JTextField textField;

//	FORMATO VENTANA
	public Calculadora2() {
		setTitle("Calculadora");
		setSize(400, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//      CREAR PANEL
		JPanel panel = new JPanel();
		panel.setLayout(null);
		Font font = new Font("Arial", Font.BOLD, 14);
		panel.setFont(font);
		add(panel);

//      OPERANDO 1
		JLabel etiquetaop1 = new JLabel();
		etiquetaop1.setBounds(10, 20, 200, 80);
		panel.add(etiquetaop1);

		JTextField textOP1 = new JTextField(20);
		textOP1.setBounds(20, 50, 270,45); // Posicionamos el campo de texto
		panel.add(textOP1);

//      OPERANDO 2

	

//      BOTON CALCULAR
		JButton botonAñadir = new JButton("=");
		botonAñadir.setBounds(90, 330, 60, 60);
		panel.add(botonAñadir);

		// Agregar ActionListener a CALCULAR
	
//		BOTONES OPERACIONES
		// Importa la clase JButton si aún no lo has hecho
		
		// Botones de operadores
		JButton buttonComa = new JButton(",");
		buttonComa.setBounds(160, 330, 60,60);
		panel.add(buttonComa);
		
		JButton buttonDiv = new JButton("/");
		buttonDiv.setBounds(230, 330, 60,60);
		panel.add(buttonDiv);

		JButton buttonProd = new JButton("*");
		buttonProd.setBounds(230, 260, 60,60);
		panel.add(buttonProd);

		JButton buttonResta = new JButton("-");
		buttonResta.setBounds(230, 190, 60,60);
		panel.add(buttonResta);

		JButton buttonSuma = new JButton("+");
		buttonSuma.setBounds(230, 120, 60,60);
		panel.add(buttonSuma);

		// Botones de números
		int xInicial = 20; // Posición inicial en x
		int yInicial = 120; // Posición inicial en y
		int xActual = xInicial;
		int yActual = yInicial;
		int espacioHorizontal = 70; // Espacio horizontal entre botones
		int espacioVertical = 70; // Espacio vertical entre botones

		for (int i = 1; i <= 9; i++) {
		    JButton button = new JButton(Integer.toString(i));
		    button.setBounds(xActual, yActual, 60, 60);
		    panel.add(button);
		    
		    button.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String valorBoton = ((JButton) e.getSource()).getText(); // Obtener el texto del botón
	                textField.setText(textField.getText() + valorBoton); // Agregar el texto del botón al JTextField
	            }
	        });
		    
		    // Actualiza las coordenadas para el próximo botón
		    xActual += espacioHorizontal;
		    if (i % 3 == 0) {
		        xActual = xInicial;
		        yActual += espacioVertical;
		    }
		}

		// Botón de cero
		JButton button0 = new JButton("0");
		button0.setBounds(xInicial, yActual, 60, 60);
		panel.add(button0);

		// Agregar ActionListener a CALCULAR
				botonAñadir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						
						String textoOP1 = textOP1.getText();
						String textoOP2 = textOP2.getText();
						
						double op1 = Double.parseDouble(textoOP1);
						
						double op2 = Double.parseDouble(textoOP2);
						
						double resultado =0;
						
						
						if(buttonSuma.isSelected()) {
							resultado = op1 + op2;
							
						}else if(buttonResta.isSelected()) {
							resultado = op1 - op2;
							
						}else if(buttonProd.isSelected()) {
							resultado = op1 * op2;
							
						}else if(buttonDiv.isSelected()) {
							resultado = op1 / op2;
							
//						}else if(buttonComa.isSelected()) {
//							resultado = op1  op2;
						}
						
						
						JOptionPane.showMessageDialog(Calculadora2.this, "El resultado es: " + resultado);
					}
				});

	}

	public static void main(String[] args) {
		// Crear una instancia de la ventana
		Calculadora2 ventana = new Calculadora2();
		// Hacer visible la ventana
		ventana.setVisible(true);
	}
}