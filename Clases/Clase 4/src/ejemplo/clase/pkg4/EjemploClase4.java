package ejemplo.clase.pkg4;

/**
 *
 * @author Rodolfo Morales
 */
public class EjemploClase4 {

    public static void main(String[] args) {
        // CREANDO OBJETOS PERSONA
        Persona persona1 = new Persona("Rodolfo Morales", 'M', 1.70, 12345678, 21);
        persona1.hablar("Hola este es el laboratorio extra de la clase 4.");
        
        Persona persona2 = new Persona("Enner Castro", 'M', 1.80, 12345679, 19);
        persona2.hablar("Hola soy estudiante del curso de ipc1");
        System.out.println("==================================");
        persona2.MostrarDatos();
        System.out.println("==================================");
        persona1.MostrarDatos();
        System.out.println("==================================");
        persona1.setEdad(22);
        persona1.MostrarDatos();
        System.out.println("==================================");
        persona2.MostrarDatos();
        System.out.println("==================================");
        Estudiante student1 = new Estudiante("Isaac Chang", 'M', 1.85, 12345670, 20, 201801573, "Ciencias y Sistemas");
        student1.MostrarDatos();
        student1.NotaIPC(88);
        student1.setCursos("IPC 1");
        student1.setCursos("Aplicada 1");
        student1.setCursos("Aplicada 3");
        student1.setCursos("Logica de sistemas");
        student1.setCursos("Fisica 1");
        student1.mostrarCursos();
        student1.setCursos("Aplicada 2");
    }
    
}
