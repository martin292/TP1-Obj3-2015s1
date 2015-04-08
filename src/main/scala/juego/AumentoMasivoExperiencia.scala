package juego

class AumentoMasivoExperiencia(val sobreQueCosa: AumentadorDeExperiencia){

  var seEjecuto = false
  
  def ejecutar{
    if(!seEjecuto){
      sobreQueCosa.aumentarMasivamenteExperiencia   
      seEjecuto = true
    }
  }

  override def toString = {
    "Aumentomasivodeexperienciasobre" + sobreQueCosa.nombre + ":" + (if(seEjecuto) "ejecutado" else "pendiente")
  }

  
}