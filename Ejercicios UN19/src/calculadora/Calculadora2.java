package calculadora;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;



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
		add(panel);

		// Crear JTextField
		textField = new JTextField("");
		textField.setBounds(43, 20, 300, 20);
		panel.add(textField);

//      BOTON CALCULAR
		JButton botonAñadir = new JButton("=");
		botonAñadir.setBounds(90, 330, 60, 60);
		panel.add(botonAñadir);

		
		botonAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String expresion = textField.getText(); // Obtener la expresión del JTextField
				ScriptEngineManager manager = new ScriptEngineManager();
				ScriptEngine engine = manager.getEngineByName("JavaScript");
				try {
					Object resultado = engine.eval(expresion); // Evaluar la expresión
					textField.setText(resultado.toString()); // Mostrar el resultado en el JTextField
				} catch (ScriptException ex) {
					// Manejar cualquier excepción al evaluar la expresión
					ex.printStackTrace();
				}
			}
		});
		// Agregar ActionListener a CALCULAR
	
//		BOTONES OPERACIONES
		// Importa la clase JButton si aún no lo has hecho
		
		// Botones de operadores
		JButton buttonComa = new JButton(",");
		buttonComa.setBounds(160, 330, 60,60);
		panel.add(buttonComa);
		
		buttonComa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + ".");
			}
		});
		
		JButton buttonDiv = new JButton("/");
		buttonDiv.setBounds(230, 330, 60,60);
		panel.add(buttonDiv);
		
		buttonDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "/");
			}
		});

		JButton buttonProd = new JButton("*");
		buttonProd.setBounds(230, 260, 60,60);
		panel.add(buttonProd);
		
		buttonProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "*");
			}
		});

		JButton buttonResta = new JButton("-");
		buttonResta.setBounds(230, 190, 60,60);
		panel.add(buttonResta);
		
		buttonResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "-");
			}
		});

		JButton buttonSuma = new JButton("+");
		buttonSuma.setBounds(230, 120, 60,60);
		panel.add(buttonSuma);

		buttonSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "+");
			}
		});
		
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
		    
//		    if(botonAñadir.isSelected()) {
//				;
//				
//			}else if(buttonResta.isSelected()) {
//				resultado = op1 - op2;
//				
//			}else if(Prod.isSelected()) {
//				resultado = op1 * op2;
//				
//			}else if(toggleDiv.isSelected()) {
//				resultado = op1 / op2;
//			}
			
		    
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
		
		

		// Agregar ActionListener al botón de cero
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "0");
			}
		});
	}
}