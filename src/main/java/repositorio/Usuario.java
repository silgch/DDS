package repositorio;

import javax.persistence.EntityManager;

public class Usuario extends Repositorio{
	Usuario(EntityManager em) {
		super(em);
	}

	public void persistir(usuario.Usuario usuario) {
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}
}
