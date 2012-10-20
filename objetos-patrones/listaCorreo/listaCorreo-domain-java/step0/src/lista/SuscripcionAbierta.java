package lista;

public class SuscripcionAbierta implements TipoSuscripcion{

	@Override
	public void suscribir(SimpleListaDeCorreo lista, Usuario usuario) {
		lista.agregarUsuario(usuario);
	}

	@Override
	public void confirmar(SimpleListaDeCorreo lista, Usuario usuario) {
		throw new RuntimeException("Esta lista no requiere suscripci�n");
	}

}
