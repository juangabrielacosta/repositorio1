import java.util.*;
/**
 * Clase ejecutable GestionBiblioteca usada para probar el funcionamiento de las clases Socio, Estudiante, Docente, Prestamo, Libro, Biblioteca.
 * 
 * @author Grupo 5.2
 * @version 1.0
 */
public class GestionBiblioteca{

    public static void main (String[] args){

        Scanner tecla = new Scanner(System.in);
        tecla.useDelimiter("\n");

        
        System.out.printf("\f\nIngrese nombre de la Biblioteca: ");
        String nombreBiblioteca = tecla.next();

        Libro libro1 = new Libro("Programando con JAVA",5, "Atlas", 1999);
        Libro libro2 = new Libro("Diccionario Poket",3,"Longman", 2000);
        Libro libro3 = new Libro("Vivir para contarla", 2, "Agostini", 1993);
        Libro libro4 = new Libro("Moby dick", 1, "Clarin", 1998);
        Libro libro5 = new Libro("El Principito", 1, "Kapeluz", 2005);
        Libro libro6 = new Libro("Sistemas Operativos", 4,"La Red",2010);
        Libro libro7 = new Libro("Pinocho", 3,"Clarin",2009);
        Libro libro8 = new Libro("Dracula", 1,"Viernes 13",1968);
        Libro libro9 = new Libro("El Hombre Lobo", 2, "Globan", 2003);
        Libro libro10 = new Libro("Titanic", 2, "Glaciar", 2000);

        Socio docente1 = new Docente(14524782, "Juan Perez", "Lengua Inglesa");
        Socio docente2 = new Docente(17982110, "Juan Fernandez", "Matematica" );
        Socio docente3 = new Docente(10912002, "María Alegre", "Ciencias Sociales");
        Socio estudiante1 = new Estudiante(28987498, "Francisco Paenza", "Sistemas Informaticos");
        Socio estudiante2 = new Estudiante(31987123, "Cesar Milstein", "Sistemas Informaticos");
        Socio estudiante3 = new Estudiante(32874012, "Karina Leloir","Sistemas Informaticos");

        //bibliotecas

        Biblioteca miBiblioteca = new Biblioteca(nombreBiblioteca);
        miBiblioteca.addSocio(docente1);
        miBiblioteca.addSocio(docente2);
        miBiblioteca.addSocio(docente3);
        miBiblioteca.addSocio(estudiante1);
        miBiblioteca.addSocio(estudiante2);
        miBiblioteca.addSocio(estudiante3);

        miBiblioteca.nuevoLibro(libro1.getTitulo(),libro1.getEdicion(), libro1.getEditorial(), libro1.getAnio());
        miBiblioteca.nuevoLibro(libro2.getTitulo(),libro2.getEdicion(), libro2.getEditorial(), libro2.getAnio());
        miBiblioteca.nuevoLibro(libro3.getTitulo(),libro3.getEdicion(), libro3.getEditorial(), libro3.getAnio());
        miBiblioteca.nuevoLibro(libro4.getTitulo(),libro4.getEdicion(), libro4.getEditorial(), libro4.getAnio());
        miBiblioteca.nuevoLibro(libro5.getTitulo(),libro5.getEdicion(), libro5.getEditorial(), libro5.getAnio());
        miBiblioteca.nuevoLibro(libro6.getTitulo(),libro6.getEdicion(), libro6.getEditorial(), libro6.getAnio());
        miBiblioteca.nuevoLibro(libro7.getTitulo(),libro7.getEdicion(), libro7.getEditorial(), libro7.getAnio());
        miBiblioteca.nuevoLibro(libro8.getTitulo(),libro8.getEdicion(), libro8.getEditorial(), libro8.getAnio());
        miBiblioteca.nuevoLibro(libro9.getTitulo(),libro9.getEdicion(), libro9.getEditorial(), libro9.getAnio());
        miBiblioteca.nuevoLibro(libro10.getTitulo(),libro10.getEdicion(), libro10.getEditorial(), libro10.getAnio());

        // pedidos     
        
        Calendar diasPrestado = new GregorianCalendar();

        //cargamos los responsables
        Prestamo prestamo1 = new Prestamo(docente1, libro1);

        docente1.addPrestamo(prestamo1);
        miBiblioteca.getLibros().get(0).addPrestamo(prestamo1);

        Prestamo prestamo2 = new Prestamo(docente2, libro2);

        docente2.addPrestamo(prestamo2);
        miBiblioteca.getLibros().get(1).addPrestamo(prestamo2);

        //los no responsables

        diasPrestado.add(Calendar.DATE, -30);

        Prestamo prestamo3 = new Prestamo(docente3, libro3);
        docente3.addPrestamo(prestamo3);
        miBiblioteca.getLibros().get(2).addPrestamo(prestamo3);

               
        Prestamo prestamo4 = new Prestamo(estudiante1, libro4);
        estudiante1.addPrestamo(prestamo4);
        miBiblioteca.getLibros().get(3).addPrestamo(prestamo4);

        Prestamo prestamo5 = new Prestamo(estudiante1, libro5);
        estudiante1.addPrestamo(prestamo5);
        miBiblioteca.getLibros().get(4).addPrestamo(prestamo5);

        
        Prestamo prestamo6 = new Prestamo(estudiante2, libro6);
        estudiante2.addPrestamo(prestamo6);
        miBiblioteca.getLibros().get(5).addPrestamo(prestamo6);

        Prestamo prestamo7 = new Prestamo(estudiante3, libro7);
        estudiante3.addPrestamo(prestamo7);
        miBiblioteca.getLibros().get(6).addPrestamo(prestamo7);

        
        
        
        System.out.println("Prueba para Listar Libros");
        System.out.println("<Presiones Enter>");
        String respuesta = tecla.next();

        System.out.println(miBiblioteca.listaDeLibros());
        System.out.println("\n\t ---------");

        System.out.println("\nRespondiendo Que cantidad de socios hay");
        System.out.println("<Presiones Enter>");
        respuesta = tecla.next();

        System.out.println(miBiblioteca.listaDeSocios());

        System.out.println("\n\t ---------");

        System.out.println("\nRespondiendo Cuál es la lista de docentes que nunca han adeudado ni adeudan libros");
        System.out.println("Docentes Responsables: <Presiones Enter>");
        respuesta = tecla.next();

        System.out.println(miBiblioteca.listaDeDocentesResponsables());        
        System.out.println("\n\t ---------");

        System.out.println("\nPrueba buscamos al socio Juan Perez");
        System.out.println("<Presiones Enter>");
        respuesta = tecla.next();

        System.out.println(miBiblioteca.buscarSocio(14524782));
        System.out.println("\n\t ---------");

        System.out.println("\nQué socio tiene prestado el libro -Programando con JAVA-");
        System.out.println("<Presiones Enter>");
        respuesta = tecla.next();

        System.out.println(miBiblioteca.quienTieneElLibro(libro1));
        System.out.println("\n\t ---------");

        
        System.out.println("Qué cantidad de socios de tipo Estudiante hay");
        System.out.println("<Presiones Enter>");
        respuesta = tecla.next();

        System.out.println(miBiblioteca.cantidadSociosPorTipo("Estudiante"));
        System.out.println("\n\t ---------");

        System.out.println("******************************************");
        System.out.println("*** Terminado Respuestas de Consignas ****");
        System.out.println("******************************************");
        
        
        System.out.println("\n\tMenu de Gestion de Biblioteca\n");
        System.out.println("[1] Agregar un Libro \n[2] Agregar un Socio \n[3] Realizar un Prestamo" +
            "\n[4] Realizar una Devolucion \n[5] Listar Libros \n[6] Listar Socio \n[7] Listar Docentes responsables"+
            "\n[8] Buscar Socio por DNI\n[9] Cantidad de Socios por Tipo \n[10] TERMINAR \n");

        //Lee la condicion que elige para continuar                   
        String condicion = tecla.next();                    

        String titulo = "";
        int edicion = 0;
        String editorial = "";
        int anio = 0;

        boolean deNuevo;

        
        int tipo = 0;
        int dni = 0;
        String nombre = "";
        String carrera = "";
        String area = "";
        boolean existe;

        Libro unLibro = null;
        Socio socioAPrestarLibro;
        Socio socioQueDevuelveLibro;

        while(!(condicion.equals("10"))){

            switch(condicion){

                case "1":
                //agregar un libro

                System.out.println("\n--------------------------------------------\n");

                System.out.printf("\n Ingrese el titulo del libro: ");
                titulo = tecla.next();

                deNuevo = false;
                while(!deNuevo){    
                    System.out.printf("\n Ingrese el numero de edición del libro: ");
                    edicion = tecla.nextInt();

                    if(edicion >=0){
                        deNuevo = true;
                    }else if (edicion <0){
                        System.out.println("\nNo se ingresó un numero de edicion válido.");
                    }                   

                }

                deNuevo = false;                
                while(!deNuevo){    

                    System.out.printf("\n Ingrese el año de publicacion del libro: ");
                    anio = tecla.nextInt();

                    if(anio >=0){
                        deNuevo = true;
                    }else if (anio <0){
                        System.out.println("\nNo se ingresó un numero de edicion válido.");
                    }                   

                }

                miBiblioteca.nuevoLibro(titulo, edicion, editorial, anio);

                System.out.printf("\n***** Libro cargado ******\n");

                System.out.println("--------------------------------------------\n");

                break;

                case "2":
                //Ingresa Socios

                System.out.println("\n--------------------------------------------\n");
                System.out.printf("\tIngrese el DNI del socio: ");
                dni = tecla.nextInt();
                existe = false;

                if(!(miBiblioteca.getSocios().isEmpty())){
                    for(Socio socio : miBiblioteca.getSocios()){
                        if(socio.getDniSocio() == dni){
                            existe = true;                              
                        }
                    }
                }

                if(!existe){
                    System.out.printf("\n Ingrese el nombre del socio: ");
                    nombre = tecla.next();

                    System.out.println("\nTipo de socio: ");
                    System.out.println("1- Docente.");
                    System.out.println("2- Estudiante.");

                    deNuevo = false;
                    while(!deNuevo){
                        System.out.print("Ingrese una opción: ");
                        tipo = tecla.nextInt();

                        if(tipo < 1 || tipo > 2){
                            System.out.println("Ingrese una opción correcta.");
                        } else {
                            deNuevo = true;
                        }
                    }

                    if (tipo == 1){
                        System.out.printf("\n Ingrese el area donde trabaja el docente: ");
                        area = tecla.next();                        

                        miBiblioteca.nuevoSocioDocente(dni, nombre, area);
                    }
                    if (tipo == 2){
                        System.out.printf("\n Ingrese la carrera del estudiante: ");
                        carrera = tecla.next();

                        miBiblioteca.nuevoSocioEstudiante(dni, nombre, carrera);

                    }

                }else{
                    System.out.println("\n El DNI ingresado corresponde a un socio previamente registrado.");
                }

                System.out.println("\n--------------------------------------------\n");
                break;
                case "3":          
                //Realiza un Prestamo

                System.out.println("\n--------------------------------------------\n");    

                if(miBiblioteca.getLibros().isEmpty()){
                    System.out.println("\nLa biblioteca no posee libros para prestar.");
                }else if(miBiblioteca.getSocios().isEmpty()){
                    System.out.println("\nLa biblioteca no posee socios a quien prestar algún libro.");
                }else{

                    
                    deNuevo = false;
                    while(!deNuevo){
                        System.out.printf("\n Ingrese el titulo del libro a prestar: ");
                        titulo = tecla.next();
                        if(titulo.isEmpty()){
                            System.out.println("\n No ha ingresado el titulo del libro a prestar.\n");
                        }else{
                            deNuevo = true;
                        }
                    }

                    existe = false;

                    for(Libro libro : miBiblioteca.getLibros()){
                        if(libro.getTitulo().equalsIgnoreCase(titulo)){
                            if(!(libro.prestado())){
                                existe = true; 
                                unLibro = libro;
                            }
                        }
                    }

                    if(existe){
                    
                        deNuevo = false;
                        while(!deNuevo){
                            System.out.println("\n Ingrese el DNI del socio que desea el libro: ");

                            dni = tecla.nextInt();
                            if(dni >=0){
                                deNuevo = true;
                            }else if (dni <0){
                                System.out.println("\nNo se ingresó un numero de DNI válido.");
                            }
                        }

                        socioAPrestarLibro = miBiblioteca.buscarSocio(dni);

                        if (socioAPrestarLibro != null){
                            Calendar fechaRetiro = new GregorianCalendar();
                            miBiblioteca.prestarLibro(fechaRetiro, socioAPrestarLibro, unLibro);
                            System.out.println("\n Prestamo realizado ");

                        }else{
                            System.out.println("\n El DNI ingresado no coincide con los cargados en el sistema.");
                            System.out.println("\n No se pudo hacer Prestamo ");
                        }                

                    }else {
                        System.out.println("\n El libro buscado no se encuentra cargado o está prestado.");
                    }

                }   

                System.out.println("\n--------------------------------------------\n");

                break;

                case "4":
                //Realiza una devolucion            

                if(miBiblioteca.getLibros().isEmpty()){
                    System.out.println("\f\nLa biblioteca no posee libros para prestar o devolver.");
                }else if(miBiblioteca.getSocios().isEmpty()){
                    System.out.println("\f\nLa biblioteca no posee socios a quien prestar o pedir la devolución de algún libro.");
                }else{

                  
                    System.out.println("\n Ingrese nombre del libro: ");                        
                    titulo = tecla.next();

                    existe = false;
                    for(int i = 0; i < miBiblioteca.getLibros().size(); i++){
                        if((miBiblioteca.getLibros().get(i).getTitulo()).equalsIgnoreCase(titulo)){          
                            miBiblioteca.devolverLibro(miBiblioteca.getLibros().get(i));  
                            existe = true;
                        }
                    }

                    if(!existe){
                        System.out.println("El Libro no puede ser devuelto");
                    }

                }

                System.out.println("\n--------------------------------------------\n");

                break;

                case "5":   
                //Listar Libros

                if(miBiblioteca.getLibros().isEmpty()){
                    System.out.println("\nLa biblioteca no posee libros para prestar.");
                }else{
                    System.out.println(miBiblioteca.listaDeLibros());
                }
                System.out.println("\n--------------------------------------------\n");
                break;

                case "6":
                //Listar Socios

                if(miBiblioteca.getSocios().isEmpty()){
                    System.out.println("\nLa biblioteca no posee socios a quien prestar algún libro.");
                }else{
                    System.out.println(miBiblioteca.listaDeSocios());
                }
                System.out.println("\n--------------------------------------------\n");
                break;

                case "7":
                //Lista Docentes Responsables

                if(miBiblioteca.docentesResponsables().isEmpty()){
                    System.out.println("\f\nLa biblioteca no posee socios docentes responsables.");

                }else{
                    System.out.println(miBiblioteca.listaDeDocentesResponsables());
                }

                System.out.println("\n--------------------------------------------\n");
                break;

                case "8":
                //Busca un Socio

                if(miBiblioteca.getSocios().isEmpty()){
                    System.out.println("\nLa biblioteca no posee socios a buscar.");
                }else{
                    existe = false;                        
                    System.out.println("\nIngrese el DNI del socio a buscar");
                    dni = tecla.nextInt();

                    System.out.println(miBiblioteca.buscarSocio(dni).toString());

                }        
                System.out.println("\n--------------------------------------------\n");
                break;
                case "9": 
                //Cantida de socios por tipo
                System.out.println("\nQue tipo de Socios desea saber su cantidad:");
                System.out.println("1- Docente.");
                System.out.println("2- Estudiante.");

                deNuevo = false;
                while(!deNuevo){
                    System.out.print("Ingrese una opción: ");
                    tipo = tecla.nextInt();

                    if(tipo < 1 || tipo > 2){
                        System.out.println("Ingrese una opción correcta.");
                    } else {
                        deNuevo = true;
                    }
                }

                if(tipo == 1 ){
                    System.out.println("La cantidad de Docentes son: "+ miBiblioteca.cantidadSociosPorTipo("Docente"));
                } else {
                    System.out.println("La cantidad de Estudiantes son: "+ miBiblioteca.cantidadSociosPorTipo("Estudiante"));
                }

                System.out.println("\n--------------------------------------------\n");

                break;

            }
            System.out.println("\n\tMenu de Gestion de Biblioteca\n");
            System.out.println("[1] Agregar un Libro \n[2] Agregar un Socio \n[3] Realizar un Prestamo" +
                "\n[4] Realizar una Devolucion \n[5] Listar Libros \n[6] Listar Socio \n[7] Listar Docentes responsables"+
                "\n[8] Buscar Socio por DNI\n[9] Cantidad de Socios por Tipo \n[10] TERMINAR \n");

            //Lee la condicion que elige para continuar                   
            condicion = tecla.next();

        }
        System.out.println("******************************************");
        System.out.println("******** Operaciones terminadas **********");
        System.out.println("******************************************");
   
    }
}