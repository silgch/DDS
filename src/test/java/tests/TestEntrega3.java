package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

import eventos.EnumEstadoSugerencia;
import eventos.Sugerencia;
import usuario.Usuario;

public class TestEntrega3 {
	Usuario ines = new Usuario("Ines");
	Sugerencia sugerencia1;
	Sugerencia sugerencia2;
	Sugerencia sugerencia3;
	    
	/*
	@Before
	public void init() {
	    Sugerencia sugerencia1 = new Sugerencia();
	    Sugerencia sugerencia2 = new Sugerencia();
	    Sugerencia sugerencia3 = new Sugerencia();
	    
	    sugerencia1.setDescripcion("sugerencia buena");
	    sugerencia2.setDescripcion("sugerencia meh");
	    sugerencia3.setDescripcion("sugerencia pedorra");
	    
	    sugerencia1.setEstado(EnumEstadoSugerencia.SUGERIDA);
	    sugerencia2.setEstado(EnumEstadoSugerencia.SUGERIDA);
	    sugerencia3.setEstado(EnumEstadoSugerencia.SUGERIDA);
	}
	
	
	@Test
	public void testEstadoDeSugerenciaCorrecto() {
		assertEquals( EnumEstadoSugerencia.SUGERIDA, sugerencia1.getEstado() );
	    ines.aceptarSugerencia(sugerencia1);
	    ines.rechazarSugerencia(sugerencia3);
	    assertEquals( EnumEstadoSugerencia.ACEPTADA, sugerencia1.getEstado() );		
		assertEquals( EnumEstadoSugerencia.RECHAZADA, sugerencia3.getEstado() );
		
		
	}
	
	@Test
	public void testCalificarSugerenciaAceptada() throws Exception {
		assertEquals( sugerencia1.getCalificacion()	, 0);
		sugerencia1.setCalificacion(10);
		assertEquals( sugerencia1.getCalificacion()	, 10);
		ines.aceptarSugerencia(sugerencia1);
		ines.calificarSugerencia(sugerencia1, 30);
		assertEquals( sugerencia1.getCalificacion()	, 30);
	}
	

	
    @Test
    public void testNoSePuedeCalificarUnaSugerenciaNoAceptada() {
    	ines.rechazarSugerencia(sugerencia1);
        Exception excepcion =
            assertThrows(Exception.class,
               () -> ines.calificarSugerencia(sugerencia1, 15),
               "Ingrese una sugerencia ACEPTADA");

        assertTrue(excepcion.getMessage().contains("ACEPTADA"));
        
        sugerencia1.setEstado(EnumEstadoSugerencia.SUGERIDA);
        Exception excepcion2 =
                assertThrows(Exception.class,
                   () -> ines.calificarSugerencia(sugerencia1, 15),
                   "Ingrese una sugerencia ACEPTADA");

            assertTrue(excepcion2.getMessage().contains("ACEPTADA"));
        
        
    }*/
    
   
    
    

}
