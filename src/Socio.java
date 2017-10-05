import java.util.*;
/**Abstraccion de un Socio en la clase Socio.
 * 
 * La clase Socio contiene la informacion sobre los distintos socios , ya sea Estudiante o Docente , y tambien sobre los libros
 * , como las diferentes acciones posibles a realizar con ellos.
 * 
 * @author Grup 5-2
 * @version 1.0
 */
public abstract class Socio {
    private int dniSocio;
    private String nombre;
    private int diasPrestamo;
    private ArrayList<Prestamo> prestamos;

    /**Constructor para objetos de la clase Socio
     */
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo) {
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(new ArrayList<Prestamo> ());
    }
    
    /**Constructor para objetos de la clase Socio (con Sobrecarga)
     */
    public Socio(int p_dniSocio, int p_diasPrestamo) {
        this.setDniSocio(p_dniSocio);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(new ArrayList<Prestamo> ());
    }
    //setters
    private void setDniSocio(int p_dniSocio) {
        this.dniSocio = p_dniSocio;
    }    
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    public void setDiasPrestamo(int p_diasPrestamo) {
        this.diasPrestamo = p_diasPrestamo;
    }
    private void setPrestamos(ArrayList<Prestamo> p_prestamos) {
        this.prestamos = p_prestamos;
    }
    //getters
    public int getDniSocio() {
        return this.dniSocio;
    }
    public String getNombre() {
        return this.nombre;
    }
    public int getDiasPrestamo() {
        return this.diasPrestamo;
    }
    public ArrayList<Prestamo> getPrestamos() {
        return this.prestamos;
    }
    //agregar, quitar prestamos del ArrayList de prestamos
    /**Este metodo permite agregar un prestamo a la lista de prestamos de un Socio.
     * 
     * @param  (Prestamo p_prestamo)
     * @return   No retorna ningun valor. 
     */
    public void addPrestamo(Prestamo p_prestamo) {
        this.getPrestamos().add(p_prestamo);
    }
    /**Este metodo permite quitar un prestamo a la lista de prestamos de un Socio.
     * 
     * @param  (Prestamo p_prestamo)
     * @return   No retorna ningun valor. 
     */
    public void removePrestamo(Prestamo p_prestamo) {
        this.getPrestamos().remove(p_prestamo);
    }
    
    /**Este metodo se lo define como abstracto para poder redefinirlo en sus subclases.
     * 
     * @param  No recibe parametros.
     * @return   Retorna un valor de tipo String. 
     */
    abstract public String soyDeLaClase();
    
    /**Este metodo permite conocer la cantidad de libros prestados que posee el Socio.
     * 
     * @param  No recibe parametros.
     * @return   Retorna un valor de tipo Integer. 
     */
    public int cantLibrosPrestados() {
        return this.getPrestamos().size();
    }
        
    /**Este metodo permite saber si el socio puede pedir prestado un libro, a partir de los vencimientos de los prestamos que
     * posee.
     * 
     * @param  No recibe parametros.
     * @return   Retorna un valor de tipo Boolean. 
     */
    public boolean puedePedir() {
        Calendar fechaHoy = new GregorianCalendar();
        boolean puedePedir = true;
        for (Prestamo prestamo: this.getPrestamos()) {
            if (prestamo.vencido(fechaHoy) == true) {
                puedePedir = false;
            }
        }
        return puedePedir;
    }
    
    /**Este metodo devuelve una cadena con la informacion del Socio y la cantidad de prestamos que realizo.
     * 
     * @param  No recibe parametros.
     * @return   Retorna un valor de tipo String. 
     */
    public String toString() {
        return "DNI: "+ this.getDniSocio() +" || "+ this.getNombre() +" ("+ this.soyDeLaClase() +") || Libros Prestados: "+ 
                this.cantLibrosPrestados();
    }
}
