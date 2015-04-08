package juego

import scala.collection.mutable.ListBuffer

class Jugador extends AumentadorDeExperiencia{
  val personajes = ListBuffer[Personaje]()
  
  def nombre = "Jugador"
  
}