package juego

import scala.collection.mutable.ListBuffer

trait TableroDeComando {

  def personajes(): ListBuffer[Personaje]
  
  /**
   * Retorna cuántos personajes hay  
   */
  def cantidadDePersonajes(): Int = {
    personajes.length
  }
  
  /**
   * Retorna la mediana de potencia de ataque. 
   * “Mediana” quiere decir el valor que está en el medio ordenando los números, p.ej. la mediana de [1,1,2,4,21,22,23] es 4.
   */
  def medianaDeAtaque(): Int = {
    val aux = new ListBuffer[Int]
    personajes.foreach { p => aux += p.ataque }
    aux.sorted
    aux.apply(aux.size/2)
  }
  
  /**
   * Retorna la mediana de potencia de defensa
   */
  def medianaDeDefensa(): Int = {
    val aux = new ListBuffer[Int]
    personajes.foreach { p => aux += p.defensa() }
    aux.sorted
    aux.apply(aux.size/2)
  }
  
  /**
   * Retorna el personaje con más experiencia
   */
  def personajeConMayorExperiencia(): Personaje = {
    personajes.maxBy { p => p.experiencia }
  }
  
  /**
   * Retorna el conjunto (o lista, o lo que sea) de personajes cuya potencia de defensa supera un parámetro
   */
  def personajesConLaDefensaMayorA(defensa: Int): ListBuffer[Personaje] = {
    personajes.filter { p => p.defensa() > defensa }
  }
  
}