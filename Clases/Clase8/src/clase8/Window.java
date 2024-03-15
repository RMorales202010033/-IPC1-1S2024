package clase8;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Rodolfo Morales - 202010033
 */
public class Window extends JFrame implements ActionListener {

    JButton btn1;
    JButton btn2;

    // Constructor de la clase Window
    public Window() {
        btn1 = new JButton("Lectura CSV");
        btn2 = new JButton("Serializacion y Escribe CSV");

        btn1.setBounds(20, 20, 240, 20);
        btn2.setBounds(20, 60, 240, 20);

        btn1.setVisible(true);
        btn1.setEnabled(true);
        btn1.addActionListener(this);
        this.add(btn1);

        btn2.setVisible(true);
        btn2.setEnabled(true);
        btn2.addActionListener(this);
        this.add(btn2);
        
        this.setTitle("Main Window");
        this.setLocationRelativeTo(null);
        this.setSize(300, 150);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            // Si se presiona el primer boton se realizará la lectura del archivo csv
            Clase8.lecturaCSV(this);
        } else if (ae.getSource() == btn2) {
            // Si se presiona el segundo botón se escribirá tanto el archivo csv como el serializado
            Clase8.serializacion();
        }
    }

}
