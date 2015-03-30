package juego

class Reforzar extends Politica {

  /**
   * ​ir a la celda en la que la suma de la potencia de ataque de los compañeros, en esa celda y sus vecinas, sea mayor.
   * 
   */
  override def retSugerencia(personaje: Personaje): Sugerencia ={
    var sugerencia = new Sugerencia("Moverse")
    
    sugerencia.celda = personaje.celda.retCeldaAReforzar(personaje)
    
    return sugerencia
  }
  
}