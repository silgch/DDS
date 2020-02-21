package repositorio;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Usuario extends Repositorio{
	Usuario(EntityManager em) {
		super(em);
	}
	
	public usuario.Usuario buscarPorUsuarioContrasenia(String userName, String contrasenia) {
		//Query  query = em.createQuery("SELECT p FROM Usuario p WHERE userName = :userName and password = :contrasenia", usuario.Usuario.class);		
		//List <Usuario> query= new ArrayList<Usuario>();
		
		try{			
			Query resultado =  em.createQuery("SELECT p FROM Usuario p WHERE userName = '"+ userName+"'  AND  password = '"+ contrasenia+"'");
			if(resultado.getResultList().size()>0){					
				return	em.createQuery("SELECT p FROM Usuario p WHERE userName = '"+ userName+"'  AND  password = '"+ contrasenia+"'",
				usuario.Usuario.class).getResultList().get(0);
			}			
		}		
		catch(ArrayIndexOutOfBoundsException excepcion)
        {
	        // ???
        }
		return null;	
	}
	
	public Usuario buscarPorMail(String mail) {
		Query  query = em.createQuery("SELECT p FROM Usuario p WHERE mail = :mail", Usuario.class);
		query.setParameter("mail", mail);
		Usuario usuario = (Usuario) query.getResultList().get(0);		
		return usuario;
	}
	
	public Usuario buscarPorNombre(String username) {
		Query  query = em.createQuery("SELECT p FROM Usuario p WHERE username = :username", Usuario.class);
		query.setParameter("username", username);
		Usuario usuario = (Usuario) query.getResultList().get(0);		
		return usuario;
	}
	
	public void actualizar(usuario.Usuario usuario) {
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
	}	
	
	public void persistir(usuario.Usuario usuario) {
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}
}
