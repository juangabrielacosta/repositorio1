import java.util.*;
/**
 * Abstraccion de un libro en la clase Libro.
 * Permite retornar un libro prestado.
 * Permite devolver un valor de verdad segun si el libro esta prestado o no.
 * Devuelve una cadena cn informacion del libro.
 * 
 * @author Grupo 5-2
 * @version 1.0
 */
public class Libro{
    private String titulo;
    private int edicion;
    private String editorial;
    private int anio;
    private ArrayList<Prestamo> prestamos;
    
    /**Constructor de Libro.
     */
    public Libro (String p_titulo, int p_edicion, String p_editorial, int p_anio){
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(new ArrayList<Prestamo>());
    }
    //setters
    private void setTitulo(String p_titulo){
        this.titulo=p_titulo;
    }
    private void setEdicion (int p_edicion){
        this.edicion=p_edicion;
    }
    private void setEditorial(String p_editorial){
        this.editorial=p_editorial;
    }
    private void setAnio (int p_anio){
        this.anio=p_anio;
    }
    private void setPrestamos (ArrayList<Prestamo> p_prestamos){
        this.prestamos=p_prestamos;   
    }
    //getters
    public int getEdicion(){
        return this.edicion;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public String getEditorial(){
        return this.editorial;
    }
    public int getAnio(){
        return this.anio;
    }
    public ArrayList<Prestamo> getPrestamos(){
        return this.prestamos;
    }
    public Prestamo getPrestamo(){
        int ultElem = this.prestamos.size();
        return (Prestamo)this.prestamos.get(ultElem - 1);
    }
    //agregar, quitar prestamo del ArrayList de prestamos
    public void addPrestamo(Prestamo p_prestamo){
        this.getPrestamos().add(p_prestamo);              
    }    
    public void removePrestamos (Prestamo p_prestamos){
        this.getPrestamos().remove(p_prestamos);
    }
    
    /**Devuelve un valor de verdadero o falso segun si el libro se encuentra prestado.
     */
    public boolean prestado(){
        if (this.prestamos.size() == 0) {
            return false;
        }
        Prestamo unP = getPrestamo();
        boolean aux = unP.getFechaDevolucion() == null;
        return aux;
    }

    /**Devuelve una cadena con informacion del libro.
     * Incluye el titulo del libro.
     */
    public String toString(){
        return ("Titulo: "+ this.getTitulo());
    }
}
