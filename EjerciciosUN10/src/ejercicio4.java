import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class ejercicio4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora Simple");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel panelOperador1 = new JPanel();
        JLabel primerOperador = new JLabel("Operador 1:");
        primerOperador.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        JTextField operador1 = new JTextField(20);
        panelOperador1.add(primerOperador);
        panelOperador1.add(operador1);
        
        JPanel panelOperador2 = new JPanel();
        JLabel segundoOperador = new JLabel("Operador 2:");
        segundoOperador.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        JTextField operador2 = new JTextField(20);
        panelOperador2.add(segundoOperador);
        panelOperador2.add(operador2);

        JPanel panelResultado = new JPanel();
        panelResultado.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelResultado.setLayout(new BoxLayout(panelResultado, BoxLayout.Y_AXIS));

        JPanel panelSimbolo = new JPanel(new GridLayout(0, 7));
        JButton mas = crearYEscalarBotonImagen("imagenes/mas.png");
        mas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    verificacion(operador1, "1");
                    verificacion(operador2, "2");
                    double resultado = Double.parseDouble(operador1.getText()) + Double.parseDouble(operador2.getText());
                    // double resultado = Double.parseDouble(operador1.getText()) - Double.parseDouble(operador2.getText()); // BOTÓN RESTAR
                    // double resultado = Double.parseDouble(operador1.getText()) / Double.parseDouble(operador2.getText()); // BOTÓN DIVIDIR
                    // double resultado = Double.parseDouble(operador1.getText()) * Double.parseDouble(operador2.getText()); // BOTÓN MULTIPLICAR
                    // double resultado = Math.pow(Double.parseDouble(operador1.getText()), Double.parseDouble(operador2.getText())); // BOTÓN POTENCIA
                    // double resultado1 = Math.sqrt(Double.parseDouble(operador1.getText())); // BOTÓN RAÍZ CUADRADA
                    // double resultado1 = Math.cbrt(Double.parseDouble(operador1.getText())); // BOTÓN CÚBICA
                    mostrarMensaje(frame, panelResultado, Double.parseDouble(operador1.getText()), Double.parseDouble(operador2.getText()), "+", resultadoStringFormat(resultado));
                } catch (CustomEx custom) {
                    System.out.println(custom.getMessage());
                }
            }
        });

        JButton menos = crearYEscalarBotonImagen("imagenes/menos.png");
        menos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    verificacion(operador1, "1");
                    verificacion(operador2, "2");
                    double resultado = Double.parseDouble(operador1.getText()) - Double.parseDouble(operador2.getText());
                    mostrarMensaje(frame, panelResultado, Double.parseDouble(operador1.getText()), Double.parseDouble(operador2.getText()), "-", resultadoStringFormat(resultado));
                } catch (CustomEx custom) {
                    System.out.println(custom.getMessage());
                }
            }
        });

        JButton slash = crearYEscalarBotonImagen("imagenes/slash.png");
        slash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    verificacion(operador1, "1");
                    verificacion(operador2, "2");
                    double resultado = Double.parseDouble(operador1.getText()) / Double.parseDouble(operador2.getText());
                    mostrarMensaje(frame, panelResultado, Double.parseDouble(operador1.getText()), Double.parseDouble(operador2.getText()), "/", resultadoStringFormat(resultado));
                } catch (CustomEx custom) {
                    System.out.println(custom.getMessage());
                }
            }
        });

        JButton asterisco = crearYEscalarBotonImagen("imagenes/asterisco.png");
        asterisco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    verificacion(operador1, "1");
                    verificacion(operador2, "2");
                    double resultado = Double.parseDouble(operador1.getText()) * Double.parseDouble(operador2.getText());
                    mostrarMensaje(frame, panelResultado, Double.parseDouble(operador1.getText()), Double.parseDouble(operador2.getText()), "*", resultadoStringFormat(resultado));
                } catch (CustomEx custom) {
                    System.out.println(custom.getMessage());
                }
            }
        });

        JButton exponente = crearYEscalarBotonImagen("imagenes/exponente.png");
        exponente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    verificacion(operador1, "1");
                    verificacion(operador2, "2");
                    double resultado = Math.pow(Double.parseDouble(operador1.getText()), Double.parseDouble(operador2.getText()));
                    mostrarMensaje(frame, panelResultado, Double.parseDouble(operador1.getText()), Double.parseDouble(operador2.getText()), "^", resultadoStringFormat(resultado));
                } catch (CustomEx custom) {
                    System.out.println(custom.getMessage());
                }
            }
        });

        JButton raizCuadrada = crearYEscalarBotonImagen("imagenes/raiz-cuadrada.png");
        raizCuadrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    verificacion(operador1, "1");
                    verificacion(operador2, "2");
                    double resultado1 = Math.sqrt(Double.parseDouble(operador1.getText()));
                    double resultado2 = Math.sqrt(Double.parseDouble(operador2.getText()));
                    mostrarMensaje(frame, panelResultado, Double.parseDouble(operador1.getText()), Double.parseDouble(operador2.getText()), "²√", resultadoStringFormat(resultado1) + "%" + resultadoStringFormat(resultado2));
                } catch (CustomEx custom) {
                    System.out.println(custom.getMessage());
                }
            }
        });

        JButton raizCubica = crearYEscalarBotonImagen("imagenes/raiz-cubica.png");
        raizCubica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    verificacion(operador1, "1");
                    verificacion(operador2, "2");
                    double resultado1 = Math.cbrt(Double.parseDouble(operador1.getText()));
                    double resultado2 = Math.cbrt(Double.parseDouble(operador2.getText()));
                    mostrarMensaje(frame, panelResultado, Double.parseDouble(operador1.getText()), Double.parseDouble(operador2.getText()), "³√", resultadoStringFormat(resultado1) + "%" + resultadoStringFormat(resultado2));
                } catch (CustomEx custom) {
                    System.out.println(custom.getMessage());
                }
            }
        });

        panelSimbolo.add(mas);
        panelSimbolo.add(menos);
        panelSimbolo.add(slash);
        panelSimbolo.add(asterisco);
        panelSimbolo.add(exponente);
        panelSimbolo.add(raizCuadrada);
        panelSimbolo.add(raizCubica);
        
        panel.add(panelOperador1);
        panel.add(panelSimbolo);
        panel.add(panelOperador2);
        panel.add(panelResultado);

        frame.add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static JButton crearYEscalarBotonImagen(String ruta) {
        Image img = new ImageIcon(ruta).getImage();
        img = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(img);

        JButton boton = new JButton(imagen);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
        return boton;
    }

    public static void verificacion(JTextField operador, String numOp) throws CustomEx {
        if (operador.getText().equals("")) {
            throw new CustomEx("Operador "+ numOp +": Está vacío");
        } else if (!operador.getText().matches("\\d+(\\.\\d+)?")) {
            throw new CustomEx("Operador "+ numOp +": No és un número");
        }
    }

    public static void mostrarMensaje(JFrame frame, JPanel panelResultado, double op1, double op2, String operador, String mensajeMostrar) {
        panelResultado.removeAll();
        String resultados[] = mensajeMostrar.split("%");

        if (resultados.length > 1) {
            JLabel resultado1 = new JLabel(operador + " de " + resultadoStringFormat(op1) + " = " + resultados[0]);
            resultado1.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
            JLabel resultado2 = new JLabel(operador + " de " + resultadoStringFormat(op2) + " = " + resultados[1]);
            resultado2.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
            panelResultado.add(resultado1);
            panelResultado.add(resultado2);
        } else {
            JLabel resultado = new JLabel(resultadoStringFormat(op1) + " " + operador + " " + resultadoStringFormat(op2) + " = "  + mensajeMostrar);
            resultado.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
            panelResultado.add(resultado);
        }
        panelResultado.revalidate();
        panelResultado.repaint();

        frame.pack();
    }

    public static String resultadoStringFormat(double resultado) {
        DecimalFormat formato = new DecimalFormat("#.###");
        if (resultado % ((int) resultado) == 0) {
            return String.valueOf((int) resultado);
        } else {
            return formato.format(resultado);
        }
    }
}