package juego

import scala.collection.mutable.ListBuffer

abstract class Celda {

  var x: Int
  var y: Int  
  var vecinas: ListBuffer[Celda]
  var personajes: ListBuffer[Personaje]
  
  def agregarVecinas(tablero: Tablero)
  def contieneEnemigoConMasEnergia(jugador: Jugador, energia: Int): Boolean
  def hayEnemigoConMasEnergia(personaje: Personaje): Boolean
  def hayColaboradores(personaje: Personaje): Boolean
  def hayCompañero(jugador: Jugador): Boolean
  def sumaDeAtaque(jugador: Jugador): Int
  def retCeldaMenorPotencialDeAtaque(personaje: Personaje): Celda
  def retCeldaMenorPotencialDeDefensa(personaje: Personaje): Celda
  def contieneEnemigo(jugador: Jugador): Boolean
  def sumaDeDefensa(jugador: Jugador): Int
  def retCeldaAReforzar(personaje: Personaje): Celda
  def sumarPotencialesDeAtaque(personaje: Personaje): Int
  def sumarAtaque(jugador:Jugador): Int
}