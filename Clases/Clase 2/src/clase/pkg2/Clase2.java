package clase.pkg2;

import java.util.Random;

/**
 *
 * @author Rodolfo Morales 202010033
 */
public class Clase2 {

    public static void main(String[] args) {
        // ARREGLOS UNIDIMENSIONALES
        // Creaci[on arreglo unidimensional de numeros enteros con 5 elementos
        int[] arregloEnteros = new int[5];

        // Visualizar el contenido del arreglo unidimensional
        // nombre_de_nuestro_vector.length -> La funcion length nos retornara el largo de nuestro vector (En este caso seria 5)
        for (int i = 0; i < arregloEnteros.length; i++) {
            System.out.println("Elemento en la posicion " + i + ": " + arregloEnteros[i]);
        }

        // Asignacion de valores a los elementos del arreglo
        arregloEnteros[0] = 10;
        arregloEnteros[1] = 20;
        arregloEnteros[2] = 30;
        arregloEnteros[3] = 40;
        arregloEnteros[4] = 50;

        System.out.println("-----------------------------------------------------");
        // Visualizar el contenido del arreglo unidimensional
        for (int i = 0; i < arregloEnteros.length; i++) {
            System.out.println("Elemento en la posición " + i + ": " + arregloEnteros[i]);
        }

        // Otra forma de declarar un arreglo unidimensional
        int[] arregloEnteros2 = {1, 2, 3, 4, 5};

        // Visualizar valores del vector usando for-each
        System.out.println("-----------------------------------------------------");
        for (int elemento : arregloEnteros2) {
            System.out.println("Elemento: " + elemento);
        }

        // ARREGLOS BIDIMIENSIONALES
        // Creacion matriz 8x8
        int[][] matriz = new int[8][8];

        // Asignar valores a los elementos de la matriz usando bucles for
        int contador = 1;
        // El primer for nos sirve para el manejo de filas
        // El segundo for nos sirve para el manejo de columnas
        for (int i = 0; i < matriz.length; i++) { // matriz.length -> 8 filas
            for (int j = 0; j < matriz[i].length; j++) { // matriz[i].length -> 8 columnas
                matriz[i][j] = contador;
                contador++;
            }
        }

        System.out.println("-----------------------------------------------------");
        // Imprimir matriz usando for-each
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < matriz.length; i++) { // matriz.length -> 8 filas
            for (int j = 0; j < matriz[i].length; j++) { // matriz[i].length -> 8 columnas
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // Otra forma de declarar una matriz
        int[][] matriz2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        // Imprimir los valores que conforman la diagonal de la matriz2
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < matriz2.length; i++) {
            System.out.println(matriz2[i][i] + " ");
        }

        // Función recursiva que retorna el factorial de un número
        System.out.println("-----------------------------------------------------");
        int numero = 5;
        long resultado = factorial(numero); // El valor que retorne la función factorial se le asignará a la variable resultado.
        System.out.println("El factorial de " + numero + " es: " + resultado);

        // LLAMADA DE MÉTODO SIN PARÁMETROS
        printMenu();

        // LLAMADA DE MÉTODO CON PARÁMETROS
        printNewMenu("5. Mostrar tabla de multiplicación");

        // LLAMADA DE FUNCIÓN SIN PARÁMETROS
        System.out.println("El número aleatorio es: " + getNumber());

        // LLAMADA DE FUNCIÓN CON PARÁMETROS
        int resultadoSuma = Suma(5, 4);
        System.out.println("El resultado de la suma es: " + resultadoSuma);
    }

    // MÉTODO SIN PARÁMETROS
    static void printMenu() {
        System.out.println("========================");
        System.out.println("MAIN MENU");
        System.out.println("1. Realizar suma");
        System.out.println("2. Realizar resta");
        System.out.println("3. Realizar multiplicacion");
        System.out.println("4. Realizar division");
        System.out.println("========================");
    }

    // MÉTODO CON PARÁMETROS
    static void printNewMenu(String newOption) {
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("MAIN MENU");
        System.out.println("1. Realizar suma");
        System.out.println("2. Realizar resta");
        System.out.println("3. Realizar multiplicacion");
        System.out.println("4. Realizar division");
        System.out.println(newOption);
        System.out.println("++++++++++++++++++++++++++++++++++++");
    }

    // FUNCIÓN SIN PARÁMETROS
    static int getNumber() {
        // Crear una instancia de la clase Random
        Random random = new Random();
        // Generar un número aleatorio en un rango específico(por ejemplo, entre 1 y 100)
        int numeroEnRango = random.nextInt(100) + 1;
        return numeroEnRango;
    }

    // FUNCIÓN CON PARÁMETROS
    static int Suma(int n1, int n2) {
        return (n1 + n2);
    }

    // FUNCIÓN RECURSIVA
    static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    // Lógica de cómo funciona la recursividad simple en la función factorial
    // El guion bajo (_) significa que en ese momento no se sabe el valor que retorna la función factorial
    // numero = 5
    // n = 5
    // -> 5 * _(24) = 120
    // n = 4
    // -> 4 * _(6) = 24
    // n = 3
    // -> 3 * _(2) = 6
    // n = 2
    // -> 2 * _(1) = 2
    // n = 1
    // -> 1
}
