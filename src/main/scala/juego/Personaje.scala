package juego

class Personaje(val jugador: Jugador, val energia: Int, val escudo: Int, val experiencia: Int) { 
  
  var celda: Celda = null
  
  var opcion: Opcion = null
  var politica: Politica = null
  
  /**
   * Retorna la potencia de ataque
   */
  def ataque(): Int ={
    return (energia/3) + (experiencia/5)
  }
  
  /**
   * Retorna la potencia de defensa
   */
  def defensa(): Int ={
    return escudo + (energia/10) + (experiencia/3)
  }
  
  /**
   * Retorna una sugerencia
   */
  def generarSugerencia(): Sugerencia = {
    if(eligeMoverse){
      return politica.retSugerencia(this)
    }
    return new Sugerencia("Quedarse en el lugar")
  }
  
  /**
   * Retorna true si elige moverse, false en caso contrario
   */
  def eligeMoverse(): Boolean ={
    return opcion.debeMoverse(this)
  }
  
}