import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ejercicio2pelis extends JFrame {
    private JTextField textField;
    private JComboBox<String> peliculasComboBox;
    private List<String> peliculas;

    public ejercicio2pelis() {
        setTitle("CINE");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        textField = new JTextField(20);
        panel.add(textField);

        JButton botonAñadir = new JButton("Añadir");
        botonAñadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = textField.getText();
                if (!nombre.isEmpty()) {
                    peliculas.add(nombre);
                    actualizarComboBox();
                    textField.setText(""); // Limpiar el campo de texto
                } else {
                    JOptionPane.showMessageDialog(ejercicio2pelis.this, "Por favor ingrese el nombre de la película");
                }
            }
        });
        panel.add(botonAñadir);

        JLabel etiquetaop1 = new JLabel("Peliculas:");
        panel.add(etiquetaop1);

        peliculas = new ArrayList<>();
        peliculasComboBox = new JComboBox<>();
        panel.add(peliculasComboBox);

        add(panel);
    }

    private void actualizarComboBox() {
        peliculasComboBox.removeAllItems(); // Limpiar el combo box
        for (String pelicula : peliculas) {
            peliculasComboBox.addItem(pelicula); // Agregar cada película al combo box
        }
    }

    public static void main(String[] args) {
        ejercicio2pelis ventana = new ejercicio2pelis();
        ventana.setVisible(true);
    }
}

