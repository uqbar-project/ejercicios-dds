package lista;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import lista.Mail;
import lista.MailSender;
import lista.SimpleListaDeCorreo;
import lista.SuscripcionAbierta;
import lista.Usuario;

import org.junit.Before;
import org.junit.Test;


public class ListaDeCorreoConMockitoTest {

  private Usuario maru;
  private Usuario fer;
  private Usuario adri;
  private SimpleListaDeCorreo listaDdsAbierta;
  private MailSender impostorMailSender;

  @Before
  public void setup() {
    maru = new Usuario("maru@gmail.com");
    fer = new Usuario("fer@gmail.com");
    adri = new Usuario("adr@gmail.com");
    impostorMailSender = mock(MailSender.class);
    listaDdsAbierta = new SimpleListaDeCorreo(new SuscripcionAbierta(), impostorMailSender);
  }

  /**
   * Mismo test 
   * @throws Exception
   */
  @Test
  public void siEnvioMailALaListaEstaSeLoEnviaACadaUsuario() throws Exception {
    listaDdsAbierta.suscribir(maru);
    listaDdsAbierta.suscribir(fer);
    listaDdsAbierta.suscribir(adri);

    listaDdsAbierta.enviarMail("lalalal", "lelelel", fer);

    verify(impostorMailSender, times(3)).enviarMail(any(Mail.class));
  }

}
