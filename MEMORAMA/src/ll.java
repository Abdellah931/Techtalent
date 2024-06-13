

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Font;


public class ll extends JFrame {

    private JPanel cp;

    public ll() {
        setTitle("Ejercicio 1");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // Panel
        cp = new JPanel();
        cp.setLayout(null);
        setContentPane(cp);

        // Label
        JLabel label1 = new JLabel("Lorem Ipsum");
		label1.setBounds(10,20,300,60);
		cp.add(label1);

        // Label
        JLabel label2 = new JLabel("Tamaño del texto: ");
		label2.setBounds(10,100,105,20);
		cp.add(label2);

        // Spinner
        JSpinner spinner = new JSpinner();
        spinner.setBounds(120,100,50,20);
        cp.add(spinner);

        // Change Listener
		ChangeListener cl = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
                Font f = new Font(null, Font.PLAIN, (int) spinner.getValue());
                label1.setFont(f);
			}

		};

        spinner.addChangeListener(cl);
    }
}