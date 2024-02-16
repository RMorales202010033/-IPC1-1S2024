package practica1_ejemplo;

// APARTADO DE IMPORTACIONES
// Importacion scanner
import java.util.Scanner;
// Importacion Random
import java.util.Random;

/**
 *
 * @author Rodolfo Morales - 202010033
 */
public class Practica1_ejemplo {

    // VARIABLES GLOBALES
    // Variable para llevar el control de la opcion del menu
    static int option = 0;
    // Matriz numerica que lleva las posiones del tablero
    static int[][] board = new int[8][8];
    // Matriz de tipo char la cual sirve para llevar el control de las penalizaciones
    static char[][] penalties = new char[8][8];
    // Variable que sirve para representar el peon que se mueve en el tablero
    static char symbol = '@';
    // Variable que lleva el control de la fila actual donde está el peon
    static int currentRow = 7;
    // Variable que lleva el control de la columna actual donde está el peon
    static int currentColumn = 0;
    // Variable que lleva el control de la posición actual en el tablero
    static int currentPosition = 1;

    public static void main(String[] args) {
        // Este metodo le agrega los valores de las posiciones al tablero para carnets impares
        boardPositionsImpares();
        // Este metodo le agrega los valores de las posiciones al tablero para carnets pares
        // boardPositionsPares(); // Recuerden cambiar el valor de current column a 7 para la posicion inicial
        // Este metodo asigna las penalizaciones a la matriz
        penaltyPositions();

        // DO-WHILE PARA MANEJO DEL MENU Y SUS OPCIONES
        do {
            if (option == 0) { // Opcion para imprimir y seleccionar una opcion
                mainMenu();
                System.out.println("=========================================");
                System.out.println("");
            } else if (option == 1) { // Opcion para iniciar un nuevo juego
                startGame();
                System.out.println("");
            }
        } while (option != 4); // Salir del meny y finalizar ejecucion del programa
        System.out.println("Gracias por jugar :D");
    }

    public static void mainMenu() {
        // Crear instancia objeto scanner
        Scanner sc = new Scanner(System.in);

        System.out.println("=============== MAIN MENU ===============");
        System.out.println("1. Start game");
        System.out.println("2. Resume game");
        System.out.println("3. Show student info.");
        System.out.println("4. Exit game");
        System.out.println("-----------------------------------------");
        System.out.print("Choose an option: ");
        // Try-catch nos sirve por si ocurre algún error, este no finalice la ejecución del programa y realice lo que está en el bloque del catch
        try {
            // Obtener la opcion de tipo numerica
            option = sc.nextInt();
            System.out.println("-----------------------------------------");
            // Validar si la opcion existe
            if (option != 1 && option != 2 && option != 3 && option != 4) {
                System.out.println("Error, you must choose a correct option.");
                option = 0;
            }
        } catch (Exception e) { // Imprimir error y volver al menu principal en caso ocurra un error
            System.out.println("-----------------------------------------");
            System.out.println("Error, you must choose a correct option.");
            option = 0;
        }
    }

    public static void startGame() {
        // Variable que guarda el valor que el usuario escoje durante el juego
        char gameOption = 'n';
        // DO-WHILE para ejecutar el tablero infinitamente, hasta que se cumplan las validacioens que finalicen el juego
        do {
            if (gameOption == 'n') { // Este bloque imprime el tablero siempre actualizado
                System.out.println("========================================================== LET'S GO!! ==========================================================");
                showBoard();
                gameOption = gameMenu();
            } else if (gameOption == 'd') { //Este bloque funciona para el dado
                Random random = new Random(); // Instancia del objeto Random
                int dado = random.nextInt(5) + 2; // 2 limite inferior y para el limite superior siempre se pone el rango superior -1, osea si el limite es 6 -> 6 -1 = 5
                System.out.println("Te has movido " + dado + " espacios.");
                // Actualizar el valor de la posicion actual
                currentPosition += dado;
                // Validar si la posicion actual es superior a la casilla 64 para finalizar el juego
                if (currentPosition > 64) {
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Bien jugado");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++");
                    break; // El break nos ayuda a salir del bucle mas cercano
                }

                // Tag para salir de varios bucles a la vez
                outerLoop:
                // ESTOS FOR SE ENCARGAN DE ACTUALIZAR LA FILA Y COLUMNA ACTUAL A LA POSICION DONDE ESTA CURRENT POSITION
                // For encargado de manejar filas
                for (int i = board.length - 1; i >= 0; i--) {
                    if ((i % 2) != 0) { // Validar si es fila impar
                        // For encargado de las columnas
                        for (int j = 0; j < board[i].length; j++) { // Recorrer las columnas de izquierda a derecha
                            if (board[i][j] == currentPosition) { // Validar si los valores de las posiciones son iguales
                                currentRow = i;
                                currentColumn = j;
                                break outerLoop; // Salir hasta la etiqueta especificada
                            }
                        }
                    } else {
                        for (int j = board[i].length - 1; j >= 0; j--) {  // Recorrer las columnas de derecha a izquierda
                            if (board[i][j] == currentPosition) {  // Validar si los valores de las posiciones son iguales
                                currentRow = i;
                                currentColumn = j;
                                break outerLoop;
                            }
                        }
                    }
                }
                // Aqui seguiria ejecutandose el codigo luego del break con la tag outerLoop
                if (penalties[currentRow][currentColumn] == '#') { // Validar si la posicion actual de la matriz de penalties tiene como valor un #
                    System.out.println("*****************************************");
                    System.out.println("!Has caído en una penalización!");
                    if (currentRow == 7 || currentRow == 6) {
                        // Codigo para realizar las penalizaciones faciles
                    } else if (currentRow == 5 || currentRow == 4 || currentRow == 3) {
                        // Codigo para realizar las penalizaciones intermedias
                    } else if (currentRow == 2 || currentRow == 1 || currentRow == 0) {
                        // Codigo para realizar las penalizaciones avanzadas
                    }
                    System.out.println("*****************************************");
                }

                gameOption = 'n';
                System.out.println("=========================================");
                System.out.println("");
            }
        } while (gameOption != 'p'); // Salir del ciclo si se escoje la letra p
        option = 0;
        System.out.println("=========================================");
        System.out.println("");
    }

    public static char gameMenu() {
        // Pedir la opcion al usuario que sea de tipo char
        Scanner sc = new Scanner(System.in);
        System.out.println("(d) Tirar dado");
        System.out.println("(p) Retornar al menu principal");
        System.out.println("-----------------------------------------");
        System.out.print("Escoja una opcion:");
        try {
            char gameOption = sc.next().charAt(0);
            System.out.println("-----------------------------------------");
            if (gameOption != 'd' && gameOption != 'p') { // Validar si la opcion seleccionada existe
                System.out.println("Error, debe escojer una opcion correcta");
                System.out.println("");
                return 'n';
            } else {
                return gameOption;
            }
        } catch (Exception e) { // Ejecuta el bloque si ocurre un error
            System.out.println("-----------------------------------------");
            System.out.println("Error, debe elegir una opcion correcta");
            System.out.println("");
            return 'n';
        }
    }

    public static void showBoard() {
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

    public static void boardPositionsImpares() {
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

    public static void boardPositionsPares() {
        // Contador para asignar la posicion en el tablero
        int position = 1;
        // For encargado de recorrer las filas de abajo para arriba
        for (int i = board.length - 1; i >= 0; i--) {
            // Validar si es fila impar
            if ((i % 2) != 0) {
                // Recorrer las columnas de derecha a izquierda
                for (int j = board[i].length - 1; j >= 0; j--) {
                    // Ir asignando el numero de posicion del tablero
                    board[i][j] = position;
                    position++;
                }
            } else {
                // Recorrer las columnas de izquierda a derecha
                for (int j = 0; j < board[i].length; j++) {
                    // Ir asignando el numero de posicion del tablero
                    board[i][j] = position;
                    position++;
                }
            }
        }
    }

    public static void penaltyPositions() {
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
