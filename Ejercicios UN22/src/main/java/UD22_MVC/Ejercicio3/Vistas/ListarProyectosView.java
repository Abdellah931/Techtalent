package UD22_MVC.Ejercicio3.Vistas;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import UD22_MVC.Ejercicio3.Controller.ProyectoController;
import UD22_MVC.Ejercicio3.Modelo.Proyecto;

public class ListarProyectosView extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;

    public ListarProyectosView() {
        setTitle("Listar Proyectos");
        setLayout(new BorderLayout());

        String[] columnNames = {"ID Proyecto", "Nombre", "Horas"};
        List<Proyecto> proyectos = ProyectoController.getAllProyectos();
        String[][] data = new String[proyectos.size()][3];
        
        for (int i = 0; i < proyectos.size(); i++) {
            data[i][0] = proyectos.get(i).getIdProyecto();
            data[i][1] = proyectos.get(i).getNombre();
            data[i][2] = String.valueOf(proyectos.get(i).getHoras());
        }

        table = new JTable(data, columnNames);
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}