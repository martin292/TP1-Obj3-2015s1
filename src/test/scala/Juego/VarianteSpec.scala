package Juego

import org.scalatest._
import juego._

class VarianteSpec extends FlatSpec with Matchers{

  def fixture =
    new{
      //
      val jugador1 = new Jugador()
      val jugador2 = new Jugador()
      
      val tablero = new Tablero(2,2)
      tablero.crearCeldasRectangulares()
      
      val p1 = new Personaje(jugador1, 30, 1, 5) with PoderGrupal
      val p2 = new Personaje(jugador1, 30, 1, 5) with CoberturaGlobal
      val p3 = new Personaje(jugador1, 30, 1, 5) with AprobechaEntorno
      val p4 = new Personaje(jugador2, 30, 1, 5) with PoderGrupal with AprobechaEntorno
      
      p1.celda = tablero.celdas.filter { c => (c.x == 0) && (c.y == 0) }.head
      p2.celda = tablero.celdas.filter { c => (c.x == 1) && (c.y == 0) }.head
      p3.celda = tablero.celdas.filter { c => (c.x == 0) && (c.y == 1) }.head
      p4.celda = tablero.celdas.filter { c => (c.x == 1) && (c.y == 1) }.head
      
      tablero.celdas.filter { c => (c.x == 0) && (c.y == 0) }.head.personajes.+=(p1)
      tablero.celdas.filter { c => (c.x == 1) && (c.y == 0) }.head.personajes.+=(p2)
      tablero.celdas.filter { c => (c.x == 0) && (c.y == 1) }.head.personajes.+=(p3)
      tablero.celdas.filter { c => (c.x == 1) && (c.y == 1) }.head.personajes.+=(p4)
      
      val item1 = new SableLaser()
      val item2 = new EscudoDeRoble()
      p3.items += item1
      p3.items += item2
      p4.items += item1
      p4.items += item2
      
      p2.n = 50
      p2.sumarCobertura()
      //
  }
  
  "Ataque de p1" should "ser igual a 20" in{
    fixture.p1.ataque() should be (20)
  }
  
  "Escudo de p2" should "ser igual a 10" in {
    fixture.p2.n should be (50)
    fixture.p2.escudo should be (8)
  }
  
  "Ataque y Defensa de p3" should "ser 13 y 8" in{    
    fixture.p3.ataque() should be (13)
    fixture.p3.defensa() should be (8)
  }
  
  "Ataque y Defensa de p4" should "ser 16 y 8" in{    
    fixture.p4.ataque() should be (16)
    fixture.p4.defensa() should be (8)
  }
  
}