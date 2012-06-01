package accion;
import lista.Mail;
import lista.Regla;

public class SimpleRegla implements Regla {

	private Regla siguienteRegla;
	private Condicion condicion;
	private Accion accion;

	public SimpleRegla(Condicion condicion, Accion accion) {
		this.condicion = condicion;
		this.accion = accion;
	}

	@Override
	public void aplicar(Mail mail) {
		if (condicion.aplicar(mail))
			accion.aplicar(mail);
		else
			siguienteRegla.aplicar(mail);
	}

	@Override
	public void siguiente(Regla regla) {
		this.siguienteRegla = regla;
	}

}
