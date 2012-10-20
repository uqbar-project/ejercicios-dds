package accion;
import lista.Mail;


public class CondicionDefault implements Condicion {

	@Override
	public boolean aplicar(Mail mail) {
		return true;
	}

}
