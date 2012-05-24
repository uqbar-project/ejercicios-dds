package ar.edu.algo2.microprocesador.domain.instrucciones;

import ar.edu.algo2.microprocesador.domain.Microcontroller;

public class LODV extends Instruccion {

	int value;
	
	public LODV(int value) {
		if (value > 255) {
			throw new IllegalArgumentException("No debe crear una instrucci�n LODV de un n�mero mayor a 255");
		} else {
			this.value = value;
		}
	}

	@Override
	public void doExecute(Microcontroller micro) {
		micro.setAAcumulator((byte) value);
	}

}
