package proyectosv1

trait Tarea {
  def costo: BigDecimal
  def duracionEnDias: Int

  def costoBase = duracionEnDias * 25
}

class TareaSimple(
  val duracionEnDias: Int,
  complejidad: Complejidad,
  impuestos: Collection[Impuesto]) extends Tarea {

  def costo = complejidad.costoTarea(this) * (1 + porcentajeImpuestos / 100)
  def porcentajeImpuestos = impuestos.view.map(_.porcentajeImpuesto).sum
}

class TareaCompuesta(tareas: Collection[Tarea]) extends Tarea {
  def costo = tareas.view.map(_.costo).sum
  def duracionEnDias = tareas.view.map(_.duracionEnDias).sum
}