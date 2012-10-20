package ar.edu.design.examples.manejoProyectos;

import java.util.List;

public class Proyecto {

	private List<Tarea> tareas;

	public double getCostoTotal() {
		double total = 0;
		for (Tarea tarea : this.tareas) {
			total = total + tarea.getCostoTotal();
		}
		return total;
	}
}
