package repositorio;

import javax.persistence.EntityManager;

public class Prenda extends Repositorio {
	Prenda(EntityManager em) {
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
	public void persistir(componentes.Prenda prenda) {
		em.getTransaction().begin();
		em.merge(prenda);
		em.getTransaction().commit();
	}
}
