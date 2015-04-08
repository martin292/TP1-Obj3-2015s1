package juego

import scala.collection.mutable.ListBuffer


trait AumentadorDeExperiencia {

  def aumentarMasivamenteExperiencia(): Unit = {
    this.personajes.foreach {p: Personaje => aumentar(p)}
  }
  
  def aumentar(p: Personaje): Unit = {
    if(p.energia >= 10){
      p.experiencia = p.experiencia + 2
    }
  }
  
  def personajes(): ListBuffer[Personaje]
  def nombre(): String
  
}