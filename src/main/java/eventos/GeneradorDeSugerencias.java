package eventos;

import static componentes.PrendaNivel.Nivel1;
import static componentes.PrendaNivel.Nivel2;
import static componentes.PrendaNivel.Nivel3;
import static componentes.PrendaNivel.Nivel4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import climaAPI.ClimaAdapter;
import climaAPI.GestorDeClimaAPIs;
//import climaAPI.OpenWeather;
import componentes.Categoria;
import componentes.Prenda;
import componentes.PrendaNivel;
//import excepciones.NoConexionApiException;
import guardarropas.Guardarropa;
//import usuario.GestorDeCuentas;
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
	
	/*
	private static GeneradorDeSugerencias instance = null;
	public static GeneradorDeSugerencias getInstance() {
		if(instance == null) 
			{instance = new GeneradorDeSugerencias();}
		return instance;
	}*/
	
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
	
    public List<Prenda> sugerirEnBaseAPersepcion(Guardarropa unGuardarropa,Usuario unUsuario,String codigoCiudad) throws Exception{
    	
    	// ejemplo String codigoCiudad = "3433955";
    	tempReal = api1.obtenerClima(codigoCiudad);
    	
    	sugerencia.clear();
    	
    	List<String> sugerenciaPMostrar = new ArrayList<String>();
    	
		Double tempCabeza = tempReal + unUsuario.getPercepcion().percepcionCabeza;
		Double tempCuello = tempReal + unUsuario.getPercepcion().percepcionCuello;
		Double tempTorso = tempReal + unUsuario.getPercepcion().percepcionTorso;
		Double tempManos = tempReal + unUsuario.getPercepcion().percepcionManos;
		Double tempPiernas = tempReal + unUsuario.getPercepcion().percepcionPiernas;
		Double tempCalzado = tempReal + unUsuario.getPercepcion().percepcionCalzado;
		
		PrendaNivel nivelCabeza = this.temperaturaANivelPrenda(tempCabeza);
		PrendaNivel nivelCuello = this.temperaturaANivelPrenda(tempCuello);
		PrendaNivel nivelTorso = this.temperaturaANivelPrenda(tempTorso);
		PrendaNivel nivelManos = this.temperaturaANivelPrenda(tempManos);
		PrendaNivel nivelPiernas = this.temperaturaANivelPrenda(tempPiernas);
		PrendaNivel nivelCalzado = this.temperaturaANivelPrenda(tempCalzado);
		
		this.sugerirAlgunoDe(unGuardarropa,nivelCabeza,Categoria.CABEZA);
		this.sugerirAlgunoDe(unGuardarropa,nivelCuello,Categoria.CUELLO);
		this.sugerirAlgunoDe(unGuardarropa,nivelTorso,Categoria.PARTE_SUPERIOR);
		this.sugerirAlgunoDe(unGuardarropa,nivelManos,Categoria.MANOS);
		this.sugerirAlgunoDe(unGuardarropa,nivelPiernas,Categoria.PARTE_INFERIOR);
		this.sugerirAlgunoDe(unGuardarropa,nivelCalzado,Categoria.CALZADO);
		this.quizaAgregamosUnAccesorio(unGuardarropa);
    			
		System.out.printf("Se genero la sugerencia para la temperatura: %1.2f \n", tempReal);
	
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

	boolean hayAlgunaPrendaQueCumpla(Guardarropa guardarropa,Categoria cat,PrendaNivel nivel) {
		for (Prenda prenda : guardarropa.getPrendas()) {
    		if((prenda.getCategoria() == cat) & (prenda.getNivel() == nivel))
    			return true;
		}return false;
	}
	
	public void siHayAlgunaAgregala(Guardarropa guardarropa,Categoria cat, PrendaNivel nivel){
		if (hayAlgunaPrendaQueCumpla(guardarropa, cat, nivel)){
			Prenda prendaRandom;
			List<Prenda> listaTemporal = new ArrayList<Prenda>();
			
			for (Prenda prenda : guardarropa.getPrendas()) {
				if((prenda.getCategoria() == cat) & (prenda.getNivel() == nivel))
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
	
	/*
	 * 	Ejemplo de sugerirAlgunoDe
	 * 
	public void sugerirAlgunoDe(Guardarropa guardarropa,PrendaNivel nivel,Categoria categoria){
		switch(nivel) {
		case Nivel1:
			siHayAlgunaAgregala(unGuardarropa,Categoria.PARTE_SUPERIOR, Nivel1); break;
		case Nivel2:
			siHayAlgunaAgregala(unGuardarropa,Categoria.PARTE_SUPERIOR, Nivel1);
			siHayAlgunaAgregala(unGuardarropa,Categoria.PARTE_SUPERIOR, Nivel2); break;
		case Nivel3:
			siHayAlgunaAgregala(unGuardarropa,Categoria.PARTE_SUPERIOR, Nivel1);
			siHayAlgunaAgregala(unGuardarropa,Categoria.PARTE_SUPERIOR, Nivel2);
			siHayAlgunaAgregala(unGuardarropa,Categoria.PARTE_SUPERIOR, Nivel3); break;
		default:
			siHayAlgunaAgregala(unGuardarropa,Categoria.PARTE_SUPERIOR, Nivel1);
			siHayAlgunaAgregala(unGuardarropa,Categoria.PARTE_SUPERIOR, Nivel2);
			siHayAlgunaAgregala(unGuardarropa,Categoria.PARTE_SUPERIOR, Nivel3);
			siHayAlgunaAgregala(unGuardarropa,Categoria.PARTE_SUPERIOR, Nivel4); break;
	}*/
	
	public void sugerirAlgunoDe(Guardarropa unGuardarropa,PrendaNivel nivel,Categoria categoria) {
		switch(nivel) {
			case Nivel1:
				siHayAlgunaAgregala(unGuardarropa,categoria, Nivel1); break;
			case Nivel2:
				siHayAlgunaAgregala(unGuardarropa,categoria, Nivel1);
				siHayAlgunaAgregala(unGuardarropa,categoria, Nivel2); break;
			case Nivel3:
				siHayAlgunaAgregala(unGuardarropa,categoria, Nivel1);
				siHayAlgunaAgregala(unGuardarropa,categoria, Nivel2);
				siHayAlgunaAgregala(unGuardarropa,categoria, Nivel3); break;
			default:
				siHayAlgunaAgregala(unGuardarropa,categoria, Nivel1);
				siHayAlgunaAgregala(unGuardarropa,categoria, Nivel2);
				siHayAlgunaAgregala(unGuardarropa,categoria, Nivel3);
				siHayAlgunaAgregala(unGuardarropa,categoria, Nivel4); break;
		}		
	}		
    
    
}









    
   /* public List<String> sugerirTodasLasCombinaciones(Guardarropa unGuardarropa) throws NoConexionApiException{
	  	String codigoCiudad = "3433955";
  		Double temp = api1.obtenerClima(codigoCiudad);

    	List<Set<Prenda>> sets = new ArrayList<Set<Prenda>>();
		if(!unGuardarropa.getPrendasSuperioresNivel1().isEmpty() && temp<25) {
			sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel1()));
		}
		if(!unGuardarropa.getPrendasSuperioresNivel2().isEmpty() && temp<=20) {
			sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel2()));
		}
		if(!unGuardarropa.getPrendasSuperioresNivel3().isEmpty() && temp<=15) {
			sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel3()));
		}
		if(!unGuardarropa.getPrendasSuperioresNivel4().isEmpty() && temp<=10) {
			sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel4()));
		}
		if(!unGuardarropa.getPrendasInferioresNivel1().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getPrendasInferioresNivel1()));
		}
		if(!unGuardarropa.getPrendasInferioresNivel2().isEmpty() && temp<=10) {
			sets.add(new HashSet(unGuardarropa.getPrendasInferioresNivel2()));
		}
		if(!unGuardarropa.getPrendasInferioresNivel3().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getPrendasInferioresNivel3()));
		}
		if(!unGuardarropa.getCalzadosNivel1().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getCalzadosNivel1()));
		}
		if(!unGuardarropa.getCalzadosNivel2().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getCalzadosNivel2()));
		}
		if(!unGuardarropa.getAccesorios().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getAccesorios()));
		}
   	 	
   	 	Set<List<Prenda>> cartesianSet = Sets.cartesianProduct(sets);
   	 	
   	 	List<String> sugerencia= new ArrayList<String>();
   	 	
		for(List<Prenda> element : cartesianSet ){
			System.out.println(element);
		}
		
		return sugerencia;
		
		
		//this.creacionAtuendo(sugerencia.toString(), unGuardarropa.getTodoJunto());
    
}
  
    public List<String> sugerirUnaCantidadDeVeces(Guardarropa unGuardarropa,int unaCantidad) throws NoConexionApiException{
	String codigoCiudad = "3433955";
	Double temp = api1.obtenerClima(codigoCiudad);

  		List<Set<Prenda>> sets = new ArrayList<Set<Prenda>>();
		if(!unGuardarropa.getPrendasSuperioresNivel1().isEmpty() && temp<25) {
			sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel1()));
		}
		if(!unGuardarropa.getPrendasSuperioresNivel2().isEmpty() && temp<=20) {
			sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel2()));
		}
		if(!unGuardarropa.getPrendasSuperioresNivel3().isEmpty() && temp<=15) {
			sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel3()));
		}
		if(!unGuardarropa.getPrendasSuperioresNivel4().isEmpty() && temp<=10) {
			sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel4()));
		}
		if(!unGuardarropa.getPrendasInferioresNivel1().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getPrendasInferioresNivel1()));
		}
		if(!unGuardarropa.getPrendasInferioresNivel2().isEmpty() && temp<=10) {
			sets.add(new HashSet(unGuardarropa.getPrendasInferioresNivel2()));
		}
		if(!unGuardarropa.getPrendasInferioresNivel3().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getPrendasInferioresNivel3()));
		}
		if(!unGuardarropa.getCalzadosNivel1().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getCalzadosNivel1()));
		}
		if(!unGuardarropa.getCalzadosNivel2().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getCalzadosNivel2()));
		}
		if(!unGuardarropa.getAccesorios().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getAccesorios()));
		}
 	 	
 	 	Set<List<Prenda>> cartesianSet = Sets.cartesianProduct(sets);
 	 	
 	 	List<String> sugerencia= new ArrayList<String>();
 	 	
		for(List<Prenda> element : cartesianSet ){
			String nombreAux ="";
			List<Prenda> listaPrendaAux = element;
			for(Prenda prenda :listaPrendaAux ){
				nombreAux=nombreAux+"-"+prenda.getNombre();
			}
			sugerencia.add(nombreAux);
		}
		for(int i =0;i<unaCantidad;i++) {
			System.out.println(this.getRandomList(sugerencia));
		}
		//this.creacionAtuendo(sugerencia.toString(), unGuardarropa.getTodoJunto());
  
		return sugerencia;
}

    public List<String> sugerirSegunTemperatura(Guardarropa unGuardarropa,Double unaTemperatura) throws NoConexionApiException{

  		List<Set<Prenda>> sets = new ArrayList<Set<Prenda>>();
		if(!unGuardarropa.getPrendasSuperioresNivel1().isEmpty() && unaTemperatura<25) {
			sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel1()));
		}
		if(!unGuardarropa.getPrendasSuperioresNivel2().isEmpty() && unaTemperatura<=20) {
			sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel2()));
		}
		if(!unGuardarropa.getPrendasSuperioresNivel3().isEmpty() && unaTemperatura<=15) {
			sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel3()));
		}
		if(!unGuardarropa.getPrendasSuperioresNivel4().isEmpty() && unaTemperatura<=10) {
			sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel4()));
		}
		if(!unGuardarropa.getPrendasInferioresNivel1().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getPrendasInferioresNivel1()));
		}
		if(!unGuardarropa.getPrendasInferioresNivel2().isEmpty() && unaTemperatura<=10) {
			sets.add(new HashSet(unGuardarropa.getPrendasInferioresNivel2()));
		}
		if(!unGuardarropa.getPrendasInferioresNivel3().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getPrendasInferioresNivel3()));
		}
		if(!unGuardarropa.getCalzadosNivel1().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getCalzadosNivel1()));
		}
		if(!unGuardarropa.getCalzadosNivel2().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getCalzadosNivel2()));
		}
		if(!unGuardarropa.getAccesorios().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getAccesorios()));
		}
 	 	
 	 	Set<List<Prenda>> cartesianSet = Sets.cartesianProduct(sets);
 	 	
 	 	List<String> sugerencia= new ArrayList<String>();
 	 	
		for(List<Prenda> element : cartesianSet ){
			String nombreAux ="";
			List<Prenda> listaPrendaAux = element;
			for(Prenda prenda :listaPrendaAux ){
				nombreAux=nombreAux+"-"+prenda.getNombre();
			}
			sugerencia.add(nombreAux);
		}
		System.out.println("Se genero la sugerencia para la temperatura" +unaTemperatura );
		return sugerencia;
}
    
	
	
	
	
/*
	  						 Implentación Vieja
	 
	
	public static Set<List<Prenda>> obtenerSugerencias(Guardarropa unGuardarropa){
		
		List<Set<Prenda>> sets = new ArrayList<Set<Prenda>>();
		
		sets.add(new HashSet(unGuardarropa.getPrendasSuperiores()));
   	    sets.add(new HashSet(unGuardarropa.getPrendasInferiores()));
   	    sets.add(new HashSet(unGuardarropa.getCalzados()));
   	 	sets.add(new HashSet(unGuardarropa.getAccesorios()));
		
		return  Sets.cartesianProduct(sets);
	}
	
	private boolean comprobarListaNoVacia(List<Prenda> unaLista) { //Ver si sirve incluirlo en ObtenerSugerencias() pare evitar el null pointer
		if(unaLista == null || unaLista.size() == 0)
			{return false;}
		else
			{return true;}		
	      
	}
*/
	
