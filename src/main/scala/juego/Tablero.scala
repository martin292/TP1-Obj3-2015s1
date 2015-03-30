package juego

import scala.collection.mutable.ListBuffer

class Tablero(alto: Int, ancho: Int){

  var celdas = ListBuffer[Celda]()
  
  /**
   * Crea N celdas rectangulares y las agrega a la lista
   */
  def crearCeldasRectangulares() = {
    for(y <- 0 to (alto-1)){
      for(x <- 0 to (ancho-1)){
        var celda = new Rectangular()
        celda.y = y
        celda.x = x
        celdas.+=(celda)
      }
    }    
    celdas.foreach { celda => celda.agregarVecinas(this) }
  }
  
}