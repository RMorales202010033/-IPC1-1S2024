package clase7;

/**
 *
 * @author Rodolfo Morales - 202010033
 */
// Librerias
import java.awt.Image;
import static java.lang.Thread.sleep;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class Moto extends Thread {

    Game game;
    int posx, posy;
    Gas gas;
    Reloj reloj;
    private volatile boolean running = true;

    public Moto(Game game, Gas gas, Reloj reloj) {
        this.gas = gas;
        this.game = game;
        this.reloj = reloj;
        posx = this.game.lbl0.getX();
        posy = this.game.lbl0.getY();
        this.game.moto = this.game.lbl0.getBounds();
    }

    public void run() {
        try {
            while (running) {
                sleep(250); // ms

                if (this.gas.posx > posx) {
                    posx += 8;
                } else if (this.gas.posx < posx) {
                    posx -= 8;
                }

                if (this.gas.posy + 50 > posy + 150) {
                    posy += 8;
                } else if (this.gas.posy + 50 < posy + 150) {
                    posy -= 8;
                }

                this.game.lbl0.setLocation(posx, posy);
                this.game.moto = this.game.lbl0.getBounds();

                if (this.game.moto.intersects(this.game.item)) {
                    sleep(250);
                    this.game.lbl1.setBounds(this.gas.posx - 25, this.gas.posy - 25, 100, 100);
                    ImageIcon img = new ImageIcon(getClass().getResource("../imgs/eat.gif"));
                    Image nuevo = img.getImage().getScaledInstance(this.game.lbl1.getWidth(), this.game.lbl1.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon render = new ImageIcon(nuevo);
                    this.game.lbl1.setIcon(render);
                    this.game.repaint();
                    sleep(800);
                    SwingUtilities.invokeLater(() -> {
                        this.game.remove(this.game.lbl1);
                        this.game.remove(this.game.lbl2);
                        this.game.repaint();
                        this.game.btn1.setEnabled(true);
                    });
                    this.gas.stopThread();
                    this.reloj.detenerReloj();
                    stopThread();

                }
                this.game.repaint();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void stopThread() {
        running = false;
    }
}
