package juego

import scala.collection.mutable.ListBuffer

abstract class Celda extends AumentadorDeExperiencia with TableroDeComando{

  var x: Int
  var y: Int  
  var vecinas: ListBuffer[Celda]
  var personajes = ListBuffer[Personaje]()
  
  
  /**
   * Retorna true si es del equipo contrario
   */
  def esContrario(personaje: Personaje, jugador: Jugador): Boolean ={
    return personaje.jugador != jugador
  }
  
  /**
   * Retorna true si tiene mas energia
   */
  def tieneMasEnergia(personaje: Personaje, energia: Int): Boolean ={
    return personaje.energia > energia
  }
  
  /**
   * Retorna true si hay un personaje (enemigo) con mas energia
   */
  def contieneEnemigoConMasEnergia(jugador: Jugador, energia: Int): Boolean ={
    return this.personajes.exists { personaje => (esContrario(personaje, jugador)) && (tieneMasEnergia(personaje, energia)) }
  }
  
  /**
   * Retorna true si en alguna celda vecina hay un enemigo con mas energia
   */
  def hayEnemigoConMasEnergia(personaje: Personaje): Boolean ={
    return this.vecinas.exists { celda => celda.contieneEnemigoConMasEnergia(personaje.jugador, personaje.energia) }
  }  
  
  /**
   * Retorna true si existe un personaje del mismo equipo
   */
  def hayCompañero(jugador: Jugador): Boolean ={
    return this.personajes.exists { p => p.jugador == jugador }
  }
  
  /**
   * Retorna true si hay 2 o mas celdas con compañero
   */
  def hayColaboradores(personaje: Personaje): Boolean ={
    return 2 <= this.vecinas.count { celda => celda.hayCompañero(personaje.jugador) }
  }
  
  //********************************************************************************************************************************
  
  def sumarPotencialDeAtaque(lista: ListBuffer[Personaje]):Int ={
    var sumatoria = 0    
    lista.foreach { p => sumatoria += p.ataque() }
    return sumatoria
  }
  
  def sumaDeAtaque(jugador: Jugador): Int ={
    val lista = this.personajes.filter { p => esContrario(p, jugador) }
    return sumarPotencialDeAtaque(lista)
  }
  
  /**
   * Retorna la celda vecina con la menor potencia de ataque (enemigo)
   */
  def retCeldaMenorPotencialDeAtaque(personaje: Personaje): Celda ={
    return vecinas.minBy { celda => celda.sumaDeAtaque(personaje.jugador) }
  }
  
  //********************************************************************************************************************************
  def potencialDeDefensa(lista: ListBuffer[Personaje]): Int ={
    var sumatoria = 0    
    lista.foreach { p => sumatoria += p.defensa() }
    return sumatoria 
  }
  
  def sumaDeDefensa(jugador: Jugador): Int ={
    val lista = this.personajes.filter { p => esContrario(p, jugador) }
    return potencialDeDefensa(lista)
  }
  
  /**
   * Retorna true si la celda contiene al menos un enemigo
   */
  def contieneEnemigo(jugador: Jugador): Boolean ={
    return this.personajes.exists { p => esContrario(p, jugador) }
  }
  
  /**
   * Retorna la celda vecina con menor potencial de defensa
   * En caso de que no alla enemigos  en las seldas vecinas, retorna una cualquiera
   */
  def retCeldaMenorPotencialDeDefensa(personaje: Personaje): Celda ={
    val lista = this.vecinas.filter { celda => celda.contieneEnemigo(personaje.jugador) }
    if(lista.isEmpty){
      return this.vecinas.head
    }    
    return lista.minBy { celda => celda.sumaDeDefensa(personaje.jugador) }
  }
  
  //********************************************************************************************************************************
  def sumarAtaque(jugador:Jugador): Int ={
    val lista = this.personajes.filter { p => p.jugador == jugador }
    return sumarPotencialDeAtaque(lista)
  }
  
  def sumarAtaqueDeVecinas(vecinas: ListBuffer[Celda], personaje: Personaje): Int ={
    var sumatoria = 0    
    vecinas.foreach { celda => sumatoria += celda.sumarAtaque(personaje.jugador) }
    return sumatoria 
    return 0
  }
  
  def sumarPotencialesDeAtaque(personaje: Personaje): Int ={
    val lista = this.personajes.filter { p => p.jugador == personaje.jugador }
    return sumarPotencialDeAtaque(lista) + sumarAtaqueDeVecinas(this.vecinas, personaje)
  }
  
  def retCeldaAReforzar(personaje: Personaje): Celda ={
    val lista = this.vecinas.filter { celda => celda.hayCompañero(personaje.jugador) }
    return lista.maxBy { celda => celda.sumarPotencialesDeAtaque(personaje) }
  }
  //********************************************************************************************************************************

  
  def nombre = "Celda"
  def agregarVecinas(tablero: Tablero)
  def vecindad(): Vecindad
}