package climaAPI;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

import climaAPI.accuWheather.AWError;
import climaAPI.accuWheather.ClimaCiudad;
import climaAPI.accuWheather.RetornoAW;
import excepciones.NoConexionApiException;




public class AccuWeather implements ClimaAdapter {
	
	public String nombreDeAPI(){return "AccuWeather";}
	
	//obtener Location Key = https://www.youtube.com/watch?v=DR3jZczgZCs
	//pruebas directas =  https://developer.accuweather.com/accuweather-forecast-api/apis/get/forecasts/v1/daily/5day/%7BlocationKey%7D
	//a considerar: la temperatura viene en F, despues hay que restarle 32 a la hora de implementar obtenerClima()
	
	public RetornoAW temperaturaProximosCincoDias(String unCodigoCiudad){
		String codigoUsuario = Key.getKeyAccuWeather(); //Agregar clase con codigo personal y poner la clase key  archivo el 
		String codigoLK = "7894";
		
		String url = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/"+codigoLK+"?apikey="+codigoUsuario;
	
	    System.out.println("Inicio: Inicia GetClima");
	    System.out.println("url: " + url);
	    
	    RetornoAW retorno = new RetornoAW();
	    ClimaCiudad cc = new ClimaCiudad();
	    //devuelve la primer posicion como caso 200 de la lista de domicilios.
	    
	    
	    HttpURLConnection con = null;
	    StringBuilder sb = new StringBuilder(); //para conseguir lo que me trae el servicio
	    
	   	
	    String codigoError = "";
	    String mensajeError = "";
	    String respuesta = "";
		
	   try{
	    	System.out.println("Entro al try");
	    	//hago conexion
	        URL obj = new URL(url);
	        con = (HttpURLConnection) obj.openConnection();
	        con.setRequestProperty("Accept", "*/*");
	        con.setRequestProperty("Accept-Encoding", "gzip");
	        con.setRequestProperty("Accept-Language", "es-AR");
	        con.setRequestProperty("Host", "dataservice.accuweather.com");
	        con.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:68.0) Gecko/20100101 Firefox/68.0");
	        con.setRequestProperty("X-Forwarded-For", "190.111.231.16");
	        con.setRequestProperty("X-Forwarded-Port", "443");
	        con.setRequestProperty("X-Forwarded-Proto", "https");
	
	        con.setRequestMethod("GET");
	
	         
	    	System.out.println("Paso los setRequestMethod");
	    
	    	int responseCode = con.getResponseCode();
	        codigoError = "" + con.getResponseCode();
	        mensajeError = con.getResponseMessage();
	        System.out.println("responseCode: " + responseCode);
	        System.out.println("codigoError: " + codigoError);
	        System.out.println("mensajeError: " + mensajeError);
	    	
	        switch(responseCode) {
	        
	        case 200:
	        
	      //lectura de la url
	        InputStream is = con.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8" );
			
	    	System.out.println("Paso el inputStream");
	
			//lectura del buffer
			BufferedReader reader;
			String line = null;
			reader = new BufferedReader(isr);
			System.out.println("Paso el buffer");
			
			while ((line = reader.readLine()) != null) {
	        	System.out.println("Response: " + line);
				sb.append(line);
			}
	
			Gson gson = new Gson();
			cc = gson.fromJson(sb.toString(), ClimaCiudad.class);
			
			retorno.getClimaCiudad().add(cc);
			
			reader.close();
	
			break;
	        
	
	        default:
	    		
	    		InputStream isError = con.getErrorStream();
	    		InputStreamReader isrError = new InputStreamReader(isError, "UTF-8" );
	            
	            String inputLineError;
	            StringBuilder responseError = new StringBuilder();
	            BufferedReader inError;
	            inError= new BufferedReader(isrError);
	            System.out.println("paso el buffer");
	            
	            while ((inputLineError = inError.readLine()) != null) {
	            	responseError.append(inputLineError);
	            }
	            
	            respuesta = responseError.toString();
	            System.out.println("Asigno una respuesta");
	            inError.close();
	            
	    		System.out.println(responseCode);
	    		System.out.println(respuesta);
	    		
	    		Gson Erroresgson = new Gson();
	    		AWError Bad_request= new AWError();
	    		Bad_request = Erroresgson.fromJson(respuesta, AWError.class);
	
	    		
	    		retorno.getErrores().add(Bad_request);
	    		}
	
	    }
	        catch(Exception e){
	        	AWError err = new AWError();
	        	e.printStackTrace();
		        err.setMessage("Fallo la conexion con API");
	    		retorno.getErrores().add(err);
				return retorno;
	    }
	  
	    return retorno;
	   
	}
	
	
	@Override
	public double obtenerClima(String unCodigoCiudad) throws NoConexionApiException {
		/* como me devuelve una cantidad n de medidas, algunas estan rotas, la idea fue
		 *  refinar la busqueda devolviendo solo un promedio de valores que esten entre
		 *  un intervalo +- 0.25 del valor promedio*/
//		
//		RetornoAW aux = this.temperaturaActual(unCodigoCiudad);
//		double promedio=0;
//		double sumaTotal=0;
//		double auxiliarParaRefinar =0;
//		double retorno = 0;
//		ArrayList<Double> listaAuxiliar = new ArrayList<Double>();
//		if(aux.getErrores().size()>0) {
//			throw new NoConexionApiException(aux.getErrores().get(0).getMessage());
//		}
//		else {
//			int cantidadMedidas = aux.getClimaCiudad().get(0).getList().size();
//			
//			for(int i=0;i<cantidadMedidas;i++) { 
//				sumaTotal=sumaTotal+(aux.getClimaCiudad().get(0).getList().get(i).getMain().getTemp() - pasajeDeKelvin);
//			}
//			promedio = sumaTotal/cantidadMedidas;
//			
//			for(int i=0;i<cantidadMedidas;i++) {
//				auxiliarParaRefinar =aux.getClimaCiudad().get(0).getList().get(i).getMain().getTemp() - pasajeDeKelvin;
//				if(auxiliarParaRefinar>(promedio+(promedio*0.25))
//						|| auxiliarParaRefinar<(promedio-(promedio*0.25))) {
//				}
//				else {
//					listaAuxiliar.add(auxiliarParaRefinar);
//				}
//			}
//			for( Double elemento : listaAuxiliar) {
//				retorno = retorno + elemento;
//			}
			return 1;
		}

}

