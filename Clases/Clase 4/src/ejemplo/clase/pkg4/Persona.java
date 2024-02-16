package ejemplo.clase.pkg4;

public class Persona {
    private String nombre;
    private char sexo;
    private double altura;
    private long CUI;
    private int edad;

    public Persona(String nombre, char sexo, double altura, long CUI, int edad) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.altura = altura;
        this.CUI = CUI;
        this.edad = edad;
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
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * @return the CUI
     */
    public long getCUI() {
        return CUI;
    }

    /**
     * @param CUI the CUI to set
     */
    public void setCUI(long CUI) {
        this.CUI = CUI;
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
    
    public void hablar(String mensaje){
        System.out.println("Yo estoy diciendo: " + mensaje);
    }
    
    public void MostrarDatos(){
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Edad: " + this.getEdad());
        System.out.println("Sexo: " + this.getSexo());
        System.out.println("Altura: " + this.getAltura());
        System.out.println("CUI: " + this.getCUI());
    }
    
    
}
