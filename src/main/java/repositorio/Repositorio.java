package repositorio;

import javax.persistence.EntityManager;

public class Repositorio {

	private Prenda prenda;
	private Guardarropa guardarropa;
	private Usuario usuario;
	
	protected EntityManager em;
	public Repositorio(EntityManager em) {
		this.em = em;
	}

	public Prenda prenda() {
		if (prenda == null) {
			prenda = new Prenda(em);
		}
		return prenda;
	}
	
	public Guardarropa guardarropa() {
		if (guardarropa == null) {
			guardarropa = new Guardarropa(em);
		}
		return guardarropa;
	}
	
	public Usuario usuario() {
		if (usuario == null) {
			usuario = new Usuario(em);
		}
		return usuario;
	}
/*
	public Comunas comunas() {
		if (comunas == null) {
			comunas = new Comunas(em);
		}
		return comunas;
	}
*/
	public void cerrar() {
		em.close();
	}

}
