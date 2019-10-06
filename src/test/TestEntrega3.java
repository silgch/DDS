package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

import eventos.EnumEstadoSugerencia;
import eventos.Sugerencia;
import usuario.Usuario;

class TestEntrega3 {
	Sugerencia sugerencia1;
	Usuario ines = new Usuario();
	
	@Before
	public void init() {
		
		sugerencia1 = new Sugerencia();
	    sugerencia1.setDescripcion("Sugerencia que me gusta mucho");
	    sugerencia1.setEstado(EnumEstadoSugerencia.SUGERIDA);
		
	}
	
	
	@Test
	public void testEstadoDeSugerenciaCorrecto() {
		assertEquals( EnumEstadoSugerencia.SUGERIDA, sugerencia1.getEstado() );
		sugerencia1.aceptarSugerencia();
		assertEquals( EnumEstadoSugerencia.ACEPTADA, sugerencia1.getEstado() );
		sugerencia1.RechazarSugerencia();
		assertEquals( EnumEstadoSugerencia.RECHAZADA, sugerencia1.getEstado() );
		
		
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
    void testNoSePuedeCalificarUnaSugerenciaNoAceptada() {
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
        
        
    }
    
   
    
    

}
