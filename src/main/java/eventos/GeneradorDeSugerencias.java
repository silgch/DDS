package eventos;

import static componentes.PrendaNivel.Nivel1;
import static componentes.PrendaNivel.Nivel2;
import static componentes.PrendaNivel.Nivel3;
import static componentes.PrendaNivel.Nivel4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import climaAPI.ClimaAdapter;
import climaAPI.GestorDeClimaAPIs;
import componentes.Categoria;
import componentes.Prenda;
import componentes.PrendaNivel;
import guardarropas.Guardarropa;
import usuario.Usuario;

//Ex-QueMePongo
public class GeneradorDeSugerencias{
	
	private GestorDeClimaAPIs gestorDeAPIs;
	private ClimaAdapter api1;
	
	Double tempReal;
	
	public GeneradorDeSugerencias() {
		gestorDeAPIs = new GestorDeClimaAPIs();
		api1 = gestorDeAPIs.entregarAPI();
	}
	
	List<Prenda> sugerencia = new ArrayList<Prenda>();
	
	/*
  	A sugerir se le da un guardarropa, el mismo tendrá varios niveles
  	de prendas (ej:remera=prendaSuperior nivel1, camperaPolar=prendaSuperior nivel4).
  	Si hace mas de 25º sugerir dará alguna prenda superior nivel1, si existiera.
  	Si hace mas de 20º segerir dará una prendaSuperior nivel1 y una de nivel2 y así...
  	Suponer que prendas inferioresNivel2 son calzas
  
  	update: a este valor se le suma (o resta) la percepcion de la persona 
  	osea que si hace 20º y el usuario es muy friolento en el pecho (usuario.percepcionPecho = 10)
  	entonces el programa tomara como "si hace" 10º
	 */	
    public List<Prenda> sugerirEnBaseAPersepcion(Guardarropa unGuardarropa,Usuario unUsuario,Evento evento) throws Exception{
    	
    	String codigoCiudad = evento.getUbicacion();
		LocalDate fecha = evento.getFecha();
    	
    	// ejemplo String codigoCiudad = "3433955";
    	tempReal = api1.obtenerClima(codigoCiudad);
    	
    	sugerencia.clear();
    	
    	List<String> sugerenciaPMostrar = new ArrayList<String>();
    	
		Double tempCabeza = tempReal + unUsuario.getPercepcion().getPercepcionCabeza();
		Double tempCuello = tempReal + unUsuario.getPercepcion().getPercepcionCuello();
		Double tempTorso = tempReal + unUsuario.getPercepcion().getPercepcionTorso();
		Double tempManos = tempReal + unUsuario.getPercepcion().getPercepcionManos();
		Double tempPiernas = tempReal + unUsuario.getPercepcion().getPercepcionPiernas();
		Double tempCalzado = tempReal + unUsuario.getPercepcion().getPercepcionCalzado();
		
		PrendaNivel nivelCabeza = this.temperaturaANivelPrenda(tempCabeza);
		PrendaNivel nivelCuello = this.temperaturaANivelPrenda(tempCuello);
		PrendaNivel nivelTorso = this.temperaturaANivelPrenda(tempTorso);
		PrendaNivel nivelManos = this.temperaturaANivelPrenda(tempManos);
		PrendaNivel nivelPiernas = this.temperaturaANivelPrenda(tempPiernas);
		PrendaNivel nivelCalzado = this.temperaturaANivelPrenda(tempCalzado);
		
		this.sugerirAlgunoDe(unGuardarropa,nivelCabeza,Categoria.CABEZA,fecha);
		this.sugerirAlgunoDe(unGuardarropa,nivelCuello,Categoria.CUELLO,fecha);
		this.sugerirAlgunoDe(unGuardarropa,nivelTorso,Categoria.PARTE_SUPERIOR,fecha);
		this.sugerirAlgunoDe(unGuardarropa,nivelManos,Categoria.MANOS,fecha);
		this.sugerirAlgunoDe(unGuardarropa,nivelPiernas,Categoria.PARTE_INFERIOR,fecha);
		this.sugerirAlgunoDe(unGuardarropa,nivelCalzado,Categoria.CALZADO,fecha);
		this.quizaAgregamosUnAccesorio(unGuardarropa);
    			
		System.out.printf("Se genero la sugerencia para la temperatura: %1.2fº\n", tempReal);
	
		for(Prenda prenda : sugerencia ){
    		String nombre = prenda.getNombre();
    		sugerenciaPMostrar.add(nombre);
		}
		
		System.out.println("La sugerencia es: "+ sugerenciaPMostrar +". Desea Aceptarla?" );
		
		/*List<Prenda> listaAux;
		listaAux = sugerencia;
		;*/
		
		return sugerencia;    
    }
    
	public void sugerirAlgunoDe(Guardarropa unGuardarropa,PrendaNivel nivel,Categoria categoria,LocalDate fecha) {
		switch(nivel) {
			case Nivel1:
				siHayAlgunaAgregala(unGuardarropa,categoria, Nivel1, fecha); break;
			case Nivel2:
				siHayAlgunaAgregala(unGuardarropa,categoria, Nivel1, fecha);
				siHayAlgunaAgregala(unGuardarropa,categoria, Nivel2, fecha); break;
			case Nivel3:
				siHayAlgunaAgregala(unGuardarropa,categoria, Nivel1, fecha);
				siHayAlgunaAgregala(unGuardarropa,categoria, Nivel2, fecha);
				siHayAlgunaAgregala(unGuardarropa,categoria, Nivel3, fecha); break;
			default:
				siHayAlgunaAgregala(unGuardarropa,categoria, Nivel1, fecha);
				siHayAlgunaAgregala(unGuardarropa,categoria, Nivel2, fecha);
				siHayAlgunaAgregala(unGuardarropa,categoria, Nivel3, fecha);
				siHayAlgunaAgregala(unGuardarropa,categoria, Nivel4, fecha); break;
		}		
	}
	
     //		void quizaAgregamosUnAccesorio(g) busca todos los accesorios dentro del guardarropa,
     //		el método tiene un 50% de chances de agregar todo accesorio que encuentre 
    
	private void quizaAgregamosUnAccesorio(Guardarropa unGuardarropa) {
		boolean trueOfalse = (Math.random() < 0.5);
		for (Prenda prenda : unGuardarropa.getPrendas()) {
			if((prenda.getCategoria() == Categoria.ACCESORIO)) {
				if(trueOfalse) sugerencia.add(prenda);
			} 
		}
	}

	boolean hayAlgunaPrendaQueCumpla(Guardarropa guardarropa,Categoria cat,PrendaNivel nivel, LocalDate fecha) {
		for (Prenda prenda : guardarropa.getPrendas()) {
    		if((prenda.getCategoria() == cat) & (prenda.getNivel() == nivel) & !(prenda.estaReservada(fecha)))
    			return true;
		}return false;
	}
	
	public void siHayAlgunaAgregala(Guardarropa guardarropa,Categoria cat, PrendaNivel nivel, LocalDate fecha){
		if (hayAlgunaPrendaQueCumpla(guardarropa, cat, nivel, fecha)){
			Prenda prendaRandom;
			List<Prenda> listaTemporal = new ArrayList<Prenda>();
			
			for (Prenda prenda : guardarropa.getPrendas()) {
				if((prenda.getCategoria() == cat) & (prenda.getNivel() == nivel) & !(prenda.estaReservada(fecha)))
					listaTemporal.add(prenda);
			}
			
			Random rand = new Random(); 
			prendaRandom = listaTemporal.get(rand.nextInt(listaTemporal.size()));
			sugerencia.add(prendaRandom);			
		}    
	}
    
    
    public String getRandomList(List<String> list) {
	    Random random = new Random();
	    int index = random.nextInt(list.size());
	    System.out.println("\nIndex :" + index );
	    return list.get(index);
	}
    
    public PrendaNivel temperaturaANivelPrenda(double temperatura) {
    	int temp = (int) temperatura;
    	if (between(temp,20,50)) return PrendaNivel.Nivel1;
    	else if (between(temp,13,19)) return PrendaNivel.Nivel2;
    	else if (between(temp,6,12)) return PrendaNivel.Nivel3;
    	else return PrendaNivel.Nivel4;

    }
    
	public static boolean between(int i, int minValueInclusive, int maxValueInclusive) {
	    return (i >= minValueInclusive && i <= maxValueInclusive);
	}
}