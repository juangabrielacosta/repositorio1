//import java.util.*; 
/** Abstraccion de un docente en la clase Docente.
 * Devuelve valor de verdad si el docente es responsable.
 * Devuelve una cadena con el nombre de la clase.
 * Permite agregar dias para prestamos de libros.
 * 
 * @author Grupo 5-2
 * @version 1.0
 */
public class Docente extends Socio {
  private String area;
  
  /**Constructor de Docente.
  */
  public Docente(int p_dniSocio, String p_nombre, String p_area) {
      super(p_dniSocio, p_nombre, 5);
      setArea(p_area);
  }
  
  /**Constructor de Docente. No recibe el nombre del docente.
  */
  public Docente(int p_dniSocio, String p_area) {
      super(p_dniSocio, 5);
      setArea(p_area);
  }
  //setter
  private void setArea(String p_area) {
      this.area = p_area;
  }
  //getter
  public String getArea() {
      return this.area;
  }
  
  /**Agrega un valor ingresado por parametro a la cantidad de dias que el docente tiene para prestamos de libros.
   */
  public void agregarDiasDePrestamo(int p_dias) {
      super.setDiasPrestamo(getDiasPrestamo() + p_dias);
  }
  
  /**Devuelve un valor de verdadero o falso segun si el docente es responsable.
   * El docente es responsable si nunca tuvo un prestamo vencido.
   */
  public boolean esResponsable() {
      if (this.puedePedir()) {
          return true;
      } else {
          return false;
      }
  }
  
  /**Devuelve una cadena con el nombre de la clase, en este caso 'Docente'.
   */
  public String soyDeLaClase() {
      return "Docente";
  }
}