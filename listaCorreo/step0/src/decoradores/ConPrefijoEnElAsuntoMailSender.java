package decoradores;

import lista.Mail;
import lista.MailSender;

public class ConPrefijoEnElAsuntoMailSender implements MailSender{
	private MailSender mailSender;
	private String prefijoDelAsunto;
	
	public ConPrefijoEnElAsuntoMailSender(MailSender mailSender, String prefijoDelAsunto) {
		this.mailSender = mailSender;
		this.prefijoDelAsunto = prefijoDelAsunto;
	}

	@Override
	public void enviarMail(Mail mail) {
		mailSender.enviarMail(new Mail(prefijoDelAsunto + mail.getTitulo(), mail.getBody(), mail.getRemitente(),
				mail.getDestinatario()));
	}
}
