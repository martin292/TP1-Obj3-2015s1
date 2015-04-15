package juego

class Personaje(val jugador: Jugador, val energia: Int, var escudo: Int, var experiencia: Int) { 
  
  var celda: Celda = null
  
  
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
      
}