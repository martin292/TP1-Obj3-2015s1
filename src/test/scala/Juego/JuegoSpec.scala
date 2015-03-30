package Juego

import org.scalatest._
import juego._

class JuegoSpec extends FlatSpec with Matchers{

  def fixture =
    new {
      val jugadorA = new Jugador()
      val jugadorB = new Jugador()
    
      val tablero = new Tablero(4, 4)
      tablero.crearCeldasRectangulares()
      
      //Personajes del jugador A----------------------------------------------------------------------
      var a1 = new Personaje(jugadorA, 1, 1, 1)
      var a2 = new Personaje(jugadorA, 1, 1, 1)
      var a3 = new Personaje(jugadorA, 10, 10, 10)
    
      a1.celda = tablero.celdas.filter { c => (c.x == 0) && (c.y == 0) }.head
      a2.celda = tablero.celdas.filter { c => (c.x == 0) && (c.y == 0) }.head
      a3.celda = tablero.celdas.filter { c => (c.x == 2) && (c.y == 0) }.head
    
      tablero.celdas.filter { c => (c.x == 0) && (c.y == 0) }.head.personajes.+=(a1)
      tablero.celdas.filter { c => (c.x == 0) && (c.y == 0) }.head.personajes.+=(a2)
      tablero.celdas.filter { c => (c.x == 2) && (c.y == 0) }.head.personajes.+=(a3)
    
      a1.opcion = new Pancho
      a2.opcion = new Pancho
      a3.opcion = new Pancho
      a1.politica = new EvitarProblemas
      a2.politica = new EvitarProblemas
      a3.politica = new EvitarProblemas
      //----------------------------------------------------------------------------------------------
      
      //Personajes del jugador B----------------------------------------------------------------------
      var b1 = new Personaje(jugadorB, 10, 10, 10)
      var b2 = new Personaje(jugadorB, 10, 10, 10)
      var b3 = new Personaje(jugadorB, 10, 10, 10)
      var b4 = new Personaje(jugadorB, 10, 10, 10)
      var b5 = new Personaje(jugadorB, 1, 1, 1)
      
      b1.celda = tablero.celdas.filter { c => (c.x == 3) && (c.y == 3) }.head
      b2.celda = tablero.celdas.filter { c => (c.x == 2) && (c.y == 3) }.head
      b3.celda = tablero.celdas.filter { c => (c.x == 3) && (c.y == 2) }.head
      b4.celda = tablero.celdas.filter { c => (c.x == 0) && (c.y == 1) }.head
      b5.celda = tablero.celdas.filter { c => (c.x == 3) && (c.y == 0) }.head
      
      tablero.celdas.filter { c => (c.x == 3) && (c.y == 3) }.head.personajes.+=(b1)
      tablero.celdas.filter { c => (c.x == 2) && (c.y == 3) }.head.personajes.+=(b2)
      tablero.celdas.filter { c => (c.x == 3) && (c.y == 2) }.head.personajes.+=(b3)
      tablero.celdas.filter { c => (c.x == 0) && (c.y == 1) }.head.personajes.+=(b4)
      tablero.celdas.filter { c => (c.x == 3) && (c.y == 0) }.head.personajes.+=(b5)
      
      b1.opcion = new Colaborador
      b4.opcion = new Colaborador
      b5.opcion = new Colaborador
      b1.politica = new Atacar
      b4.politica = new Atacar
      b5.politica = new Atacar
      
      //----------------------------------------------------------------------------------------------
      
    }
  
    
  "Sugerencias A" should "Ser quedarse en el lugar" in{    
    fixture.a1.generarSugerencia().str should be ("Quedarse en el lugar")
    fixture.a2.generarSugerencia().str should be ("Quedarse en el lugar")
    fixture.a3.generarSugerencia().str should be ("Quedarse en el lugar")
  }
  
  "Sugerencia B1" should "ser Quedarse en el lugar" in{    
    fixture.b1.generarSugerencia().str should be ("Quedarse en el lugar")
  }
  
  "Sugerencia B4" should "ser Moverse" in{    
    var sug = fixture.b4.generarSugerencia()
    
    sug.str should be ("Moverse")
    sug.celda.x should be (0)
    sug.celda.y should be (0)
  }
  
  "Sugerencia B5" should "ser Moverse" in{    
    var sugerencia = fixture.b5.generarSugerencia()
    
    sugerencia.str should be ("Moverse")
    sugerencia.celda.x should be (2)
    sugerencia.celda.y should be (0)
  }
   
  
  
  
  
}