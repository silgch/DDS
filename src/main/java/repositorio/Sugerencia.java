package repositorio;

import javax.persistence.EntityManager;

public class Sugerencia extends Repositorio{
	Sugerencia(EntityManager em) {
		super(em);
	}
	/*public Sugerencia buscarPorId(Long id) {
		return em.find(Sugerencia.class, id);		
	}
	
	public Sugerencia buscarPorMailContrasenia(String mail, String contrasenia) {
		Query  query = em.createQuery("SELECT p FROM Sugerencia p WHERE mail = :mail and password = :contrasenia", Sugerencia.class);
		query.setParameter("mail", mail);
		query.setParameter("contrasenia", contrasenia);
		//Suponemos que no se permite tener 2 usuarios con el mismo username (ver validaciones al crear el sugerencia)
		Sugerencia sugerencia = (Sugerencia) query.getResultList().get(0);		
		return sugerencia;
	}
	
	public eventos.Sugerencia buscarPorUsuarioContrasenia(String userName, String contrasenia) {
		//Query  query = em.createQuery("SELECT p FROM Sugerencia p WHERE userName = :userName and password = :contrasenia", eventos.Sugerencia.class);		
		//List <Sugerencia> query= new ArrayList<Sugerencia>();
		
		try{			
			Query resultado =  em.createQuery("SELECT p FROM Sugerencia p WHERE userName = '"+ userName+"'  AND  password = '"+ contrasenia+"'");
			if(resultado.getResultList().size()>0){					
				return	em.createQuery("SELECT p FROM Sugerencia p WHERE userName = '"+ userName+"'  AND  password = '"+ contrasenia+"'",
				eventos.Sugerencia.class).getResultList().get(0);
			}			
		}		
		catch(ArrayIndexOutOfBoundsException excepcion)
        {
	        // ???
        }
		return null;	
	}*/
	

	public void actualizar(eventos.Sugerencia sugerencia) {
		em.getTransaction().begin();
		em.merge(sugerencia);
		em.getTransaction().commit();
	}	
	
	public void persistir(eventos.Sugerencia sugerencia) {
		em.getTransaction().begin();
		em.persist(sugerencia);
		em.getTransaction().commit();
	}
}
