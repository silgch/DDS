package repositorio;

import javax.persistence.EntityManager;

public class Trama extends Repositorio{
	Trama(EntityManager em) {
		super(em);
	}
	public componentes.Trama convertirTipoDePrenda(String nombre) {
		
		return  em.createQuery("SELECT t FROM Trama  t WHERE nombre = '"+ nombre+"' ", componentes.Trama.class)
		.getResultList().get(0);
		
	}
	public void persistir(componentes.Trama trama) {
		em.getTransaction().begin();
		em.persist(trama);
		em.getTransaction().commit();
	}
}
