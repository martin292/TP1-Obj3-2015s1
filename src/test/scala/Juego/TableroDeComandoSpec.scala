package Juego

import org.scalatest._
import juego._

class TableroDeComandoSpec extends FlatSpec with Matchers{

  def massiveCheck(algo: TableroDeComando, cantP: Int, densidad: Int, medAtaque: Int, medDefensa: Int) = { }
  
  "una celda" should "hacer bien las cuentas" in{
    val celda= new Rectangular()
    massiveCheck(celda.vecindad,7,3,20,12)
  }

  
}