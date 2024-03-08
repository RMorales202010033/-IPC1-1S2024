package clase7;

/**
 *
 * @author Rodolfo Morales - 202010033
 */
// Librerias
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Game extends JFrame implements ActionListener {

    JLabel lbl0, lbl1, lbl2;
    JButton btn1;
    ImagenFondo ILogin = new ImagenFondo();
    Rectangle moto, item;

    public Game() {
        this.setContentPane(ILogin);
        //////////////// BTN1 ///////////////
        btn1 = new JButton("Give me Gas");
        btn1.setBounds(650, 580, 130, 30);
        btn1.setFont(new Font("Agency FB", Font.BOLD, 20));
        btn1.setVisible(true);
        btn1.addActionListener(this);
        this.add(btn1);

        //////////////// MOTO ///////////////
        lbl0 = new JLabel();
        lbl0.setBounds(40, 400, 150, 150);
        ImageIcon img = new ImageIcon(getClass().getResource("../imgs/moto.gif"));
        Image nuevo = img.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        lbl0.setHorizontalAlignment(SwingConstants.CENTER);
        lbl0.setVerticalAlignment(SwingConstants.CENTER);
        ImageIcon render = new ImageIcon(nuevo);
        lbl0.setIcon(render);
        lbl0.setVisible(true);
        this.add(lbl0);
        moto = lbl0.getBounds();
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        lbl0.setBorder(border);

        ///////////////////// MAIN WINDOW ////////////////////////////
        this.setTitle("Looking for gas");
        this.setLayout(null);
        this.setSize(800, 650);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            Reloj reloj = new Reloj(this);
            reloj.start();
            Gas gas = new Gas(this, reloj);
            gas.start();
            item = lbl1.getBounds();
        }
    }

    class ImagenFondo extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("../imgs/fondo.gif")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
