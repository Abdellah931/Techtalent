import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ejercicio3minicuesta extends JFrame {
    private JRadioButton windowsRadio, linuxRadio, macRadio;
    private JCheckBox programacionCheck, diseñoCheck, administracionCheck;
    private JSlider horasSlider;
    private JButton enviarButton;

    public ejercicio3minicuesta() {
        setTitle("Mini Encuesta");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        // Sistema Operativo
        JPanel sistemaOperativoPanel = new JPanel();
        sistemaOperativoPanel.setBorder(BorderFactory.createTitledBorder("Elije un sistema operativo"));
        windowsRadio = new JRadioButton("Windows");
        linuxRadio = new JRadioButton("Linux");
        macRadio = new JRadioButton("Mac");
        ButtonGroup sistemaOperativoGroup = new ButtonGroup();
        sistemaOperativoGroup.add(windowsRadio);
        sistemaOperativoGroup.add(linuxRadio);
        sistemaOperativoGroup.add(macRadio);
        sistemaOperativoPanel.add(windowsRadio);
        sistemaOperativoPanel.add(linuxRadio);
        sistemaOperativoPanel.add(macRadio);
        panel.add(sistemaOperativoPanel);

        // Especialidad
        JPanel especialidadPanel = new JPanel();
        especialidadPanel.setBorder(BorderFactory.createTitledBorder("Elije tu especialidad"));
        programacionCheck = new JCheckBox("Programación");
        diseñoCheck = new JCheckBox("Diseño gráfico");
        administracionCheck = new JCheckBox("Administración");
        especialidadPanel.add(programacionCheck);
        especialidadPanel.add(diseñoCheck);
        especialidadPanel.add(administracionCheck);
        panel.add(especialidadPanel);

        // Horas dedicadas
        JPanel horasPanel = new JPanel();
        horasPanel.setBorder(BorderFactory.createTitledBorder("Horas dedicadas en el ordenador"));
        horasSlider = new JSlider(0, 10, 0);
        horasSlider.setMajorTickSpacing(1);
        horasSlider.setPaintTicks(true);
        horasSlider.setPaintLabels(true);
        horasPanel.add(horasSlider);
        panel.add(horasPanel);

        // Botón de enviar
        enviarButton = new JButton("Enviar");
        enviarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarResultados();
            }
        });
        panel.add(enviarButton);

        add(panel);
    }

    private void mostrarResultados() {
        StringBuilder resultados = new StringBuilder("Resultados de la encuesta:\n");

        // Sistema Operativo seleccionado
        if (windowsRadio.isSelected()) {
            resultados.append("- Sistema Operativo: Windows\n");
        } else if (linuxRadio.isSelected()) {
            resultados.append("- Sistema Operativo: Linux\n");
        } else if (macRadio.isSelected()) {
            resultados.append("- Sistema Operativo: Mac\n");
        }

        // Especialidades seleccionadas
        resultados.append("- Especialidades: ");
        if (programacionCheck.isSelected()) {
            resultados.append("Programación ");
        }
        if (diseñoCheck.isSelected()) {
            resultados.append("Diseño gráfico ");
        }
        if (administracionCheck.isSelected()) {
            resultados.append("Administración ");
        }
        resultados.append("\n");

        // Horas dedicadas
        resultados.append("- Horas dedicadas en el ordenador: ").append(horasSlider.getValue()).append("\n");

        JOptionPane.showMessageDialog(this, resultados.toString(), "Resultados", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ejercicio3minicuesta miniEncuesta = new ejercicio3minicuesta();
                miniEncuesta.setVisible(true);
            }
        });
    }
}
