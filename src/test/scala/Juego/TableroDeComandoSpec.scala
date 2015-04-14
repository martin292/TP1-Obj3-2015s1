package Juego

import org.scalatest._
import juego._

class TableroDeComandoSpec extends FlatSpec with Matchers{

  def fixture =
    new {
      val jugador = new Jugador()
      
      val p1 = new Personaje(jugador, 30, 1, 30)
      val p2 = new Personaje(jugador, 30, 1, 15)
      val p3 = new Personaje(jugador, 30, 1, 0)
      
      jugador.personajes += p1
      jugador.personajes += p2
      jugador.personajes += p3
      
      val celda = new Rectangular()
      
      celda.personajes += p1
      celda.personajes += p2
      celda.personajes += p3
      
      val vecindad = new Vecindad()
      
      vecindad.personajes += p1
      vecindad.personajes += p2
      vecindad.personajes += p3
  }
  
  
  def chequeoMasivo(algo: TableroDeComando, cantP: Int, densidad: Int, medAtaque: Int, medDefensa: Int) = { 
    assert(algo.cantidadDePersonajes() == cantP)
    assert(algo.medianaDeAtaque() == medAtaque)
    assert(algo.medianaDeDefensa() == medDefensa)
  }
    
  "ChequeoMasivo" should "Funcionar con jugador" in{
    chequeoMasivo(fixture.jugador, 3, 3, 13, 9)
  }
  
  "ChequeoMasivo" should "Funcionar con celda" in{
    chequeoMasivo(fixture.celda, 3, 3, 13, 9)
  }
  
  "ChequeoMasivo" should "Funcionar con vecindad" in{
    chequeoMasivo(fixture.vecindad, 3, 3, 13, 9)
  }
  
  "queJugadoresTienenPersonaje" should "ser jugador" in{
    fixture.jugador.queJugadoresTienenPersonaje().size should be (1)
    fixture.celda.queJugadoresTienenPersonaje().size should be (1)
    fixture.vecindad.queJugadoresTienenPersonaje().size should be (1)
  }
  
  "PersonajeConMayorExperiencia" should "ser p1" in{
    fixture.jugador.personajeConMayorExperiencia().experiencia should be (30)
    fixture.celda.personajeConMayorExperiencia().experiencia should be (30)
    fixture.vecindad.personajeConMayorExperiencia().experiencia should be (30)
  }

  "personajesConLaDefensaMayorA" should "" in{
    fixture.jugador.personajesConLaDefensaMayorA(9).size should be (1)
    fixture.celda.personajesConLaDefensaMayorA(9).size should be (1)
    fixture.vecindad.personajesConLaDefensaMayorA(9).size should be (1)
  }
  
}