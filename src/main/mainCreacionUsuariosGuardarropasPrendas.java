package main;

import Componentes.*;
import guardarropas.*;
import usuario.*;


public class mainCreacionUsuariosGuardarropasPrendas {

	public static void main(String[] args) throws Exception {

		//3. Creaci�n de m�ltiples usuarios, cada uno con distintas prendas y guardarropas

		

			Usuario ines = new Usuario();
			
			Prenda prendaRemeraRoja= new Prenda(TipoDePrenda.REMERA, Material.ALGODON, new Color(200,0,0), new Color(110,10,0),Trama.ESTAMPADA);
			Prenda prendaRemeraAzul= new Prenda(TipoDePrenda.REMERA, Material.ALGODON, new Color(0,0,100),Trama.CUADROS);
		    Prenda prendaPantalonCorderoy= new Prenda(TipoDePrenda.PANTALON, Material.CORDEROY, new Color(0,70,100),Trama.LISA);
		    Prenda prendaPantalonJean = new Prenda(TipoDePrenda.PANTALON, Material.JEAN, new Color(0,0,200),Trama.LISA);
		    Prenda prendaZapatillaLona= new Prenda(TipoDePrenda.ZAPATILLAS, Material.LONA, new Color(0,200,200),Trama.LISA);
		    Prenda prendaZapatillaCuero= new Prenda(TipoDePrenda.ZAPATILLAS, Material.CUERO, new Color(0,0,0),Trama.LISA);
		    Prenda prendaBotaCuero = new Prenda(TipoDePrenda.BOTAS, Material.CUERO, new Color(0,200,200),Trama.LISA);
		    Prenda prendaBotaCuerina = new Prenda(TipoDePrenda.BOTAS, Material.CUERINA, new Color(0,200,200),Trama.LISA);
		    Prenda relojOro = new Prenda(TipoDePrenda.RELOJ,  Material.ORO, new Color(234, 190, 63),Trama.LISA);
		    
		    Guardarropa guardarropaInes = new Guardarropa();
		    
		    guardarropaInes.agregarAGuardarropas(prendaRemeraRoja);
		    guardarropaInes.agregarAGuardarropas(prendaRemeraAzul);
		    guardarropaInes.agregarAGuardarropas(prendaPantalonCorderoy);
		    guardarropaInes.agregarAGuardarropas(prendaZapatillaLona);
		    guardarropaInes.agregarAGuardarropas(relojOro);
		    guardarropaInes.agregarAGuardarropas(prendaBotaCuerina);
		    
		    guardarropaInes.sugerir();
		    
		}
		
	    Guardarropa guardarropaPablo = new Guardarropa();
	    Guardarropa guardarropaJuan = new Guardarropa();


}
