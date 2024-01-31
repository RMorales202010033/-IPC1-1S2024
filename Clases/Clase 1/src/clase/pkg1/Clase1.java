package clase.pkg1;

// Importaciones
// Importacion de scanner el cual servirá para los inputs
import java.util.Scanner;

/**
 *
 * @author Rodolfo Morales 202010033
 */
public class Clase1 {

    // VARIABLES GLOBALES
    // Si las variables globales se van a usar dentro de un método de tipo static, estas se deben declarar de tipo static igual
    static int option = 0;
    // Creando objeto de tipo scanner
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Hack: Si escriben sout y le dan a la tecla tab, les evitará escribir System.out.println        

        // VARIABLES LOCALES DE LA FUNCION MAIN
        // Este es el ejemplo para la clase numero 1 y dentro de esta funcion main ira el codigo del ejemplo
        /*
            Este es un comentario
            multilinea para nuestro primer ejemplo
         */
        // Declarando variable de tipo entero
        int edad = 21;
        // Declarando variable de tipo double (decimal)
        double precio = 500.90;
        System.out.println("Realizando casteo de decimal a entero: " + (int) precio);
        // Declarando variable de tipo float (decimal), se debe agregar la f al final para que java sepa que es de tipo flotante
        float precio1 = 34.5f;
        /*
        Declarando variable de tipo char (Un solo caracter, este puede ser letra, numero, caracter especial, si se desea poner la comilla
        simple por ejemplo se debe usar el caracter de escape: \).
        El caracter debe ir entre comillas simples.
         */
        char letra = 'r';
        /* Los String no son un tipo de dato primitivo, los string son un arreglo de caracteres por ejemplo si se tiene el string "mensaje"
        su equivalente seria:
           ['m','e','n','s','a','j','e']
        El objeto de tipo String se debe escribir como se muestra en el ejemplo de abajo, debido a que java declaró la clase de esa manera.
         */
        String mensaje = "Esta es la primer clase del semestre";
        // Declarando variables de tipo booleana esta acepta dos valores Verdadero (true) o Falso (false), estas son
        // palabras reservadas del lenguaje.
        boolean validar = false;
        boolean validar1 = true;

        // Usando signo de negacion
        int numNegativo = -4;

        int numPositivo = 5;
        int numPositivo2 = 3;

        // Realizando una suma
        int suma = numNegativo + numPositivo + numPositivo2;
        System.out.println("El resultado de la suma es: " + suma);
        // Realizando una suma desde el mismo println, recordar el uso de parentesis para que no se concatenen los números y se realice la operación
        System.out.println("El resultado de la suma es: " + (numPositivo + numPositivo2));

        // Realizando una resta
        int resta = numNegativo - numPositivo;
        System.out.println("El resultado de la resta es: " + resta);

        // Realizaqndo una multiplicacion
        int multiplicacion = numNegativo * numPositivo * (-numPositivo2);
        System.out.println("El resultado de la multiplicacion es: " + multiplicacion);

        // Realizando una division
        // Recordar que cuando se usa / se obtiene el cociente
        int cociente = numNegativo / 2;
        // Recordar que cuando se usa % obtenemos el residuo
        int residuo = numNegativo % 2;
        System.out.println("El cociente de la division es: " + cociente);
        System.out.println("El residuo de la division es: " + residuo);

        // OPERADORES COMPUESTOS
        int comp1 = 5;
        int comp2 = 3;
        // comp1++ => comp1 = comp1(5) + 1 = 6
        System.out.println("El valor de comp1 es: " + comp1++);
        // Orden en que se ejecutan las instruccioens de la linea 83
        // 1. Imprime lo siguiente: "El valor de comp1 es: "
        // 2. Imprime comp1
        // 3. Luego de haber impreso lo anterior, actualiza el valor de comp1
        System.out.println(comp1);

        System.out.println("El valor de comp1 es: " + ++comp1);
        // Orden en que se ejecutan las instruccioens de la linea 90
        // 1. Imprime lo siguiente: "El valor de comp1 es: "
        // 2. Actualiza el valor de comp1 sumandole 1
        // 3. Imprime el valor actualizado de comp1

        comp1--; // comp1 = comp1(7) - 1 = 6
        System.out.println("El valor de comp1 es: " + comp1);

        comp1 += comp2; // comp1 = comp1(6) + comp2(3) = 9
        System.out.println("El valor de comp1 es: " + comp1);

        // OPERACIONES RELACIONALES
        System.out.println("Mayor que: " + (comp1 > comp2)); // 9 > 3 = true
        System.out.println("Mayor que: " + (comp1 < comp2)); // 9 < 3 = false
        System.out.println("Mayor o igual que: " + (comp1 >= 9)); // 9 >= 9 = true
        System.out.println("Menor o igual que: " + (10 <= comp1)); // 10 <= 9 = false
        System.out.println("Igual a: " + (comp1 == comp2)); // 9 == 3 = false
        System.out.println("No es igual a: " + (comp1 != comp2)); // 9 != 3 = true

        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;

        // OPERACIONES LOGICAS
        System.out.println("Resultado de la operacion logica: " + (a == b && c > d));
        // (1 == 2) y (3 > 4) => (false) y (false) = false
        System.out.println("Resultado de la operacion logica: " + (a < b || c < d));
        // (1 < 2) o (3 < 4) => (true) o (true) = true
        System.out.println("Resultado de la operacion logica: " + !(a == b));
        // !(1 == 2) => !(false) = true

        System.out.println("Resultado de la operacion logica: " + (a == b && c > d || a < b || c < d));
        // (1 == 2) y (3 > 4) or (1 < 2) o (3 < 4) => [(false) y (false)] or (true) or (true)
        // [false or true] or true => true or true = true

        // USANDO INPUT
        // Limpiar la consola ejecutando el comando cls en Windows
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print("Ingrese el a�o actual: ");
        // Obtener un entero por consola y guardarlo en una variable de tipo entera
        int year = sc.nextInt();
        System.out.println("------------------------------------");
        System.out.println("El valor de year: " + year);

        // ESTRUCTURAS DE CONTROL
        // Recordar que si no se cumple ninguna condicion de los if o else if, se ejecutara el else por defecto si este existiese,
        // para que una condicion se cumpla la operacion relacional debe retornar un true
        if (comp1 < comp2) {
            System.out.println("La operacion relacional del if es verdadera");
        } else if (comp1 != comp2) {
            System.out.println("La operacion relacional del else if es verdadera");
        } else {
            System.out.println("Todas las condiciones anteriores son falsas");
        }

        // El switch evalua todos los casos propuestos y si ninguno se cumple, ejecutará el código que esté dentro de default.
        int j = 4;
        switch (j) {
            case 1:
                System.out.println("Primero");
                break;
            case 2:
                System.out.println("Segundo");
                break;
            case 3:
                System.out.println("Tercero");
                break;
            default:
                System.out.println("Default");
                break;
        }

        // CICLOS
        // El for lleva dentro de los parentesis 3 cosas: la asignacion del valor a la variable que se usará, la condición la cual siempre que sea
        // verdadera ejecutará el código dentro del for, de lo contrario se saldrá del ciclo y por último la actualización de la variables.
        for (int i = 0; i < 10; i++) {
            System.out.println("El valor de i es: " + i);
        }
        System.out.println("+++++++++++++++++++++++++++++++");

        // El while evalua si la condición es verdadera, si en dado caso lo es, ejecutará el código que tiene dentro, de lo contrario se saldrá del ciclo.
        // *Nota: Recordar siempre evaluar qué nos ayudará a salir dentro de un ciclo, de lo contrario se ejecutará infinitamente. Por ejemplo si en este
        // caso no se coloca el k++ dentro del while, el código se enciclará ya que k siempre será menor a 10
        int k = 0;
        while (k <= 10) {
            System.out.println("El valor de k es: " + k);
            k++;
        }

        // El do-while es parecido al while solo que este primero ejecuta el código y luego procede a evaluar la condición del while, si la condición
        // retorna un positivo se ejecutará de nuevo del código dentro del do, de lo contrario se terminará el ciclo y se ejecutarán las siguientes
        // líneas del programa
        // Para el ejemplo de abajo, la única manera de salir del ciclo es si option llega ser igual a 2, debido a que 2 != 2 es false
        // Actualmente option vale 0
        do {
            System.out.println("===========================");
            if (option == 0) {
                System.out.println("MENU PRINCIPAL");
                System.out.println("1. Suma");
                System.out.println("2. Salir");
                System.out.println("-----------------------");
                option = sc.nextInt();
                if (option > 2) {
                    System.out.println("Escoja una opcion correcta");
                    option = 0;
                }
            } else if (option == 1) {
                System.out.println("MENU SUMA");
                System.out.print("Ingrese el primer numero: ");
                int num1 = sc.nextInt();
                System.out.print("Ingrese el segundo numero: ");
                int num2 = sc.nextInt();
                System.out.println("-----------------------");
                System.out.println("El resultado de la suma es: " + (num1 + num2));
                System.out.println("-----------------------");
                option = 0;
            }
        } while (option != 2);
        System.out.println("Gracias por usar la app\nNombre y carnet");
    }
}
