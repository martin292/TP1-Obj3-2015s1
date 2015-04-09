package juego

import scala.collection.mutable.ListBuffer

trait TableroDeComando {

  def personajes(): ListBuffer[Personaje]
  
  def cantidadDePersonajes(): Int = {
    personajes.length
  }
  
  def medianaDeAtaque(): Int = {
    val aux = new ListBuffer[Int]
    personajes.foreach { p => aux += p.ataque }
    aux.apply(aux.size/2)
  }
  
  def medianaDeDefensa(): Int = {
    val aux = new ListBuffer[Int]
    personajes.foreach { p => aux += p.defensa() }
    aux.apply(aux.size/2)
  }
  
  def personajeConMayorExperiencia(): Personaje = {
    personajes.maxBy { p => p.experiencia }
  }
  
  def personajesConLaDefensaMayorA(defensa: Int): ListBuffer[Personaje] = {
    personajes.filter { p => p.defensa() > defensa }
  }
  
}