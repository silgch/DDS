package repositorio;

import javax.persistence.EntityManager;

public class Evento extends Repositorio {
	Evento(EntityManager em) {
		super(em);
	}
	/*
	public Prenda buscarPorId(Long id) {
		return em.find(Prenda.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Prenda> buscarPrendaPorNombre(String nombre) {
		List<Prenda> prenda = null;
		prenda = em.createNamedQuery("buscarPrendaPorNombre").setParameter("pnombre", "%" + nombre + "%").getResultList();
		return prenda;
	}
 	*/	
	public void persistir(eventos.Evento evento) {
		em.getTransaction().begin();
		em.persist(evento);
		em.getTransaction().commit();
	}
}
