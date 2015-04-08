package Juego

import org.scalatest._
import juego._

class AumentoMasivoExperienciaSpec extends FlatSpec with Matchers{

  def fixture =
    new {
    
      val jugador = new Jugador
      
      val p1 = new Personaje(jugador, 10, 1, 0)
      val p2 = new Personaje(jugador, 50, 1, 0)
      val p3 = new Personaje(jugador, 1, 1, 0)
            
      jugador.personajes +=(p1)
      jugador.personajes +=(p2)
      jugador.personajes +=(p3)
      
      //------------------------------------------------
      
      val celda = new Rectangular()
    
      val p4 = new Personaje(jugador, 10, 1, 0)
      val p5 = new Personaje(jugador, 50, 1, 0)
      val p6 = new Personaje(jugador, 1, 1, 0)
      
      celda.personajes +=(p4)
      celda.personajes +=(p5)
      celda.personajes +=(p6)
      
  }
  
  "Ejecutar1" should "aumentar experiencia de p1 y p2" in{
    val aumentador1 = new AumentoMasivoExperiencia(fixture.jugador)
    aumentador1.ejecutar
    
    aumentador1.seEjecuto should be (true)
    
    fixture.p1.experiencia should be (2)
    fixture.p2.experiencia should be (2)
    fixture.p3.experiencia should be (0)
  }
  
  "Ejecutar2" should "aumentar experiencia de p4 y p5" in{
    val aumentador2 = new AumentoMasivoExperiencia(fixture.celda)
    aumentador2.ejecutar
    
    aumentador2.seEjecuto should be (true)
    
    fixture.p4.experiencia should be (2)
    fixture.p5.experiencia should be (2)
    fixture.p6.experiencia should be (0)
  }
  
  
}