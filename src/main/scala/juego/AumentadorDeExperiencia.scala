package juego

import scala.collection.mutable.ListBuffer

trait AumentadorDeExperiencia {

  def personajes(): ListBuffer[Personaje]
  
  /**
   * Aumenta en 2 la experiencia de los personajes cuya energia es >= a 10
   */
  def aumentarMasivamenteExperiencia = {
    this.personajes.foreach { p => if(p.energia >= 10){p.experiencia += 2}}
  }
    
  def nombre(): String
  
}