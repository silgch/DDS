package tests;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import componentes.Categoria;
import componentes.Color;
import componentes.Material;
import componentes.Prenda;
import componentes.PrendaNivel;
import componentes.TipoDePrenda;
import componentes.Trama;



@SuppressWarnings("unchecked")
public class TestPersistencia {
	private static EntityManager manager;
	private static EntityManagerFactory emf;
	
	public static void main(String[] args) {
		//Creamos el festor de persistencia (EM)
		emf=Persistence.createEntityManagerFactory("DDS");
		manager= emf.createEntityManager();
		
		
		//Creo una Prenda
		Material algodon=new Material("Aldodon");
		Color colorBlanco=new Color("Blanco", 255,255,0);
		Trama lisa= new Trama("Lisa");
		Set<Material> tiposDeMaterialRemera;
		tiposDeMaterialRemera = new HashSet<Material>();
		tiposDeMaterialRemera.add(algodon);
		TipoDePrenda remera = new  TipoDePrenda("Remera",Categoria.PARTE_SUPERIOR, tiposDeMaterialRemera,PrendaNivel.Nivel1);

		Prenda unaRemeraBlancaLisa = new Prenda("Remera Blanca lisa", remera, algodon, colorBlanco, lisa );
		Prenda unaRemeraBlancaLisa2 = new Prenda("Remera Blanca lisa 2", remera, algodon, colorBlanco, lisa );
		
		manager.getTransaction().begin();
		manager.persist(unaRemeraBlancaLisa);
		manager.persist(unaRemeraBlancaLisa2);		
		manager.getTransaction().commit();
		

		
		imprimirTodo();
	}
	@SuppressWarnings("unchecked")
	private static void imprimirTodo() {
		
		
		
		  List <Prenda> prendas = (List <Prenda>)
		  manager.createQuery("FROM prenda").getResultList();
		  System.out.println("En esta base de datos hay "+ prendas.size()+
		  " prendas.");
		 
		
		
		
	}
}

