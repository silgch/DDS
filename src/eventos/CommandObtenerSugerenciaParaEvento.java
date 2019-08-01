package eventos;

import java.io.IOException;
import java.util.List;

import API.OpenWeather;
import guardarropas.Guardarropa;

public class CommandObtenerSugerenciaParaEvento implements ICommand {

	@Override
	public void Execute(Evento evento) throws IOException {
		
		
		// Consulto a la API cual es el clima para el evento que le estoy pasando, es decir: 
		// cual es la temperatura promedio para ese dia,y se la asigno al evento. 
	
		evento.setTemperatura(OpenWeather.obtenerClima(evento.getUbicacion())); // Ver con Nico. porque pide un String? como le digo a la API la fecha para la cual quiero saberla temperatura?

			
		
		List<Guardarropa> guardarropas = evento.getUsuario().getGuardarropas(); 
		
		for(Guardarropa guardarropa: guardarropas){
			
			evento.setSugerencias(guardarropa.sugerirTodasLasCombinaciones(evento.getTemperatura()));
			//Cambiar sugerirTodas Las Combinaciones para que le podamos pasar por parametro la temperatura
		}
		
	}

}