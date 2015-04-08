package Juego

import org.scalatest._
import juego._

class AumentoMasivoExperienciaSpec extends FlatSpec with Matchers{

  def fixture =
    new {
    
      var jugador = new Jugador()
      var celda = new Rectangular()
      
      var p1 = new Personaje(jugador, 10, 0, 0)
      var p2 = new Personaje(jugador, 1, 0, 0)
      var p3 = new Personaje(jugador, 50, 0, 0)
            
      jugador.personajes +=(p1)
      jugador.personajes +=(p2)
      jugador.personajes +=(p3)
      
      celda.personajes +=(p1)
      celda.personajes +=(p2)
      celda.personajes +=(p3)      
      
      var aumentadorJugador = new AumentoMasivoExperiencia(jugador)
      var aumentadorCelda = new AumentoMasivoExperiencia(celda)
  }
  
  "Ejecutar con Jugador" should "aumentar experiencia de p1 y p3" in{
    fixture.aumentadorJugador.ejecutar
        
    fixture.aumentadorJugador.seEjecuto should be (true)
    
    fixture.p1.experiencia should be (2)
    fixture.p2.experiencia should be (0)
    fixture.p3.experiencia should be (2)
  }
  
  "Ejecutar con Celda" should "aumentar experiencia de p1 y p3" in{
    fixture.aumentadorCelda.ejecutar
        
    fixture.aumentadorCelda.seEjecuto should be (true)
    
    fixture.p1.experiencia should be (4)
    fixture.p2.experiencia should be (0)
    fixture.p3.experiencia should be (4)
  }
  
  
}