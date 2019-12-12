package tests;

import java.time.LocalDate;
import java.util.HashSet;
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
import eventos.Evento;
import guardarropas.Guardarropa;
import repositorio.Repositorio;
import usuario.Usuario;

public class PersistenciaTest {
	
	private static final String PERSISTENCE_UNIT_NAME = "ati1txh3yqvapdna";
	private static EntityManagerFactory emf;
	private static Repositorio repositorio;
	
	public static void main(String[] args) throws Exception {
		
	//Creamos el gestor de persistencia (EM)
	emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager manager = emf.createEntityManager();
	repositorio = new Repositorio(manager);
		
		
	//Creo
	Usuario javier = new Usuario("Javier");
	Usuario pedro = new Usuario("Pedro");
	Usuario aroco = new Usuario("aroco");
	Usuario jazul = new Usuario("jazul");
	
	//TipoDePrenda(String nombre, Categoria categoria, Set<Material> tiposDeMaterialesPermitidos, PrendaNivel nivel)
	
	Material algodon = new Material("Algodon");
	Material seda = new Material ("Seda");
	Material poliester = new Material ("Poliester");
	Material lycra = new Material ("Lycra");
	Material cuero = new Material ("Cuero");
	Material nylon = new Material ("Nylon");
	Material jean = new Material ("Jean");
	
	Color negro = new Color ("Negro", 0,0,0);
	Color blanco = new Color ("Blanco", 255,255,255);
	Color amarillo = new Color ("Amarillo", 250,255,51);
	Color celeste = new Color ("Celeste", 51,255,255);
	Color gris = new Color ("Gris", 140,150,150);
	Color bordo = new Color ("Bordo", 210,50,0);
	Color verde = new Color ("Verde", 30,210,0);
	
	Trama lisa = new Trama("Lisa");
	
	Set <Material> tiposDeMaterialRemera = new HashSet<Material>();
	Set <Material> tiposDeMaterialSueter = new HashSet<Material>();	
	Set <Material> tiposDeMaterialCampera = new HashSet<Material>();
	Set <Material> tiposDeMaterialPantalon = new HashSet<Material>();
	Set <Material> tiposDeMaterialCalzaBuzo = new HashSet<Material>();
	Set <Material> tiposDeMaterialMusculosa = new HashSet<Material>();
	Set <Material> tiposDeMaterialZapatillas = new HashSet<Material>();	
	Set <Material> tiposDeMaterialZapatos = new HashSet<Material>();
	
	Guardarropa ropaAroco = new Guardarropa();
	Guardarropa ropaJazul = new Guardarropa();
	
	aroco.agregarGuardarropa(ropaAroco);
	jazul.agregarGuardarropa(ropaJazul);
	
	
	
	
	tiposDeMaterialRemera.add(algodon); tiposDeMaterialRemera.add(seda); tiposDeMaterialRemera.add(poliester); tiposDeMaterialRemera.add(lycra);
	tiposDeMaterialSueter.add(algodon); tiposDeMaterialSueter.add(seda); tiposDeMaterialSueter.add(poliester); 
	tiposDeMaterialCampera.add(algodon); tiposDeMaterialCampera.add(seda); tiposDeMaterialCampera.add(poliester); tiposDeMaterialCampera.add(cuero); tiposDeMaterialCampera.add(nylon); 
	tiposDeMaterialPantalon.add(algodon); tiposDeMaterialPantalon.add(seda); tiposDeMaterialPantalon.add(poliester); tiposDeMaterialPantalon.add(jean); tiposDeMaterialPantalon.add(nylon); 
	tiposDeMaterialCalzaBuzo.add(algodon);tiposDeMaterialCalzaBuzo.add(lycra);tiposDeMaterialCalzaBuzo.add(poliester);tiposDeMaterialCalzaBuzo.add(nylon);
	tiposDeMaterialMusculosa.add(algodon);tiposDeMaterialMusculosa.add(lycra);
	tiposDeMaterialZapatillas.add(cuero); 	tiposDeMaterialZapatillas.add(nylon); 
	tiposDeMaterialZapatos.add(cuero); 
	
	TipoDePrenda remeraRedMangaCorta = new TipoDePrenda("Remera cuello redondo manga corta", Categoria.PARTE_SUPERIOR, tiposDeMaterialRemera, PrendaNivel.Nivel1);
	TipoDePrenda remeraRedMangaLarga = new TipoDePrenda("Remera cuello redondo manga larga", Categoria.PARTE_SUPERIOR, tiposDeMaterialRemera, PrendaNivel.Nivel1);
	TipoDePrenda remeraVMangaCorta = new TipoDePrenda("Remera escote V manga corta", Categoria.PARTE_SUPERIOR, tiposDeMaterialRemera, PrendaNivel.Nivel1);
	TipoDePrenda remeraVMangaLarga = new TipoDePrenda("Remera escote V manga larga", Categoria.PARTE_SUPERIOR, tiposDeMaterialRemera, PrendaNivel.Nivel1);
	TipoDePrenda sueter = new TipoDePrenda("Sueter", Categoria.PARTE_SUPERIOR, tiposDeMaterialSueter, PrendaNivel.Nivel2);
	TipoDePrenda campera = new TipoDePrenda("Campera", Categoria.PARTE_SUPERIOR, tiposDeMaterialCampera, PrendaNivel.Nivel3);
	TipoDePrenda pantalonLargo = new TipoDePrenda("Pantalon Largo", Categoria.PARTE_INFERIOR, tiposDeMaterialPantalon, PrendaNivel.Nivel1);
	TipoDePrenda pantalonCorto = new TipoDePrenda("Pantalon Corto", Categoria.PARTE_INFERIOR, tiposDeMaterialPantalon, PrendaNivel.Nivel1);
	TipoDePrenda bermuda = new TipoDePrenda("Bermuda", Categoria.PARTE_INFERIOR, tiposDeMaterialPantalon, PrendaNivel.Nivel1);
	TipoDePrenda pollera = new TipoDePrenda("Pollera", Categoria.PARTE_INFERIOR, tiposDeMaterialPantalon, PrendaNivel.Nivel1);
	TipoDePrenda calza = new TipoDePrenda("Calza", Categoria.PARTE_INFERIOR, tiposDeMaterialCalzaBuzo, PrendaNivel.Nivel1);
	TipoDePrenda buzo = new TipoDePrenda("Buzo", Categoria.PARTE_SUPERIOR, tiposDeMaterialCalzaBuzo, PrendaNivel.Nivel2);
	TipoDePrenda musculosa = new TipoDePrenda("Musculosa", Categoria.PARTE_SUPERIOR, tiposDeMaterialMusculosa, PrendaNivel.Nivel1);
	TipoDePrenda zapatillas = new TipoDePrenda("Zapatillas", Categoria.CALZADO, tiposDeMaterialZapatillas, PrendaNivel.Nivel1);
	TipoDePrenda zapatos = new TipoDePrenda("Zapatos", Categoria.CALZADO, tiposDeMaterialZapatillas, PrendaNivel.Nivel1);
	TipoDePrenda sandalias = new TipoDePrenda("Sandalias", Categoria.CALZADO, tiposDeMaterialZapatillas, PrendaNivel.Nivel1);	
	
	//String nombre, TipoDePrenda tipo, Material material, Color colorPrincipal, Trama trama)
	Prenda remera1 = new Prenda("Remera negra de algodon, cuello redondo manga corta", remeraRedMangaCorta,algodon,  negro, lisa);
	Prenda remeraLycraBlanca = new Prenda("Remera escote V Blanca, de lycra, manga corta", remeraVMangaCorta,lycra,  blanco, lisa);
	Prenda musculosaLycraAmarilla = new Prenda("Musculosa, de lycra, amarilla", musculosa,lycra,  amarillo, lisa);	
	Prenda camperaCueroBlanco = new Prenda("Campera de cuero blanco", campera,cuero,  blanco, lisa);	
	Prenda sueterPoliesterBlanco = new Prenda("Sueter Poliester blanco", sueter,poliester,  blanco, lisa);	
	Prenda bermudaJeanCeleste = new Prenda("Bermuda Jean Celeste", bermuda,jean,  celeste, lisa);	
	Prenda pantalonLargoGris = new Prenda("Pantalon largo gris", pantalonLargo,nylon,  gris, lisa);	
	Prenda zapatillasBordo = new Prenda("Zapatillas bordo", zapatillas,nylon,  bordo, lisa);	
	Prenda zapatosNegros = new Prenda("Zapatos negros de cuero", zapatos, cuero,  negro, lisa);	
	
	ropaAroco.agregarAGuardarropas(remera1);
	ropaAroco.agregarAGuardarropas(remeraLycraBlanca);
	ropaAroco.agregarAGuardarropas(musculosaLycraAmarilla);
	ropaAroco.agregarAGuardarropas(camperaCueroBlanco);
	ropaAroco.agregarAGuardarropas(sueterPoliesterBlanco);
	ropaAroco.agregarAGuardarropas(bermudaJeanCeleste);
	ropaAroco.agregarAGuardarropas(pantalonLargoGris);
	ropaAroco.agregarAGuardarropas(zapatillasBordo);
	ropaAroco.agregarAGuardarropas(zapatosNegros);
	
	javier.setNombre("Javier");
	javier.setApellido("Fernandez");
	javier.setMail("javier@gmail.com");
	javier.setPassword("Javier123");
	
	pedro.setNombre("Pedro");
	pedro.setApellido("Gonzalez");
	pedro.setMail("pedro@hotmail.com.ar");
	pedro.setPassword("1133");

	
	aroco.setNombre("Alejandro");
	aroco.setApellido("Roco");
	aroco.setMail("aroco@aroco.com.ar");
	aroco.setPassword("123456");
	
	jazul.setNombre("Julieta");
	jazul.setApellido("Azul");
	jazul.setMail("jazul@hotmail.com.ar");
	jazul.setPassword("123456");
	// Ver como cambiar de cuenta.
	
	ropaAroco.setNombre("Guardarropa de Aroco");
	ropaJazul.setNombre("Guardarropa de J Azul");
	
	Evento eventoPedroUno = new Evento(LocalDate.now(), "Ir al cine", pedro,"3433955");
	
	
	//Persisto 
	repositorio.material().persistir(jean);
	repositorio.material().persistir(nylon);
	repositorio.material().persistir(cuero);
	repositorio.material().persistir(lycra);
	repositorio.material().persistir(poliester);
	repositorio.material().persistir(seda);
	repositorio.material().persistir(algodon);
	
	repositorio.tipo().persistir(remeraVMangaLarga);
	repositorio.tipo().persistir(remeraVMangaCorta);
	repositorio.tipo().persistir(remeraRedMangaCorta);
	repositorio.tipo().persistir(remeraRedMangaLarga);
	repositorio.tipo().persistir(sueter);
	repositorio.tipo().persistir(campera);
	repositorio.tipo().persistir(pantalonCorto);
	repositorio.tipo().persistir(pantalonLargo);
	repositorio.tipo().persistir(bermuda);
	repositorio.tipo().persistir(pollera);
	repositorio.tipo().persistir(calza);
	repositorio.tipo().persistir(buzo);
	repositorio.tipo().persistir(musculosa);
	repositorio.tipo().persistir(zapatillas);
	repositorio.tipo().persistir(zapatos);
	repositorio.tipo().persistir(sandalias);
	
	repositorio.color().persistir(negro);
	repositorio.color().persistir(blanco);
	repositorio.color().persistir(amarillo);
	repositorio.color().persistir(celeste);
	repositorio.color().persistir(gris);
	repositorio.color().persistir(bordo);
	repositorio.color().persistir(verde);
	
	repositorio.trama().persistir(lisa);
	
	repositorio.usuario().persistir(javier);
	repositorio.usuario().persistir(pedro);
	repositorio.usuario().persistir(aroco);
	repositorio.usuario().persistir(jazul);
	
	
	
	repositorio.guardarropa().persistir(ropaJazul);
	repositorio.guardarropa().persistir(ropaAroco);
	
	repositorio.prenda().persistir(remera1);
	repositorio.prenda().persistir(remeraLycraBlanca);
	repositorio.prenda().persistir(musculosaLycraAmarilla);
	repositorio.prenda().persistir(camperaCueroBlanco);
	repositorio.prenda().persistir(sueterPoliesterBlanco);
	repositorio.prenda().persistir(bermudaJeanCeleste);
	repositorio.prenda().persistir(pantalonLargoGris);
	repositorio.prenda().persistir(zapatillasBordo);
	repositorio.prenda().persistir(zapatosNegros);
	
	

	

	
	repositorio.evento().persistir(eventoPedroUno);
	
	
	//Cambio unos parametros y verifico
	pedro.setMail("pedro1@hotmail.com.ar");
	repositorio.usuario().actualizar(pedro);
	
}	
}
