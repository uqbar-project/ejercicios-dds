package lista;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import decoradores.ConFooterMailSender;
import decoradores.ConPrefijoEnElAsuntoMailSender;

public class ListaDeCorreoTest {

  private final class MailSenderMock implements MailSender {
    private List<Mail> mailsEnviados = new ArrayList<Mail>();

    public void enviarMail(Mail mail) {
      mailsEnviados.add(mail);
    }

    public int getCantidadMailsMandados() {
      return mailsEnviados.size();
    }

    public List<Mail> getMailsEnviados() {
      return mailsEnviados;
    }
  }

  private Usuario maru;
  private Usuario fer;
  private Usuario adri;
  private SimpleListaDeCorreo listaDdsAbierta;
  private SimpleListaDeCorreo listaPdpCerrada;
  private SimpleListaDeCorreo listaTadpCerrada;
  private MailSenderMock impostorMailSender;

  @Before
  public void setup() {
    maru = new Usuario("maru@gmail.com");
    fer = new Usuario("fer@gmail.com");
    adri = new Usuario("adr@gmail.com");

    impostorMailSender = new MailSenderMock();
    listaDdsAbierta = new SimpleListaDeCorreo(new SuscripcionAbierta(), impostorMailSender);
    listaPdpCerrada = new SimpleListaDeCorreo(new SuscripcionCerrada(), impostorMailSender);
    listaTadpCerrada = new SimpleListaDeCorreo(new SuscripcionCerrada(), new ConFooterMailSender(
        impostorMailSender, "La presente lista no se responsabiliza por daños y prejuicios"));
  }

  @Test
  public void sePuedeSuscribirEnListaAbierta() {
    listaDdsAbierta.suscribir(maru);
    assertTrue(listaDdsAbierta.estaSuscripto(maru));

  }

  @Test(expected = RuntimeException.class)
  public void noSePuedeConfirmarEnListaAbierta() {
    listaDdsAbierta.suscribir(adri);
    listaDdsAbierta.confirmar(adri);
  }

  @Test
  public void suscribirEnListaCerradaDejaAlUsuarioPendiente() {
    listaPdpCerrada.suscribir(fer);
    assertTrue(listaPdpCerrada.contieneUsuarioPendiente(fer));

  }

  @Test
  public void sePuedeConfirmarEnListaCerrada() {
    listaPdpCerrada.suscribir(maru);
    listaPdpCerrada.confirmar(maru);
  }

  @Test
  public void siEnvioMailALaListaEstaSeLoEnviaACadaUsuario() {
    listaDdsAbierta.suscribir(maru);
    listaDdsAbierta.suscribir(fer);
    listaDdsAbierta.suscribir(adri);
    listaDdsAbierta.enviarMail("lalalal", "lelelel", fer);

    assertEquals(3, impostorMailSender.getCantidadMailsMandados());
  }
  

  @Test
  public void elDecoratorConFooterAgregaUnFooterAlFinalDelMensaje() {
    listaTadpCerrada.suscribir(maru);
    listaTadpCerrada.confirmar(maru);

    listaTadpCerrada.enviarMail("Mi segundo mail", "Este es otro body", maru);

    assertEquals("Este es otro body\nLa presente lista no se responsabiliza por da�os y prejuicios",
        impostorMailSender.getMailsEnviados().get(0).getBody());
  }

  @Test
  public void losDecoratorsSonCombinables() {
    listaTadpCerrada = new SimpleListaDeCorreo(new SuscripcionCerrada(), new ConPrefijoEnElAsuntoMailSender(
        new ConFooterMailSender(impostorMailSender, "footer"), "[tadp]-"));

    listaTadpCerrada.suscribir(adri);
    listaTadpCerrada.confirmar(adri);

    listaTadpCerrada.enviarMail("Mi segundo mail", "Este es otro body", adri);

    Mail mail = impostorMailSender.getMailsEnviados().get(0);
    assertEquals("Este es otro body\nfooter", mail.getBody());
    assertEquals("[tadp]-Mi segundo mail", mail.getTitulo());
  }

}
