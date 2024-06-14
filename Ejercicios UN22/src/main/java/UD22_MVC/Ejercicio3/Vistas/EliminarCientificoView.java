package UD22_MVC.Ejercicio3.Vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import UD22_MVC.Ejercicio3.Controller.CientificoController;
import java.util.List;

public class EliminarCientificoView extends JFrame {
    private JComboBox<String> cientificoComboBox;
    private JButton submitButton;

    public EliminarCientificoView() {
        setTitle("Eliminar Científico");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Disposes only this window
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        CientificoController controller = new CientificoController();
        List<String> nombresCientificos = controller.getAllNombresCientificos(); // Obtener nombres de científicos

        panel.add(new JLabel("Seleccione el científico a eliminar:"));
        cientificoComboBox = new JComboBox<>(nombresCientificos.toArray(new String[0]));
        panel.add(cientificoComboBox);

        submitButton = new JButton("Eliminar");
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreSeleccionado = (String) cientificoComboBox.getSelectedItem();
                if (nombreSeleccionado != null) {
                    CientificoController controller = new CientificoController();
                    controller.deleteCientifico(nombreSeleccionado);
                    JOptionPane.showMessageDialog(null, "Científico eliminado exitosamente!");
                    dispose();  // Close this window after action
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un científico a eliminar.");
                }
            }
        });

        add(panel);
    }
}

