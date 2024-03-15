package clase8;

import java.io.Serializable;

/**
 *
 * @author Rodolfo Morales - 202010033
 */
public class Animal implements Serializable {

    // Atributos de la clase animal
    private String raza;
    private String nombre;
    private int edad;

    // Constructor de la clase animal
    public Animal(String raza, String nombre, int edad) {
        this.raza = raza;
        this.nombre = nombre;
        this.edad = edad;
    }

    // Por medio de esta funcion se retorna en un string los datos del objeto actual
    @Override
    public String toString() {
        return "Animal{"
            + "raza= '" + this.raza + '\''
            + ", nombre= '" + this.nombre + '\''
            + ", edad= " + this.edad
            + '}';
    }

    /**
     * @return the raza
     */
    public String getRaza() {
        return raza;
    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
