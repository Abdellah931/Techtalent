package UD22_MVC.Ejercicio3.Vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import UD22_MVC.Ejercicio3.Controller.CientificoController;
import UD22_MVC.Ejercicio3.Modelo.Cientifico;
import java.util.List;
import java.awt.BorderLayout;


public class LeerCientificoView extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;

    public LeerCientificoView() {
        setTitle("Listar Cientificos");
        setLayout(new BorderLayout());

        String[] columnNames = {"DNI", "Nombre"};
        List<Cientifico> cientificos = CientificoController.getAllCientificos();
        String[][] data = new String[cientificos.size()][2];
        
        for (int i = 0; i < cientificos.size(); i++) {
            data[i][0] = cientificos.get(i).getdni_cientifico();
            data[i][1] = cientificos.get(i).getNomApels();
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