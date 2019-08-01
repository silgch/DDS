package guardarropas;

import java.util.ArrayList;
import java.util.List;

import Excepciones.NoConexionApiException;
import componentes.Prenda;
import queMePongo.QueMePongo;
import usuario.Usuario;

/*	
 	Cada Usuario tiene uno o mas guardarropas.Cuando
	un usuario crea una prenda, se la incluye en su guardarropas, 
  	mediante el metodo agregarAGuardarropas.
*/

public class Guardarropa {
	List<Prenda> prendasSuperioresNivel1;
    List<Prenda> prendasSuperioresNivel2;
    List<Prenda> prendasSuperioresNivel3;
    List<Prenda> prendasSuperioresNivel4;
    List<Prenda> prendasInferioresNivel1;
    List<Prenda> prendasInferioresNivel2;
    List<Prenda> prendasInferioresNivel3;
    List<Prenda> calzadosNivel1;
    List<Prenda> calzadosNivel2;
    List<Prenda> accesorios;
    
    private Usuario miDuenio= null;
    private OrganizadorDeGuardarropa miOrganizador = new OrganizadorDeGuardarropa(this);
    
    //Constructores:
    public Guardarropa() {
      //this.todoJunto = new ArrayList<Prenda>();    	
        this.prendasSuperioresNivel1 = new ArrayList<Prenda>();
        this.prendasSuperioresNivel2 = new ArrayList<Prenda>();
        this.prendasSuperioresNivel3 = new ArrayList<Prenda>();
        this.prendasSuperioresNivel4 = new ArrayList<Prenda>();
        this.prendasInferioresNivel1 = new ArrayList<Prenda>();
        this.prendasInferioresNivel2 = new ArrayList<Prenda>();
        this.prendasInferioresNivel3 = new ArrayList<Prenda>();
        this.calzadosNivel1 = new ArrayList<Prenda>();
        this.calzadosNivel2 = new ArrayList<Prenda>();
        this.accesorios = new ArrayList<Prenda>();
    }

    public void duenio(Usuario usuario){
    	if (miDuenio == null){miDuenio = usuario;}
    }
    
    public void agregarAGuardarropas(Prenda prenda) throws Exception {
    	if (miDuenio == null) {
    		throw new Exception("Primero debe asignar un usuario a este guardarropa.");
    	}
    	if (miDuenio.tieneGuardarropaLleno(this)){
    		throw new Exception("El usuario no puede agregar mas ropa debido a su plan.");
    	}
    	miOrganizador.organizameEsta(prenda);
     }

	public int cantidadDePrendas() {
		int cantidad=0;
		//Esto lo hacemos para evitar un nullPointer si no hay prendas de alguna categoria.
		if (prendasSuperioresNivel1.isEmpty()) {cantidad+=0;} else {cantidad += prendasSuperioresNivel1.size();}
		if (prendasSuperioresNivel2.isEmpty()) {cantidad+=0;} else {cantidad += prendasSuperioresNivel1.size();}
		if (prendasSuperioresNivel3.isEmpty()) {cantidad+=0;} else {cantidad += prendasSuperioresNivel1.size();}
		if (prendasSuperioresNivel4.isEmpty()) {cantidad+=0;} else {cantidad += prendasSuperioresNivel1.size();}
		if (prendasInferioresNivel1.isEmpty()) {cantidad+=0;} else {cantidad += prendasInferioresNivel1.size();}
		if (prendasInferioresNivel2.isEmpty()) {cantidad+=0;} else {cantidad += prendasInferioresNivel2.size();}
		if (prendasInferioresNivel3.isEmpty()) {cantidad+=0;} else {cantidad += prendasInferioresNivel3.size();}
		if (calzadosNivel1.isEmpty()) {cantidad+=0;} else {cantidad += calzadosNivel1.size();}
		if (calzadosNivel2.isEmpty()) {cantidad+=0;} else {cantidad += calzadosNivel2.size();}
		if (accesorios.isEmpty()) {cantidad+=0;} else {cantidad += accesorios.size();}
		
		return cantidad;
	}
	
	public void sugerir() throws NoConexionApiException{
		
		//return QueMePongo.obtenerSugerencia(this);
		//QueMePongo.obtenerSugerencia(this);
		QueMePongo.getInstance().sugerir(this);
	}
	
	public void sugerirTodasLasCombinaciones() throws NoConexionApiException{
		QueMePongo.getInstance().sugerirTodasLasCombinaciones(this);
	}
// Reacomodar el codigo interno 
	public void sugerirTodasLasCombinaciones(Double temperatura) throws NoConexionApiException{
		QueMePongo.getInstance().sugerirTodasLasCombinaciones(this);
	}
	
	
	public void sugerirUnaCantidadDeCombinaciones(int unaCantidad) throws NoConexionApiException{
		QueMePongo.getInstance().sugerirUnaCantidadDeVeces(this, unaCantidad);
	}

	public List<Prenda> getPrendasSuperioresNivel1() {
		return prendasSuperioresNivel1;
	}

	public List<Prenda> getPrendasSuperioresNivel2() {
		return prendasSuperioresNivel2;
	}

	public List<Prenda> getPrendasSuperioresNivel3() {
		return prendasSuperioresNivel3;
	}

	public List<Prenda> getPrendasSuperioresNivel4() {
		return prendasSuperioresNivel4;
	}

	public List<Prenda> getPrendasInferioresNivel1() {
		return prendasInferioresNivel1;
	}

	public List<Prenda> getPrendasInferioresNivel2() {
		return prendasInferioresNivel2;
	}

	public List<Prenda> getPrendasInferioresNivel3() {
		return prendasInferioresNivel3;
	}

	public List<Prenda> getCalzadosNivel1() {
		return calzadosNivel1;
	}

	public List<Prenda> getCalzadosNivel2() {
		return calzadosNivel2;
	}

	public List<Prenda> getAccesorios() {
		return accesorios;
	}
}

//DEPRECADO	
/* 
	//    public void sugerir(){//DEPRECADO: usar el metodo del mismo nombre en clase QueMePongo//
//    	
//    	List<Set<Prenda>> sets = new ArrayList<Set<Prenda>>();
//		
//   		sets.add(new HashSet(this.prendasSuperiores));
//   	    sets.add(new HashSet(this.prendasInferiores));
//   	    sets.add(new HashSet(this.calzados));
//   	 	sets.add(new HashSet(this.accesorios));
//   	 	
//   	 	Set<List<Prenda>> cartesianSet = Sets.cartesianProduct(sets);
//   	 	
//   	 	List<String> listaAux= new ArrayList<String>();
//   	 	
//		for(List<Prenda> element : cartesianSet ){
//			
//			String nombreAux ="";
//			List<Prenda> listaPrendaAux = element;
//			for(Prenda prenda :listaPrendaAux ){
//		    	 
//				nombreAux=nombreAux+"-"+prenda.getNombre();
//				
//			}
//			
//			listaAux.add(nombreAux);
//		}
//		
//		System.out.println(this.getRandomList(listaAux));
//    } 
//    
//	public String getRandomList(List<String> list) {
//	    Random random = new Random();
//	    int index = random.nextInt(list.size());
//	    System.out.println("\nIndex :" + index );
//	    return list.get(index);
//	}

 	public void sugerenciaConTodosLosGuardarropas(List<Guardarropa> guardarropas) throws Exception{
//    	//DEPRECADO: usar el metodo del mismo nombre en clase QueMePongo//
//    	Guardarropa aux = new Guardarropa();
//    	for(Guardarropa element : guardarropas) {
//    		this.fusionarGuardarropa(aux,element);
//    	}
//    	
//    	List<Set<Prenda>> sets = new ArrayList<Set<Prenda>>();
//		
//   		sets.add(new HashSet(aux.getPrendasSuperiores()));
//   	    sets.add(new HashSet(aux.getPrendasInferiores()));
//   	    sets.add(new HashSet(aux.getCalzados()));
//   	 	sets.add(new HashSet(aux.getAccesorios()));
//   	 	
//   	 	Set<List<Prenda>> cartesianSet = Sets.cartesianProduct(sets);
//   	 	
//   	 	List<String> listaAux= new ArrayList<String>();
//   	 	
//		for(List<Prenda> element : cartesianSet ){
//
//			String nombreAux ="";
//			List<Prenda> listaPrendaAux = element;
//			for(Prenda prenda :listaPrendaAux ){
//				nombreAux=nombreAux+"-"+prenda.getNombre();
//			}
//			listaAux.add(nombreAux);
//		}
//		System.out.println(this.getRandomList(listaAux));
//	        	
//    }
 
 	public void fusionarGuardarropa(Guardarropa a,Guardarropa b) throws Exception {
//		
//		for(Prenda p : b.getPrendasSuperiores()) {
//			a.agregarPrendaSuperior(p);
//		}
//		for(Prenda p : b.getPrendasInferiores()) {
//			a.agregarPrendaInferior(p);;
//		}
//		for(Prenda p : b.getCalzados()) {
//			a.agregarCalzado(p);
//		}
//		for(Prenda p : b.getAccesorios()) {
//			a.agregarAccesorio(p);
//		}
//		
//	}
*/