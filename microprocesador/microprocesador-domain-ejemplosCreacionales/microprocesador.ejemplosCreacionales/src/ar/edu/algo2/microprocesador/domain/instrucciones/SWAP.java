package ar.edu.algo2.microprocesador.domain.instrucciones;

import ar.edu.algo2.microprocesador.domain.Microcontroller;

public class SWAP extends Instruccion {

	@Override
	public void execute(Microcontroller micro) {
		byte swapValue = micro.getBAcumulator();
		micro.setBAcumulator(micro.getAAcumulator());
		micro.setAAcumulator(swapValue);
		System.out.println("Ejecuto SWAP. Acumulador A: " + micro.getAAcumulator() + " | Acumulador B: " + micro.getBAcumulator());
	}

}
