package juego

abstract class Opcion {

  def debeMoverse(personaje: Personaje): Boolean
  
}