import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class ejercicio9Grupal extends JFrame {
    private JButton[] buttons = new JButton[16];
    private ArrayList<Color> colors = new ArrayList<>();
    private JButton firstButton = null;
    private JButton secondButton = null;
    private Color firstColor;
    private Color secondColor;
    private boolean isComparing = false; // Variable para controlar el estado de comparación

    public ejercicio9Grupal() {
        // Configuración de la ventana
        setTitle("Memorama de Colores");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 4)); // 4x4 GridLayout

        // Inicializar colores de los botones
        Color[] colorArray = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW,
                              Color.ORANGE, Color.CYAN, Color.MAGENTA, Color.PINK};

        for (Color color : colorArray) {
            colors.add(color);
            colors.add(color);
        }
        Collections.shuffle(colors);

        // Crear y añadir botones
        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton();
            buttons[i].setBackground(Color.GRAY);
            buttons[i].addActionListener(new ButtonClickListener());
            add(buttons[i]);
        }
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isComparing) {
                // Si ya se están comparando dos botones, no permitir más clics
                return;
            }

            JButton clickedButton = (JButton) e.getSource();
            int index = -1;
            for (int i = 0; i < buttons.length; i++) {
                if (clickedButton == buttons[i]) {
                    index = i;
                    break;
                }
            }

            if (clickedButton.getBackground().equals(Color.GRAY) && firstButton != clickedButton) {
                clickedButton.setBackground(colors.get(index));

                if (firstButton == null) {
                    firstButton = clickedButton;
                    firstColor = colors.get(index);
                } else {
                    secondButton = clickedButton;
                    secondColor = colors.get(index);
                    isComparing = true; // Indicar que estamos en estado de comparación

                    if (firstColor.equals(secondColor)) {
                        firstButton.setEnabled(false);
                        secondButton.setEnabled(false);
                        resetSelection();
                    } else {
                        Timer timer = new Timer(500, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                firstButton.setBackground(Color.GRAY);
                                secondButton.setBackground(Color.GRAY);
                                resetSelection();
                            }
                        });
                        timer.setRepeats(false);
                        timer.start();
                    }
                }
            }
        }

        private void resetSelection() {
            firstButton = null;
            secondButton = null;
            isComparing = false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ejercicio9Grupal().setVisible(true);
            }
        });
    }
}
