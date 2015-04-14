package juego

import scala.collection.mutable.ListBuffer

class Rectangular extends Celda {

  var x = 0
  var y = 0
  var vecinas = new ListBuffer[Celda]  
   
  
  /**
   * Agrega las celdas vecinas a la lista
   */
  override def agregarVecinas(tablero: Tablero){
    
    val norte = retornarVecina(tablero.celdas, x, y+1)
    val sur = retornarVecina(tablero.celdas, x, y-1)
    val este = retornarVecina(tablero.celdas, x+1, y)
    val oeste = retornarVecina(tablero.celdas, x-1, y)
    val noreste = retornarVecina(tablero.celdas, x+1, y+1)
    val noroeste = retornarVecina(tablero.celdas, x-1, y+1)
    val sureste = retornarVecina(tablero.celdas, x+1, y-1)
    val suroeste = retornarVecina(tablero.celdas, x-1, y-1)
    
    var lista = ListBuffer(norte, sur, este, oeste, noreste, noroeste, sureste, suroeste)
    
    this.vecinas = lista.filter{_ != null}
  }
  
  /**
   * Busca y retorna una celda el la posicion x = posX y = posY
   */
  def retornarVecina(celdas : ListBuffer[Celda], posX: Int, posY: Int): Celda = {
    val celda = celdas filter { celda => celda.x == posX && celda.y == posY }
    if(celda.isEmpty){
      return null
    }
    val vecina = celda.head
    return vecina

  }  
  
  override def vecindad(): Vecindad = {
    val vecindad = new Vecindad()
    
    vecindad.personajes.appendAll(personajes)
    vecinas.foreach { c => vecindad.personajes.appendAll(c.personajes) }
    
    vecindad
  } 
    
}