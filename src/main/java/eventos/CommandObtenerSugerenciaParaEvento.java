package eventos;

import java.io.IOException;
import java.util.List;

import climaAPI.ClimaAdapter;
import climaAPI.GestorDeClimaAPIs;
import excepciones.NoConexionApiException;
import guardarropas.Guardarropa;

public class CommandObtenerSugerenciaParaEvento implements ICommand {
	
	private GestorDeClimaAPIs gestorDeAPIs;
	private ClimaAdapter api1 = gestorDeAPIs.entregarAPI();

	@Override
	public void execute(Evento evento) throws IOException {
		
		try {
			String codigoCiudad = "3433955";
			
			// Consulto a la API cual es el clima para el evento que le estoy pasando, es decir: 
			// cual es la temperatura promedio para ese dia,y se la asigno al evento. 

			evento.setTemperatura(api1.obtenerClima(codigoCiudad)); 
			System.out.println("La temperatura para el evento es "+evento.getTemperatura());
			
			List<Guardarropa> guardarropas = evento.getUsuario().getGuardarropas(); 
			
			for(Guardarropa guardarropa: guardarropas){
				
				evento.setSugerencias(guardarropa.sugerirTodasLasCombinacionesSegunTemperatura(evento.getTemperatura()));

			}
		}
		catch(NoConexionApiException ae) {
			System.out.println("Hubo un problema con la conexion a la api:"+ae);

		}
		catch(Exception e) {
			System.out.println("Hubo un problema en: "+e);

		}
		
	}

}