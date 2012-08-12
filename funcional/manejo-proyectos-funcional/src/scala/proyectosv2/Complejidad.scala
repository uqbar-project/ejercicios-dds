package object proyectosv2 {

  type Impuesto = BigDecimal
  
  def ImpuestoA: Impuesto = 0.5
  
  def ImpuestoB: Impuesto = 0.25

  type Complejidad = (Tarea => BigDecimal)

  def ComplejidadMinima: Complejidad = _.costoBase
  
  def ComplejidadMedia: Complejidad = _.costoBase * 1.05

  def ComplejidadMaxima: Complejidad = tarea => {
    val costoSinAtrasos = tarea.costoBase * 1.07
    if (tarea.duracionEnDias <= 10)
      costoSinAtrasos
    else
      costoSinAtrasos + (tarea.duracionEnDias - 10) * 10
  }

}

