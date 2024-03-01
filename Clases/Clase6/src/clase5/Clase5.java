package clase5;

// Libraries
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author Rodolfo Morales
 */
public class Clase5 {

    static ArrayList<String[]> students = new ArrayList<>();
    static String[][] example_students = {
        {"202010033", "Rodolfo", "Morales", "jrodolfomc2002@gmail.com", "Masculino"},
        {"202010034", "Luisa", "Castillo", "luisac@gmail.com", "Femenino"},
        {"202010025", "Ayeser", "Juarez", "ayez@gmail.com", "Masculino"},
        {"202011535", "Esteban", "Ennati", "enox@gmail.com", "Masculino"},};
    static int code = 202300000;

    public static void main(String[] args) {
        try {
//            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LOGIN.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (String[] student : example_students) {
            students.add(student);
        }
        LOGIN login = new LOGIN();
    }

    public static Object[][] convertirDatos_students() {
        int filas = students.size();
        Object[][] arreglo_students = new Object[filas][5];
        for (int i = 0; i < filas; i++) {
            arreglo_students[i][0] = students.get(i)[0];
            arreglo_students[i][1] = students.get(i)[1];
            arreglo_students[i][2] = students.get(i)[2];
            arreglo_students[i][3] = students.get(i)[3];
            arreglo_students[i][4] = students.get(i)[4];
        }
        return arreglo_students;
    }

    public static void addStudent(String[] dataStudent) {
        students.add(dataStudent);
    }
}

// arraylist = [paciente1, paciente2, paciente3]
//paciente1.getCarnet()
// arreglo_students[i][0] = students.get(i).getCarnet()