package repositorio;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Usuario extends Repositorio{
	Usuario(EntityManager em) {
		super(em);
	}
	public Usuario buscarPorId(Long id) {
		return em.find(Usuario.class, id);
		
	}
	
	public Usuario buscarPorMailContrasenia(String mail, String contrasenia) {
		Query  query = em.createQuery("SELECT p FROM Usuario p WHERE mail = :mail and password = :contrasenia", Usuario.class);
		query.setParameter("mail", mail);
		query.setParameter("contrasenia", contrasenia);
		//Suponemos que no se permite tener 2 usuarios con el mismo username (ver validaciones al crear el usuario)
		Usuario usuario = (Usuario) query.getResultList().get(0);
		
		return usuario;
	}
	
	public Usuario buscarPorUsuarioContrasenia(String userName, String contrasenia) {
		Query  query = em.createQuery("SELECT p FROM Usuario p WHERE userName = :userName and password = :contrasenia", Usuario.class);
		query.setParameter("userName", userName);
		query.setParameter("contrasenia", contrasenia);
	
		Usuario usuario = (Usuario) query.getResultList().get(0);
		
		return usuario;
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
