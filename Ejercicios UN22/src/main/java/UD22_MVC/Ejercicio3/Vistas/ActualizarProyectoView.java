package UD22_MVC.Ejercicio3.Vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import UD22_MVC.Ejercicio3.Controller.ProyectoController;
import UD22_MVC.Ejercicio3.Modelo.Proyecto;

public class ActualizarProyectoView extends JFrame {
    private JComboBox<String> idProyectoComboBox;
    private JTextField nombreField;
    private JTextField horasField;
    private JButton actualizarButton;

    public ActualizarProyectoView() {
        setTitle("Actualizar Proyecto");
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

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(30, 70, 100, 30);
        add(nombreLabel);

        nombreField = new JTextField();
        nombreField.setBounds(150, 70, 150, 30);
        add(nombreField);

        JLabel horasLabel = new JLabel("Horas:");
        horasLabel.setBounds(30, 110, 100, 30);
        add(horasLabel);

        horasField = new JTextField();
        horasField.setBounds(150, 110, 150, 30);
        add(horasField);

        actualizarButton = new JButton("Actualizar");
        actualizarButton.setBounds(150, 150, 100, 30);
        add(actualizarButton);

        // Listener para cargar los datos del proyecto seleccionado
        idProyectoComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String idProyecto = (String) idProyectoComboBox.getSelectedItem();
                    Proyecto proyecto = ProyectoController.getProyectoById(idProyecto);
                    if (proyecto != null) {
                        nombreField.setText(proyecto.getNombre());
                        horasField.setText(String.valueOf(proyecto.getHoras()));
                    }
                }
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idProyecto = (String) idProyectoComboBox.getSelectedItem();
                String nombre = nombreField.getText();
                int horas = Integer.parseInt(horasField.getText());
                ProyectoController.updateProyecto(idProyecto, nombre, horas);
                JOptionPane.showMessageDialog(null, "Proyecto actualizado con éxito!");
            }
        });

        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ActualizarProyectoView();
    }
}