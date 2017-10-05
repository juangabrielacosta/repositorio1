import java.util.*;
/**
 * Abstraccion de una biblioteca en la clase biblioteca.
 * Permite prestar un libro.
 * Permite devolver un libro.
 * Devuelve una coleccion de libros con prestamos activos vencidos.
 * Devuelve una coleccion con los docentes responsables.
 * Devuelve el nombre del socio que tiene prestado un libro determinado.
 * Permite buscar un socio por DNI.
 * Devuelve una cadena con informacion de los socios.
 * Devuelve una cadena con informacion de los libros.
 * Devuelve una cadena con informacion de los docentes responsables.
 * 
 * @author Grupo 5-2
 * @version 1.0
 */
public class Biblioteca {
    private String nombre;
    private ArrayList<Socio> socios;
    private ArrayList<Libro> libros;
    
    /**Constructor de Biblioteca.
     */
    public Biblioteca(String p_nombre) {
        this.setNombre(p_nombre);
        this.setSocios(new ArrayList<Socio>());
        this.setLibros(new ArrayList<Libro>());
    }
    //setters
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    private void setSocios(ArrayList<Socio> p_socios){
        this.socios = p_socios;
    }
    private void setLibros(ArrayList<Libro> p_libros){
        this.libros = p_libros;
    }
    //getters
    public String getNombre(){
        return this.nombre;
    }
    public ArrayList<Socio> getSocios(){
        return this.socios;
    }
    public ArrayList<Libro> getLibros(){
        return this.libros;
    }
    //agregar, quitar socio del ArrayList de socios
    public void addSocio(Socio p_socio){
        this.getSocios().add(p_socio);
    }
    public void removeSocio(Socio p_socio){
        this.getSocios().remove(p_socio);
    }
    //agregar, quitar libros del ArrayList de libros
    public void addLibro(Libro p_libro){
        this.getLibros().add(p_libro);
    }
    public void removeLibro(Libro p_libro){
        this.getLibros().remove(p_libro);
    }
    
    /**Crea un nuevo libro con los datos ingresados por parametro y lo agrega al ArrayList de libros.
     */
    public void nuevoLibro(String p_titulo, int p_edicion, String p_editorial, int p_anio){
        Libro unLibro = new Libro(p_titulo, p_edicion, p_editorial, p_anio);
        this.addLibro(unLibro);
    }
    
    /**Crea un nuevo socio de tipo Estudiante con los datos ingresados por parametro y lo agrega al ArrayList de socios.
     */
    public void nuevoSocioEstudiante(int p_dniSocio, String p_nombre, String p_carrera){
        Socio unEstudiante = new Estudiante(p_dniSocio, p_nombre, p_carrera);
        this.addSocio(unEstudiante);
    }
    
    /**Crea un nuevo socio de tipo Docente con los datos ingresados por parametro y lo agrega al ArrayList de socios.
     */
    public void nuevoSocioDocente(int p_dniSocio, String p_nombre, String p_area){
        Socio unDocente = new Docente(p_dniSocio, p_nombre, p_area);
        this.addSocio(unDocente);
    }
    
    /**Devuelve un entero con la cantidad de socios de un tipo ingresado por parametro.
     * Los socios pueden ser de tipo 'Estudiante' o 'Docente'.
     */
    public int cantidadSociosPorTipo(String p_objeto){
        int contadorObjeto = 0;
        for(Socio unSocio : this.getSocios()) {
            if(p_objeto.equals(unSocio.soyDeLaClase())) {
                contadorObjeto = contadorObjeto + 1;
            }            
        }
        return contadorObjeto;
    }
    
    /**Realiza el prestamo de un libro a un socio.
     */
    public boolean prestarLibro(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro){
        /*
        if(!p_libro.prestado() && p_socio.puedePedir()){
            Prestamo prestamo = new Prestamo(p_fechaRetiro, p_socio, p_libro);
            p_libro.addPrestamo(prestamo);
            p_socio.addPrestamo(prestamo);
            return true;
        }
        else{
            return false;
        }
        */
        boolean pudoPrestar = false;
        //realiza el prestamo si el libro existe en el ArrayList de libros
        if(this.getLibros().contains(p_libro)){
            //Recorre el ArrayList de libros
            for(Libro libro: this.getLibros()){
                //Es el titulo del libro que tengo que prestar el mismo titulo del libro actual obtenido con el foreach
                if(libro.getTitulo().equals(p_libro.getTitulo())){                               
                    //esta el libro ya prestado?
                    if(libro.prestado()) {
                        System.out.print("Libro ya esta prestado");
                    } else {    //se realiza el prestamo del libro
                        //se instancia un nuevo prestamo
                        Prestamo unPrestamo = new Prestamo(p_fechaRetiro, p_socio, p_libro);
                        //si el socio que desea retirar el libro no existe
                        if((this.buscarSocio(p_socio.getDniSocio()).equals(null))) {
                            //ingresa el socio que desea retirar el libro al ArrayList de socios
                            this.getSocios().add(p_socio);
                        }
                        //agrega el prestamo del libro al ArrayList de prestamos del socio
                        p_socio.addPrestamo(unPrestamo);
                        libro.addPrestamo(unPrestamo);
                        pudoPrestar = true;
                    }
                }
            }
        }
        return pudoPrestar;
        //*/
      }
    
    /**Permite devolver el libro.
     * Lo realiza asignando a la fecha de devolucion la fecha actual.
     */
    public void devolverLibro(Libro p_libro){
        if(this.getLibros().contains(p_libro)){
            if(p_libro.prestado()){
                Calendar fechaHoy = new GregorianCalendar();
                Prestamo prestamo = p_libro.getPrestamo();
                prestamo.setFechaDevolucion(fechaHoy);
                prestamo.getSocio().removePrestamo(prestamo);
                }else{
                System.out.println("El libro se encuentra en Biblioteca"); 
            }
        }
        else{
            System.out.println("Biblioteca no dispone de ese Libro");
        }
    }
    
    /**Devuelve un ArrayList de Prestamos con los prestamos actuales vencidos.
     */
    public ArrayList<Prestamo> prestamosVencidos(){
        ArrayList<Prestamo> prestamosVencidos = new ArrayList<Prestamo>();
        Prestamo prestamo;
        for(Libro libro: this.getLibros()){
            prestamo = libro.getPrestamo();
            boolean prestado = (libro.prestado());
            boolean vencido = (prestamo.vencido(new GregorianCalendar()));
            if(prestado && vencido){
                prestamosVencidos.add(prestamo);
            }
        }
        return prestamosVencidos;
    }    
    
    /**Devuelve un ArrayList de Docentes con todos los docentes responsables.
     * Los docentes son responsables si no tienen ningun prestamo vencido.
     */
    public ArrayList<Docente> docentesResponsables(){
        ArrayList<Docente> docentesResponsables = new ArrayList<Docente>();
        for(Socio socio: this.getSocios()){
            if( socio.soyDeLaClase().equals("Docente")) {
                if(((Docente) socio).esResponsable()){
                    docentesResponsables.add((Docente)socio);
                }
            }
        }
        return docentesResponsables;
    }
    
    /**Devuelve una cadena con el nombre del socio que tiene prestado el libro ingresado por parametro.
     */
    public String quienTieneElLibro(Libro p_libro){
        for(Libro libro: this.getLibros()){
            //el libro ingresado por parametro ya esta prestado?
            if(libro.prestado()) {
                return libro.getPrestamo().getSocio().getNombre();
            }
        }
        return "El libro se encuentra en biblioteca";
    }
    
    /**Permite buscar un socio por DNI ingresado por parametro.
     * Devuelve un objeto Socio si lo encuentra.
     */
    public Socio buscarSocio(int p_dni){
        for(Socio socio: this.getSocios()){
            if(socio.getDniSocio() == p_dni){
                return socio;
            }
        }
        return null;
    }
    
    /**Devuelve una cadena con informacion de los socios.
     * Incluye DNI, nombre y apellido, cantidad de libros prestados.
     */
    public String listaDeSocios(){
        String lista = "\tLista de Socios:\n";
        lista = lista + "\n";
        //recorre la coleccion de socios 
        for (int i = 0; i < this.getSocios().size(); i++) {
            //vamos concatenando la lista usando el metodo toString de la clase Socio
            lista = lista + (i + 1) + ") " + this.getSocios().get(i).toString() + "\n";
        }
        lista = lista + "\n";
        lista = lista + "*************************************************** \n";
        lista = lista + "Cant. Socios tipo Estudiante: " + this.cantidadSociosPorTipo("Estudiante") + "\n";
        lista = lista + "Cant. Socios tipo Docente: " + this.cantidadSociosPorTipo("Docente") + "\n";
        lista = lista + "***************************************************";
        return lista;
    }
    
    /**Devuelve una cadena con informacion de los libros.
     * Incluye titulo del libro, y si esta prestado.
     */
    public String listaDeLibros(){
        String lista = "\tLista de Libros: \n";
        lista = lista + "\n";
        String estaPrestado;
        for (int i = 0; i < this.getLibros().size(); i++) {
            if (this.getLibros().get(i).prestado()) {
                estaPrestado = "SI";
            } else {
                estaPrestado ="NO";
            }
            lista = lista + (i + 1) + ") " + this.getLibros().get(i).toString() + " || Prestado: (" 
                          + estaPrestado + ") " + "\n";
        }
        return lista;
    }
    
    /**Devuelve una cadena con informacion de los docentes responsables.
     * Incluye DNI, nombre y apellido,  cantidad de libros prestados.
     */
    public String listaDeDocentesResponsables() {
        String lista = "\tLista de Docentes Responsables \n";
        for (Docente docente : this.docentesResponsables()) {
            lista = lista + "* " + docente.toString() + "\n";
        }
        return lista;
    }
}
