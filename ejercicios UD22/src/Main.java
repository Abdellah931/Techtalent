import UD22_MVC.Ejercicio3.Vistas.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    public Main() {
        setTitle("Gestión de Científicos, Proyectos y Asignaciones");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        String[] tables = {"Científicos", "Proyectos", "Asignado_a"};
        JComboBox<String> tableSelector = new JComboBox<>(tables);
        panel.add(tableSelector);

        JButton btnCRUD = new JButton("Seleccionar acción");
        btnCRUD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTable = (String) tableSelector.getSelectedItem();
                if (selectedTable != null) {
                    mostrarMenuCRUD(selectedTable);
                }
            }
        });
        panel.add(btnCRUD);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(btnSalir);

        add(panel);
    }

    private void mostrarMenuCRUD(String table) {
        String[] options = {"Crear", "Leer", "Actualizar", "Eliminar", "Volver"};
        int choice = JOptionPane.showOptionDialog(this, "Seleccione una opción para " + table + ":", "Menú " + table,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        switch (table) {
            case "Científicos":
                handleCientificos(choice);
                break;
            case "Proyectos":
                handleProyectos(choice);
                break;
            case "Asignado_a":
                handleAsignados(choice);
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private void handleCientificos(int choice) {
        switch (choice) {
            case 0:
                new CrearCientificoView().setVisible(true);
                break;
            case 1:
                new LeerCientificoView().setVisible(true);
                break;
            case 2:
                new ActualizarCientificoView().setVisible(true);
                break;
            case 3:
                new EliminarCientificoView().setVisible(true);
                break;
            case 4:
                break; // Volver
            default:
                System.out.println("Opción no válida");
        }
    }

    private void handleProyectos(int choice) {
        switch (choice) {
            case 0:
                new CrearProyectoView().setVisible(true);
                break;
            case 1:
                new ListarProyectosView().setVisible(true);
                break;
            case 2:
                new ActualizarProyectoView().setVisible(true);
                break;
            case 3:
                new EliminarProyectoView().setVisible(true);
                break;
            case 4:
                break; // Volver
            default:
                System.out.println("Opción no válida");
        }
    }

    private void handleAsignados(int choice) {
        switch (choice) {
            case 0:
                new CrearAsignadoAView().setVisible(true);
                break;
            case 1:
                new LeerAsignadoAView().setVisible(true);
                break;
            case 2:
                new ActualizarAsignadoAView().setVisible(true);
                break;
            case 3:
                new EliminarAsignadoAView().setVisible(true);
                break;
            case 4:
                break; // Volver
            default:
                System.out.println("Opción no válida");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}