package repositorio;

import javax.persistence.EntityManager;

public class Trama extends Repositorio{
	Trama(EntityManager em) {
		super(em);
	}

	public void persistir(componentes.Trama trama) {
		em.getTransaction().begin();
		em.persist(trama);
		em.getTransaction().commit();
	}
}
