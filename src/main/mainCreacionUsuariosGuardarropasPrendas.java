package main;

import Componentes.*;
import guardarropas.*;
import usuario.*;


public class mainCreacionUsuariosGuardarropasPrendas {

	public static void main(String[] args) throws Exception {

			Usuario ines = new Usuario();
		   
		    Prenda remeraRoja= PrendaBuildDirector.construirRemeraRoja();
			Prenda remeraAzul= PrendaBuildDirector.construirRemeraAzul();
			Prenda remeraVerde = PrendaBuildDirector.construirRemeraVerde();
		    Prenda pantalonCorderoy= PrendaBuildDirector.construirPantalonCorderoy();
		    Prenda pantalonJean = PrendaBuildDirector.construirPantalonJean();
		    Prenda pantalonRockero = PrendaBuildDirector.construirPantalonRockero();
		    Prenda zapatillaLona= PrendaBuildDirector.construirZapatillaLona();
		    Prenda zapatillaCuero= PrendaBuildDirector.construirZapatillaCuero();
		    Prenda botaCuero = PrendaBuildDirector.construirBotaCuero();
		    Prenda botaCuerina = PrendaBuildDirector.construirBotaCuerina();
		    Prenda relojOro = PrendaBuildDirector.construirRelojOro();
		    Prenda relojPlastico = PrendaBuildDirector.construirRelojPlastico();		    
		    
		    Guardarropa guardarropaInesUno = new Guardarropa();
		    
		    Guardarropa guardarropaInesDos = new Guardarropa();
	
		    guardarropaInesUno.agregarAGuardarropas(remeraRoja);
		    guardarropaInesUno.agregarAGuardarropas(remeraAzul);
		    guardarropaInesUno.agregarAGuardarropas(pantalonCorderoy);
		    guardarropaInesUno.agregarAGuardarropas(zapatillaLona);
		    guardarropaInesUno.agregarAGuardarropas(relojOro);
		    guardarropaInesUno.agregarAGuardarropas(botaCuerina);
		    guardarropaInesUno.agregarAGuardarropas(botaCuero);
			
		    guardarropaInesDos.agregarAGuardarropas(remeraVerde);
		    guardarropaInesDos.agregarAGuardarropas(pantalonRockero);
		    guardarropaInesDos.agregarAGuardarropas(pantalonJean);
		    guardarropaInesDos.agregarAGuardarropas(zapatillaLona);
		    guardarropaInesDos.agregarAGuardarropas(zapatillaCuero);
		    guardarropaInesDos.agregarAGuardarropas(relojPlastico);
		    
		    
		    ines.agregarGuardarropa(guardarropaInesUno);
		    ines.agregarGuardarropa(guardarropaInesDos);
		    
		    
		    guardarropaInesUno.sugerir();
		    
		    guardarropaInesDos.sugerir();
		    
		    guardarropaInesUno.sugerenciaConTodosLosGuardarropas(ines.getGuardarropas());
		    
		}
}
