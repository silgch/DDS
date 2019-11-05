package dao;

import javax.persistence.EntityManager;

import repositorio.Repositorio;
import repositorio.Usuario;

public class usuarioDAO {
	
	private Repositorio repositorio;
	
	public usuarioDAO(EntityManager entityManager) {
		this.repositorio = new Repositorio(entityManager);
	}

	public Usuario obteneUsuarioPorId(long id) {
		Usuario usuario = repositorio.usuario().buscarPorId(id);
		
		if(usuario == null) {
			try {
				throw new Exception("No existe un usuario con el id: " + id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return usuario;
	}
	
	public Usuario obtenerUsuarioPoMail(String mail,String password) {
		Usuario usuario = repositorio.usuario().buscarPorMailContrasenia(mail, password);
		
		if(usuario == null) {
			try {
				throw new Exception("No existe un usuario con el mail: " + mail);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		
		return usuario;
	}
	
	public void crearUsuario(usuario.Usuario u) {
		repositorio.usuario().persistir(u);
	}
	
	public void actualizarUsuario(usuario.Usuario u) {
		repositorio.usuario().actualizar(u);
	}
}
