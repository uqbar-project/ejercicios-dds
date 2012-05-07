package ar.edu.design.examples.manejoProyectos;

import ar.edu.design.examples.manejoProyectos.exceptions.BusinessException;


public class TareaSimple implements TipoDeTarea {

	@Override
	public double getCostoTotal(Tarea tarea) {
		return this.getCosto(tarea);
		
	}

	@Override
	public double getCosto(Tarea tarea) {
		return tarea.getCostoBase();
	}

	@Override
	public void agregarSubtarea(Tarea tarea) throws BusinessException {
		throw new BusinessException("No puede agregar subtareas a una tarea simple");
	}

}
