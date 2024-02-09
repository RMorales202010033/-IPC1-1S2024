package clase3;

/**
 *
 * @author Rodolfo Morales - 202010033
 */
public class Clase3 {

    static boolean v1 = true;

    public static void main(String[] args) {
        int contador = 0;
        while (contador < 10) {
            System.out.println("Numero actual: " + (contador + 1));
            contador = sumarUno(contador);
        }
        try {
            int[] myNumbers = {1, 2, 3};
            System.out.println(myNumbers[10]);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Something went wrong: " + aioobe.getMessage());
        }

        try {
            double division = 21 / 0;
        } catch (ArithmeticException ae) {
            System.out.println("Error: " + ae.getMessage());
        }
        try {
            String str = null;
            int length = str.length();
        } catch (NullPointerException ne) {
            System.out.println("Error: " + ne.getMessage());
        }

        try {
            Object obj = "Hola";
            Integer num = (Integer) obj;
        } catch (ClassCastException ce) {
            System.out.println("Error: " + ce.getMessage());
        }
        try {
            int[] arr = new int[5];
            System.out.println(arr[5]);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        // Instanceando ojbeto de tipo Tablero
        Tablero board = new Tablero();
        // Imprimir tablero con método publico de nuestro objeto
        board.showBoard();
    }

    public static int sumarUno(int valor) {
        return (valor + 1);
    }

}
