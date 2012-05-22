package ar.edu.algo2.microprocesador.domain.instrucciones;

import ar.edu.algo2.microprocesador.domain.Microcontroller;

public class ADD extends Instruccion {

	@Override
	public void execute(Microcontroller micro) {
		micro.updateAccumulators(micro.getAAcumulator() + micro.getBAcumulator());
		System.out.println("Ejecuto ADD");
	}

}