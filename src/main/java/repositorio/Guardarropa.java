package repositorio;

import javax.persistence.EntityManager;

public class Guardarropa extends Repositorio{
	Guardarropa(EntityManager em) {
		super(em);
	}

	public void persistir(guardarropas.Guardarropa guardarropa) {
		em.getTransaction().begin();
		em.persist(guardarropa);
		em.getTransaction().commit();
	}
}
