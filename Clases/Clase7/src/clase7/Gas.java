package clase7;

/**
 *
 * @author Rodolfo Morales - 202010033
 */
// Librerias
import java.awt.Color;
import java.awt.Image;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Gas extends Thread {

    Game game;
    int posx;
    int posy;
    Moto moto;
    Reloj reloj;
    private volatile boolean running = true;

    public Gas(Game game, Reloj reloj) {
        this.game = game;
        this.reloj = reloj;
        Random random = new Random();
        this.posx = random.nextInt(625) + 10;
        this.posy = random.nextInt(200) + 380;
        this.game.lbl1 = new JLabel();
        this.game.lbl1.setBounds(this.posx, this.posy, 50, 50);
        ImageIcon img = new ImageIcon(getClass().getResource("../imgs/gasolina.png"));
        Image nuevo = img.getImage().getScaledInstance(this.game.lbl1.getWidth(), this.game.lbl1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon render = new ImageIcon(nuevo);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        this.game.lbl1.setBorder(border);
        this.game.lbl1.setIcon(render);
        this.game.lbl1.setVisible(true);
        this.game.add(this.game.lbl1);
        this.game.item = this.game.lbl1.getBounds();
        this.game.repaint();
    }

    public void run() {
        moto = new Moto(this.game, this, this.reloj);
        moto.start();
        try {
            while (running) {
                this.game.btn1.setEnabled(false);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void stopThread() {
        running = false;
    }

}
