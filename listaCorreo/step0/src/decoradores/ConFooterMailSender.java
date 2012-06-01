package decoradores;

import lista.Mail;
import lista.MailSender;

public class ConFooterMailSender implements MailSender {

  private MailSender mailSender;
  private String footer;

  public ConFooterMailSender(MailSender mailSender, String footer) {
    this.mailSender = mailSender;
    this.footer = footer;
  }

  @Override
  public void enviarMail(Mail mail) {
    mailSender
        .enviarMail(new Mail(mail.getTitulo(), mail.getBody() + "\n" + footer, mail.getRemitente(), mail.getDestinatario()));
  }

}
