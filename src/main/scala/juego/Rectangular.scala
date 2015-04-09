package juego

import scala.collection.mutable.ListBuffer

class Rectangular extends Celda {

  var x = 0
  var y = 0
  var vecinas = new ListBuffer[Celda]
  
  override def vecindad(): Vecindad = {
    val vecindad = new Vecindad()
    
    vecindad.personajes.appendAll(personajes)
    vecinas.foreach { c => vecindad.personajes.appendAll(c.personajes) }
    
    vecindad
  }
  
  
  /**
   * Agrega las celdas vecinas a la lista
   */
  override def agregarVecinas(tablero: Tablero){
    
    val norte = retornarVecina(tablero.celdas, x, y+1)
    val sur = retornarVecina(tablero.celdas, x, y-1)
    val este = retornarVecina(tablero.celdas, x+1, y)
    val oeste = retornarVecina(tablero.celdas, x-1, y)
    val noreste = retornarVecina(tablero.celdas, x+1, y+1)
    val noroeste = retornarVecina(tablero.celdas, x-1, y+1)
    val sureste = retornarVecina(tablero.celdas, x+1, y-1)
    val suroeste = retornarVecina(tablero.celdas, x-1, y-1)
    
    var lista = ListBuffer(norte, sur, este, oeste, noreste, noroeste, sureste, suroeste)
    
    this.vecinas = lista.filter{_ != null}
  }
  
  /**
   * Busca y retorna una celda el la posicion x = posX y = posY
   */
  def retornarVecina(celdas : ListBuffer[Celda], posX: Int, posY: Int): Celda = {
    val celda = celdas filter { celda => celda.x == posX && celda.y == posY }
    if(celda.isEmpty){
      return null
    }
    val vecina = celda.head
    return vecina

  }
  
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
  override def contieneEnemigoConMasEnergia(jugador: Jugador, energia: Int): Boolean ={
    return this.personajes.exists { personaje => (esContrario(personaje, jugador)) && (tieneMasEnergia(personaje, energia)) }
  }
  
  /**
   * Retorna true si en alguna celda vecina hay un enemigo con mas energia
   */
  override def hayEnemigoConMasEnergia(personaje: Personaje): Boolean ={
    return this.vecinas.exists { celda => celda.contieneEnemigoConMasEnergia(personaje.jugador, personaje.energia) }
  }
  
  /**
   * Retorna true si existe un personaje del mismo equipo
   */
  override def hayCompañero(jugador: Jugador): Boolean ={
    return this.personajes.exists { p => p.jugador == jugador }
  }
  
  /**
   * Retorna true si hay 2 o mas celdas con compañero
   */
  override def hayColaboradores(personaje: Personaje): Boolean ={
    return 2 <= this.vecinas.count { celda => celda.hayCompañero(personaje.jugador) }
  }
  
  //***************************************************************************************************************************
  
  def sumarPotencialDeAtaque(lista: ListBuffer[Personaje]):Int ={
    var sumatoria = 0    
    lista.foreach { p => sumatoria += p.ataque() }
    return sumatoria
  }
  
  override def sumaDeAtaque(jugador: Jugador): Int ={
    val lista = this.personajes.filter { p => esContrario(p, jugador) }
    return sumarPotencialDeAtaque(lista)
  }
  
  /**
   * Retorna la celda vecina con la menor potencia de ataque (enemigo)
   */
  override def retCeldaMenorPotencialDeAtaque(personaje: Personaje): Celda ={
    return vecinas.minBy { celda => celda.sumaDeAtaque(personaje.jugador) }
  }
  
  //***************************************************************************************************************************
  
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
  override def retCeldaMenorPotencialDeDefensa(personaje: Personaje): Celda ={
    val lista = this.vecinas.filter { celda => celda.contieneEnemigo(personaje.jugador) }
    if(lista.isEmpty){
      return this.vecinas.head //TODO
    }    
    return lista.minBy { celda => celda.sumaDeDefensa(personaje.jugador) }
  }
  
  //***************************************************************************************************************************
  
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
  
  override def retCeldaAReforzar(personaje: Personaje): Celda ={
    val lista = this.vecinas.filter { celda => celda.hayCompañero(personaje.jugador) }
    return lista.maxBy { celda => celda.sumarPotencialesDeAtaque(personaje) }
  }
  
  
    
}