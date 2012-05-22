package ar.edu.algo2.microprocesador.domain.instrucciones;

import ar.edu.algo2.microprocesador.domain.Microcontroller;

public class LODV implements Instruccion {
	
	private byte value;
	
	@Override
	public void execute(Microcontroller micro) {
		micro.setAAcumulator(value);
		System.out.println("Ejecuto LODV de " + this.value);
	}

	@Override
	public void prepare(Microcontroller micro) {
		micro.advancePC();
		this.value = micro.getProgram(micro.getPC());
	}

}
