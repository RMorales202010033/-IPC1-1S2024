package ejemplo.clase.pkg4;

/**
 *
 * @author jrodo
 */
public class Estudiante extends Persona {

    private int carnet;
    private String carrera;
    private String[] cursos;
    private int contador;

    public Estudiante(String nombre, char sexo, double altura, long CUI, int edad, int carnet, String carrera) {
        super(nombre, sexo, altura, CUI, edad);
        this.carnet = carnet;
        this.carrera = carrera;
        this.cursos = new String[5];
        this.contador = 0;
        System.out.println("Creacion de un estudiante");
    }

    public void NotaIPC(int nota) {
        if (nota >= 61) {
            System.out.println(this.getNombre() + " ha aprobado el curso de IPC 1 con una nota de " + nota);
            System.out.println("Por lo tanto, podrá seguir adelantando los cursos de la carrera de: " + this.getCarrera());
        } else {
            System.out.println("El estudiante con carnet: " + this.getCarnet() + " ha reprobado el curso.");
        }
    }

    public void mostrarCursos() {
        System.out.println("Cursos asignados: ");
        for (int i = 0; i < this.getCursos().length; i++) {
            System.out.println((i + 1) + ". " + this.getCursos()[i]);
        }
    }

    /**
     * @return the carnet
     */
    public int getCarnet() {
        return carnet;
    }

    /**
     * @param carnet the carnet to set
     */
    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    /**
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * @return the cursos
     */
    public String[] getCursos() {
        return cursos;
    }

    /**
     * @param cursos the cursos to set
     */
    public void setCursos(String curso) {
        if (this.getContador() < this.getCursos().length) {
            this.getCursos()[this.getContador()] = curso;
            setContador(getContador() + 1); // contador = contador + 1
        } else {
            System.out.println("La capacidad de cursos asignados ha llegado a su límite.");
        }
    }

    /**
     * @return the contador
     */
    public int getContador() {
        return contador;
    }

    /**
     * @param contador the contador to set
     */
    public void setContador(int contador) {
        this.contador = contador;
    }

}
