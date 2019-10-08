package repositorio;

import javax.persistence.EntityManager;

public class Repositorio {

	private Prenda prenda;
	private Guardarropa guardarropa;
	
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
