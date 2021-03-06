package Juego

import org.scalatest._
import juego._

class Escenario2Spec extends FlatSpec with Matchers{

  def fixture =
    new {
      val jugadorA = new Jugador()
      val jugadorB = new Jugador()
    
      val tablero = new Tablero(4, 4)
      tablero.crearCeldasRectangulares()
      
      //Personajes del jugador A----------------------------------------------------------------------
      var a1 = new Personaje(jugadorA, 10, 10, 10)
      var a2 = new Personaje(jugadorA, 10, 10, 10)
      var a3 = new Personaje(jugadorA, 10, 10, 10)
      var a4 = new Personaje(jugadorA, 10, 10, 10)
      var a5 = new Personaje(jugadorA, 10, 10, 10)
      
      a1.celda = tablero.celdas.filter { c => (c.x == 0) && (c.y == 0) }.head
      a2.celda = tablero.celdas.filter { c => (c.x == 3) && (c.y == 2) }.head
      a3.celda = tablero.celdas.filter { c => (c.x == 3) && (c.y == 1) }.head
      a4.celda = tablero.celdas.filter { c => (c.x == 2) && (c.y == 0) }.head
      a5.celda = tablero.celdas.filter { c => (c.x == 2) && (c.y == 2) }.head
      
      tablero.celdas.filter { c => (c.x == 0) && (c.y == 0) }.head.personajes.+=(a1)
      tablero.celdas.filter { c => (c.x == 3) && (c.y == 2) }.head.personajes.+=(a2)
      tablero.celdas.filter { c => (c.x == 3) && (c.y == 1) }.head.personajes.+=(a3)
      tablero.celdas.filter { c => (c.x == 2) && (c.y == 0) }.head.personajes.+=(a4)
      tablero.celdas.filter { c => (c.x == 2) && (c.y == 2) }.head.personajes.+=(a5)
      
      jugadorA.opcion = new Colaborador
      jugadorA.politica = new EvitarProblemas
           
      //----------------------------------------------------------------------------------------------
      
      //Personajes del jugador A----------------------------------------------------------------------
      var b1 = new Personaje(jugadorB, 1, 1, 1)
      var b2 = new Personaje(jugadorB, 100, 1, 1)
      
      b1.celda = tablero.celdas.filter { c => (c.x == 0) && (c.y == 1) }.head
      b2.celda = tablero.celdas.filter { c => (c.x == 2) && (c.y == 2) }.head
      
      tablero.celdas.filter { c => (c.x == 0) && (c.y ==1) }.head.personajes.+=(b1)
      tablero.celdas.filter { c => (c.x == 2) && (c.y == 2) }.head.personajes.+=(b2)
      
      jugadorB.opcion = new Colaborador
      jugadorB.politica = new SegunComoMeSiento
      
      //----------------------------------------------------------------------------------------------
      
    }
  
  
  "Sugerencia A1" should "ser Moverse" in{    
    var sugerencia = fixture.jugadorA.generarSugerencia(fixture.a1)
    
    sugerencia.str should be ("Moverse")
    sugerencia.celda.x should be (0)
    sugerencia.celda.y should be (1)
  }
  
  "Sugerencia A2" should "ser Moverse" in{
    var sugerencia = fixture.jugadorA.generarSugerencia(fixture.a2)
    
    sugerencia.str should be ("Quedarse en el lugar")
  }
  
  "Sugerencia B1" should "ser Moverse" in{    
    var sugerencia = fixture.jugadorB.generarSugerencia(fixture.b1)
    
    sugerencia.str should be ("Moverse")
  }
  
  "Sugerencia B2" should "ser Moverse" in{    
    var sugerencia = fixture.jugadorB.generarSugerencia(fixture.b2)
    
    sugerencia.str should be ("Moverse")
  }
  
}