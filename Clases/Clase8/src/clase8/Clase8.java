package clase8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Clase8 {

    static ArrayList<Animal> animals = new ArrayList<Animal>();

    public static void main(String[] args) {
        // Instanceando un objeto de tipo Window (es nuestra interfaz gráfica)
        Window window = new Window();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        //Lectura del archivo serializado si ya existe
        // Si la función LeerArchivo nos retorna un objeto entonces realizamos el casteo para que ese 
        // objeto sea ahora un objeto arraylist que almacene animales.
        // Ahora si nos retorna un valor null LeerArchivo entonces significa que el archivo no existe
        animals = (ArrayList<Animal>) LeerArchivo();
        // Validamos si animals no es nulo
        if (animals != null) {
            // Si el arraylist animals tiene valores entonces los imprimimos
            for (Animal animal_x : animals) {
                System.out.println(animal_x.toString());
            }
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        } else {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Aun no existe un archivo serializado.");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        System.out.println("");
    }

    public static void serializacion() {
        animals = new ArrayList<>(); // Inicializa la lista si es nula
        // Instanceamos 3 objetos de tipo animal y los agregamos al ArrayList
        Animal animal1 = new Animal("Labrador", "Mike", 12);
        Animal animal2 = new Animal("Pastor aleman", "Max", 5);
        Animal animal3 = new Animal("Chihuahua", "Jinx", 9);
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        // Escribimos el archivo binario
        EscribirArchivo();
        // Escribimos el archivo csv
        EscribirArchivoCSV();
    }

    public static void lecturaCSV(JFrame frame) {

        JFileChooser fileChooser = new JFileChooser();

        //Filtro para que unicamente deje seleccionar archivos CSV 
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos CSV", "csv");
        fileChooser.setFileFilter(filter);

        // Mostrar el diálogo de selección de archivos
        int result = fileChooser.showOpenDialog(frame);

        // Verificar si se seleccionó un archivo
        if (result == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("=======================================================================");
            System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());

            // Leer el archivo CSV y mostrar su contenido como tabla
            try {
                Scanner scanner = new Scanner(selectedFile);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    for (String part : parts) {
                        System.out.print(part + "\t | \t");
                    }
                    System.out.println();
                }
                scanner.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            System.out.println("=======================================================================");
            System.out.println("");
        }

    }

    public static void EscribirArchivo() {
        // Serialización de la lista
        try {
            // Creamos el archivo binario en la ruta especificada
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./Archivos/Animals.bin"));
            // Escribimos nuestro ArrayList de tipo Animal
            out.writeObject(animals);
            // Cerramos el archivo
            out.close();
            System.out.println("***********************************************************************");
            System.out.println("Lista de animales serializada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("***********************************************************************");
    }

    public static Object LeerArchivo() {
        // Deserialización de la lista
        try {
            // Abrimos el archivo binario en la ruta especificada
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("./Archivos/Animals.bin"));
            // Leemos el objeto guardado (Arraylist de tipo Animal) y lo guardamos en un Arryalist del mismo tipo
            ArrayList<Animal> animals = (ArrayList<Animal>) in.readObject();
            // Cerramos el archivo
            in.close();
            System.out.println("Lista de animales deserializada correctamente.");
            // Retornamos el objeto
            return animals;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Si no existe ningun archivo o si ocurre un error, se retorna null
        return null;
    }

    public static void EscribirArchivoCSV() {
        // Teniendo la ruta del archivo y el nombre del mismo se procede a crearlo
        String csvFile = "./Archivos/ListaAnimales.csv";
        try (PrintWriter writer = new PrintWriter(new File(csvFile))) {
            StringBuilder sb = new StringBuilder();
            // Luego se va agregando en un objeto StringBuilder el texto que queremos guardar
            sb.append("Id,raza,nombre,edad\n");
            int id = 1;

            sb.append(id++).append(",");
            sb.append("Beagle").append(",");
            sb.append("Luky").append(",");
            sb.append(8).append("\n");

            sb.append(id++).append(",");
            sb.append("Caniche").append(",");
            sb.append("Dexter").append(",");
            sb.append(7).append("\n");

            sb.append(id++).append(",");
            sb.append("Dalmata").append(",");
            sb.append("Pepe").append(",");
            sb.append(3).append("\n");
            // Escribimos el texto en el archivo, se guarda lo que tenga el objeto StringBuilder
            writer.write(sb.toString());
            System.out.println("Archivo CSV creado correctamente.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("***********************************************************************");
    }
}
