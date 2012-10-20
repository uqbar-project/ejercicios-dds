package accion;
import lista.Mail;

public class CondicionEmisor implements Condicion {

	private String emisor;

	public CondicionEmisor(String emisor) {
		this.emisor = emisor;
	}

	@Override
	public boolean aplicar(Mail mail) {
		return mail.getRemitente().equals(emisor);
	}

}
