package juego

class EvitarProblemas extends Politica {

  /**
   * ​Ir a la celda vecina en la cual la suma de las potencias de ataque de los personajes enemigos sea menor
   */
  override def retSugerencia(personaje: Personaje): Sugerencia ={
    var sugerencia = new Sugerencia("Moverse")
    
    sugerencia.celda = personaje.celda.retCeldaMenorPotencialDeAtaque(personaje)
    
    return sugerencia
  }
  
}