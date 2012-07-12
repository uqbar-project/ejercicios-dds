type Impuesto = Double
type Complejidad = (Tarea -> Double)
data Tarea = Simple Int Complejidad [Impuesto] | Compuesta [Tarea]

costo tarea@(Simple _ complejidad impuestos) = complejidad tarea * (1 + totalImpuestos / 100)
                                               where totalImpuestos = sum impuestos
costo t = totalSubtareas costo t

duracionEnDias (Simple duracion _ _) = duracion
duracionEnDias t = totalSubtareas duracionEnDias t

totalSubtareas f (Compuesta tareas) = sum.map f $ tareas

costoBase = fromIntegral.(*25).duracionEnDias 


impuestoA = 0.5 :: Impuesto
impuestoB = 0.25 :: Impuesto

complejidadMinima = costoBase
complejidadMedia = (*1.05).costoBase 
complejidadMaxima tarea | duracionEnDias tarea <= 10 = costoSinAtrasos
                        | otherwise = costoSinAtrasos + ((fromIntegral.duracionEnDias) tarea - 10) * 10
                        where costoSinAtrasos = costoBase tarea * 1.07
