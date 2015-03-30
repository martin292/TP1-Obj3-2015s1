package juego

class Pancho extends Opcion {
  
  /**
   * ​Para cualquier personaje, la decisión es quedarse en el lugar.
   */
  override def debeMoverse(personaje: Personaje): Boolean ={
    return false
  }
  
}