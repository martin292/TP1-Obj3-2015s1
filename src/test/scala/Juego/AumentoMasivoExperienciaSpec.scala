package Juego

import org.scalatest._
import juego._

class AumentoMasivoExperienciaSpec extends FlatSpec with Matchers{

  def fixture =
    new {
    
      val jugador = new Jugador()
      val celda = new Rectangular()
      
      val p1 = new Personaje(jugador, 10, 0, 0)
      val p2 = new Personaje(jugador, 1, 0, 0)
      val p3 = new Personaje(jugador, 50, 0, 0)
      
      val p4 = new Personaje(jugador, 10, 0, 0)
      val p5 = new Personaje(jugador, 1, 0, 0)
      val p6 = new Personaje(jugador, 50, 0, 0)
            
      jugador.personajes +=(p1)
      jugador.personajes +=(p2)
      jugador.personajes +=(p3)
      
      celda.personajes +=(p4)
      celda.personajes +=(p5)
      celda.personajes +=(p6)      
      
      val aumentadorJugador = new AumentoMasivoExperiencia(jugador)
      val aumentadorCelda = new AumentoMasivoExperiencia(celda)
      
      aumentadorJugador.ejecutar
      aumentadorCelda.ejecutar
  }
  
  
  "Con Jugador" should "aumentar experiencia de p1 y p3" in{    
        
    fixture.aumentadorJugador.seEjecuto should be (true)
    
    fixture.p1.experiencia should be (2)
    fixture.p2.experiencia should be (0)
    fixture.p3.experiencia should be (2)
    
    fixture.aumentadorJugador.toString() should be ("Aumento masivo de experiencia sobre Jugador :  ejecutado")
  }
  
  "Con Celda" should "aumentar experiencia de p4 y p6" in{    
        
    fixture.aumentadorCelda.seEjecuto should be (true)
    
    fixture.p1.experiencia should be (2)
    fixture.p2.experiencia should be (0)
    fixture.p3.experiencia should be (2)
    
    fixture.aumentadorCelda.toString() should be ("Aumento masivo de experiencia sobre Celda :  ejecutado")
  }
  
  
}