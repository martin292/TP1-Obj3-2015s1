package Juego

import org.scalatest._
import juego.Tablero

class TableroSpec extends FlatSpec with Matchers{

  "Crear Celdas Rectangulares" should "crear 16 celdas" in{    
    val tablero = new Tablero(4, 4)    
    tablero.crearCeldasRectangulares()
    tablero.celdas.size should be(16)  
  }
 
}