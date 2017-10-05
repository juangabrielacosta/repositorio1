import java.util.*;
/**Abstraccion de un prestamo en la clase Prestamo.
 * Devuelve un valor de verdad si la entrega del libro se encuentra vencida.
 * Devuelve una cadena con informacion del prestamo.
 * 
 * @author Grupo 5-2
 * @version 1.0
 */
public class Prestamo {
    private Calendar fechaRetiro;
    private Calendar fechaDevolucion;
    private Socio socio;
    private Libro libro;

    /**Constructor para objetos de la clase Prestamo.
     */
    public Prestamo(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro) {
        this.setFechaRetiro(p_fechaRetiro);
        this.setSocio(p_socio);
        this.setLibro(p_libro);
    }
    
    /**Constructor para objetos de la clase Prestamo. No recibe la fecha del retiro.
     */
    public Prestamo(Socio p_socio, Libro p_libro) {
        this.setSocio(p_socio);
        this.setLibro(p_libro);
        this.setFechaRetiro(new GregorianCalendar());
    }
    //setters
    private void setFechaRetiro(Calendar p_fechaRetiro) {
        this.fechaRetiro = p_fechaRetiro;
    }    
    public void setFechaDevolucion(Calendar p_fechaDevolucion) {
        this.fechaDevolucion = p_fechaDevolucion;
    }    
    private void setSocio(Socio p_socio) {
        this.socio = p_socio;
    }    
    private void setLibro(Libro p_libro) {
        this.libro = p_libro;
    }
    //getters
    public Calendar getFechaRetiro() {
        return this.fechaRetiro;
    }    
    public Calendar getFechaDevolucion() {
        return this.fechaDevolucion;
    }    
    public Socio getSocio() {
        return this.socio;
    }    
    public Libro getLibro() {
        return this.libro;
    }
    
    /**Devuelve un valor de verdad si el prestamo se encuentra vencido.
     * El prestamo se encuentra vencido si la fecha pasada como parametro es mayor a la fecha de vencimiento del prestamo.
     * 
     * @param  (Calendar p_fecha)
     * @return   Retorna un valor de tipo Boolean.
     */
    public boolean vencido(Calendar p_fecha) {
        int diasPrestamo = this.getSocio().getDiasPrestamo();
        Calendar fechaDevolucion = this.getFechaRetiro();
        fechaDevolucion.add(Calendar.DATE, diasPrestamo);
        return (p_fecha.after(fechaDevolucion));
    }
    
    /**Devuelve una cadena con informacion del prestamo.
     * Incluye fecha de retiro, fecha de devolucion, titulo del libro, nombre del socio.
     * 
     * @param  No recibe parametros.
     * @return   Retorna un valor de tipo String.
     */
    public String toString() {
        return "Retiro: "+ this.getFechaRetiro() +" - Devolucion: "+ this.getFechaDevolucion()
              +"Libro: "+ this.getLibro().getTitulo()
              +"Socio: "+ this.getSocio().getNombre();
    }
}
