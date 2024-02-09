package clase3;

import java.util.Random;

/**
 *
 * @author Rodolfo Morales - 202010033
 */
public class Tablero {

    // Creación variables privadas de la clase (Estas variables no pueden ser accedidas por otras clases)
    private int[][] board = new int[8][8];
    private char symbol = '@';
    private char[][] penalties = new char[8][8];
    private int currentRow = 7;
    private int currentColumn = 0;

    // Creación constructor que no recibe ningún parámetro
    public Tablero() {
        // Ejecución funciones privadas de la clase, estas se ejecutan cuando se crea la instancia de un nuevo objeto
        boardPositionsImpares();
        penaltyPositions();
    }

    // Función pública, esta función puede ser usada en otras clases media vez se tenga la instancia de un objeto de tipo Tablero
    public void showBoard() {
        // For encargado del manejo de filas
        for (int i = 0; i < board.length; i++) {
            // For encargado del manejo de columnas
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("\t" + penalties[i][j] + board[i][j] + "\t|"); // Imprime la primer fila la que contiene:  #posicion   |
            }
            System.out.println("");
            // For encargado del manejo de columnas
            for (int j = 0; j < board[i].length; j++) {
                if (i == currentRow && j == currentColumn) { // Valida si la fila y columna actual coinciden para imprimir @
                    System.out.print("\t" + symbol + "\t|"); // Imprime la segunda fila la que contiene:  @   |
                } else {
                    System.out.print("\t\s" + "\t|"); // Imprime la segunda fila la que contiene:      |
                }
            }
            System.out.println("");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    private void boardPositionsImpares() {
        // Contador para asignar la posicion en el tablero
        int position = 1;
        // For encargado de recorrer las filas de abajo para arriba
        for (int i = board.length - 1; i >= 0; i--) {
            // Validar si es fila impar
            if ((i % 2) != 0) {
                // Recorrer las columnas de izquierda a derecha
                for (int j = 0; j < board[i].length; j++) {
                    // Ir asignando el numero de posicion del tablero
                    board[i][j] = position;
                    position++;
                }
            } else {
                // Recorrer las columnas de derecha a izquierda
                for (int j = board[i].length - 1; j >= 0; j--) {
                    // Ir asignando el numero de posicion del tablero
                    board[i][j] = position;
                    position++;
                }
            }
        }
    }

    private void penaltyPositions() {
        // Recorrer las filas de la matriz de penalizaciones
        for (int i = 0; i < penalties.length; i++) {
            // Generar numero random para obtener de manera aleatoria la cantidad de penalizaciones por fila
            Random random = new Random();
            int numberPenalties = random.nextInt(3) + 2; // Limite inferior = 2 y limite superior = 3 + 1 = 4
            // Vector para guardar las posiciones donde se asignaran las penalizaciones
            int[] vector = new int[numberPenalties]; // numberPenalties = 3; [4,2,7]
            int cont = 0;
            boolean v1 = true;
            // Llevar el control de cuantas posiciones de penalizacion se han asignado al vector sin que se repitan
            while (cont < numberPenalties) {
                int positionPenalty = random.nextInt(7) + 1; // Limite inferior = 1 y limite superior = 8, pero la formula es L.S - 1 = 7
                v1 = true;
                // Recorrer el vector
                for (int j = 0; j < vector.length; j++) {
                    if (positionPenalty == vector[j]) { // Validar si el valor de la posicion ya existe
                        v1 = false;
                        break;
                    } else if (vector[j] == 0) { // Validar si hay posicion disponible
                        vector[j] = positionPenalty; // Asignar el valor de la posicion al vector
                        break;
                    }
                }
                if (v1) { // Si la posicion fue asignada se incrementa el contador
                    cont++;
                }
            }
            // Recorrer el vector e ir asignando a las posiciones el caracter de penalizacion
            for (int j = 0; j < vector.length; j++) {
                penalties[i][vector[j] - 1] = '#';
            }
        }
    }
}
