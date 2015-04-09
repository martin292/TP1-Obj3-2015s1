package juego

class AumentoMasivoExperiencia(val sobreQueCosa: AumentadorDeExperiencia){

  var seEjecuto = false
  
  def ejecutar{
    if(!seEjecuto)this.sobreQueCosa.aumentarMasivamenteExperiencia   
    this.seEjecuto = true
  }

  override def toString = {
    "Aumento masivo de experiencia sobre " + sobreQueCosa.nombre + " : " + (if(seEjecuto) " ejecutado" else " pendiente")
  }

  
}