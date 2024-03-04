package clase5;

// Libraries
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.text.MessageFormat;
import java.util.Map;
import javax.swing.*;

public class MATERIA implements ActionListener {

    // Variable public contador
    public static int contador = 0;
    // JPanels
    JPanel jp1;
    // Labels
    JLabel lbl1;
    //Buttons
    JButton btn1;

    private String materia;
    private int id;

    public MATERIA(String materia) {
        this.materia = materia;
        this.id = contador;
        // Actualizar el valor del contador
        contador += 1;
        initComponents();
    }

    public void initComponents() {
        // Panel de la materia
        jp1 = new JPanel();
        jp1.setLayout(null);
        jp1.setBackground(Color.CYAN);
        jp1.setPreferredSize(new Dimension(590, 400));

        lbl1 = new JLabel(this.getMateria());
        lbl1.setFont(new Font("Kristen ITC", Font.BOLD, 20));

        // Calcular las coordenadas para centrar horizontalmente y verticalmente
        int labelWidth = 100;
        int labelHeight = 30;
        int panelWidth = 590;
        int panelHeight = 400;

        int x = (panelWidth - labelWidth) / 2;
        int y = (panelHeight - labelHeight) / 2;

        lbl1.setBounds(x, 165, labelWidth, labelHeight);
        lbl1.setVerticalAlignment(SwingConstants.CENTER);
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        jp1.add(lbl1);

        // Button
        btn1 = new JButton("Id materia");

        // Calcular coordenadas para centrar horizontalmente y verticalmente
        int buttonWidth = 100;
        int buttonHeight = 30;

        int x1 = (panelWidth - buttonWidth) / 2;
        int y1 = (panelHeight - buttonHeight) / 2;

        btn1.setBounds(x1, 205, buttonWidth, buttonHeight);
        btn1.setVisible(true);
        btn1.setEnabled(true);
        btn1.addActionListener(this);
        jp1.add(btn1);
        
        jp1.setVisible(true);
    }
    
    public JPanel getPanel(){
        return jp1;
    }

    /**
     * @return the materia
     */
    public String getMateria() {
        return materia;
    }

    /**
     * @param materia the materia to set
     */
    public void setMateria(String materia) {
        this.materia = materia;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            System.out.println("El id del curso de " + this.getMateria() + " es: " + this.getId());
        }
    }

}
