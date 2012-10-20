package ar.edu.design.examples.manejoProyectos;

public class ComplejidadMaxima extends Complejidad {

	@Override
	public double getCosto(Tarea tarea) {
		int tiempoTarea = tarea.getTiempo();
		double costo = super.getCosto(tarea) * 1.07;
		if (tiempoTarea >= 10) {
			int diferencia = tiempoTarea - 10;
			costo += 10 * diferencia;
		}
		return costo;
	}

}
