package juego

import scala.collection.mutable.ListBuffer

class Jugador extends AumentadorDeExperiencia{
  val personajes = ListBuffer[Personaje]()
  
  var opcion: Opcion = null
  var politica: Politica = null
  
  def nombre = "Jugador"
  
  /**
   * Retorna una sugerencia
   */
  def generarSugerencia(p: Personaje): Sugerencia = {
    if(eligeMoverse(p)){
      return politica.retSugerencia(p)
    }
    return new Sugerencia("Quedarse en el lugar")
  }
  
  /**
   * Retorna true si elige moverse, false en caso contrario
   */
  def eligeMoverse(p: Personaje): Boolean ={
    return opcion.debeMoverse(p)
  }
  
}