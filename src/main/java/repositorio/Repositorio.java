package repositorio;

import javax.persistence.EntityManager;



public class Repositorio {

	private Prenda prenda;
	private Guardarropa guardarropa;
	private Usuario usuario;
	private Trama trama;
	private Color color;
	private Material material;
	private TipoDePrenda tipo;
	private Evento evento;
	
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
	public Trama trama() {
		if (trama == null) {
			trama = new Trama(em);
		}
		return trama;
	}
	public Color color() {
		if (color == null) {
			color = new Color(em);
		}
		return color;
	}
	public Material material() {
		if (material == null) {
			material = new Material(em);
		}
		return material;
	}
	public TipoDePrenda tipo() {
		if (tipo == null) {
			tipo = new TipoDePrenda(em);
		}
		return tipo;
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
