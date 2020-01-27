package repositorio;

import javax.persistence.EntityManager;

public class Material extends Repositorio {
	Material(EntityManager em) {
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
	
	public componentes.Material buscarMaterialPorNombre(String nombre) {		
		return em.createQuery("SELECT t FROM TipoDePrenda  t WHERE nombre = '"+ nombre+"' ", componentes.Material.class).getResultList().get(0);		
	}
	
	public void persistir(componentes.Material material) {
		em.getTransaction().begin();
		em.persist(material);
		em.getTransaction().commit();
	}
}
