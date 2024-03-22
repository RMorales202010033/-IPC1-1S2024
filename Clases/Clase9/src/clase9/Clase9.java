package clase9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Rodolfo Morales - 202010033
 */
public class Clase9 {

    // Creamos nuestras listas de tipo string para que almacenen los puntos iniciales y finales
    static ArrayList<String> listaInicio = new ArrayList<String>();
    static ArrayList<String> listaFin = new ArrayList<String>();

    public static void main(String[] args) {
        // Instanceamos un objeto de tipo Window
        Window window = new Window();
    }

    public static void lecturaCSV(Window mywindow) {
        // Instanceamos un objeto JFile Chooser
        JFileChooser fileChooser = new JFileChooser();

        //Filtro para que unicamente deje seleccionar archivos CSV 
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos CSV", "csv");
        fileChooser.setFileFilter(filter);

        // Si el archivo fue seleccionado correctamente entrara en el if
        int result = fileChooser.showOpenDialog(mywindow);

        if (result == JFileChooser.APPROVE_OPTION) {
            // Obtenemos el archivo seleccionado
            File selectedFile = fileChooser.getSelectedFile();
            // Vamos concatenandole a nuestro textArea informacion
            mywindow.textArea.append("-> Abriendo csv en la siguiente ruta:\n");
            mywindow.textArea.append(selectedFile.getAbsolutePath() + "\n");
            mywindow.textArea.append("\n");
            mywindow.textArea.append("-> Leyendo csv\n");

            // Leer el archivo CSV y mostrar su contenido como tabla
            try {
                // Con el objeto scanner obtenemos la info del csv con encoding utf-8
                Scanner scanner = new Scanner(selectedFile, "UTF-8");
                // Creamos un contador para omitir los encabezados y contar los registros
                int contadorLineas = -1;
                // Recorremos las lineas del csv
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    // Si son los encabezados los omite
                    if (contadorLineas == -1) {
                        contadorLineas = 0;
                        continue;
                    }
                    // Agregamos los valores del csv a nuestros arrays
                    listaInicio.add(parts[0]);
                    listaFin.add(parts[1]);
                    contadorLineas++;
                }
                scanner.close();
                // Volvemos nuestras listas bidireccionales
                for (int i = 0; i < contadorLineas; i++) {
                    listaInicio.add(listaFin.get(i));
                    listaFin.add(listaInicio.get(i));
                }

                mywindow.textArea.append("Se leyeron: " + contadorLineas + " registros\n");
                mywindow.textArea.append("\n");

                // Agregar elementos al combobox inicial
                for (String element : listaInicio) {
                    mywindow.puntoInicial.addItem(element);
                }

                // Agregar elementos al combobox final
                for (String element : listaFin) {
                    mywindow.puntoFinal.addItem(element);
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }

    }

    public static void printLists(Window mywindow) {
        mywindow.textArea.append("Lista de puntos iniciales:\n");
        for (String pInicio : listaInicio) {
            mywindow.textArea.append("-> " + pInicio + "\n");
        }

        mywindow.textArea.append("\nLista de puntos finales:\n");
        for (String pFin : listaFin) {
            mywindow.textArea.append("-> " + pFin + "\n");
        }
        mywindow.textArea.append("\n");
    }

}
