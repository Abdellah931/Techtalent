package UD22_MVC.Ejercicio3.Vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import UD22_MVC.Ejercicio3.Controller.CientificoController;
import UD22_MVC.Ejercicio3.Modelo.Cientifico;

public class ActualizarCientificoView extends JFrame {
    private JComboBox<String> cientificoComboBox;
    private JTextField nombreField;
    private JButton submitButton;

    public ActualizarCientificoView() {
        setTitle("Actualizar Científico");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Seleccionar Científico:"));
        cientificoComboBox = new JComboBox<>();
        cargarCientificos(); // Llena el JComboBox con los científicos disponibles
        panel.add(cientificoComboBox);

        panel.add(new JLabel("Nuevo Nombre y Apellidos:"));
        nombreField = new JTextField(20);
        panel.add(nombreField);

        submitButton = new JButton("Actualizar");
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dniCientifico = (String) cientificoComboBox.getSelectedItem(); // Obtiene el dni_cientifico seleccionado
                String nuevoNombre = nombreField.getText();
                CientificoController.updateCientifico(dniCientifico, nuevoNombre);
                JOptionPane.showMessageDialog(null, "Científico actualizado exitosamente!");
                nombreField.setText("");
            }
        });

        add(panel);
    }

    // Método para cargar los científicos disponibles en el JComboBox
    private void cargarCientificos() {
        List<Cientifico> cientificos = CientificoController.getAllCientificos();
        for (Cientifico cientifico : cientificos) {
            cientificoComboBox.addItem(cientifico.getdni_cientifico());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ActualizarCientificoView().setVisible(true);
            }
        });
    }
}