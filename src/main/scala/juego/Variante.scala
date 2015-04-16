package juego

import scala.collection.mutable.ListBuffer

trait Variante extends Personaje {}

//---------------------------------------------------------------------------------------

trait PoderGrupal extends Variante{
  this: Personaje =>  
    
    override def ataque(): Int = {
      val vecindad = this.celda.vecindad()
    
      val lista = vecindad.personajes.filter { p => p.jugador == this.jugador }
    
      (10 * sumatoriaDeEnergia(lista))/100 + super.ataque()
    }
  
    def sumatoriaDeEnergia(lista: ListBuffer[Personaje]):Int ={
      var sumatoria = 0    
      lista.foreach { p => sumatoria += p.energia }
      sumatoria
    }  
}

//---------------------------------------------------------------------------------------

trait CoberturaGlobal extends Variante{  
  this: Personaje =>
    var n: Int = 0
    
    def sumarCobertura() = { 
      this.escudo = (n * sumatoriaDeExperiencia(this.jugador.personajes))/100 + this.escudo
    }
      
    def sumatoriaDeExperiencia(lista: ListBuffer[Personaje]):Int ={
      var sumatoria = 0    
      lista.foreach { p => sumatoria += p.experiencia }
      sumatoria
    }
  
}

//---------------------------------------------------------------------------------------

trait AprobechaEntorno extends Variante{
  this: Personaje =>
    val items = new ListBuffer[Item]
    
    override def ataque(): Int = {
      sumatoriaDeAtaque + super.ataque()
    }
    
    override def defensa(): Int ={
      sumatoriaDeDefensa + super.defensa()
    }
    
    def sumatoriaDeAtaque():Int ={
      var sumatoria = 0    
      items.foreach { i => sumatoria += i.ataque }
      sumatoria
    }
    
    def sumatoriaDeDefensa():Int ={
      var sumatoria = 0    
      items.foreach { i => sumatoria += i.defensa }
      sumatoria
    }
    
}
