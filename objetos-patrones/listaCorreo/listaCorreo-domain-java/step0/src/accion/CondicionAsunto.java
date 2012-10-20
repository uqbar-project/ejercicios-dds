package accion;
import lista.Mail;

public class CondicionAsunto implements Condicion {

	private String asunto;

	public CondicionAsunto(String asunto) {
		this.asunto = asunto;
	}

	@Override
	public boolean aplicar(Mail mail) {
		return mail.getTitulo().contains(asunto);
	}

}
