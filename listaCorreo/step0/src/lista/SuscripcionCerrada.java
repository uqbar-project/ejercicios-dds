package lista;

public class SuscripcionCerrada implements TipoSuscripcion {

	@Override
	public void suscribir(SimpleListaDeCorreo lista, Usuario usuario) {
		lista.agregarUsuarioPendiente(usuario);
	}

	@Override
	public void confirmar(SimpleListaDeCorreo lista, Usuario usuario) {
		if (!lista.contieneUsuarioPendiente(usuario)){
			throw new RuntimeException("No puede confirmarse porque no es un usuario pendiente de confirmaci�n");
		}
		lista.agregarUsuario(usuario);
		lista.quitarUsuarioPendiente(usuario);
	}

}
