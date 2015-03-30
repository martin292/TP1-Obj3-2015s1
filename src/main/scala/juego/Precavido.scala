package juego

class Precavido extends Opcion {

  /**
   * Se queda si en ninguna casilla vecina hay un enemigo (o sea, un personaje perteneciente a otro jugador) con más energía que él.
   * 
   */
  override def debeMoverse(personaje: Personaje): Boolean ={
    return personaje.celda.hayEnemigoConMasEnergia(personaje)    
  }
  
}