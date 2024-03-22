package clase9;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Rodolfo Morales - 202010033
 */
public class Window extends JFrame implements ActionListener {

    // Creamos los objetos de nuestra interfaz
    JButton btn1;
    JButton btn2;
    JTextArea textArea;
    JComboBox<String> puntoInicial;
    JComboBox<String> puntoFinal;

    // Constructor de nuestra ventana
    public Window() {
        // Inicializamos nuestros objetos de interfaz
        btn1 = new JButton("Lectura CSV");
        btn2 = new JButton("Imprimir Listas");
        textArea = new JTextArea();
        textArea.setEditable(false);

        // Obtenemos las dimensiones de la pantalla
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // Le asignamos al textArea un scroll
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(100, 100, screenWidth - 200, screenHeight - 200);

        btn1.setBounds(20, 20, 240, 20);
        btn2.setBounds(20, 60, 240, 20);

        btn1.addActionListener(this);
        btn2.addActionListener(this);

        this.add(btn1);
        this.add(btn2);
        this.add(scrollPane);

        // Inicializamos los combobox y le agregamos un item
        puntoInicial = new JComboBox<>();
        puntoInicial.addItem("Select");
        puntoInicial.setBounds(300, 20, 200, 25);
        this.add(puntoInicial);

        puntoFinal = new JComboBox<>();
        puntoFinal.addItem("Select");
        puntoFinal.setBounds(540, 20, 200, 25);
        this.add(puntoFinal);

        this.setTitle("Main Window");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            Clase9.lecturaCSV(this);
        } else if (ae.getSource() == btn2) {
            Clase9.printLists(this);
        }
    }

}
