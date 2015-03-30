package juego

class Colaborador extends Opcion {

  /**
   * ​se queda si en dos (o más) celdas vecina hay, al menos, un compañero en cada una, caso contrario elige moverse.
   */
  override def debeMoverse(personaje: Personaje): Boolean ={
    return !personaje.celda.hayColaboradores(personaje)
  }
  
}