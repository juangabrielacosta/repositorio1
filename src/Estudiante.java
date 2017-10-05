//import java.util.*;
/** Abstraccion de un estudiante en la clase Estudiante.
 * Devuelve una cadena con el nombre de la clase.
 * Devuelve un valor de verdad si el estudiante puede hacer un retiro de un libro de la biblioteca.
 * 
 * @author Grupo 5-2
 * @version 1.0
 */
public class Estudiante extends Socio {
    private String carrera;
    
    /**Cnstructor de Estudiante.
     */
    public Estudiante(int p_dniSocio, String p_nombre, String p_carrera) {
        super(p_dniSocio, p_nombre, 20);
        setCarrera(p_carrera);
    }
    
    /**Cnstructor de Estudiante. No recibe nombre del estudiante.
     */
    public Estudiante(int p_dniSocio, String p_carrera) {
        super(p_dniSocio, 20);
        setCarrera(p_carrera);
    }
    //setter
    private void setCarrera(String p_carrera) {
        this.carrera = p_carrera;
    }
    //getter
    public String getCarrera() {
        return this.carrera;
    }
    
    /**Devuelve valor de verdadero o falso segun si el estudiante pueda pedir prestado un libro.
     * Puede pedir prestado si no tiene ningun prestamo vencido y si no tiene mas de tres libros prestados.
     */
    public boolean puedePedir() {
        int can = this.getPrestamos().size();
        if ((can < 3 & super.puedePedir())) {
            return true;
        }
        return false;
    }
    
    /**Devuelve una cadena con el nombre de la clase, en este caso es 'Estudiante'.
     */
    public String soyDeLaClase() {
        return "Estudiante";
    }
}
