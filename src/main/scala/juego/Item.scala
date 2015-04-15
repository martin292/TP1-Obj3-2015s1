package juego

abstract class Item {
  val defensa: Int
  val ataque: Int
}

class SableLaser extends Item {
  val ataque = 2
  val defensa = 0
}

class EscudoDeRoble extends Item {
  val ataque = 0
  val defensa = 3
}