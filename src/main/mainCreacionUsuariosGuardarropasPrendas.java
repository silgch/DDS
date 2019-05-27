package main;

import Componentes.*;
import guardarropas.*;
import usuario.*;


public class mainCreacionUsuariosGuardarropasPrendas {

	public static void main(String[] args) throws Exception {

			Usuario ines = new Usuario();
			Usuario joeyRamone = new Usuario();
		   
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
		    Prenda remeraNegra = PrendaBuildDirector.construirRemeraNegra();
		    Prenda pantalonNegro = PrendaBuildDirector.construirPantalonNegro();
		    Prenda lentesNegros = PrendaBuildDirector.construirLentesNegros();
		    Prenda zapatillasNegras = PrendaBuildDirector.construirZapatillasNegros();
		    
		    		    
		    Guardarropa guardarropaInesUno = new Guardarropa();
		    
		    Guardarropa guardarropaInesDos = new Guardarropa();
		    
		    Guardarropa guardarropaJoeyRamone = new Guardarropa();
	
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
		    
		    guardarropaJoeyRamone.agregarAGuardarropas(remeraNegra);
		    guardarropaJoeyRamone.agregarAGuardarropas(pantalonNegro);
		    guardarropaJoeyRamone.agregarAGuardarropas(lentesNegros);
		    guardarropaJoeyRamone.agregarAGuardarropas(zapatillasNegras);
		    
		    
		    ines.agregarGuardarropa(guardarropaInesUno);
		    ines.agregarGuardarropa(guardarropaInesDos);
		    joeyRamone.agregarGuardarropa(guardarropaJoeyRamone);
		    
		    guardarropaInesUno.sugerir();
		    
		    guardarropaInesDos.sugerir();
		    
		    guardarropaJoeyRamone.sugerir();
		    
		    guardarropaInesUno.sugerenciaConTodosLosGuardarropas(ines.getGuardarropas());
		    
		}
}
