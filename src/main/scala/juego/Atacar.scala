package juego

class Atacar extends Politica {

  /**
   * ​ir a la celda en la cual la suma de las potencias de defensa de los
     personajes enemigos sea menor, contando solamente las celdas en las que haya al
     menos un enemigo. 
     Si en ninguna de las celdas vecinas hay enemigos, entonces elegir una cualquiera
   */
  override def retSugerencia(personaje: Personaje): Sugerencia ={
    var sugerencia = new Sugerencia("Moverse")
    
    sugerencia.celda = personaje.celda.retCeldaMenorPotencialDeDefensa(personaje)
    
    return sugerencia
  }
  
}