package juego

import scala.collection.mutable.ListBuffer

trait AumentadorDeExperiencia {

  var personajes = ListBuffer[Personaje]()
  
  def aumentarMasivamenteExperiencia(): Unit = {
    personajes.foreach {p => if(p.energia >= 10){p.experiencia += 2}}
  }
    
  def nombre(): String
  
}