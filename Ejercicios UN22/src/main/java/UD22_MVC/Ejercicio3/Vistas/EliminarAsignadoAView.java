package UD22_MVC.Ejercicio3.Vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import UD22_MVC.Ejercicio3.Controller.AsignadoAController;
import UD22_MVC.Ejercicio3.Modelo.AsignadoA;

public class EliminarAsignadoAView extends JFrame {
    private JComboBox<AsignadoA> asignadoAComboBox;
    private JButton submitButton;

    public EliminarAsignadoAView() {
        setTitle("Eliminar Asignación");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Seleccionar Asignación:"));
        asignadoAComboBox = new JComboBox<>();
        cargarAsignaciones();
        panel.add(asignadoAComboBox);

        submitButton = new JButton("Eliminar");
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                AsignadoA asignadoA = (AsignadoA) asignadoAComboBox.getSelectedItem();
                AsignadoAController controller = new AsignadoAController();
                controller.deleteAsignadoA(asignadoA.getIdProyecto(), asignadoA.getdni_cientifico());
                JOptionPane.showMessageDialog(null, "Asignación eliminada exitosamente!");
                dispose();
            }
        });

        add(panel);
    }

    private void cargarAsignaciones() {
        AsignadoAController controller = new AsignadoAController();
        List<AsignadoA> asignaciones = AsignadoAController.getAllAsignados();
        for (AsignadoA asignacion : asignaciones) {
            asignadoAComboBox.addItem(asignacion);
        }
}
}
