package ar.edu.algo2.microprocesador.domain.instrucciones;

import ar.edu.algo2.microprocesador.domain.Microcontroller;
import ar.edu.algo2.microprocesador.processing.ProgramIterator;

public class LODV extends Instruccion {
	
	private byte value;
	
	@Override
	public void execute(Microcontroller micro) {
		micro.setAAcumulator(value);
		System.out.println("Ejecuto LODV de " + this.value);
	}

	@Override
	public void prepare(ProgramIterator programIterator) {
		this.value = programIterator.readValue();
	}


}
