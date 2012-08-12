package proyectosv1

trait Impuesto {
  def porcentajeImpuesto: BigDecimal
}

object ImpuestoA extends Impuesto {
  def porcentajeImpuesto = 0.5
}

object ImpuestoB extends Impuesto {
  def porcentajeImpuesto = 0.25
}
