package repositorio;

import javax.persistence.EntityManager;

public class Usuario extends Repositorio{
	Usuario(EntityManager em) {
		super(em);
	}

	public void persistir(usuario.Usuario usuario) {
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
	}
}
