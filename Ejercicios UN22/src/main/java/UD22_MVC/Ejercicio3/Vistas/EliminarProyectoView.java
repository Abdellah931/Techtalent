package UD22_MVC.Ejercicio3.Vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import UD22_MVC.Ejercicio3.Controller.ProyectoController;
import UD22_MVC.Ejercicio3.Modelo.Proyecto;

public class EliminarProyectoView extends JFrame {
    private JComboBox<String> idProyectoComboBox;
    private JButton eliminarButton;

    public EliminarProyectoView() {
        setTitle("Eliminar Proyecto");
        setLayout(null);

        JLabel idProyectoLabel = new JLabel("ID Proyecto:");
        idProyectoLabel.setBounds(30, 30, 100, 30);
        add(idProyectoLabel);

        idProyectoComboBox = new JComboBox<>();
        idProyectoComboBox.setBounds(150, 30, 150, 30);
        add(idProyectoComboBox);

        // Llenar el JComboBox con los IDs de los proyectos
        List<Proyecto> proyectos = ProyectoController.getAllProyectos();
        for (Proyecto proyecto : proyectos) {
            idProyectoComboBox.addItem(proyecto.getIdProyecto());
        }

        eliminarButton = new JButton("Eliminar");
        eliminarButton.setBounds(150, 70, 100, 30);
        add(eliminarButton);

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idProyecto = (String) idProyectoComboBox.getSelectedItem();
                ProyectoController.deleteProyecto(idProyecto);
                JOptionPane.showMessageDialog(null, "Proyecto eliminado con éxito!");
                // Actualizar el JComboBox después de eliminar el proyecto
                idProyectoComboBox.removeItem(idProyecto);
            }
        });

        setSize(350, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EliminarProyectoView();
    }
}