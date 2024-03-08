package clase7;

/**
 *
 * @author Rodolfo Morales - 202010033
 */
// Librerias
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Reloj extends Thread {

    Game game;
    private volatile boolean running = true;
    private int segundos = 0;
    private int minutos = 0;

    public Reloj(Game game) {
        this.game = game;
        this.game.lbl2 = new JLabel("Tiempo: 00:00");
        this.game.lbl2.setBounds(10, 10, 100, 20);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        this.game.lbl2.setBorder(border);
        this.game.lbl2.setVisible(true);
        this.game.add(this.game.lbl2);
        this.game.repaint();
    }

    @Override
    public void run() {
        while (running) {
            try {
                sleep(1000); // miliseconds
                segundos++;

                if (segundos == 60) {
                    segundos = 0;
                    minutos++;
                }
                actualizarReloj();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void detenerReloj() {
        running = false;
    }

    private void actualizarReloj() {
        String tiempo = String.format("%02d:%02d", minutos, segundos);
        this.game.lbl2.setText("Tiempo: " + tiempo);
    }

}
