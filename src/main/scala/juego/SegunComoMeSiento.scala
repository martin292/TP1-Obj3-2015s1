package juego

class SegunComoMeSiento extends Politica {

  
  /**
   * ​si la energía del personaje es mayor a 50, salir a atacar; en caso contrario, evitar problemas
   */
  override def retSugerencia(personaje: Personaje): Sugerencia ={
    var politica = new EvitarProblemas()
    if(personaje.energia > 50){
      var politica = new Atacar()
      return politica.retSugerencia(personaje)
    }
    return politica.retSugerencia(personaje)
  }
  
}