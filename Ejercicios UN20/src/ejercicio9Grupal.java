import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
    private int pairsFound = 0; // Contador de parejas encontradas
    private JPanel panelParejas = new JPanel();
    private JPanel panelBotones = new JPanel();
    private JLabel parejasCont;
    private StringBuilder TotalParejas = new StringBuilder ();
    private int intentos = 0;
    
    public ejercicio9Grupal() {
        // Configuración de la ventana
        setTitle("Memorama de Colores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints pos = new GridBagConstraints();
        pos.fill = pos.BOTH;
        pos.weightx = 1;
        pos.weightx = 1;
        pos.gridx = 0;

        // Inicializar colores de los botones
        Color[] colorArray = {
            Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW,
            Color.ORANGE, Color.CYAN, Color.MAGENTA, Color.PINK
        };

        for (Color color : colorArray) {
            colors.add(color);
            colors.add(color);
        }
        Collections.shuffle(colors);
        
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        panel.setBackground(Color.CYAN);
        JLabel titul = new JLabel("Enecuetra los dictadores con Abdellah :)");
        titul.setFont(new Font(Font.SERIF, Font.PLAIN, 35));
        titul.setForeground(Color.MAGENTA);
        panel.add(titul);
        pos.gridy = 0;
        add(panel, pos);
        
     
        ParejasTotales(TotalParejas, pairsFound);
        pos.gridy = 1;
        add(panelParejas, pos);
       
        panelBotones.setPreferredSize(new Dimension(400, 400));
        panelBotones.setLayout(new GridLayout(4, 4));
     
        
        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton();
            buttons[i].setBackground(Color.GRAY);
            buttons[i].addActionListener(new ButtonClickListener());
            panelBotones.add(buttons[i]);
        }
        pos.gridy = 2;
        add(panelBotones, pos);
        pack();
        setLocationRelativeTo(null);
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
                	intentos++;
                    secondButton = clickedButton;
                    secondColor = colors.get(index);
                    isComparing = true; // Indicar que estamos en estado de comparación

                    if (firstColor.equals(secondColor)) {
                    	intentos = 0;
                        firstButton.setEnabled(false);
                        secondButton.setEnabled(false);
                        
                        pairsFound++; // Incrementar el contador de parejas encontradas
                        panelParejas.removeAll();
                        ParejasTotales(TotalParejas, pairsFound);
                        panelParejas.revalidate();
                        panelParejas.repaint();
                        resetSelection();

                        if (pairsFound == 8) { // Verificar si todas las parejas han sido encontradas
                            JOptionPane.showMessageDialog(null, "¡Enhorabuena! Has encontrado todas las parejas.");
                        }
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
                if(intentos >= 5) {
                	intentos();
                	pairsFound = 0;
                    panelParejas.removeAll();
                    ParejasTotales(TotalParejas, pairsFound);
                    panelParejas.revalidate();
                    panelParejas.repaint();

                }
            }
        }

        private void resetSelection() {
            firstButton = null;
            secondButton = null;
            isComparing = false;
        }
    }
    
    public void ParejasTotales (StringBuilder TotalParejas, int pairsFound) {
    	panelParejas.setLayout(new BoxLayout(panelParejas, BoxLayout.Y_AXIS));
	    TotalParejas = new StringBuilder (" Voila! Cantidad de parejas &encontradas ");
	    TotalParejas.append(pairsFound).append("/8");
	    String[] textos = TotalParejas.toString().split("&");
	    JLabel parejasCont1 = new JLabel(textos[0]);
	    JLabel parejasCont2 = new JLabel(textos[1]);
	    parejasCont1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
	    parejasCont2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
	    parejasCont1.setAlignmentX(Component.CENTER_ALIGNMENT);   
	    parejasCont2.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    panelParejas.add(parejasCont1);
	    panelParejas.add(parejasCont2);
    }
    
    public void intentos () {
    	for (Object o : panelBotones.getComponents()) {
    		if (o instanceof JButton) {
    			JButton Button = (JButton)o;
    			Button.setBackground(Color.gray);
    			Button.setEnabled(true);
    		}
    	}
    	panelBotones.repaint();
    	panelBotones.revalidate();
    	intentos = 0;
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