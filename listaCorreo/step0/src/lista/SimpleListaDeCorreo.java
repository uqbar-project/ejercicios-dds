package lista;
import java.util.ArrayList;
import java.util.List;

public class SimpleListaDeCorreo implements ListaDeCorreo {

  private TipoSuscripcion tipoSuscripcion;
  private List<Usuario> suscriptos = new ArrayList<Usuario>();
  private List<Usuario> usuariosPendientes = new ArrayList<Usuario>();
  private List<Observer> observers = new ArrayList<Observer>();
  private MailSender mailSender;

  public SimpleListaDeCorreo(TipoSuscripcion tipoSuscripcion, MailSender mailSender) {
    this.tipoSuscripcion = tipoSuscripcion;
    this.mailSender = mailSender;
  }

  @Override
  public void agregarUsuario(Usuario usuario) {
    this.suscriptos.add(usuario);
  }

  @Override
  public void agregarObservador(Observer observer) {
    this.observers.add(observer);
  }

  @Override
  public void agregarUsuarioPendiente(Usuario usuario) {
    this.usuariosPendientes.add(usuario);
    for (Observer observer : this.observers) {
      observer.notifySuscripcion(usuario);
    }
  }

  @Override
  public void suscribir(Usuario usuario) {
    tipoSuscripcion.suscribir(this, usuario);

  }

  @Override
  public void confirmar(Usuario usuario) {
    this.tipoSuscripcion.confirmar(this, usuario);
  }

  public boolean estaSuscripto(Usuario usuario) {
    return this.suscriptos.contains(usuario);

  }

  public void quitarUsuarioPendiente(Usuario usuario) {
    this.usuariosPendientes.remove(usuario);
  }

  public boolean contieneUsuarioPendiente(Usuario usuario) {
    return this.usuariosPendientes.contains(usuario);
  }

  public void enviarMail(String titulo, String body, Usuario remitente) {
    for (Usuario usuario : this.suscriptos) {
      mailSender.enviarMail(new Mail(titulo, body, remitente.getMail(), usuario.getMail()));
    }
  }

  public MailSender
  getMailSender() {
    return mailSender;
  }

}
